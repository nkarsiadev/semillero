package pichincha.com.backtarea.Entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
    // atributos generales de la clase cuenta

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // genera automaticamente el id incrementalmente
    private Long idUsuario;

    private String nombreUsuario;
    private String apellidoUsuario;
    private String ciUsuario;
    private Date fechaNacimiento;
    private String sexoUsuario;
    private String dirrecionDomicilioUsuario;
    private int edadUsuario;
    private String estadoUsuario;
    private String estadoLaboral;

    // Sobreescritura de ToString
    @Override
    public String toString() {
        return "Usuario [apellidoUsuario=" + apellidoUsuario + ", ciUsuario=" + ciUsuario
                + ", dirrecionDomicilioUsuario=" + dirrecionDomicilioUsuario + ", edadUsuario=" + edadUsuario
                + ", estadoLaboral=" + estadoLaboral + ", estadoUsuario=" + estadoUsuario + ", fechaNacimiento="
                + fechaNacimiento + ", idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", sexoUsuario="
                + sexoUsuario + "]";
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCiUsuario() {
        return ciUsuario;
    }

    public void setCiUsuario(String ciUsuario) {
        this.ciUsuario = ciUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getDirrecionDomicilioUsuario() {
        return dirrecionDomicilioUsuario;
    }

    public void setDirrecionDomicilioUsuario(String dirrecionDomicilioUsuario) {
        this.dirrecionDomicilioUsuario = dirrecionDomicilioUsuario;
    }

    public int getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario() {
        try {
            Date newDate = new Date();
            Calendar calendar1 = new GregorianCalendar();
            calendar1.setTime(newDate);

            Calendar calendar2 = new GregorianCalendar();
            calendar2.setTime(this.fechaNacimiento);

            this.edadUsuario = calendar1.get(Calendar.YEAR) - calendar2.get(Calendar.YEAR);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getEstadoLaboral() {
        return estadoLaboral;
    }

    public void setEstadoLaboral(String estadoLaboral) {
        this.estadoLaboral = estadoLaboral;
    }

}
