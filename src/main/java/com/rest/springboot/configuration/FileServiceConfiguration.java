package com.rest.springboot.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FileServiceConfiguration {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
