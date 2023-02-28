/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicalTest.apiTarjeta.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fidel
 */
@Entity
@Table(name = "tbl_transaccion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
    @NamedQuery(name = "TblTransaccion.findAll", query = "SELECT t FROM TblTransaccion t"),
    @NamedQuery(name = "TblTransaccion.findByIdTransaccion", query = "SELECT t FROM TblTransaccion t WHERE t.idTransaccion = :idTransaccion"),
    @NamedQuery(name = "TblTransaccion.findByHash", query = "SELECT t FROM TblTransaccion t WHERE t.hash = :hash"),
    @NamedQuery(name = "TblTransaccion.findByReferencia", query = "SELECT t FROM TblTransaccion t WHERE t.referencia = :referencia"),
    @NamedQuery(name = "TblTransaccion.findByTotalCompra", query = "SELECT t FROM TblTransaccion t WHERE t.totalCompra = :totalCompra"),
    @NamedQuery(name = "TblTransaccion.findByDireccionCompra", query = "SELECT t FROM TblTransaccion t WHERE t.direccionCompra = :direccionCompra"),
    @NamedQuery(name = "TblTransaccion.findByCreated", query = "SELECT t FROM TblTransaccion t WHERE t.created = :created"),
    @NamedQuery(name = "TblTransaccion.findByUpdated", query = "SELECT t FROM TblTransaccion t WHERE t.updated = :updated")})
public class TblTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaccion")
    private Long idTransaccion;
    @Column(name = "hash")
    private String hash;
    @Column(name = "referencia")
    private Long referencia;
    @Column(name = "total_compra")
    private Long totalCompra;
    @Column(name = "direccion_compra")
    private String direccionCompra;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private TblEstado idEstado;

   

    public TblTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getReferencia() {
        return referencia;
    }

    public void setReferencia(Long referencia) {
        this.referencia = referencia;
    }

    public Long getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Long totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getDireccionCompra() {
        return direccionCompra;
    }

    public void setDireccionCompra(String direccionCompra) {
        this.direccionCompra = direccionCompra;
    }

  
    @PrePersist
    public void prePersist (){
        this.created = new Date();
    }
    
    @PreUpdate
    public void preUpdate(){
        
        this.updated= new Date();
    }

    public TblEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TblEstado idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTransaccion)) {
            return false;
        }
        TblTransaccion other = (TblTransaccion) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.sercivio.entity.TblTransaccion[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
