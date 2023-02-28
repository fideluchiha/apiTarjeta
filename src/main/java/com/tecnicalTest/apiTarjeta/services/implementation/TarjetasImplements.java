package com.tecnicalTest.apiTarjeta.services.implementation;

import com.google.gson.Gson;
import com.tecnicalTest.apiTarjeta.DTO.RequestAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestCreateTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestDeleteTarjetaDto;
import com.tecnicalTest.apiTarjeta.DTO.RequestEnrolarTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseCreateTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseDeleteTarjetaDto;
import com.tecnicalTest.apiTarjeta.DTO.ResponseEnrolarTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseSelectTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.TblTarjetasDto;
import com.tecnicalTest.apiTarjeta.Util.TarjetasUtil;
import com.tecnicalTest.apiTarjeta.entity.TblEstado;
import com.tecnicalTest.apiTarjeta.entity.TblLogs;
import com.tecnicalTest.apiTarjeta.entity.TblTarjetas;
import com.tecnicalTest.apiTarjeta.entity.TblTipo;
import com.tecnicalTest.apiTarjeta.entity.TblTransaccion;
import com.tecnicalTest.apiTarjeta.repository.EstadoRepository;
import com.tecnicalTest.apiTarjeta.repository.LogsRepository;
import com.tecnicalTest.apiTarjeta.repository.TarjetaRepository;
import com.tecnicalTest.apiTarjeta.repository.TipoRepository;
import com.tecnicalTest.apiTarjeta.repository.TransaccionRepository;

import com.tecnicalTest.apiTarjeta.services.interfaces.ItarjetasServices;
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

public class TarjetasImplements implements ItarjetasServices {

    @Autowired
    private TarjetaRepository tarjetasRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private LogsRepository logsRepository;
    TarjetasUtil TarjetasUtil = new TarjetasUtil();

    @Override
    public List<TblTarjetasDto> findAll() {
        
        List<TblTarjetasDto> list = new  ArrayList<>(); 
        List<TblTarjetas> Tblclientes = this.tarjetasRepository.findAll();
        
        for (int i = 0; i < Tblclientes.size(); i++) {
            
            list.add(TblTarjetasDto.builder()
                    .PAN(TarjetasUtil.panMask(Tblclientes.get(i).getPan()))
                    .cedula(Tblclientes.get(i).getCedula())
                    .identificador(Tblclientes.get(i).getHash())
                    .estado(Tblclientes.get(i).getIdEstado().getDescripcion())
                    .numeroValidacion(Tblclientes.get(i).getNumeroValidacion())
                    .telefono(Tblclientes.get(i).getTelefono())
                    .titular(Tblclientes.get(i).getTitular())
                    .build());
              //  System.out.println(Tblclientes.iterator().next().);
              }
        return list;
    }

    @Override
    public ResponseCreateTarjetaDTO save( RequestCreateTarjetaDTO Dto) {
        
        String validPan = String.valueOf(Dto.getPan());
        if(validPan.length() < 16 || validPan.length() > 19 ){
            
            return ResponseCreateTarjetaDTO.builder()
                        .codigoRespuesta("01")
                        .mensaje("Error Pan no tiene el tamaño adecuado").build();
        }

        try {

            Optional<TblTipo> tipo = tipoRepository.findById(Dto.getIdTipo());
            Optional<TblEstado> estado = estadoRepository.findByDescripcion("creada");

            if (tipo.isPresent() && estado.isPresent()) {

                TblTarjetas tarjetas = TblTarjetas.builder().
                        cedula(Dto.getCedula())
                        .numeroValidacion(TarjetasUtil.validNumber())
                        .pan(Dto.getPan())
                        .titular(Dto.getTitular())
                        .idTipo(tipo.get())
                        .telefono(Dto.getTelefono())
                        .idEstado(estado.get())
                        .hash(TarjetasUtil.hashEncritp(Dto.getPan()))
                        .build();
                tarjetas = this.tarjetasRepository.save(tarjetas);
                
                Gson gson = new Gson();
                this.logsRepository.save(TblLogs.builder()
                        .accion("Insert")
                        .antes("Nuevo")
                        .ahora(gson.toJson(Dto))
                        .tabla("TblTarjetas")
                        .build());

                return ResponseCreateTarjetaDTO.builder()
                        .codigoRespuesta("00")
                        .mensaje("Exitoso!!! tarjeta creada")
                        .PAN(TarjetasUtil.panMask(Dto.getPan()))
                        .numeroValidacion(tarjetas.getNumeroValidacion())
                        .identificador(tarjetas.getHash())
                        .build();
            } else {

                return ResponseCreateTarjetaDTO.builder()
                        .codigoRespuesta("01")
                        .mensaje("Error no existe tipo").build();
            }

        } catch (Exception ex) {
            return ResponseCreateTarjetaDTO.builder()
                    .codigoRespuesta("01")
                    .mensaje("Error Tecnico contactar a soporte").build();
        }

    }

