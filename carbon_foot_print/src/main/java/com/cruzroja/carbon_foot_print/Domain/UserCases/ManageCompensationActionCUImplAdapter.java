package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageCompensationActionCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Input.ManageCompensationPlanCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageCompensationActionGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.CompensationMiddleWare;
import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.mapper.CompensationMapperDomainMiddleWare;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;

public class ManageCompensationActionCUImplAdapter implements ManageCompensationActionCUIntPort {

    private final ManageCompensationActionGatewayIntPort gateway;
    private final ManageCompensationPlanCUIntPort cuPlan;
    private final ExceptionFormatterIntPort exceptionFormatter;
    private final CompensationMapperDomainMiddleWare mapper;

    public ManageCompensationActionCUImplAdapter(
            ManageCompensationActionGatewayIntPort gateway,
            ManageCompensationPlanCUIntPort cuPlan,
            ExceptionFormatterIntPort exceptionFormatter,
            CompensationMapperDomainMiddleWare mapper) {
        this.gateway = gateway;
        this.cuPlan = cuPlan;
        this.exceptionFormatter = exceptionFormatter;
        this.mapper = mapper;
    }

    @Override
    public List<CompensationMiddleWare> findAll() {
        List<CompensationMiddleWare> data = this.mapper.mapDomainToMiddleWare(this.gateway.findAll());
        if (data.isEmpty())
            this.exceptionFormatter.returNoData("Not exist compensation actions");
        return data;
    }

    @Override
    public CompensationMiddleWare findByPlanId(long plan) {
        CompensationMiddleWare data = this.mapper.mapGroupedDomainToMiddleWare(this.gateway.findById(plan));
        if (data == null)
            this.exceptionFormatter.returNoData("Not exist compensation actions with plan id: " + plan + ".");
        return data;
    }

    @Override
    public CompensationMiddleWare findByPlanName(String name) {

        CompensationMiddleWare data = this.mapper.mapGroupedDomainToMiddleWare(this.gateway.findByName(name));
        if (data == null)
            this.exceptionFormatter.returNoData("Not exist compensation actions with name: " + name + ".");
        return data;
    }

    @Override
    public CompensationMiddleWare save(CompensationMiddleWare compensationMiddleWare) {
        if (compensationMiddleWare.isValidActions(this.gateway.findValidActions()))
            this.exceptionFormatter.returnResponseBusinessRuleViolated("The selected actions are not in the system.");
        compensationMiddleWare.calculeFullPrice();
        CompensationPlan plan = this.cuPlan.saveCompensationPlan(compensationMiddleWare.getPlan());
        compensationMiddleWare.setPlan(plan);
        return this.mapper.mapGroupedDomainToMiddleWare(
                this.gateway.save(this.mapper.mapMiddleWareTODomain(compensationMiddleWare)));
    }

    @Override
    public CompensationMiddleWare update(CompensationMiddleWare compensationMiddleWare) {
        if (compensationMiddleWare.isValidActions(this.gateway.findValidActions()))
            this.exceptionFormatter.returnResponseBusinessRuleViolated("The selected actions are not in the system.");
        CompensationMiddleWare old = this.mapper
                .mapGroupedDomainToMiddleWare(this.gateway.findById(compensationMiddleWare.getPlan().getPlanId()));
        compensationMiddleWare.calculeFullPrice();
        this.cuPlan.updateWithPrice(compensationMiddleWare.getPlan());
        List<Long> removed = compensationMiddleWare.removedActions(old.getOnlyActions());
        if (!removed.isEmpty())
            this.gateway.delete(compensationMiddleWare.getPlan().getPlanId(), removed);
        return this.mapper.mapGroupedDomainToMiddleWare(
                this.gateway.save(this.mapper.mapMiddleWareTODomain(compensationMiddleWare)));
    }

}
