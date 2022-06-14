using Microsoft.AspNetCore.Mvc;
using product.API.Models;
using product.API.Services;

namespace product.API.Controllers;

[ApiController]
[Route("api/[controller]")]
public class CuentaController : ControllerBase
{
    private readonly ICuentaService _cuentaService;
    public CuentaController(ICuentaService cuentaService)
    {
        _cuentaService = cuentaService;
    }
    
    [HttpGet(Name = "GetCuentas")]
    public ActionResult GetCuentas()
    {
        try
        {
            return Ok(_cuentaService.GetCuentas());
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpGet("{numero}", Name = "GetCuenta")]
    public ActionResult GetCuenta(string numero)
    {
        try
        {
            return Ok(_cuentaService.GetCuenta(numero));
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpPost]
    public ActionResult PostCuenta(Cuenta cuenta)
    {
        try
        {
            return Ok(_cuentaService.PostCuenta(cuenta));
        }
        catch(Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpPut]
    public ActionResult UpdateCuenta(Cuenta cuenta)
    {
        try
        {
            return Ok(_cuentaService.UpdateCuenta(cuenta));
        }
        catch(Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [Route("{numero}")]
    [HttpDelete]
    public ActionResult DeleteCuenta(string numero)
    {
        try
        {
            return Ok($"Cuenta {_cuentaService.DeleteCuenta(numero)} borrada con Exito!");
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }
}
