package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper createMapper(){
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}
