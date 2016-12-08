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
@Table(name = "tipoantecedentes")
@NamedQueries({
    @NamedQuery(name = "Tipoantecedentes.findAll", query = "SELECT t FROM Tipoantecedentes t")
    , @NamedQuery(name = "Tipoantecedentes.findByIdtipo", query = "SELECT t FROM Tipoantecedentes t WHERE t.idtipo = :idtipo")
    , @NamedQuery(name = "Tipoantecedentes.findByNombre", query = "SELECT t FROM Tipoantecedentes t WHERE t.nombre = :nombre")})
public class Tipoantecedentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo", nullable = false)
    private Integer idtipo;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAntecedentesidtipo")
    private List<Antecedentes> antecedentesList;

    public Tipoantecedentes() {
    }

    public Tipoantecedentes(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
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

    public List<Antecedentes> getAntecedentesList() {
        return antecedentesList;
    }

    public void setAntecedentesList(List<Antecedentes> antecedentesList) {
        this.antecedentesList = antecedentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoantecedentes)) {
            return false;
        }
        Tipoantecedentes other = (Tipoantecedentes) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Tipoantecedentes[ idtipo=" + idtipo + " ]";
    }
    
}
