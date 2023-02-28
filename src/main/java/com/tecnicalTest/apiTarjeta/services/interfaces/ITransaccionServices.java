/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnicalTest.apiTarjeta.services.interfaces;

import com.tecnicalTest.apiTarjeta.DTO.RequestAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.TblTransaccionDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fidel
 */
@Service
public interface ITransaccionServices {
    
     List<TblTransaccionDto> findAll();
    
    ResponseCreateTransaccionDTO createTransaccion (RequestCreateTransaccionDTO Dto);
    
    ResponseAnularTransaccionDTO  anularTransaccion ( RequestAnularTransaccionDTO Dto);
}
