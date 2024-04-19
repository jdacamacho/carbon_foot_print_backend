package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManegeUserVolunteerGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserVolunteerEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.UserVolunteerRepository;

@Service
public class ManegeUserVolunteerGatewayImplAdapter implements ManegeUserVolunteerGatewayIntPort {

    private final UserVolunteerRepository serviceBD;
    private final ModelMapper mapper;

    public ManegeUserVolunteerGatewayImplAdapter(UserVolunteerRepository serviceBD, ModelMapper mapper) {
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public List<UserVolunteer> findAll() {
        Iterable<UserVolunteerEntity> dataFromBD = this.serviceBD.findAll();
        return this.mapper.map(dataFromBD, new TypeToken<List<UserVolunteer>>() {
        }.getType());
    }

    @Override
    public UserVolunteer save(UserVolunteer userVolunteer) {
        UserVolunteerEntity userToSave = this.mapper.map(userVolunteer, UserVolunteerEntity.class);
        UserVolunteerEntity userSaved = this.serviceBD.save(userToSave);
        return this.mapper.map(userSaved, UserVolunteer.class);
    }

    @Override
    public UserVolunteer findUserVolunteerByNumberDocument(long numberDocument) {
        UserVolunteerEntity dataFromBD = this.serviceBD.findById(numberDocument).get();
        UserVolunteer response = this.mapper.map(dataFromBD, UserVolunteer.class);
        return response;
    }

    @Override
    public List<UserVolunteer> findUserVolunteerByPosition(String position) {
        Iterable<UserVolunteerEntity> dataFromBD = this.serviceBD.findByPosition(position);
        return this.mapper.map(dataFromBD, new TypeToken<List<UserVolunteer>>() {
        }.getType());
    }

    @Override
    public List<Role> findRoles() {
        Iterable<RoleEntity> dataFromBD = this.serviceBD.findAllRoles();
        return this.mapper.map(dataFromBD, new TypeToken<List<Role>>() {
        }.getType());
    }

    @Override
    public boolean existById(long id) {
        return this.serviceBD.existsById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return this.serviceBD.existsByUsername(username);
    }

    @Override
    public boolean existsByPersonalEmail(String personalEmail) {
        return this.serviceBD.existsByPersonalEmail(personalEmail);
    }

}
