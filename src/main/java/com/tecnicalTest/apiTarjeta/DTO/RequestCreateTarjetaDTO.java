package com.tecnicalTest.apiTarjeta.DTO;

import javax.persistence.Column;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author fidel
 */
@Data
@Builder
public class RequestCreateTarjetaDTO {
    
    @NotNull(message = "pan es obligatorio")
    private Long pan;
    @NotNull(message = "idTipo es obligatorio")
    private Long idTipo;
    @NotNull(message = "titular es obligatorio")
    private String titular;
    @NotNull(message = "cedula es obligatorio")
    private int cedula;
    @NotNull(message = "telefono es obligatorio")
    private int telefono;
    
    
    
    
}
