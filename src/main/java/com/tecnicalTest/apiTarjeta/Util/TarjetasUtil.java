package com.tecnicalTest.apiTarjeta.Util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author fidel
 */
public class TarjetasUtil {
    
    public int validNumber(){
        
        int resultado = (int) (Math.random()*100+1);
        return resultado;
    }
    
    public String panMask(Long pan){
        
        
        String onePart = String.valueOf(pan).substring(0, 6);
        String twoPart = String.valueOf(pan).
                substring(
                        String.valueOf(pan).length()-4,
                        String.valueOf(pan).length());
        return onePart+"****"+twoPart;
    }
    
    public String hashEncritp(Long tarjeta){
        
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            System.out.println(simpleDateFormat.format(date));
            String hash = String.valueOf(tarjeta)+"/"+simpleDateFormat.format(date);
            System.out.println("hash--"+hash);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(hash.getBytes(StandardCharsets.UTF_8));
            String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
            
            // imprimir resumen de mensaje SHA-256
            System.out.println(sha256);
            
            
            return sha256;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TarjetasUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public Boolean validTime(Date compra){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(compra); //tuFechaBase es un Date;
        calendar.add(Calendar.MINUTE, 5); //minutosASumar es int.
        
        Date tiempoLimite = calendar.getTime();
        
        Date now = new Date();
        
        Boolean valid= false;
        System.out.println(now+ " "+tiempoLimite+now.before(tiempoLimite));
        
        System.out.println(now+" "+compra+now.after(compra));
        if (now.before(tiempoLimite) && now.after(compra)) {
            
            valid = true;
        }
        return valid;
    }
    
    
    /*public static void main(String[] args) throws ParseException{
        
        String sDate1="27-02-2023 21:03";  
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
         Date date1 = simpleDateFormat.parse(sDate1);
        TarjetasUtil TarjetasUtil =new TarjetasUtil();
		//System.out.println(TarjetasUtil.hashEncritp(123456789963214L));
        System.out.println(TarjetasUtil.validTime(date1));
                
	
	}*/
    
    
    
    
    
}
