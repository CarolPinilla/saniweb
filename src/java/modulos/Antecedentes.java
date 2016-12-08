/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulos;

import java.io.Serializable;
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

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "antecedentes")
@NamedQueries({
    @NamedQuery(name = "Antecedentes.findAll", query = "SELECT a FROM Antecedentes a")
    , @NamedQuery(name = "Antecedentes.findById", query = "SELECT a FROM Antecedentes a WHERE a.id = :id")
    , @NamedQuery(name = "Antecedentes.findByOrigen", query = "SELECT a FROM Antecedentes a WHERE a.origen = :origen")})
public class Antecedentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "origen")
    private Boolean origen;
    @JoinColumn(name = "historiasClinicas_idUsuarios", referencedColumnName = "idUsuarios", nullable = false)
    @ManyToOne(optional = false)
    private Historiasclinicas historiasClinicasidUsuarios;
    @JoinColumn(name = "tipoAntecedentes_idtipo", referencedColumnName = "idtipo", nullable = false)
    @ManyToOne(optional = false)
    private Tipoantecedentes tipoAntecedentesidtipo;

    public Antecedentes() {
    }

    public Antecedentes(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOrigen() {
        return origen;
    }

    public void setOrigen(Boolean origen) {
        this.origen = origen;
    }

    public Historiasclinicas getHistoriasClinicasidUsuarios() {
        return historiasClinicasidUsuarios;
    }

    public void setHistoriasClinicasidUsuarios(Historiasclinicas historiasClinicasidUsuarios) {
        this.historiasClinicasidUsuarios = historiasClinicasidUsuarios;
    }

    public Tipoantecedentes getTipoAntecedentesidtipo() {
        return tipoAntecedentesidtipo;
    }

    public void setTipoAntecedentesidtipo(Tipoantecedentes tipoAntecedentesidtipo) {
        this.tipoAntecedentesidtipo = tipoAntecedentesidtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedentes)) {
            return false;
        }
        Antecedentes other = (Antecedentes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Antecedentes[ id=" + id + " ]";
    }
    
}
