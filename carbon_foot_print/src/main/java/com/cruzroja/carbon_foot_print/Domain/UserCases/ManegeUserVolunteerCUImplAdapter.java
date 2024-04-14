package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManegeUserVolunteerCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManegeUserVolunteerGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;

public class ManegeUserVolunteerCUImplAdapter implements ManegeUserVolunteerCUIntPort {

    private final ManegeUserVolunteerGatewayIntPort gateway;
    private final ExceptionFormatterIntPort errorFormatter;

    public ManegeUserVolunteerCUImplAdapter(ManegeUserVolunteerGatewayIntPort gateway,
            ExceptionFormatterIntPort errorFormatter) {
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
    }

    @Override
    public List<UserVolunteer> listUserVolunteers() {
        List<UserVolunteer> volunteers = this.gateway.findAll();
        if (volunteers.size() == 0)
            this.errorFormatter.returNoData("No registered volunteers found");
        return volunteers;
    }

    @Override
    public UserVolunteer saveUserVolunteer(UserVolunteer userVolunteer) {
        if (this.gateway.existUserVolunteerByNumberDocument(userVolunteer.getDocumentNumber()) != 0)
            this.errorFormatter.returnResponseErrorEntityExists(
                    "All ready exist an user with number of document " + userVolunteer.getDocumentNumber() + ".");
        if (!userVolunteer.isValidRole(this.gateway.findRoles()))
            this.errorFormatter.returnResponseBadFormat("The roles is not avalible.");
        return this.gateway.save(userVolunteer);
    }

    @Override
    public UserVolunteer updateUserVolunteer(UserVolunteer userVolunteer) {

        if (this.gateway.existUserVolunteerByNumberDocument(userVolunteer.getDocumentNumber()) == 0)
            this.errorFormatter.returnResponseErrorEntityNotFound(
                    "The volunteer woth document number " + userVolunteer.getDocumentNumber() + " has not been found.");
        UserVolunteer oldVolunteer = this.gateway.findUserVolunteerByNumberDocument(userVolunteer.getDocumentNumber());
        if (!userVolunteer.isValidRole(this.gateway.findRoles()))
            this.errorFormatter.returnResponseBadFormat("The roles is not avalible.");
        oldVolunteer.update(userVolunteer);
        return this.gateway.save(oldVolunteer);
    }

    @Override
    public UserVolunteer getUserVolunteerByNumberDocument(long numberDocument) {
        UserVolunteer volunteer = this.gateway.findUserVolunteerByNumberDocument(numberDocument);
        if (volunteer == null)
            this.errorFormatter.returnResponseErrorEntityNotFound(
                    "The volunteer woth document number " + numberDocument + " has not been found.");
        return volunteer;
    }

    @Override
    public List<UserVolunteer> getUserVolunteerByPosition(String position) {
        List<UserVolunteer> volunteers = this.gateway.findUserVolunteerByPosition(position);
        if (volunteers.size() == 0)
            this.errorFormatter.returNoData("There are no volunteers registered with the position: " + position + ".");
        return volunteers;
    }

}
