/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.tecnicalTest.apiTarjeta.controller;

import com.tecnicalTest.apiTarjeta.DTO.RequestAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.RequestCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseAnularTransaccionDTO;
import com.tecnicalTest.apiTarjeta.DTO.ResponseCreateTransaccionDTO;
import com.tecnicalTest.apiTarjeta.services.interfaces.ITransaccionServices;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author fidel
 */
@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest(classes = TransaccionController.class)
@AutoConfigureMockMvc(addFilters = false)
@EnableWebMvc
public class TransaccionControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    ITransaccionServices iTransaccionServices;

    /**
     * Test of index method, of class TransaccionController.
     */
    @Test
    public void testIndex() throws Exception {
        System.out.println("index");
               
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/transaccion/all")
                .accept(MediaType.APPLICATION_JSON).content("")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

   
    
}
