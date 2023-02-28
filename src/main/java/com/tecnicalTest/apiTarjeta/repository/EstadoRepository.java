package com.tecnicalTest.apiTarjeta.repository;

import com.tecnicalTest.apiTarjeta.entity.TblEstado;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fidel
 */
public interface EstadoRepository extends CrudRepository<TblEstado, Long>{
    
    
    Optional<TblEstado> findByDescripcion(String descripcion);
    
}
