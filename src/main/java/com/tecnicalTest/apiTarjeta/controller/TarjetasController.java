package com.tecnicalTest.apiTarjeta.controller;



import com.tecnicalTest.apiTarjeta.DTO.RequestCreateTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestDeleteTarjetaDto;
import com.tecnicalTest.apiTarjeta.DTO.RequestEnrolarTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseCreateTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseDeleteTarjetaDto;
import com.tecnicalTest.apiTarjeta.DTO.ResponseEnrolarTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseSelectTarjetaDTO;
import com.tecnicalTest.apiTarjeta.services.interfaces.ItarjetasServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fidel
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/tarjetas")
public class TarjetasController {
    
    @Autowired
    private ItarjetasServices itarjetasServices;
    
     @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index() {
        
        return  ResponseEntity.ok(this.itarjetasServices.findAll());
    
    }
    
    
      @PostMapping(value ="/saveTarjetas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseCreateTarjetaDTO saveTarjetas(@Valid @RequestBody RequestCreateTarjetaDTO request){
        
        return this.itarjetasServices.save(request);
    }
    
    @PutMapping(value ="/enrollTarjetas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEnrolarTarjetaDTO enrollTarjetas(@Valid @RequestBody RequestEnrolarTarjetaDTO request){
        
        return this.itarjetasServices.tarjetaEnrolar(request);
    }
    
    /**
     *
     * @param identificador
     * @return
     */
    @GetMapping(value ="/getTarjeta/{identificador}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseSelectTarjetaDTO getTarjeta(@PathVariable("identificador") String identificador) {
        
        return this.itarjetasServices.getTarjeta(identificador);
    
    }
    
    @DeleteMapping(value ="/deleteTarjeta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDeleteTarjetaDto deleteTarjeta(@Valid @RequestBody RequestDeleteTarjetaDto request){
        
        return this.itarjetasServices.deleteTarjeta(request);
        
    }
    
    
    
    
   // deleteTarjeta
    
  
    
    
    ///getTarjeta
    
    
    
   // RequestCreateTarjetaDTO
    
}
