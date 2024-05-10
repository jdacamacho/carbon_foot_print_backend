package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageSourceCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageSourceGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Source;

public class ManageSourceCUImplAdapter implements ManageSourceCUIntPort{
    private final ManageSourceGatewayIntPort gateway;
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManageSourceCUImplAdapter(ManageSourceGatewayIntPort gateway,
                                    ExceptionFormatterIntPort exceptionFormatter){
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<Source> listSources() {
        List<Source> sources = this.gateway.findAll();
        if(sources.size() == 0){
            this.exceptionFormatter.returNoData("No sources found in the System");
        }
        return sources;
    }

    @Override
    public Source saveSource(Source source) {
        Source objResponse = null;
        if(this.gateway.existsByName(source.getSourceName())){
            this.exceptionFormatter.returnResponseErrorEntityExists("Source exists with that name in the System");
        }
        objResponse = this.gateway.save(source);
        return objResponse;
        
    }

    @Override
    public Source updateSource(Source source) {
        Source objResponse = null;
        if(!this.gateway.existsById(source.getIdSource())){
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Source not found in the System with that ID");
        }else{
            Source sourceObtained = this.gateway.findById(source.getIdSource());
            if(this.gateway.existsByName(source.getSourceName())){
                if(!sourceObtained.verifySourceName(source.getSourceName())){
                    this.exceptionFormatter.returnResponseErrorEntityExists("Source found in the System with that name");
                }
            }
            sourceObtained.setSourceName(source.getSourceName());
            objResponse = this.gateway.save(sourceObtained);
        }
        return objResponse;
    }

    @Override
    public Source findByIdSource(long idSource) {
        Source objResponse = null;
        if(!this.gateway.existsById(idSource)){
            this.exceptionFormatter.returNoData("Source with that ID not found in the System");
        }
        objResponse = this.gateway.findById(idSource);
        return objResponse;
    }

    @Override
    public Source findBySourceName(String sourceName) {
        Source objResponse = null;
        if(!this.gateway.existsByName(sourceName)){
            this.exceptionFormatter.returNoData("Source with that ID not found in the System");
        }
        objResponse = this.gateway.findByname(sourceName);
        return objResponse;
    }
    

}
