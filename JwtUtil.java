package com.example.ems.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "your_secret_key"; // it should be long enough
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private final JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

    public String generateToken(String email)
    {
        Map<String,Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 60 * 12)) //12 hours
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token, String email)
    {
        return email.equals(extractEmail(token)) && !isTokenExpired(token);
    }

    public String extractEmail(String token)
    {
        return extractClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token)
    {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public Claims extractClaims(String token)
    {
        return jwtParser.parseClaimsJws(token).getBody();
    }
}
