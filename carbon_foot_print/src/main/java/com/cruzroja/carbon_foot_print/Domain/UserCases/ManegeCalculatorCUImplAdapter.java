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

/**
 * @class ManegeCalculatorCUImplAdapter
 * @brief Implementación de la interfaz ManegeCalculatorCUIntPort para el cálculo de huella de carbono.
 * 
 * Esta clase se encarga de procesar una lista de datos de consumo, validar la información y calcular la huella de carbono.
 */
public class ManegeCalculatorCUImplAdapter implements ManegeCalculatorCUIntPort {
    private final ManagePollutionSourceGatewayIntPort gateway;
    private final ExceptionFormatterIntPort errorFormatter;

    /**
     * Constructor para inicializar los servicios necesarios.
     * 
     * @param gateway Servicio para obtener fuentes de contaminación.
     * @param errorFormatter Servicio para formatear y manejar errores.
     */
    public ManegeCalculatorCUImplAdapter(ManagePollutionSourceGatewayIntPort gateway,
            ExceptionFormatterIntPort errorFormatter) {
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
    }

    /**
     * Calcula la huella de carbono para una lista de datos de consumo.
     * 
     * @param data Lista de datos de consumo.
     * @return CalculatorResponse con los resultados del cálculo de la huella de carbono.
     */
    @Override
    public CalculatorResponse calculeFootPrint(List<DataCalculator> data) {
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        
        // Verifica que la lista de datos no esté vacía.
        if (data.isEmpty())
            this.errorFormatter.returnResponseBadFormat("La lista de datos no puede ser vacía");
        
        for (DataCalculator item : data) {
            // Obtiene la fuente de contaminación correspondiente.
            PollutionSource pollutionSource = this.gateway.findById(item.getPollutionId(), item.getSourceId());
            if (pollutionSource == null)
                this.errorFormatter
                        .returnResponseBusinessRuleViolated("No se encontró pollution source con id pollution: "
                                + item.getPollutionId() + " y source: " + item.getSourceId() + ".");
            
            // Verifica que el año del dato no sea superior al año actual.
            if (item.getYear() > actualYear)
                this.errorFormatter
                        .returnResponseBusinessRuleViolated("El año a calcular no puede ser superior al actual.");
            
            // Verifica que la cobertura sea válida.
            if (!item.isValidCoverge())
                this.errorFormatter
                        .returnResponseBusinessRuleViolated(
                                "El informedSource debe ser menor o igual al totalSource");
            
            item.setPollutionSource(pollutionSource);
            item.calculeData();
        }
        
        Calculator calculator = new Calculator(data);
        
        // Verifica si hay datos duplicados.
        if (calculator.isDuplicate())
            this.errorFormatter.returnResponseBusinessRuleViolated(
                    "Se detectaron datos repetidos, asegúrese de que la llave compuesta por (month, year, pollutionId, sourceId) sea única en cada registro.");
        
        // Calcula la huella de carbono.
        calculator.calcule();
        return calculator.getResults();
    }
}
