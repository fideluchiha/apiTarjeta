
package com.tecnicalTest.apiTarjeta.DTO;


import lombok.Builder;
import lombok.Data;



/**
 *
 * @author fidel
 */

@Data
@Builder
public class ResponseDeleteTarjetaDto {
    
    
    private String codigoRespuesta;
    private String mensaje;
    
}
