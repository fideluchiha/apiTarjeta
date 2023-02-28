/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.tecnicalTest.apiTarjeta.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author fidel
 */
@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest(classes = TarjetasUtil.class)
public class TarjetasUtilTest {
    
    @InjectMocks TarjetasUtil TarjetasUtil;
    
    private Long pan = 4565456545621321L;

    /**
     * Test of validNumber method, of class TarjetasUtil.
     */
    @Test
    public void testValidNumber() {
        System.out.println("validNumber");
        int test= this.TarjetasUtil.validNumber();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue( test > 0);
    }

    /**
     * Test of panMask method, of class TarjetasUtil.
     */
    @Test
    public void testPanMask() {
        System.out.println("panMask");
        
        String result = this.TarjetasUtil.panMask(pan);
        assertNotNull(result);
    }

    /**
     * Test of hashEncritp method, of class TarjetasUtil.
     */
    @Test
    public void testHashEncritp() {
        System.out.println("hashEncritp");
        
        String result = this.TarjetasUtil.hashEncritp(pan);
        assertNotNull(result);
    }

    

    /**
     * Test of validTime method, of class TarjetasUtil.
     */
    @Test
    public void testValidTime() throws ParseException {
        System.out.println("validTime");
        String sDate1="27-02-2023 21:03"; 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date1 = simpleDateFormat.parse(sDate1);
        Boolean valid =this.TarjetasUtil.validTime(date1);
        
        assertFalse(valid);
        
    }

   
}
