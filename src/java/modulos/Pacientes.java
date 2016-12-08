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
import javax.persistence.ManyToMany;
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
@Table(name = "pacientes")
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p")
    , @NamedQuery(name = "Pacientes.findByIdUsuarios", query = "SELECT p FROM Pacientes p WHERE p.idUsuarios = :idUsuarios")
    , @NamedQuery(name = "Pacientes.findByOcupacion", query = "SELECT p FROM Pacientes p WHERE p.ocupacion = :ocupacion")
    , @NamedQuery(name = "Pacientes.findByTipoAfiliacion", query = "SELECT p FROM Pacientes p WHERE p.tipoAfiliacion = :tipoAfiliacion")
    , @NamedQuery(name = "Pacientes.findByEps", query = "SELECT p FROM Pacientes p WHERE p.eps = :eps")
    , @NamedQuery(name = "Pacientes.findByRh", query = "SELECT p FROM Pacientes p WHERE p.rh = :rh")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarios", nullable = false)
    private Integer idUsuarios;
    @Size(max = 45)
    @Column(name = "ocupacion", length = 45)
    private String ocupacion;
    @Size(max = 45)
    @Column(name = "tipoAfiliacion", length = 45)
    private String tipoAfiliacion;
    @Size(max = 45)
    @Column(name = "eps", length = 45)
    private String eps;
    @Size(max = 15)
    @Column(name = "rh", length = 15)
    private String rh;
    @ManyToMany(mappedBy = "pacientesList")
    private List<Acudientes> acudientesList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pacientes")
    private Historiasclinicas historiasclinicas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientesidUsuarios")
    private List<Citas> citasList;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Pacientes() {
    }

    public Pacientes(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTipoAfiliacion() {
        return tipoAfiliacion;
    }

    public void setTipoAfiliacion(String tipoAfiliacion) {
        this.tipoAfiliacion = tipoAfiliacion;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public List<Acudientes> getAcudientesList() {
        return acudientesList;
    }

    public void setAcudientesList(List<Acudientes> acudientesList) {
        this.acudientesList = acudientesList;
    }

    public Historiasclinicas getHistoriasclinicas() {
        return historiasclinicas;
    }

    public void setHistoriasclinicas(Historiasclinicas historiasclinicas) {
        this.historiasclinicas = historiasclinicas;
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
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Pacientes[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
