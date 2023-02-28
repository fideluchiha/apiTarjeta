/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnicalTest.apiTarjeta.repository;

import com.tecnicalTest.apiTarjeta.entity.TblLogs;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fidel
 */
public interface LogsRepository extends CrudRepository<TblLogs, Long>{
    
}
