package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Source {
    private long idSource;
    private String sourceName;

    public Source(){

    }

}
