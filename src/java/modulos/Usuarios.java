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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuarios", query = "SELECT u FROM Usuarios u WHERE u.idUsuarios = :idUsuarios")
    , @NamedQuery(name = "Usuarios.findByTipoDocumento", query = "SELECT u FROM Usuarios u WHERE u.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Usuarios.findByDocumento", query = "SELECT u FROM Usuarios u WHERE u.documento = :documento")
    , @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuarios.findByDireccion", query = "SELECT u FROM Usuarios u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuarios.findByFechaNacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Usuarios.findByLugarNacimiento", query = "SELECT u FROM Usuarios u WHERE u.lugarNacimiento = :lugarNacimiento")
    , @NamedQuery(name = "Usuarios.findByGenero", query = "SELECT u FROM Usuarios u WHERE u.genero = :genero")
    , @NamedQuery(name = "Usuarios.findByTelefonoFijio", query = "SELECT u FROM Usuarios u WHERE u.telefonoFijio = :telefonoFijio")
    , @NamedQuery(name = "Usuarios.findByTelefonoMovil", query = "SELECT u FROM Usuarios u WHERE u.telefonoMovil = :telefonoMovil")
    , @NamedQuery(name = "Usuarios.findByEstadoCivil", query = "SELECT u FROM Usuarios u WHERE u.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "Usuarios.findByClave", query = "SELECT u FROM Usuarios u WHERE u.clave = :clave")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuarios", nullable = false)
    private Integer idUsuarios;
    @Size(max = 20)
    @Column(name = "tipoDocumento", length = 20)
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "documento", nullable = false, length = 45)
    private String documento;
    @Size(max = 45)
    @Column(name = "nombres", length = 45)
    private String nombres;
    @Size(max = 45)
    @Column(name = "apellidos", length = 45)
    private String apellidos;
    @Size(max = 45)
    @Column(name = "direccion", length = 45)
    private String direccion;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "lugarNacimiento", length = 45)
    private String lugarNacimiento;
    @Size(max = 45)
    @Column(name = "genero", length = 45)
    private String genero;
    @Size(max = 15)
    @Column(name = "telefonoFijio", length = 15)
    private String telefonoFijio;
    @Size(max = 15)
    @Column(name = "telefonoMovil", length = 15)
    private String telefonoMovil;
    @Size(max = 20)
    @Column(name = "estadoCivil", length = 20)
    private String estadoCivil;
    @Size(max = 10)
    @Column(name = "clave", length = 10)
    private String clave;
    @ManyToMany(mappedBy = "usuariosList")
    private List<Roles> rolesList;
    @JoinColumn(name = "estadoUsuarios_idestadoUsuarios", referencedColumnName = "idestadoUsuarios", nullable = false)
    @ManyToOne(optional = false)
    private Estadousuarios estadoUsuariosidestadoUsuarios;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private Personalodontologico personalodontologico;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private Pacientes pacientes;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Usuarios(Integer idUsuarios, String documento) {
        this.idUsuarios = idUsuarios;
        this.documento = documento;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefonoFijio() {
        return telefonoFijio;
    }

    public void setTelefonoFijio(String telefonoFijio) {
        this.telefonoFijio = telefonoFijio;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public Estadousuarios getEstadoUsuariosidestadoUsuarios() {
        return estadoUsuariosidestadoUsuarios;
    }

    public void setEstadoUsuariosidestadoUsuarios(Estadousuarios estadoUsuariosidestadoUsuarios) {
        this.estadoUsuariosidestadoUsuarios = estadoUsuariosidestadoUsuarios;
    }

    public Personalodontologico getPersonalodontologico() {
        return personalodontologico;
    }

    public void setPersonalodontologico(Personalodontologico personalodontologico) {
        this.personalodontologico = personalodontologico;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modulos.Usuarios[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
