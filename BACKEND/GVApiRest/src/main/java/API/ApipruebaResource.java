/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package API;

import com.api.bean.Cuenta;
import com.api.bean.Json;
import com.api.bean.Usuario;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Gaby
 */
@Path("apiprueba")
public class ApipruebaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApipruebaResource
     */
    public ApipruebaResource() {
    }

    /**
     * Retrieves representation of an instance of API.ApipruebaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsuario(
            @QueryParam("cedula") String cedula,
            @QueryParam("nombre") String nombre,
            @QueryParam("ncuenta") String ncuenta,
            @QueryParam("tipocuenta") String tipocuenta
    ) {
        //TODO return proper representation object
        Usuario usuario = new Usuario();
        Cuenta cuenta=new Cuenta();
        
        usuario.setCedula(cedula);
        usuario.setNombre(nombre);
        
        cuenta.setNcuenta(ncuenta);
        cuenta.setTipocuenta(tipocuenta);
        
        usuario.setCuenta(cuenta);
        
        Json obj=new Json();
        obj.setUsuario(usuario);
        
        Gson gson=new Gson();
        String jsonString=gson.toJson(obj);
        return jsonString;
    }

    /**
     * PUT method for updating or creating an instance of ApipruebaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
