
package com.tecnicalTest.apiTarjeta.repository;

import com.tecnicalTest.apiTarjeta.entity.TblTarjetas;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fidel
 */
@Repository
public interface TarjetaRepository extends CrudRepository<TblTarjetas, Long>{
    
   
    Optional<TblTarjetas> findByHash(String hash);
    
    public List<TblTarjetas> findAll();
    
}
