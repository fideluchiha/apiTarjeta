
package com.tecnicalTest.apiTarjeta.repository;

import com.tecnicalTest.apiTarjeta.entity.TblTransaccion;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fidel
 */
public interface TransaccionRepository extends CrudRepository<TblTransaccion, Long>{
    
    
     Optional<TblTransaccion> findByHashAndReferenciaAndTotalCompra(String hash,Long referencia, Long totalCompra);
    
      List<TblTransaccion> findAll();
}
