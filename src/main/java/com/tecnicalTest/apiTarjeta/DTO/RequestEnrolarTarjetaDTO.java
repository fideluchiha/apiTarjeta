package com.tecnicalTest.apiTarjeta.DTO;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author fidel
 */

@Data
@Builder
public class RequestEnrolarTarjetaDTO {
    
    private int numeroValidacion;
    private String identificador;
    
}
