using PlantillaApi.Context;
using PlantillaApi.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Net;

namespace PlantillaApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CuentaController : Controller
    {
        private readonly AppDbContext context;

        public CuentaController(AppDbContext context)
        {
            this.context = context;
        }

        [HttpGet]

        public ActionResult Get()
        {
            if (context.cuentas == null)
            {
                return BadRequest("No se encontro ninguna cuenta");
            }
            else
            {
                return Ok(context.cuentas.ToList());
            }
        }

        [HttpGet("{id}", Name ="GetCuenta")]

        public ActionResult Get(int numcuenta)
        {
            var cuenta = context.cuentas.FirstOrDefault(c => c.Numcuenta == numcuenta);
            if (cuenta == null)
            {
                return NotFound($"La cuenta {numcuenta} no existe");
            }
            else
            {
                return Ok(cuenta);
            }
        }

        [HttpPost]

        public ActionResult Post([FromBody]Cuentas cuenta)
        {
             try
             {
                 context.cuentas.Add(cuenta);
                 context.SaveChanges();
                 return Ok(cuenta);
             }
             catch (Exception ex)
             {
                 return BadRequest("La cuenta ya exite");
             }

           
          /*  if (cuenta.Numcuenta == cuenta)
            {  
                context.cuentas.Add(cuenta);
                context.SaveChanges();
                return Ok(cuenta);
                return BadRequest("no existe");
            }
            else
            {
                return BadRequest("si existe");
            }
            */
            
        }


        [HttpPut ("{numcuenta}")]

        public ActionResult Put(int numcuenta, [FromBody] Cuentas cuenta)
        {
           
                if (cuenta.Numcuenta == numcuenta)
                {
                    context.Entry(cuenta).State=EntityState.Modified;
                    context.SaveChanges();
                    return Ok($"Se actualizo la cuenta numero {cuenta}");
                }
                else
                {
                    return BadRequest($"La cuenta {numcuenta} no se pudo modificar");
                }
            
           
        }

        [HttpDelete("{numcuenta}")]

        public ActionResult Delete(int numcuenta)
        {
            
                var cuenta = context.cuentas.FirstOrDefault(c => c.Numcuenta == numcuenta);
                if (cuenta != null)
                {
                    context.cuentas.Remove(cuenta);
                    context.SaveChanges();
                    return Ok($"Se elimino la cuenta numero {numcuenta}");
                }
                else
                {
                    return BadRequest($"No se pudo eliminar la cuenta {numcuenta}");
                }
           
        }

        
    }
}
