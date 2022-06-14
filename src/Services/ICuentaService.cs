using Microsoft.AspNetCore.Mvc;
using product.API.Models;
using System.Collections.Generic;
using System.Threading.Tasks;
namespace product.API.Services
{
    public interface ICuentaService
    {
        List<Cuenta> GetCuentas();
        Cuenta GetCuenta(string numero);
        Cuenta PostCuenta(Cuenta cuenta);
        Cuenta UpdateCuenta(Cuenta cuenta);
        String DeleteCuenta(string numero);
    }
}
