package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.BadCredentialsException;

import com.cruzroja.carbon_foot_print.Application.Input.ManageAuthCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageAuthGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Credential;
import com.cruzroja.carbon_foot_print.Infrastucture.JWT.JwtService;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BadCredentialException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserEntity;

public class ManageAuthCUImplAdapter implements ManageAuthCUIntPort {

    private final ManageAuthGatewayIntPort gateway;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManageAuthCUImplAdapter(ManageAuthGatewayIntPort gateway,
                                    JwtService jwtService,
                                    AuthenticationManager authenticationManager,
                                    ExceptionFormatterIntPort exceptionFormatter){
        this.gateway = gateway;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public Credential login(String username, String password) {
        Credential credential = new Credential();
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        try{
            if(authentication.isAuthenticated()){
                Optional<UserEntity> userBD = this.gateway.findByUsername(username);
                UserDetails user = userBD.orElseThrow();
                String token = this.jwtService.getToken(user);
                credential.setDocumentNumber(userBD.get().getDocumentNumber());
                credential.setUsername(userBD.get().getUsername());
                credential.setToken(token);  
            }else{
                    
            }
        }catch(BadCredentialsException ex){
            throw new BadCredentialException("Checkout your username or password");
        }
        
        return credential;
    }
    
}
