package com.cruzroja.carbon_foot_print.Infrastucture.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageRoleGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageUserCompanyGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManegeUserVolunteerGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageRoleCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageUserCompanyCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManegeUserVolunteerCUImplAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public ManageUserCompanyCUImplAdapter createUserCompanyCU(ManageUserCompanyGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        ManageUserCompanyCUImplAdapter userCompanyCU = new ManageUserCompanyCUImplAdapter(gateway, exceptionFormatter);
        return userCompanyCU;
    }

    @Bean
    public ManageRoleCUImplAdapter createRoleCU(ManageRoleGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        ManageRoleCUImplAdapter roleCU = new ManageRoleCUImplAdapter(gateway, exceptionFormatter);
        return roleCU;
    }

    @Bean
    ManegeUserVolunteerCUImplAdapter createUserVolunteerCompanyCU(ManegeUserVolunteerGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter, PasswordEncoder passwordEncoder) {
        ManegeUserVolunteerCUImplAdapter userVolunterCU = new ManegeUserVolunteerCUImplAdapter(gateway,
                exceptionFormatter,passwordEncoder);
        return userVolunterCU;
    }
}
