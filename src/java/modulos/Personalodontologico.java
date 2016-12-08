/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "personalodontologico")
@NamedQueries({
    @NamedQuery(name = "Personalodontologico.findAll", query = "SELECT p FROM Personalodontologico p")
    , @NamedQuery(name = "Personalodontologico.findByIdUsuarios", query = "SELECT p FROM Personalodontologico p WHERE p.idUsuarios = :idUsuarios")
    , @NamedQuery(name = "Personalodontologico.findByEspecialidad", query = "SELECT p FROM Personalodontologico p WHERE p.especialidad = :especialidad")
    , @NamedQuery(name = "Personalodontologico.findByTarjetaProfesional", query = "SELECT p FROM Personalodontologico p WHERE p.tarjetaProfesional = :tarjetaProfesional")})
public class Personalodontologico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarios", nullable = false)
    private Integer idUsuarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "especialidad", nullable = false, length = 25)
    private String especialidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tarjetaProfesional", nullable = false, length = 45)
    private String tarjetaProfesional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personalOdontologicoidUsuarios")
    private List<Citas> citasList;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Personalodontologico() {
    }

    public Personalodontologico(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Personalodontologico(Integer idUsuarios, String especialidad, String tarjetaProfesional) {
        this.idUsuarios = idUsuarios;
        this.especialidad = especialidad;
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
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
        if (!(object instanceof Personalodontologico)) {
            return false;
        }
        Personalodontologico other = (Personalodontologico) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Personalodontologico[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
