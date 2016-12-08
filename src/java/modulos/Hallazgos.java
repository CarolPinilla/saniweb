/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "hallazgos")
@NamedQueries({
    @NamedQuery(name = "Hallazgos.findAll", query = "SELECT h FROM Hallazgos h")
    , @NamedQuery(name = "Hallazgos.findByIdHallazgo", query = "SELECT h FROM Hallazgos h WHERE h.idHallazgo = :idHallazgo")
    , @NamedQuery(name = "Hallazgos.findByFechaRegistro", query = "SELECT h FROM Hallazgos h WHERE h.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Hallazgos.findByMesial", query = "SELECT h FROM Hallazgos h WHERE h.mesial = :mesial")
    , @NamedQuery(name = "Hallazgos.findByOclusal", query = "SELECT h FROM Hallazgos h WHERE h.oclusal = :oclusal")
    , @NamedQuery(name = "Hallazgos.findByLingual", query = "SELECT h FROM Hallazgos h WHERE h.lingual = :lingual")
    , @NamedQuery(name = "Hallazgos.findByDistal", query = "SELECT h FROM Hallazgos h WHERE h.distal = :distal")
    , @NamedQuery(name = "Hallazgos.findByIncisal", query = "SELECT h FROM Hallazgos h WHERE h.incisal = :incisal")
    , @NamedQuery(name = "Hallazgos.findByVestibular", query = "SELECT h FROM Hallazgos h WHERE h.vestibular = :vestibular")
    , @NamedQuery(name = "Hallazgos.findByApical", query = "SELECT h FROM Hallazgos h WHERE h.apical = :apical")
    , @NamedQuery(name = "Hallazgos.findByHallazgoscol", query = "SELECT h FROM Hallazgos h WHERE h.hallazgoscol = :hallazgoscol")})
public class Hallazgos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHallazgo", nullable = false)
    private Long idHallazgo;
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "mesial")
    private Short mesial;
    @Column(name = "oclusal")
    private Short oclusal;
    @Column(name = "lingual")
    private Short lingual;
    @Column(name = "distal")
    private Short distal;
    @Column(name = "incisal")
    private Short incisal;
    @Column(name = "vestibular")
    private Short vestibular;
    @Column(name = "apical")
    private Short apical;
    @Size(max = 45)
    @Column(name = "hallazgoscol", length = 45)
    private String hallazgoscol;
    @JoinColumn(name = "odontogramas_idOdontograma", referencedColumnName = "idOdontograma", nullable = false)
    @ManyToOne(optional = false)
    private Odontogramas odontogramasidOdontograma;
    @JoinColumn(name = "piezaDental_idDiente", referencedColumnName = "idDiente", nullable = false)
    @ManyToOne(optional = false)
    private Piezadental piezaDentalidDiente;
    @JoinColumn(name = "tratamiento_idTratamiento", referencedColumnName = "idTratamiento", nullable = false)
    @ManyToOne(optional = false)
    private Tratamiento tratamientoidTratamiento;

    public Hallazgos() {
    }

    public Hallazgos(Long idHallazgo) {
        this.idHallazgo = idHallazgo;
    }

    public Long getIdHallazgo() {
        return idHallazgo;
    }

    public void setIdHallazgo(Long idHallazgo) {
        this.idHallazgo = idHallazgo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Short getMesial() {
        return mesial;
    }

    public void setMesial(Short mesial) {
        this.mesial = mesial;
    }

    public Short getOclusal() {
        return oclusal;
    }

    public void setOclusal(Short oclusal) {
        this.oclusal = oclusal;
    }

    public Short getLingual() {
        return lingual;
    }

    public void setLingual(Short lingual) {
        this.lingual = lingual;
    }

    public Short getDistal() {
        return distal;
    }

    public void setDistal(Short distal) {
        this.distal = distal;
    }

    public Short getIncisal() {
        return incisal;
    }

    public void setIncisal(Short incisal) {
        this.incisal = incisal;
    }

    public Short getVestibular() {
        return vestibular;
    }

    public void setVestibular(Short vestibular) {
        this.vestibular = vestibular;
    }

    public Short getApical() {
        return apical;
    }

    public void setApical(Short apical) {
        this.apical = apical;
    }

    public String getHallazgoscol() {
        return hallazgoscol;
    }

    public void setHallazgoscol(String hallazgoscol) {
        this.hallazgoscol = hallazgoscol;
    }

    public Odontogramas getOdontogramasidOdontograma() {
        return odontogramasidOdontograma;
    }

    public void setOdontogramasidOdontograma(Odontogramas odontogramasidOdontograma) {
        this.odontogramasidOdontograma = odontogramasidOdontograma;
    }

    public Piezadental getPiezaDentalidDiente() {
        return piezaDentalidDiente;
    }

    public void setPiezaDentalidDiente(Piezadental piezaDentalidDiente) {
        this.piezaDentalidDiente = piezaDentalidDiente;
    }

    public Tratamiento getTratamientoidTratamiento() {
        return tratamientoidTratamiento;
    }

    public void setTratamientoidTratamiento(Tratamiento tratamientoidTratamiento) {
        this.tratamientoidTratamiento = tratamientoidTratamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHallazgo != null ? idHallazgo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hallazgos)) {
            return false;
        }
        Hallazgos other = (Hallazgos) object;
        if ((this.idHallazgo == null && other.idHallazgo != null) || (this.idHallazgo != null && !this.idHallazgo.equals(other.idHallazgo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Hallazgos[ idHallazgo=" + idHallazgo + " ]";
    }
    
}
