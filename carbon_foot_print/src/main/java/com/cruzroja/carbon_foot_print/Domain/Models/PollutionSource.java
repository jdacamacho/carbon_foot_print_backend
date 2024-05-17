package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PollutionSource {
    private PollutionType pollution;
    private Source source;

    public PollutionSource() {
    }
}
