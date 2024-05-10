package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Source;

public interface ManageSourceGatewayIntPort {
    public List<Source> findAll();
    public Source save(Source source);
    public Source findById(long idSource);
    public boolean existsById(long idCourse);
    public Source findByname(String sourceName);
    public boolean existsByName(String name);
}
