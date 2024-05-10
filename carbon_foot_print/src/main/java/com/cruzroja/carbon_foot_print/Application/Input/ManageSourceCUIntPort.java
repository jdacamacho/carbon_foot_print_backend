package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Source;

public interface ManageSourceCUIntPort {
    public List<Source> listSources();
    public Source saveSource(Source source);
    public Source updateSource(Source source);
    public Source findByIdSource(long idSource);
    public Source findBySourceName(String sourceName);
}
