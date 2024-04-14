package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;

public interface ManegeUserVolunteerCUIntPort {
    public List<UserVolunteer> listUserVolunteers();

    public UserVolunteer saveUserVolunteer(UserVolunteer userVolunteer);

    public UserVolunteer updateUserVolunteer(UserVolunteer userVolunteer);

    public UserVolunteer getUserVolunteerByNumberDocument(long numberDocument);

    public List<UserVolunteer> getUserVolunteerByPosition(String position);
}
