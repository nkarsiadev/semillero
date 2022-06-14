package APIRest.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import APIRest.api.models.Usuario;

@Repository // conexion a la base de datos
@Transactional // consultas a la base de datos
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager; // conecxion con la base de datos

    @Override
    public List<Usuario<Long, String>> getUsuarios() {
        try {

        } catch (Exception e) {
            // TODO: handle exception
            // return "no se encontro al";
        }
        String query = "FROM Usuario"; // hay que decirle en que tabla tiene que buscar en clase usuario
        System.out.println(entityManager.createQuery(query).getResultList().toString());
        List<Usuario<Long, String>> response = entityManager.createQuery(query).getResultList();
        return response;
        // return null;
        // return query;
    }

    @Override
    public Usuario<Long, String> getUsuario(Long id) {
        // TODO Auto-generated method stub
        Usuario<Long, String> usuario = entityManager.find(Usuario.class, id);
        usuario.setNombre("Daniel");
        System.out.println(usuario.getNombre());
        return usuario;
    }

    @Override
    public Usuario<Long, String> crearUsuario(Usuario<Long, String> usuario) {
        // TODO Auto-generated method stub
        Usuario<Long, String> nuevoUsuario = entityManager.merge(usuario);
        return nuevoUsuario;
    }

    @Override
    public String eliminarUsuario(Long id) {
        // TODO Auto-generated method stub
        Usuario<Long, String> usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
        return "usuario eliminado";
    }

}