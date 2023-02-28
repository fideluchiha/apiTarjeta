package com.tecnicalTest.apiTarjeta.services.interfaces;

import com.tecnicalTest.apiTarjeta.DTO.RequestCreateTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestDeleteTarjetaDto;
import com.tecnicalTest.apiTarjeta.DTO.RequestEnrolarTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseCreateTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseDeleteTarjetaDto;
import com.tecnicalTest.apiTarjeta.DTO.ResponseEnrolarTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseSelectTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.TblTarjetasDto;
import com.tecnicalTest.apiTarjeta.entity.TblTarjetas;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fidel
 */
@Service
public interface ItarjetasServices {
    
    
    List<TblTarjetasDto> findAll();
    
    ResponseCreateTarjetaDTO save(RequestCreateTarjetaDTO Dto);
    
    
    ResponseEnrolarTarjetaDTO tarjetaEnrolar(RequestEnrolarTarjetaDTO Dto);
    
    ResponseSelectTarjetaDTO getTarjeta(String identificador);
    
    ResponseDeleteTarjetaDto deleteTarjeta(RequestDeleteTarjetaDto identificador);
    
   
}
