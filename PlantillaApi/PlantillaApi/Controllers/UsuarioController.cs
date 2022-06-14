using PlantillaApi.Context;
using PlantillaApi.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace PlantillaApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsuarioController : Controller
    {
        private readonly AppDbContext context;

        public UsuarioController(AppDbContext context)
        {
            this.context = context;
        }

        [HttpGet]

        public ActionResult Get()
        {
            if (context.usuarios == null)
            {
                return BadRequest("No se encontro ningun usuario");
            }
            else
            {
                return Ok(context.usuarios.ToList());
            }
        }

        [HttpGet("{id}", Name ="GetUsuario")]

        public ActionResult Get(int ci)
        {
            
            var usuario = context.usuarios.FirstOrDefault(u => u.Ci == ci);
            if (usuario == null)
            {
                return NotFound($"El usuario {ci} no existe");
            }
            else
            {
                return Ok(usuario);
            }

        }

        [HttpPost]

        public ActionResult Post([FromBody]Usuarios usuario)
        {
            try
            {
                context.usuarios.Add(usuario);
                context.SaveChanges();
                return Ok(usuario);
            }
            catch (Exception ex)
            {
                return BadRequest("El usuario ya existe");
            }
        }

      

        [HttpPut ("{ci}")]

        public ActionResult Put(int ci, [FromBody] Usuarios usuario)
        {
            
                if (usuario.Ci == ci)
                {
                    context.Entry(usuario).State=EntityState.Modified;
                    context.SaveChanges();
                    return Ok($"Se actualizo el usuario {ci}");
                }
                else
                {
                    return BadRequest($"El usuario {ci} no se pudo modificar");
                }
            
        }

        [HttpDelete("{ci}")]

        public ActionResult Delete(int ci)
        {
            
                var usuario = context.usuarios.FirstOrDefault(u => u.Ci == ci);
                if (usuario != null)
                {
                    context.usuarios.Remove(usuario);
                    context.SaveChanges();
                    return Ok($"Se elimino la cuenta numero {ci}");
                }
                else
                {
                    return BadRequest($"No se pudo eliminar al usuario {ci}");
                }
            
        }

        
    }
}
