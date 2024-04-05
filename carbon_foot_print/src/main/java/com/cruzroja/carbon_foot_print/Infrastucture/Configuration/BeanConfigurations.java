package com.cruzroja.carbon_foot_print.Infrastucture.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageUserCompanyGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageUserCompanyCUImplAdapter;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public ManageUserCompanyCUImplAdapter createUserCompanyCU(ManageUserCompanyGatewayIntPort gateway,
                                                                ExceptionFormatterIntPort exceptionFormatter){
        ManageUserCompanyCUImplAdapter userCompanyCU = new ManageUserCompanyCUImplAdapter(gateway, exceptionFormatter);
        return userCompanyCU;
    }
}
