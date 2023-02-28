/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicalTest.apiTarjeta.services.implementation;

import com.tecnicalTest.apiTarjeta.DTO.RequestAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.TblTransaccionDto;
import com.tecnicalTest.apiTarjeta.Util.TarjetasUtil;
import com.tecnicalTest.apiTarjeta.entity.TblEstado;
import com.tecnicalTest.apiTarjeta.entity.TblTarjetas;
import com.tecnicalTest.apiTarjeta.entity.TblTransaccion;
import com.tecnicalTest.apiTarjeta.repository.EstadoRepository;
import com.tecnicalTest.apiTarjeta.repository.TarjetaRepository;
import com.tecnicalTest.apiTarjeta.repository.TransaccionRepository;
import com.tecnicalTest.apiTarjeta.services.interfaces.ITransaccionServices;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fidel
 */
@Component
public class TransaccionImplements implements ITransaccionServices {
    
    @Autowired
    private TarjetaRepository tarjetasRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private TransaccionRepository transaccionRepository;
    
    TarjetasUtil TarjetasUtil = new TarjetasUtil();
    
    @Override
    public List<TblTransaccionDto> findAll(){
        
         List<TblTransaccionDto> list = new  ArrayList<>(); 
        List<TblTransaccion> Tbltarjetas = this.transaccionRepository.findAll();
        
        for (int i = 0; i < Tbltarjetas.size(); i++) {
            
            list.add(TblTransaccionDto.builder()
                    .compra(Tbltarjetas.get(i).getTotalCompra())
                    .direccion(Tbltarjetas.get(i).getDireccionCompra())
                    .identificador(Tbltarjetas.get(i).getHash())
                    .referencia(Tbltarjetas.get(i).getReferencia())
                    .estado(Tbltarjetas.get(i).getIdEstado().getDescripcion())
                    .build());
              //  System.out.println(Tblclientes.iterator().next().);
              }
        return list;
        
    }
    
     @Override
    public ResponseCreateTransaccionDTO createTransaccion(RequestCreateTransaccionDTO Dto) {
        try {
            
            
            Optional<TblTarjetas> tarjeta = tarjetasRepository.findByHash(Dto.getIdentificador());
            Optional<TblEstado> aprobada = estadoRepository.findByDescripcion("Aprobada");
            Optional<TblEstado> estado = estadoRepository.findByDescripcion("enrolada");
            if (tarjeta.isPresent()) {

                if (tarjeta.get().getIdEstado().getIdEstado() == estado.get().getIdEstado()) {

                    TblTransaccion transaccion= TblTransaccion.builder()
                            .hash(Dto.getIdentificador())
                            .referencia(Dto.getReferencia())
                            .totalCompra(Dto.getCompra())
                            .idEstado(aprobada.get())
                            .direccionCompra(Dto.getDireccion())
                            .build();
                    this.transaccionRepository.save(transaccion);

                    return ResponseCreateTransaccionDTO.builder()
                            .codigoRespuesta("00")
                            .mensaje("Compra exitosa")
                            .estado(transaccion.getIdEstado().getDescripcion())
                            .referencia(Dto.getReferencia())
                            .build();

                } else {

                    return ResponseCreateTransaccionDTO.builder()
                            .codigoRespuesta("02")
                            .mensaje("Tarjeta no enrolada")
                            .referencia(Dto.getReferencia())
                            .build();

                }

            } else {

                return ResponseCreateTransaccionDTO.builder()
                        .codigoRespuesta("01")
                        .mensaje("Tarjeta no existe,")
                        .referencia(Dto.getReferencia())
                        .build();

            }

        } catch (Exception ex) {
            Logger.getLogger(TarjetasUtil.class.getName()).log(Level.SEVERE, null, ex);
            return ResponseCreateTransaccionDTO.builder()
                    .codigoRespuesta("XX")
                    .mensaje("Error Tecnico contactar a soporte").build();

        }
    }

    @Override
    public ResponseAnularTransaccionDTO  anularTransaccion(RequestAnularTransaccionDTO Dto) {
        try{
                
                
            
                Optional<TblTransaccion> transaccion = transaccionRepository.findByHashAndReferenciaAndTotalCompra(Dto.getIdentificador(),
                        Dto.getReferencia(), Dto.getCompra());
                Optional<TblEstado> estado = estadoRepository.findByDescripcion("anulada");

                if(transaccion.isPresent()){
                    
                    if(!TarjetasUtil.validTime(transaccion.get().getCreated())){
                    
                        return ResponseAnularTransaccionDTO.builder()
                        .codigoRespuesta("02")
                            .mensaje("No se puede anular transacción").build();

                    }

                    TblTransaccion transaccionPresent = transaccion.get();

                    transaccionPresent.setIdEstado(estado.get());
                    transaccionRepository.save(transaccionPresent);

                    return ResponseAnularTransaccionDTO.builder()
                                .codigoRespuesta("00")
                                .mensaje("Compra anulada")
                                .referencia(Dto.getReferencia())
                                .build();


                }else{

                    return ResponseAnularTransaccionDTO.builder()
                                .codigoRespuesta("01")
                                .mensaje("numero de referencia inválido")
                                .referencia(Dto.getReferencia())
                                .build();

                }
        
               
       } catch (Exception ex) {
            Logger.getLogger(TarjetasUtil.class.getName()).log(Level.SEVERE, null, ex);
            return ResponseAnularTransaccionDTO.builder()
                    .codigoRespuesta("02")
                    .mensaje("No se puede anular transacción").build();

        }
               }
    
}
