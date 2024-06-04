package com.cruzroja.carbon_foot_print.Domain.CompansationPlan.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.ActionWithAmount;
import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.CompensationMiddleWare;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationAction;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;

@Component
public class CompensationMapperDomainMiddleWare {
    public List<CompensationAction> mapMiddleWareTODomain(CompensationMiddleWare middleWare) {
        CompensationPlan plan = middleWare.getPlan();
        List<CompensationAction> domain = new ArrayList<>();
        middleWare.getActions()
                .forEach(action -> domain.add(new CompensationAction(action.getAction(), plan, action.getAmount())));
        return domain;
    }

    public CompensationMiddleWare mapGroupedDomainToMiddleWare(List<CompensationAction> domain) {
        if (domain == null)
            return null;
        CompensationPlan plan = domain.get(0).getPlan();
        List<ActionWithAmount> action = new ArrayList<>();
        domain.forEach(compensation -> action.add(new ActionWithAmount(compensation.getAction(),
                compensation.getCompensationActionAmount(), compensation.getCompensationActionPrice())));
        return new CompensationMiddleWare(plan, action);
    }

    public List<CompensationMiddleWare> mapDomainToMiddleWare(List<CompensationAction> domain) {
        if (domain == null)
            return null;
        Map<Long, List<CompensationAction>> groups = this.groupByPlan(domain);
        List<CompensationMiddleWare> response = new ArrayList<>();
        groups.forEach((k, v) -> {
            response.add(this.mapGroupedDomainToMiddleWare(v));
        });
        return response;
    }

    private Map<Long, List<CompensationAction>> groupByPlan(List<CompensationAction> domain) {
        if (domain == null)
            return null;
        return domain.stream().collect(Collectors.groupingBy(ca -> ca.getPlan().getPlanId()));
    }
}
