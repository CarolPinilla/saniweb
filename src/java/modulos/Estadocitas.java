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
@Table(name = "estadocitas")
@NamedQueries({
    @NamedQuery(name = "Estadocitas.findAll", query = "SELECT e FROM Estadocitas e")
    , @NamedQuery(name = "Estadocitas.findByIdEstado", query = "SELECT e FROM Estadocitas e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "Estadocitas.findByNombre", query = "SELECT e FROM Estadocitas e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estadocitas.findByDescripcion", query = "SELECT e FROM Estadocitas e WHERE e.descripcion = :descripcion")})
public class Estadocitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstado", nullable = false)
    private Integer idEstado;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Size(max = 65)
    @Column(name = "descripcion", length = 65)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCitasidEstado")
    private List<Citas> citasList;

    public Estadocitas() {
    }

    public Estadocitas(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
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

    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
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
        if (!(object instanceof Estadocitas)) {
            return false;
        }
        Estadocitas other = (Estadocitas) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Estadocitas[ idEstado=" + idEstado + " ]";
    }
    
}
