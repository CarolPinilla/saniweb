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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "historiasclinicas")
@NamedQueries({
    @NamedQuery(name = "Historiasclinicas.findAll", query = "SELECT h FROM Historiasclinicas h")
    , @NamedQuery(name = "Historiasclinicas.findByIdUsuarios", query = "SELECT h FROM Historiasclinicas h WHERE h.idUsuarios = :idUsuarios")
    , @NamedQuery(name = "Historiasclinicas.findByFechaApertura", query = "SELECT h FROM Historiasclinicas h WHERE h.fechaApertura = :fechaApertura")
    , @NamedQuery(name = "Historiasclinicas.findByMotivoConsulta", query = "SELECT h FROM Historiasclinicas h WHERE h.motivoConsulta = :motivoConsulta")})
public class Historiasclinicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarios", nullable = false)
    private Integer idUsuarios;
    @Column(name = "fechaApertura")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    @Size(max = 250)
    @Column(name = "motivoConsulta", length = 250)
    private String motivoConsulta;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pacientes pacientes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private List<Odontogramas> odontogramasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historiasClinicasidUsuarios")
    private List<Antecedentes> antecedentesList;

    public Historiasclinicas() {
    }

    public Historiasclinicas(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public List<Odontogramas> getOdontogramasList() {
        return odontogramasList;
    }

    public void setOdontogramasList(List<Odontogramas> odontogramasList) {
        this.odontogramasList = odontogramasList;
    }

    public List<Antecedentes> getAntecedentesList() {
        return antecedentesList;
    }

    public void setAntecedentesList(List<Antecedentes> antecedentesList) {
        this.antecedentesList = antecedentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historiasclinicas)) {
            return false;
        }
        Historiasclinicas other = (Historiasclinicas) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Historiasclinicas[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
