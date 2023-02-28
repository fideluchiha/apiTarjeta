
package com.tecnicalTest.apiTarjeta.DTO;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author fidel
 */
@Data
@Builder
public class ResponseCreateTarjetaDTO {
    
    private String codigoRespuesta;
    private String mensaje;
    private int numeroValidacion;
    private String PAN;
    private String identificador;
    
    
}
