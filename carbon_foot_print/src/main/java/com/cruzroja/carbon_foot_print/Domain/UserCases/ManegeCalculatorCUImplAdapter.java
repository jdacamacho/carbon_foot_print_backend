package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.Calendar;
import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManegeCalculatorCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManagePollutionSourceGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Calculator.Calculator;
import com.cruzroja.carbon_foot_print.Domain.Calculator.CalculatorResponse;
import com.cruzroja.carbon_foot_print.Domain.Models.DataCalculator;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;

public class ManegeCalculatorCUImplAdapter implements ManegeCalculatorCUIntPort {
    private final ManagePollutionSourceGatewayIntPort gateway;
    private final ExceptionFormatterIntPort errorFormatter;

    public ManegeCalculatorCUImplAdapter(ManagePollutionSourceGatewayIntPort gateway,
            ExceptionFormatterIntPort errorFormatter) {
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
    }

    @Override
    public CalculatorResponse calculeFootPrint(List<DataCalculator> data) {
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        if (data.isEmpty())
            this.errorFormatter.returnResponseBadFormat("La lista de datos no puede ser vacía");
        for (DataCalculator item : data) {
            PollutionSource pollutionSource = this.gateway.findById(item.getPollutionId(), item.getSourceId());
            if (pollutionSource == null)
                this.errorFormatter
                        .returnResponseBusinessRuleViolated("No se encontró pollution source con id pollution: "
                                + item.getPollutionId() + " y source: " + item.getSourceId() + ".");
            if (item.getYear() > actualYear)
                this.errorFormatter
                        .returnResponseBusinessRuleViolated("El año a calcular no puede ser superior al actual.");
            if (!item.isValidCoverge())
                this.errorFormatter
                        .returnResponseBusinessRuleViolated(
                                "El informedSource debe ser menor o igual al totalSource");
            item.setPollutionSource(pollutionSource);
            item.calculeData();
        }
        Calculator calculator = new Calculator(data);
        if (calculator.isDuplicate())
            this.errorFormatter.returnResponseBusinessRuleViolated(
                    "Se detectaron datos repetidos, asegurese de que la llave compuesta por (month, year, pollutionId, sourceId) sea única en cada registro.");
        calculator.calcule();
        return calculator.getResults();
    }

}
