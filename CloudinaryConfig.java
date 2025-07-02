package com.example.library_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

	@Bean
	Cloudinary cloudinary()
	{
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dxlty9afb",
                "api_key", "971865867645447",
                "api_secret", "g-Or9RyS_sJwzyXVDAdcrTQjBOc"
				));
	}
}
