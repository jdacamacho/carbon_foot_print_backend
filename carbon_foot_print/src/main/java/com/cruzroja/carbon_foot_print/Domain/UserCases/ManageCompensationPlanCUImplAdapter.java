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
                                        ExceptionFormatterIntPort exceptionFormatter){
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<CompensationPlan> finAllCompensationPlan() {
        List<CompensationPlan> compensationPlans = this.gateway.findAll();
        if(compensationPlans.size() == 0){
            this.exceptionFormatter.returNoData("Not exists compensation plans");
        }
        return compensationPlans;
    }

    @Override
    public CompensationPlan saveCompensationPlan(CompensationPlan compensationPlan) {
        CompensationPlan objPlan = null;
        if(this.gateway.existsByName(compensationPlan.getPlanName())){
            this.exceptionFormatter.returnResponseErrorEntityExists("Compensation plan with that name already exists in the System");
        }else{
            if(!compensationPlan.isValidDiscount()){
                this.exceptionFormatter.returnResponseBusinessRuleViolated("Discount is not valid");
            }
            if(compensationPlan.hasDuplicateAction()){
                this.exceptionFormatter.returnResponseBusinessRuleViolated("Compensation plan has actions duplicate");
            }
            if(!compensationPlan.isValidActions(this.gateway.findAllActions())){
                this.exceptionFormatter.returnResponseBusinessRuleViolated("Compensation has actions that are not valid");
            }
            compensationPlan.calculatePrice();
            objPlan = this.gateway.save(compensationPlan);
        }
        return objPlan;
    }

    @Override
    public CompensationPlan updateCompensationPlan(CompensationPlan compensationPlan) {
        CompensationPlan objPlan = null;
        if(!this.gateway.existsById(compensationPlan.getPlanId())){
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that id was not found");
        }else{
            CompensationPlan oldPlan = this.gateway.findById(compensationPlan.getPlanId());
            if(this.gateway.existsByName(compensationPlan.getPlanName())){
                
                if(!oldPlan.isPlanNameEqual(compensationPlan)){
                    this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that name already exists in the System");
                }
            }else{
                if(!compensationPlan.isValidDiscount()){
                    this.exceptionFormatter.returnResponseBusinessRuleViolated("Discount is not valid");
                }
                if(compensationPlan.hasDuplicateAction()){
                    this.exceptionFormatter.returnResponseBusinessRuleViolated("Compensation plan has actions duplicate");
                }
                if(!compensationPlan.isValidActions(this.gateway.findAllActions())){
                    this.exceptionFormatter.returnResponseBusinessRuleViolated("Compensation has actions that are not valid");
                }
            }
            oldPlan.update(compensationPlan);
            objPlan = this.gateway.save(oldPlan);
        }
        return objPlan;
    }

    @Override
    public CompensationPlan findByCompensationPlanId(long planId) {
        CompensationPlan response = null;
        if(!this.gateway.existsById(planId)){
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that id was not found");
        }
        response = this.gateway.findById(planId);
        return response;
    }

    @Override
    public CompensationPlan findByCompesationPlanName(String planName) {
        CompensationPlan response = null;
        if(!this.gateway.existsByName(planName)){
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that name was not found");
        }
        response = this.gateway.findByName(planName);
        return response;
    }
    
}
