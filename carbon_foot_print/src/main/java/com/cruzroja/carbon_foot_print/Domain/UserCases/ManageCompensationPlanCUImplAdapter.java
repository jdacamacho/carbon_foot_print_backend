
/**
 * @file ManageCompensationPlanCUImplAdapter.java
 * @brief Implementación de la interfaz ManageCompensationPlanCUIntPort.
 */

package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageCompensationPlanCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageCompensationPlanGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;

public class ManageCompensationPlanCUImplAdapter implements ManageCompensationPlanCUIntPort {

    private final ManageCompensationPlanGatewayIntPort gateway;
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManageCompensationPlanCUImplAdapter(ManageCompensationPlanGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<CompensationPlan> finAllCompensationPlan() {
        List<CompensationPlan> compensationPlans = this.gateway.findAll();
        if (compensationPlans.size() == 0) {
            this.exceptionFormatter.returNoData("Not exists compensation plans");
        }
        return compensationPlans;
    }

    @Override
    public CompensationPlan saveCompensationPlan(CompensationPlan compensationPlan) {
        CompensationPlan objPlan = null;
        if (this.gateway.existsByName(compensationPlan.getPlanName()))
            this.exceptionFormatter
                    .returnResponseErrorEntityExists("Compensation plan with that name already exists in the System");
        if (!compensationPlan.isValidDiscount())
            this.exceptionFormatter.returnResponseBusinessRuleViolated("Discount is not valid");
        return objPlan;
    }

    @Override
    public CompensationPlan updateCompensationPlan(CompensationPlan compensationPlan) {

        if (!this.gateway.existsById(compensationPlan.getPlanId()))
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that id was not found");
        CompensationPlan oldPlan = this.gateway.findById(compensationPlan.getPlanId());
        if (!oldPlan.isPlanNameEqual(compensationPlan))
            if (this.gateway.existsByName(compensationPlan.getPlanName()))
                this.exceptionFormatter.returnResponseErrorEntityNotFound(
                        "Compensation plan with that name already exists in the System");
        if (!compensationPlan.isValidDiscount())
            this.exceptionFormatter.returnResponseBusinessRuleViolated("Discount is not valid");
        oldPlan.update(compensationPlan);
        return this.gateway.save(oldPlan);
    }

    @Override
    public CompensationPlan findByCompensationPlanId(long planId) {
        CompensationPlan response = null;
        if (!this.gateway.existsById(planId)) {
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that id was not found");
        }
        response = this.gateway.findById(planId);
        return response;
    }

    @Override
    public CompensationPlan findByCompesationPlanName(String planName) {
        CompensationPlan response = null;
        if (!this.gateway.existsByName(planName)) {
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that name was not found");
        }
        response = this.gateway.findByName(planName);
        return response;
    }

    @Override
    public CompensationPlan updateWithPrice(CompensationPlan compensationPlan) {
        if (!this.gateway.existsById(compensationPlan.getPlanId()))
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that id was not found");
        CompensationPlan oldPlan = this.gateway.findById(compensationPlan.getPlanId());
        if (!oldPlan.isPlanNameEqual(compensationPlan))
            if (this.gateway.existsByName(compensationPlan.getPlanName()))
                this.exceptionFormatter.returnResponseErrorEntityNotFound(
                        "Compensation plan with that name already exists in the System");
        if (!compensationPlan.isValidDiscount())
            this.exceptionFormatter.returnResponseBusinessRuleViolated("Discount is not valid");
        oldPlan.updateWithPrice(compensationPlan);
        return this.gateway.save(oldPlan);
    }

}
