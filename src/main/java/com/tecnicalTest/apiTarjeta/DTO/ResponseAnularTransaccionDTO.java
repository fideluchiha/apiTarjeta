/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicalTest.apiTarjeta.DTO;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author fidel
 */
@Data
@Builder
public class ResponseAnularTransaccionDTO {
    
     private String codigoRespuesta;
     private String mensaje;
     private Long referencia;
    
}
