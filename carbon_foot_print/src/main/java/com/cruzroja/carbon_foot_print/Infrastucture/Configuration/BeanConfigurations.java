package com.cruzroja.carbon_foot_print.Infrastucture.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cruzroja.carbon_foot_print.Application.Input.ManageCompensationPlanCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageActionGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageAuthGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageCompanyPlanGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageCompensationActionGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageCompensationPlanGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManagePollutionSourceGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManagePollutionTypeGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageRoleGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageSourceGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageUserCompanyGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManegeCategoryGatewayIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManegeUserVolunteerGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.mapper.CompensationMapperDomainMiddleWare;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageActionCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageAuthCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageCompanyPlanCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageCompensationActionCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageCompensationPlanCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManagePollutionSourceCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManagePollutionTypeCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageRoleCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageSourceCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManageUserCompanyCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManegeCalculatorCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManegeCategoryCUImplAdapter;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManegeUserVolunteerCUImplAdapter;
import com.cruzroja.carbon_foot_print.Infrastucture.JWT.JwtService;

@Configuration
public class BeanConfigurations {

    @Bean
    public ManageUserCompanyCUImplAdapter createUserCompanyCU(ManageUserCompanyGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter,
            PasswordEncoder passwordEncoder) {
        ManageUserCompanyCUImplAdapter userCompanyCU = new ManageUserCompanyCUImplAdapter(gateway, exceptionFormatter,
                passwordEncoder);
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
                exceptionFormatter, passwordEncoder);
        return userVolunterCU;
    }

    @Bean
    ManageAuthCUImplAdapter createAuthCU(ManageAuthGatewayIntPort gateway,
            JwtService jwtService,
            AuthenticationManager authenticationManager,
            ExceptionFormatterIntPort exceptionFormatter) {
        ManageAuthCUImplAdapter authCU = new ManageAuthCUImplAdapter(gateway, jwtService, authenticationManager,
                exceptionFormatter);
        return authCU;
    }

    @Bean
    ManegeCategoryCUImplAdapter createCategoryCU(ManegeCategoryGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        return new ManegeCategoryCUImplAdapter(gateway, exceptionFormatter);
    }

    @Bean
    public ManagePollutionTypeCUImplAdapter createPollutionTypeCU(ManagePollutionTypeGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        return new ManagePollutionTypeCUImplAdapter(gateway, exceptionFormatter);
    }

    @Bean
    public ManageSourceCUImplAdapter createSourceCU(ManageSourceGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        ManageSourceCUImplAdapter sourceCU = new ManageSourceCUImplAdapter(gateway, exceptionFormatter);
        return sourceCU;
    }

    @Bean
    public ManagePollutionSourceCUImplAdapter createPollutionSourceCU(ManagePollutionSourceGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        return new ManagePollutionSourceCUImplAdapter(gateway, exceptionFormatter);
    }

    @Bean
    public ManegeCalculatorCUImplAdapter createCalculatorCU(ManagePollutionSourceGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        return new ManegeCalculatorCUImplAdapter(gateway, exceptionFormatter);
    }

    @Bean
    public ManageActionCUImplAdapter createActionCU(ManageActionGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        return new ManageActionCUImplAdapter(gateway, exceptionFormatter);
    }

    @Bean
    public ManageCompensationPlanCUImplAdapter createCompensationPlanCU(ManageCompensationPlanGatewayIntPort gareway,
            ExceptionFormatterIntPort exceptionFormatter) {
        return new ManageCompensationPlanCUImplAdapter(gareway, exceptionFormatter);
    }

    @Bean
    public ManageCompensationActionCUImplAdapter createCompensationActionCU(
            ManageCompensationActionGatewayIntPort gateway,
            ManageCompensationPlanCUIntPort cuPlan,
            ExceptionFormatterIntPort exceptionFormatter,
            CompensationMapperDomainMiddleWare mapper) {
        return new ManageCompensationActionCUImplAdapter(gateway, cuPlan, exceptionFormatter, mapper);
    }

    @Bean
    public ManageCompanyPlanCUImplAdapter createCompanyPlanCU(ManageCompanyPlanGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        return new ManageCompanyPlanCUImplAdapter(gateway, exceptionFormatter);
    }

}
