using System;
using System.Collections.Generic;

namespace Api_db.Models
{
    public partial class Cliente
    {
        public int Idcliente { get; set; }
        public int Idcuenta { get; set; }
        public string? Nombre { get; set; }
        public string? Direccion { get; set; }

        public virtual Cuentum IdcuentaNavigation { get; set; } = null!;
    }
}
