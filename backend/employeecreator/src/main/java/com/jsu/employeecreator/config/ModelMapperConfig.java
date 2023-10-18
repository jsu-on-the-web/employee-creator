package com.jsu.employeecreator.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jsu.employeecreator.converters.StringTrimConverter;


@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {

		// DTO goes in, Employee comes out

		ModelMapper mapper = new ModelMapper();
		// set up my options here
		// trim strings
		mapper.typeMap(String.class, String.class).setConverter(new StringTrimConverter());
		mapper.getConfiguration().setSkipNullEnabled(true);
		return mapper;
	}

}
