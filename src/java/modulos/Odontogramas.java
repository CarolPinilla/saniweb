/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "odontogramas")
@NamedQueries({
    @NamedQuery(name = "Odontogramas.findAll", query = "SELECT o FROM Odontogramas o")
    , @NamedQuery(name = "Odontogramas.findByIdOdontograma", query = "SELECT o FROM Odontogramas o WHERE o.idOdontograma = :idOdontograma")
    , @NamedQuery(name = "Odontogramas.findByFechaCreacion", query = "SELECT o FROM Odontogramas o WHERE o.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Odontogramas.findByFechaCierre", query = "SELECT o FROM Odontogramas o WHERE o.fechaCierre = :fechaCierre")})
public class Odontogramas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOdontograma", nullable = false)
    private Long idOdontograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fechaCierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones", length = 65535)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odontogramasidOdontograma")
    private List<Hallazgos> hallazgosList;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios", nullable = false)
    @ManyToOne(optional = false)
    private Historiasclinicas idUsuarios;

    public Odontogramas() {
    }

    public Odontogramas(Long idOdontograma) {
        this.idOdontograma = idOdontograma;
    }

    public Odontogramas(Long idOdontograma, Date fechaCreacion) {
        this.idOdontograma = idOdontograma;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdOdontograma() {
        return idOdontograma;
    }

    public void setIdOdontograma(Long idOdontograma) {
        this.idOdontograma = idOdontograma;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Hallazgos> getHallazgosList() {
        return hallazgosList;
    }

    public void setHallazgosList(List<Hallazgos> hallazgosList) {
        this.hallazgosList = hallazgosList;
    }

    public Historiasclinicas getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Historiasclinicas idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOdontograma != null ? idOdontograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odontogramas)) {
            return false;
        }
        Odontogramas other = (Odontogramas) object;
        if ((this.idOdontograma == null && other.idOdontograma != null) || (this.idOdontograma != null && !this.idOdontograma.equals(other.idOdontograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Odontogramas[ idOdontograma=" + idOdontograma + " ]";
    }
    
}
