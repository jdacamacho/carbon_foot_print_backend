package com.cruzroja.carbon_foot_print.Application.Input;

import com.cruzroja.carbon_foot_print.Domain.Models.Credential;

public interface ManageAuthCUIntPort {
    public Credential login(String username, String password);
}
