using Microsoft.AspNetCore.Mvc;
using product.API.Services;
using product.API.Models;

namespace product.API.Controllers;

[ApiController]
[Route("api/[controller]")]
public class UsuarioController : ControllerBase
{
    private readonly IUsuarioService _usuarioService;
    public UsuarioController(IUsuarioService usuarioService)
    {
        _usuarioService = usuarioService;
    }

    [HttpGet(Name = "GetUsuarios")]
    public ActionResult GetUsuarios()
    {
        try
        {
            return Ok(_usuarioService.GetUsuarios());
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpGet("{ci}", Name = "GetUsuario")]
    public ActionResult GetUsuario(string ci)
    {
        try
        {
            return Ok(_usuarioService.GetUsuario(ci));
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpPost]
    public ActionResult PostUsuario(Usuario usuario)
    {
        try
        {
            return Ok(_usuarioService.PostUsuario(usuario));
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpPut]
    public ActionResult UpdateUsuario(Usuario usuario)
    {
        try
        {
            return Ok(_usuarioService.UpdateUsuario(usuario));
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [Route("{ci}")]
    [HttpDelete]
    public ActionResult DeleteUsuario(string ci)
    {
        try
        {
            return Ok($"Usuario {_usuarioService.DeleteUsuario(ci)} borrado con Exito!");
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }
}
