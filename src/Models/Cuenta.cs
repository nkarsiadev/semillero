using System;
using System.Collections.Generic;

namespace product.API.Models
{
    public partial class Cuenta
    {
        public string Numero { get; set; } = null!;
        public string CiUsuario { get; set; } = null!;
        public string Tipo { get; set; } = null!;
        public double Saldo { get; set; }

        public virtual Usuario? CiUsuarioNavigation { get; set; } = null!;
    }
}
