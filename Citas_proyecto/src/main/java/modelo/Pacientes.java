
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "pacientes")
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pacIdentificacion")
    private Integer pacIdentificacion;
    @Column(name = "pacNombre")
    private String pacNombre;
    @Column(name = "pacApellidos")
    private String pacApellidos;
    @Column(name = "pacFechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date pacFechaNacimiento;
    @Column(name = "pacSexo")
    private String pacSexo;

    public Pacientes() {
    }

    public Pacientes(Integer pacIdentificacion) {
        this.pacIdentificacion = pacIdentificacion;
    }

    public Integer getPacIdentificacion() {
        return pacIdentificacion;
    }

    public void setPacIdentificacion(Integer pacIdentificacion) {
        this.pacIdentificacion = pacIdentificacion;
    }

    public String getPacNombre() {
        return pacNombre;
    }

    public void setPacNombre(String pacNombre) {
        this.pacNombre = pacNombre;
    }

    public String getPacApellidos() {
        return pacApellidos;
    }

    public void setPacApellidos(String pacApellidos) {
        this.pacApellidos = pacApellidos;
    }

    public Date getPacFechaNacimiento() {
        return pacFechaNacimiento;
    }

    public void setPacFechaNacimiento(Date pacFechaNacimiento) {
        this.pacFechaNacimiento = pacFechaNacimiento;
    }

    public String getPacSexo() {
        return pacSexo;
    }

    public void setPacSexo(String pacSexo) {
        this.pacSexo = pacSexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacIdentificacion != null ? pacIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.pacIdentificacion == null && other.pacIdentificacion != null) || (this.pacIdentificacion != null && !this.pacIdentificacion.equals(other.pacIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pacientes[ pacIdentificacion=" + pacIdentificacion + " ]";
    }
    
}
