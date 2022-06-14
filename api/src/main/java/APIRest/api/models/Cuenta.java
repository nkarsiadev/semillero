package APIRest.api.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity // le dice que va sacar de la base de datos
@Table(name = "cuentas")
public class Cuenta<L, S, F> {

    @Id
    // @Getter
    // @Setter
    @Column(name = "id")
    private Long id;

    // @Getter
    // @Setter
    @Column(name = "usuarioid")
    private Long usuarioId;

    // @Getter
    // @Setter
    @Column(name = "tipocuenta")
    private String tipoCuenta;

    // @Getter
    // @Setter
    @Column(name = "numerocuenta")
    private Long numeroCuenta;

    // @Getter
    // @Setter
    @Column(name = "saldo")
    private Float saldo;
    // private ArrayList<F> depositos = new ArrayList<F>();
    // private ArrayList<F> retiros = new ArrayList<F>();

    public Cuenta(Long id, Long usuarioId, String tipoCuenta, Long numeroCuenta, Float saldo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        // this.depositos = depositos;
        // this.retiros = retiros;
    }

    public Cuenta() {
    }

    /**
     * @return I return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the tipoCuenta
     */
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * @param tipoCuenta the tipoCuenta to set
     */
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * @return I return the numeroCuenta
     */
    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return Float return the saldo
     */
    public Float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    // /**
    // * @return ArrayList<F> return the depositos
    // */
    // public ArrayList<F> getDepositos() {
    // return depositos;
    // }

    // /**
    // * @param depositos the depositos to set
    // */
    // public void setDepositos(F deposito) {
    // this.depositos.add(deposito);
    // }

    // /**
    // * @return ArrayList<F> return the retiros
    // */
    // public ArrayList<F> getRetiros() {
    // return retiros;
    // }

    // /**
    // * @param retiros the retiros to set
    // */
    // public void setRetiros(F retiro) {
    // this.retiros.add(retiro);
    // }

    /**
     * @return Long return the usuarioId
     */
    public Long getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}