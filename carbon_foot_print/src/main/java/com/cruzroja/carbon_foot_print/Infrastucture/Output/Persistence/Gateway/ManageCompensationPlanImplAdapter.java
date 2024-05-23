package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageCompensationPlanGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CompensationPlanEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.CompensationPlanRepository;

@Service
public class ManageCompensationPlanImplAdapter implements ManageCompensationPlanGatewayIntPort{

    private final CompensationPlanRepository serviceBD;
    private final ModelMapper mapper;

    public ManageCompensationPlanImplAdapter(CompensationPlanRepository serviceBD,
                                                ModelMapper mapper){
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public List<CompensationPlan> findAll() {
        Iterable<CompensationPlanEntity> dataFromBD = this.serviceBD.findAll();
        List<CompensationPlan> response = this.mapper.map(dataFromBD, new TypeToken<List<CompensationPlan>>(){}.getType());
        return response;
    }

    @Override
    public CompensationPlan save(CompensationPlan compensationPlan) {
        CompensationPlanEntity objToSave = this.mapper.map(compensationPlan, CompensationPlanEntity.class);
        CompensationPlanEntity objSaved = this.serviceBD.save(objToSave);
        CompensationPlan response = this.mapper.map(objSaved, CompensationPlan.class);
        return response;
    }

    @Override
    public CompensationPlan findById(long planId) {
        CompensationPlanEntity dataFromBD = this.serviceBD.findById(planId).get();
        CompensationPlan response = this.mapper.map(dataFromBD, CompensationPlan.class);
        return response;
    }

    @Override
    public CompensationPlan findByName(String planName) {
        CompensationPlanEntity dataFromBD = this.serviceBD.findByPlanName(planName);
        CompensationPlan response = this.mapper.map(dataFromBD, CompensationPlan.class);
        return response;
    }

    @Override
    public boolean existsById(long planId) {
        return this.serviceBD.existsById(planId);
    }

    @Override
    public boolean existsByName(String planName) {
        return this.serviceBD.existsByPlanName(planName);
    }
    
}
