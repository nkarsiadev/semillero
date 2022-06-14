package pichincha.com.backtarea.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cuenta")
public class Cuenta {
    // atributos generales de la clase cuenta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;
    private String numeroCuenta;
    private Date fechaCreacionCuenta;
    private String estadoCuenta;
    private String tipoCuenta; // ahorro, corriente, etc
    private double saldoCuenta;
    private String monedaCuenta;
    private String SaldoDeuda;

    // relacion con la clase cuenta para generar el JSON correctamente
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    // Sobreescritura de ToString
    @Override
    public String toString() {
        return "Cuenta [SaldoDeuda=" + SaldoDeuda + ", estadoCuenta=" + estadoCuenta + ", fechaCreacionCuenta="
                + fechaCreacionCuenta + ", idCuenta=" + idCuenta + ", monedaCuenta=" + monedaCuenta + ", numeroCuenta="
                + numeroCuenta + ", saldoCuenta=" + saldoCuenta + ", tipoCuenta=" + tipoCuenta + ", usuario=" + usuario
                + "]";
    }

    // setters y getters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cuenta() {

    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setFechaCreacionCuenta(java.util.Date date) {
        this.fechaCreacionCuenta = date;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCeunta) {
        this.numeroCuenta = numeroCeunta;
    }

    public Date getFechaCreacionCuenta() {
        return fechaCreacionCuenta;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public String getMonedaCuenta() {
        return monedaCuenta;
    }

    public void setMonedaCuenta(String monedaCuenta) {
        this.monedaCuenta = monedaCuenta;
    }

    public String getSaldoDeuda() {
        return SaldoDeuda;
    }

    public void setSaldoDeuda(String saldoDeuda) {
        SaldoDeuda = saldoDeuda;
    }

}
