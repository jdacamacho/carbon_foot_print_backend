package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.Date;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.CompanyPlanId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "company_plan")
@Data
@AllArgsConstructor
@IdClass(CompanyPlanId.class)
public class CompanyPlanEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "companyId")
    private UserCompanyEntity company;
    @Id
    @ManyToOne
    @JoinColumn(name = "vendedorId")
    private UserVolunteerEntity seller;
    @Id
    @ManyToOne
    @JoinColumn(name = "planId")
    private CompensationPlanEntity plan;
    @Id
    @Temporal(TemporalType.DATE)
    private Date sold;

    public CompanyPlanEntity() {
        this.sold = new Date();
    }
}
