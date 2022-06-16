using Microsoft.AspNetCore.Mvc;
using product.Application.Services;
using product.Models;

namespace product.Controllers;

[Route("api/v1/[controller]")]
[ApiController]
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
        return Ok(_cuentaService.GetCuentas());
    }

    [HttpGet("{numero}", Name = "GetCuenta")]
    public ActionResult GetCuenta(string numero)
    {
        return Ok(_cuentaService.GetCuenta(numero));
    }

    [HttpPost]
    public ActionResult PostCuenta(Cuenta cuenta)
    {
        
        return Ok(_cuentaService.PostCuenta(cuenta));
    }

    [Route("{numero}")]
    [HttpPut]
    public ActionResult UpdateCuenta(string numero, Cuenta cuenta)
    {
        return Ok(_cuentaService.UpdateCuenta(numero, cuenta));
    }

    [Route("{numero}")]
    [HttpDelete]
    public ActionResult DeleteCuenta(string numero)
    {
        return Ok(_cuentaService.DeleteCuenta(numero));
    }
}
