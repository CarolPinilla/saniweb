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
@Table(name = "estadousuarios")
@NamedQueries({
    @NamedQuery(name = "Estadousuarios.findAll", query = "SELECT e FROM Estadousuarios e")
    , @NamedQuery(name = "Estadousuarios.findByIdestadoUsuarios", query = "SELECT e FROM Estadousuarios e WHERE e.idestadoUsuarios = :idestadoUsuarios")
    , @NamedQuery(name = "Estadousuarios.findByNombre", query = "SELECT e FROM Estadousuarios e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estadousuarios.findByDescripcion", query = "SELECT e FROM Estadousuarios e WHERE e.descripcion = :descripcion")})
public class Estadousuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestadoUsuarios", nullable = false)
    private Integer idestadoUsuarios;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Size(max = 65)
    @Column(name = "descripcion", length = 65)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoUsuariosidestadoUsuarios")
    private List<Usuarios> usuariosList;

    public Estadousuarios() {
    }

    public Estadousuarios(Integer idestadoUsuarios) {
        this.idestadoUsuarios = idestadoUsuarios;
    }

    public Integer getIdestadoUsuarios() {
        return idestadoUsuarios;
    }

    public void setIdestadoUsuarios(Integer idestadoUsuarios) {
        this.idestadoUsuarios = idestadoUsuarios;
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

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoUsuarios != null ? idestadoUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadousuarios)) {
            return false;
        }
        Estadousuarios other = (Estadousuarios) object;
        if ((this.idestadoUsuarios == null && other.idestadoUsuarios != null) || (this.idestadoUsuarios != null && !this.idestadoUsuarios.equals(other.idestadoUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Estadousuarios[ idestadoUsuarios=" + idestadoUsuarios + " ]";
    }
    
}
