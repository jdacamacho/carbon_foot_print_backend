package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyPlan {
    private UserCompany company;
    private UserVolunteer seller;
    private CompensationPlan plan;
    private Date sold;

    public CompanyPlan() {
        this.sold = new Date();
    }

    public CompanyPlan(UserCompany company, UserVolunteer seller, CompensationPlan plan) {
        this.company = company;
        this.seller = seller;
        this.plan = plan;
        this.sold = new Date();
    }
}
