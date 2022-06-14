using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using product.API.Exceptions;
using product.API.Infraestructure;
using product.API.Models;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;
namespace product.API.Services
{
    public class CuentaService : ICuentaService
    {
        private readonly masterContext _context;
        public CuentaService(masterContext context)
        {
            _context = context;
        }
        List<Cuenta> ICuentaService.GetCuentas()
        {
            List<Cuenta> cuentas = _context.Cuenta.ToList();
            if(cuentas.Count == 0)
            {
                throw new CuentaException("No existen cuentas");
            }
            return cuentas;
        }

        Cuenta ICuentaService.GetCuenta(string numero)
        {
            Cuenta cuenta = _context.Cuenta.FirstOrDefault(cuenta => cuenta.Numero == numero);
            if(cuenta == null)
            {
                throw new CuentaException("No existe la cuenta");
            }
            return cuenta;
        }

        Cuenta ICuentaService.PostCuenta(Cuenta cuenta)
        {
            try
            {
                _context.Cuenta.Add(cuenta);
                _context.SaveChanges();
            }
            catch (CuentaException ex)
            {
                throw new CuentaException("No se pudo crear la cuenta", ex.InnerException);
            }
            return cuenta;
        }

        Cuenta ICuentaService.UpdateCuenta(Cuenta cuenta)
        {
            try
            {
                _context.Entry(cuenta).State = EntityState.Modified;
                _context.SaveChanges();
            }
            catch (CuentaException ex)
            {
                throw new CuentaException(ex.Message);
            }
            return cuenta;
        }
        
        String ICuentaService.DeleteCuenta(string numero)
        {
            var cuenta = _context.Cuenta.FirstOrDefault(cuenta => cuenta.Numero == numero);
            if (cuenta == null)
            {
                throw new CuentaException("No existe la cuenta a eliminar");
            }

            try
            {
                _context.Cuenta.Remove(cuenta);
                _context.SaveChanges();
            }
            catch(CuentaException ex)
            {
                throw new CuentaException(ex.Message);
            }
            return numero;
        }
    }
}
