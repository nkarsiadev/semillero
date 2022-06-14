package APIRest.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import APIRest.api.Exceptions.UsuariosNotDeletedException;
import APIRest.api.Exceptions.UsuariosNotFoundException;
import APIRest.api.models.Usuario;

@Repository // conexion a la base de datos
@Transactional // consultas a la base de datos
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager; // conecxion con la base de datos

    @Override
    public List<Usuario<Long, String>> getUsuarios() {
        
        String query = "FROM Usuario"; // hay que decirle en que tabla tiene que buscar en clase usuario
        // System.out.println(entityManager.createQuery(query).getResultList().toString());
        // System.out.println(entityManager.createQuery(query).getResultList().size());
        // if (entityManager.createQuery(query).getResultList().size() ==0){
        //     throw new UsuariosNotFoundException("No se encontro ningun usuario");
        // }else{

            return entityManager.createQuery(query).getResultList();
        // }
        // return query;
    }

    // busca un usuario
    @Override
    public Usuario<Long, String> getUsuario(Long id) {
        // TODO Auto-generated method stub
        Usuario<Long, String> usuario = entityManager.find(Usuario.class, id);
        // usuario.setNombre("Daniel");
        // if (usuario == null){
        //     throw new UsuariosNotFoundException("No se encontro un usuarion con ese id: " + id);
        // }else {

            System.out.println(usuario == null);
            return usuario;
        // }
        // System.out.println(entityManager.contains(id));
        // // if (entityManager.contains(id)){

        //     Usuario<Long, String> usuario = entityManager.find(Usuario.class, id);
        //     // usuario.setNombre("Daniel");
        //     System.out.println(usuario.getNombre());
        //     return usuario;
        // // }else {
        // //     throw new Exception("El usuario no existe");
        // // }
    }

    // crea un usuario nuevo
    @Override
    public Usuario<Long, String> crearUsuario(Usuario<Long, String> usuario) {
        
        // TODO Auto-generated method stub
        Usuario<Long, String> nuevoUsuario = entityManager.merge(usuario);
        return nuevoUsuario;
    }

    // modifica un usuario
    @Override
    public Usuario<Long, String> updateUsuario(Usuario<Long, String> usuario) {
        
        // TODO Auto-generated method stub
        Usuario nuevoUsuario = entityManager.merge(usuario);
        return nuevoUsuario; 
    }

    @Override
    public String eliminarUsuario(Long id) throws UsuariosNotFoundException {
        // TODO Auto-generated method stub
        
        Usuario<Long, String> usuario = entityManager.find(Usuario.class, id);
        if (usuario == null){
            throw new UsuariosNotFoundException("No se encontro un usuario con ese id: " + id);
        }else{

            entityManager.remove(usuario);
            return "usuario eliminado";
        }
    }

    @Override
    public String eliminarAllUsuarios() throws UsuariosNotDeletedException {
        // TODO Auto-generated method stub        
        entityManager.clear();
        String query = "FROM Usuario"; // hay que decirle en que tabla tiene que buscar en clase usuario
        List<Usuario<Long, String>> usuarios = entityManager.createQuery(query).getResultList();
        if( usuarios.size() != 0 ){
            throw new UsuariosNotDeletedException("Todavia existen usuarios");
        }else {
            return "no existen usuarios";

        }
    }
}