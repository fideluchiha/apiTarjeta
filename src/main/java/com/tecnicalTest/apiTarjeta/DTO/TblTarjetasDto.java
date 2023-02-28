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
public class TblTarjetasDto {
    
    
    private int numeroValidacion;
    private String PAN;
    private String estado;
    private String identificador;
    private String titular;
    private int cedula;
    private int telefono;
    
}
