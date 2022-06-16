package controller;

import bean.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value="/persona", method = RequestMethod.GET)
    public Persona obtenerPersona(HttpServletRequest request){

        Persona person=new Persona();
        person.setNombre("Israel");
        person.setApellido("Morales");
        person.setDocumento("12345");
        return person;
    }
}
