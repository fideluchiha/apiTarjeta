package com.tecnicalTest.apiTarjeta.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
import lombok.ToString;

/**
 *
 * @author fidel
 */
@Entity
@Table(name = "tbl_logs")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
    @NamedQuery(name = "TblLogs.findAll", query = "SELECT t FROM TblLogs t"),
    @NamedQuery(name = "TblLogs.findByIdLogs", query = "SELECT t FROM TblLogs t WHERE t.idLogs = :idLogs"),
    @NamedQuery(name = "TblLogs.findByAccion", query = "SELECT t FROM TblLogs t WHERE t.accion = :accion"),
    @NamedQuery(name = "TblLogs.findByAntes", query = "SELECT t FROM TblLogs t WHERE t.antes = :antes"),
    @NamedQuery(name = "TblLogs.findByAhora", query = "SELECT t FROM TblLogs t WHERE t.ahora = :ahora"),
    @NamedQuery(name = "TblLogs.findByUsuario", query = "SELECT t FROM TblLogs t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TblLogs.findByTabla", query = "SELECT t FROM TblLogs t WHERE t.tabla = :tabla"),
    @NamedQuery(name = "TblLogs.findByCreated", query = "SELECT t FROM TblLogs t WHERE t.created = :created"),
    @NamedQuery(name = "TblLogs.findByUpdated", query = "SELECT t FROM TblLogs t WHERE t.updated = :updated")})
public class TblLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_logs")
    private Long idLogs;
    @Column(name = "accion")
    private String accion;
    @Column(name = "antes")
    private String antes;
    @Column(name = "ahora")
    private String ahora;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "tabla")
    private String tabla;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

   

    public TblLogs(Long idLogs) {
        this.idLogs = idLogs;
    }

    public Long getIdLogs() {
        return idLogs;
    }

    public void setIdLogs(Long idLogs) {
        this.idLogs = idLogs;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAntes() {
        return antes;
    }

    public void setAntes(String antes) {
        this.antes = antes;
    }

    public String getAhora() {
        return ahora;
    }

    public void setAhora(String ahora) {
        this.ahora = ahora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    @PrePersist
    public void prePersist (){
        this.created = new Date();
    }
    
    @PreUpdate
    public void preUpdate(){
        
        this.updated= new Date();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogs != null ? idLogs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLogs)) {
            return false;
        }
        TblLogs other = (TblLogs) object;
        if ((this.idLogs == null && other.idLogs != null) || (this.idLogs != null && !this.idLogs.equals(other.idLogs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.sercivio.entity.TblLogs[ idLogs=" + idLogs + " ]";
    }
    
}
