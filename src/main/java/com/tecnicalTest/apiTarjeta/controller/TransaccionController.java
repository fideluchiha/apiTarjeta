
package com.tecnicalTest.apiTarjeta.controller;

import com.tecnicalTest.apiTarjeta.DTO.RequestAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestEnrolarTarjetaDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseEnrolarTarjetaDTO;
import com.tecnicalTest.apiTarjeta.services.interfaces.ITransaccionServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/transaccion")
public class TransaccionController {
    
    @Autowired
    ITransaccionServices iTransaccionServices;
    
     @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index() {
        
        return  ResponseEntity.ok(this.iTransaccionServices.findAll());
    
    }
    
    
     @PostMapping(value ="/saveTransaccion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseCreateTransaccionDTO saveTarjetas(@Valid @RequestBody RequestCreateTransaccionDTO request){
        
        return this.iTransaccionServices.createTransaccion(request);
    }
    
    
    @PutMapping(value ="/anularTransaccion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseAnularTransaccionDTO anularTransaccion(@Valid @RequestBody RequestAnularTransaccionDTO request){
        
        return this.iTransaccionServices.anularTransaccion(request);
    }
    
    
    
    
}
