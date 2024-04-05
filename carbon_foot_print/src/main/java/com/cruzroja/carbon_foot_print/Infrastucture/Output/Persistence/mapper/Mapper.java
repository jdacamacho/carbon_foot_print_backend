package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cruzroja.carbon_foot_print.Domain.Models.Address;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.AddressEntity;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper createMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<AddressEntity,Address> mapAddress = mapper.emptyTypeMap(AddressEntity.class, Address.class);
        mapAddress.addMappings(m -> m.skip(Address::setObjUserCompany)).implicitMappings();

        return mapper;
    }
}
