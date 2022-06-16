package APIRest.api.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity // le dice que va sacar de la base de datos
@Table(name = "usuarios") // nobre de la taba en la base de datos
public class Usuario<N, S> {

    @Id // le dice que es la llave primaria
    @Getter
    @Setter
    @Column(name = "id") // getter y setter vienen de la dependencia tombak para no tener que hacer las
                         // fucniones getter y setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name = "apellido")
    private String apellido;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "telefono")
    private String telefono;

    // private float saldo; // acceso dentro de la clase
    @Getter
    @Setter
    @Column(name = "direccion")
    private String direccion;
    // JSONArray cuentas = new JSONArray();
    // private ArrayList<Float> cuentas = new ArrayList<Float>();

    public Usuario(Long id, String nombre, String apellido, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        // this.cuentas = cuentas;
    }

    public Usuario() {

    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return int return the id
     */
    public Long getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
        this.id = id;
    }

    /**
     * @return String return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return ArrayList<Float> return the cuentas
     */
    // public ArrayList<Float> getCuentas() {
    // return cuentas;
    // }

    /**
     * @param cuentas the cuentas to set
     */
    // public void setCuentas(ArrayList<Float> cuentas) {
    // this.cuentas = cuentas;
    // }

    /**
     * @return S return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}