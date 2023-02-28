
package com.tecnicalTest.apiTarjeta.entity;

import com.tecnicalTest.apiTarjeta.entity.TblTarjetas;
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
@Table(name = "tbl_tipo")
@NamedQueries({
    @NamedQuery(name = "TblTipo.findAll", query = "SELECT t FROM TblTipo t"),
    @NamedQuery(name = "TblTipo.findByIdTipo", query = "SELECT t FROM TblTipo t WHERE t.idTipo = :idTipo"),
    @NamedQuery(name = "TblTipo.findByDescripcion", query = "SELECT t FROM TblTipo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TblTipo.findByCreated", query = "SELECT t FROM TblTipo t WHERE t.created = :created"),
    @NamedQuery(name = "TblTipo.findByUpdated", query = "SELECT t FROM TblTipo t WHERE t.updated = :updated")})
public class TblTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Long idTipo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private Collection<TblTarjetas> tblTarjetasCollection;

    public TblTipo() {
    }

    public TblTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
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
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipo)) {
            return false;
        }
        TblTipo other = (TblTipo) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testTecnical.apiTarjetas.entity.TblTipo[ idTipo=" + idTipo + " ]";
    }
    
}
