package com.tecnicalTest.apiTarjeta.DTO;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author fidel
 */
@Data
@Builder
public class ResponseEnrolarTarjetaDTO {
    
    
    private String codigoRespuesta;
    private String mensaje;
    private String PAN;
    
}
