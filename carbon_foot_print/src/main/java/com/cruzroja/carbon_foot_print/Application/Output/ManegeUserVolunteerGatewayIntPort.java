package com.cruzroja.carbon_foot_print.Application.Output;

import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;
import java.util.List;

public interface ManegeUserVolunteerGatewayIntPort {
    public List<UserVolunteer> findAll();

    public UserVolunteer save(UserVolunteer userVolunteer);

    public UserVolunteer findUserVolunteerByNumberDocument(long numberDocument);

    public List<UserVolunteer> findUserVolunteerByPosition(String position);

    public List<Role> findRoles();

}
