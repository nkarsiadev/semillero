//using Microsoft.AspNetCore.Mvc;
//using product.Models;
//using product.Context;
//using BP.Models;
//using Microsoft.EntityFrameworkCore;

//namespace product.Controllers;

//[ApiController]
//[Route("[controller]")]
//public class UsuarioController : ControllerBase
//{
//    private readonly masterContext context;
//    private readonly ILogger<UsuarioController> _logger;
//    public UsuarioController(ILogger<UsuarioController> logger, masterContext context)
//    {
//        _logger = logger;
//        this.context = context;
//    }

//    [HttpGet(Name = "GetUsuarios")]
//    public ActionResult GetUsuarios()
//    {
//        try
//        {
//            return Ok(context.usuario.ToList());
//        }
//        catch (Exception ex)
//        {
//            return BadRequest(ex.Message);
//        }
//    }

//    [HttpGet("{ci:int}", Name = "GetUsuario")]
//    public ActionResult GetUsuario(string ci)
//    {
//        try
//        {
//            var usuario = context.usuario.FirstOrDefault(u => u.Ci == ci);
//            return Ok(usuario);
//        }
//        catch (Exception ex)
//        {
//            return BadRequest(ex.Message);
//        }
//    }

//    [HttpPost]
//    public ActionResult PostUsuario(Usuario usuario)
//    {
//        try
//        {
//            context.usuario.Add(usuario);
//            context.SaveChanges();
//            return CreatedAtRoute("GetUsuario", new { ci = usuario.Ci}, usuario);
//        }
//        catch (Exception ex)
//        {
//            return BadRequest(ex.InnerException);
//        }
//    }


//    [HttpPut("{ci:int}")]
//    public ActionResult UpdateUsuario(string ci, Usuario usuario)
//    {
//        try
//        {
//            if (usuario.Ci == ci)
//            {
//                context.Entry(usuario).State = EntityState.Modified;
//                context.SaveChanges();
//                return CreatedAtRoute("GetUsuario", new { ci = usuario.Ci}, usuario);
//            }
//            else
//            {
//                return BadRequest();
//            }
//        }
//        catch (Exception ex)
//        {
//            return BadRequest(ex.Message);
//        }
//    }

//    [HttpDelete("{ci:int}")]
//    public ActionResult DeleteUsuario(string ci)
//    {
//        try
//        {
//            var usuario = context.usuario.FirstOrDefault(u => u.Ci == ci);
//            if (usuario != null)
//            {
//                context.usuario.Remove(usuario);
//                context.SaveChanges();
//                return Ok(ci);
//            }
//            else
//            {
//                return BadRequest();
//            }
//        }
//        catch (Exception ex)
//        {
//            return BadRequest(ex.Message);
//        }
//    }
//}
