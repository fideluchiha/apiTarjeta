package com.tecnicalTest.apiTarjeta.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fidel
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDeleteTarjetaDto {
    
    private String identificador;
    
}
