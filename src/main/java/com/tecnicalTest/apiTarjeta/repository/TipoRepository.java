package com.tecnicalTest.apiTarjeta.repository;

import com.tecnicalTest.apiTarjeta.entity.TblTipo;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fidel
 */
public interface TipoRepository extends CrudRepository<TblTipo, Long>{
    
    Optional<TblTipo> findById(Long id);
    
}
