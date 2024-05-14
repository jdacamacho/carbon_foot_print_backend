package com.cruzroja.carbon_foot_print.Infrastucture.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cruzroja.carbon_foot_print.Infrastucture.JWT.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigurations {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
            .csrf(csrf -> 
                csrf
                .disable())
            .authorizeHttpRequests(authRequest ->
              authRequest
                .requestMatchers("/api/auth").permitAll()
                //Roles
                .requestMatchers("/api/roles").hasRole("Listar_Roles")
                .requestMatchers("/api/roles/idRole/{idRole}").hasRole("Consultar_Rol")
                .requestMatchers("/api/roles/permissions").hasRole("Listar_permisos")
                .requestMatchers(HttpMethod.POST, "/api/roles").hasRole("Crear_Roles")
                .requestMatchers(HttpMethod.PUT, "/api/roles").hasRole("Actualizar_Roles")
                //Empresas
                .requestMatchers("/api/user/companies").hasRole("Listar_Empresas")
                .requestMatchers("/api/user/companies/nit/{nitCompany}").hasRole("Consultar_Empresa_NIT")
                .requestMatchers("/api/user/companies/numberDocument/{numberDocument}").hasRole("Consultar_Empresa_Documento")
                .requestMatchers(HttpMethod.POST, "/api/user/companies").hasRole("Crear_Empresas")
                .requestMatchers(HttpMethod.PUT, "/api/user/companies").hasRole("Actualizar_Empresas")
                //Voluntarios
                .requestMatchers("/api/user/volunteers").hasRole("Listar_Voluntarios")
                .requestMatchers("/api/user/volunteers/{documentNumber}").hasRole("Consultar_Voluntario")
                .requestMatchers("/api/user/volunteers/position").hasRole("Consultar_Voluntario_Posicion")
                .requestMatchers(HttpMethod.POST, "/api/user/volunteers").hasRole("Crear_Voluntarios")
                .requestMatchers(HttpMethod.PUT, "/api/user/volunteers").hasRole("Actualizar_Voluntarios")
                // Fuentes
                .requestMatchers("/api/sources").hasRole("Listar_Fuentes")
                .requestMatchers("/api/sources/{idSource}").hasRole("Consultar_Fuente_ID")
                .requestMatchers("/api/sources/sourceName").hasRole("Consultar_Fuente_name")
                .requestMatchers(HttpMethod.POST, "/api/sources").hasRole("Crear_Fuente")
                .requestMatchers(HttpMethod.PUT, "/api/sources").hasRole("Actualizar_Fuente")
                .anyRequest().authenticated()
                //Para que puedan usar los demas endopints cambiar authenticated() por permiteAll()
                )
            .sessionManagement(sessionManager->
                sessionManager 
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();     
    }
}
