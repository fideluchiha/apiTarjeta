package com.tecnicalTest.apiTarjeta.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author fidel
 */
@Entity
@Table(name = "tbl_tarjetas")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TblTarjetas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarjetas")
    private Long idTarjetas;
    @Column(name = "pan")
    private Long pan;
    @Column(name = "titular")
    private String titular;
    @Column(name = "cedula")
    private Integer cedula;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "numero_validacion")
    private Integer numeroValidacion;
    @Column(name = "hash")
    private String hash;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    
    @JsonBackReference
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private TblEstado idEstado;
    @JsonBackReference
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private TblTipo idTipo;
    
    
    
   public TblTarjetas(Long idTarjetas) {
        this.idTarjetas = idTarjetas;
    }

    public Long getIdTarjetas() {
        return idTarjetas;
    }

    public void setIdTarjetas(Long idTarjetas) {
        this.idTarjetas = idTarjetas;
    }

    public Long getPan() {
        return pan;
    }

    public void setPan(Long pan) {
        this.pan = pan;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getNumeroValidacion() {
        return numeroValidacion;
    }

    public void setNumeroValidacion(Integer numeroValidacion) {
        this.numeroValidacion = numeroValidacion;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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

    public TblTipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TblTipo idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarjetas != null ? idTarjetas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTarjetas)) {
            return false;
        }
        TblTarjetas other = (TblTarjetas) object;
        if ((this.idTarjetas == null && other.idTarjetas != null) || (this.idTarjetas != null && !this.idTarjetas.equals(other.idTarjetas))) {
            return false;
        }
        return true;
    }

   

    
    
}