    @Override
    public ResponseEnrolarTarjetaDTO tarjetaEnrolar(RequestEnrolarTarjetaDTO Dto) {

        try {
            Optional<TblTarjetas> tarjeta = tarjetasRepository.findByHash(Dto.getIdentificador());
            Optional<TblEstado> estado = estadoRepository.findByDescripcion("enrolada");

            if (tarjeta.isPresent() && estado.isPresent() && tarjeta.get().getNumeroValidacion() == Dto.getNumeroValidacion()) {

                TblTarjetas EnrollCard = tarjeta.get();
                EnrollCard.setIdEstado(estado.get());
                this.tarjetasRepository.save(EnrollCard);
                this.logsRepository.save(TblLogs.builder()
                        .accion("tarjetaEnrolar")
                        .antes(tarjeta.toString())
                        .ahora(EnrollCard.toString())
                        .tabla("TblTarjetas")
                        .build());
                return ResponseEnrolarTarjetaDTO.builder()
                        .codigoRespuesta("00")
                        .mensaje("Exito")
                        .PAN(TarjetasUtil.panMask(EnrollCard.getPan()))
                        .build();

            } else if (tarjeta.isPresent() && estado.isPresent() && tarjeta.get().getNumeroValidacion() != Dto.getNumeroValidacion()) {

                return ResponseEnrolarTarjetaDTO.builder()
                        .codigoRespuesta("02")
                        .mensaje("Número de validación inválido").build();
            } else {

                return ResponseEnrolarTarjetaDTO.builder()
                        .codigoRespuesta("01")
                        .mensaje("Tarjeta no existe").build();
            }

        } catch (Exception ex) {
            Logger.getLogger(TarjetasUtil.class.getName()).log(Level.SEVERE, null, ex);
            return ResponseEnrolarTarjetaDTO.builder()
                    .codigoRespuesta("XX")
                    .mensaje("Error Tecnico contactar a soporte").build();

        }

        //return null;
    }

    @Override
    public ResponseSelectTarjetaDTO getTarjeta(String identificador) {

        try {
            Optional<TblTarjetas> tarjeta = tarjetasRepository.findByHash(identificador);

            if (tarjeta.isPresent()) {

                return ResponseSelectTarjetaDTO.builder()
                        .codigoRespuesta("00")
                        .mensaje("Exito")
                        .PAN(TarjetasUtil.panMask(tarjeta.get().getPan()))
                        .titular(tarjeta.get().getTitular())
                        .cedula(tarjeta.get().getCedula())
                        .telefono(tarjeta.get().getTelefono())
                        .estado(tarjeta.get().getIdEstado().getDescripcion())
                        .build();

            } else {

                return ResponseSelectTarjetaDTO.builder()
                        .codigoRespuesta("01")
                        .mensaje("No existen Datos")
                        .build();
            }

        } catch (Exception ex) {
            Logger.getLogger(TarjetasUtil.class.getName()).log(Level.SEVERE, null, ex);
            return ResponseSelectTarjetaDTO.builder()
                    .codigoRespuesta("XX")
                    .mensaje("Error Tecnico contactar a soporte").build();

        }

    }

    @Override
    public ResponseDeleteTarjetaDto deleteTarjeta(RequestDeleteTarjetaDto Dto) {
        try {
            Optional<TblTarjetas> tarjeta = tarjetasRepository.findByHash(Dto.getIdentificador());
            Optional<TblEstado> estado = estadoRepository.findByDescripcion("desactivada");

            if (tarjeta.isPresent() && estado.isPresent()) {

                TblTarjetas deleteCard = tarjeta.get();
                deleteCard.setIdEstado(estado.get());
                this.tarjetasRepository.save(deleteCard);
                this.logsRepository.save(TblLogs.builder()
                        .accion("deleteTarjeta")
                        .antes(tarjeta.toString())
                        .ahora(deleteCard.toString())
                        .tabla("TblTarjetas")
                        .build());

                return ResponseDeleteTarjetaDto.builder()
                        .codigoRespuesta("00")
                        .mensaje("Se ha eliminado la tarjeta")
                        .build();

            } else {

                return ResponseDeleteTarjetaDto.builder()
                        .codigoRespuesta("01")
                        .mensaje("No se ha eliminado la tarjeta")
                        .build();
            }

        } catch (Exception ex) {
            Logger.getLogger(TarjetasUtil.class.getName()).log(Level.SEVERE, null, ex);
            return ResponseDeleteTarjetaDto.builder()
                    .codigoRespuesta("XX")
                    .mensaje("Error Tecnico contactar a soporte").build();

        }

    }

   

}
