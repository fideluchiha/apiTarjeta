package com.tecnicalTest.apiTarjeta.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fidel
 */
@Entity
@Table(name = "tbl_estado")
@NamedQueries({
    @NamedQuery(name = "TblEstado.findAll", query = "SELECT t FROM TblEstado t"),
    @NamedQuery(name = "TblEstado.findByIdEstado", query = "SELECT t FROM TblEstado t WHERE t.idEstado = :idEstado"),
    @NamedQuery(name = "TblEstado.findByDescripcion", query = "SELECT t FROM TblEstado t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TblEstado.findByCreated", query = "SELECT t FROM TblEstado t WHERE t.created = :created"),
    @NamedQuery(name = "TblEstado.findByUpdated", query = "SELECT t FROM TblEstado t WHERE t.updated = :updated")})
public class TblEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Long idEstado;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private Collection<TblTarjetas> tblTarjetasCollection;

    public TblEstado() {
    }

    public TblEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Collection<TblTarjetas> getTblTarjetasCollection() {
        return tblTarjetasCollection;
    }

    public void setTblTarjetasCollection(Collection<TblTarjetas> tblTarjetasCollection) {
        this.tblTarjetasCollection = tblTarjetasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEstado)) {
            return false;
        }
        TblEstado other = (TblEstado) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testTecnical.apiTarjetas.entity.TblEstado[ idEstado=" + idEstado + " ]";
    }
    
}
