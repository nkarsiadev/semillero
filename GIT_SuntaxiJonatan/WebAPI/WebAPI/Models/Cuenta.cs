using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebAPI.Models
{
    public class Cuenta
    {
        public int IdCuenta { get; set; }
        public string DocumentoIdentidad { get; set; }
        public string Nombres { get; set; }
        public string Saldo { get; set; }
        public DateTime FechaRegistro { get; set; }
    }
}