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

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "citas")
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c")
    , @NamedQuery(name = "Citas.findByIdcitas", query = "SELECT c FROM Citas c WHERE c.idcitas = :idcitas")
    , @NamedQuery(name = "Citas.findByFecha", query = "SELECT c FROM Citas c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Citas.findByHora", query = "SELECT c FROM Citas c WHERE c.hora = :hora")
    , @NamedQuery(name = "Citas.findByValor", query = "SELECT c FROM Citas c WHERE c.valor = :valor")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcitas", nullable = false)
    private Integer idcitas;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor", precision = 22)
    private Double valor;
    @JoinColumn(name = "estadoCitas_idEstado", referencedColumnName = "idEstado", nullable = false)
    @ManyToOne(optional = false)
    private Estadocitas estadoCitasidEstado;
    @JoinColumn(name = "pacientes_idUsuarios", referencedColumnName = "idUsuarios", nullable = false)
    @ManyToOne(optional = false)
    private Pacientes pacientesidUsuarios;
    @JoinColumn(name = "personalOdontologico_idUsuarios", referencedColumnName = "idUsuarios", nullable = false)
    @ManyToOne(optional = false)
    private Personalodontologico personalOdontologicoidUsuarios;

    public Citas() {
    }

    public Citas(Integer idcitas) {
        this.idcitas = idcitas;
    }

    public Integer getIdcitas() {
        return idcitas;
    }

    public void setIdcitas(Integer idcitas) {
        this.idcitas = idcitas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Estadocitas getEstadoCitasidEstado() {
        return estadoCitasidEstado;
    }

    public void setEstadoCitasidEstado(Estadocitas estadoCitasidEstado) {
        this.estadoCitasidEstado = estadoCitasidEstado;
    }

    public Pacientes getPacientesidUsuarios() {
        return pacientesidUsuarios;
    }

    public void setPacientesidUsuarios(Pacientes pacientesidUsuarios) {
        this.pacientesidUsuarios = pacientesidUsuarios;
    }

    public Personalodontologico getPersonalOdontologicoidUsuarios() {
        return personalOdontologicoidUsuarios;
    }

    public void setPersonalOdontologicoidUsuarios(Personalodontologico personalOdontologicoidUsuarios) {
        this.personalOdontologicoidUsuarios = personalOdontologicoidUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcitas != null ? idcitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idcitas == null && other.idcitas != null) || (this.idcitas != null && !this.idcitas.equals(other.idcitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Citas[ idcitas=" + idcitas + " ]";
    }
    
}
