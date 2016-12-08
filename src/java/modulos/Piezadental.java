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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "piezadental")
@NamedQueries({
    @NamedQuery(name = "Piezadental.findAll", query = "SELECT p FROM Piezadental p")
    , @NamedQuery(name = "Piezadental.findByIdDiente", query = "SELECT p FROM Piezadental p WHERE p.idDiente = :idDiente")
    , @NamedQuery(name = "Piezadental.findByNombre", query = "SELECT p FROM Piezadental p WHERE p.nombre = :nombre")})
public class Piezadental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDiente", nullable = false)
    private Integer idDiente;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piezaDentalidDiente")
    private List<Hallazgos> hallazgosList;

    public Piezadental() {
    }

    public Piezadental(Integer idDiente) {
        this.idDiente = idDiente;
    }

    public Integer getIdDiente() {
        return idDiente;
    }

    public void setIdDiente(Integer idDiente) {
        this.idDiente = idDiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Hallazgos> getHallazgosList() {
        return hallazgosList;
    }

    public void setHallazgosList(List<Hallazgos> hallazgosList) {
        this.hallazgosList = hallazgosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiente != null ? idDiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piezadental)) {
            return false;
        }
        Piezadental other = (Piezadental) object;
        if ((this.idDiente == null && other.idDiente != null) || (this.idDiente != null && !this.idDiente.equals(other.idDiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Piezadental[ idDiente=" + idDiente + " ]";
    }
    
}
