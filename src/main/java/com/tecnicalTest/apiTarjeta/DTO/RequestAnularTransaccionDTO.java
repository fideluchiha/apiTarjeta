/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicalTest.apiTarjeta.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author fidel
 */
@Data
@Builder
public class RequestAnularTransaccionDTO {
    
    @NotBlank(message = "identificador no puede venir vacio")
    @NotNull(message = "identificador no puede venir nulo")
    private String identificador;
    @NotNull(message = "referencia no puede venir vacio")
    @Range(min=100000, max=999999)
    private Long referencia;
    @NotNull(message = "compra es obligatorio")
    @Min(100)
    private Long compra;
    
    
}
