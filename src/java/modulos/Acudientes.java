/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "acudientes")
@NamedQueries({
    @NamedQuery(name = "Acudientes.findAll", query = "SELECT a FROM Acudientes a")
    , @NamedQuery(name = "Acudientes.findByCedula", query = "SELECT a FROM Acudientes a WHERE a.cedula = :cedula")
    , @NamedQuery(name = "Acudientes.findByNombre", query = "SELECT a FROM Acudientes a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Acudientes.findByApellido", query = "SELECT a FROM Acudientes a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Acudientes.findByTelefonoFijo", query = "SELECT a FROM Acudientes a WHERE a.telefonoFijo = :telefonoFijo")
    , @NamedQuery(name = "Acudientes.findByTelefonoMovil", query = "SELECT a FROM Acudientes a WHERE a.telefonoMovil = :telefonoMovil")})
public class Acudientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula", nullable = false)
    private Integer cedula;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido", length = 45)
    private String apellido;
    @Size(max = 45)
    @Column(name = "telefonoFijo", length = 45)
    private String telefonoFijo;
    @Size(max = 45)
    @Column(name = "telefonoMovil", length = 45)
    private String telefonoMovil;
    @JoinTable(name = "pacientes_has_acudientes", joinColumns = {
        @JoinColumn(name = "acudientes_cedula", referencedColumnName = "cedula", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "pacientes_idUsuarios", referencedColumnName = "idUsuarios", nullable = false)})
    @ManyToMany
    private List<Pacientes> pacientesList;

    public Acudientes() {
    }

    public Acudientes(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public List<Pacientes> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<Pacientes> pacientesList) {
        this.pacientesList = pacientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acudientes)) {
            return false;
        }
        Acudientes other = (Acudientes) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Acudientes[ cedula=" + cedula + " ]";
    }
    
}
