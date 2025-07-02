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
				"cloud_name", "your_cloud_name",
                		"api_key", "your_cloudinary_api_key",
                		"api_secret", "your_cloudinary_api_secret_key"
		));
	}
}
