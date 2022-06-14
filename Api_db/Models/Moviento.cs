using System;
using System.Collections.Generic;

namespace Api_db.Models
{
    public partial class Moviento
    {
        public int Idmovimiento { get; set; }
        public int Idcuenta { get; set; }
        public DateTime? Fecha { get; set; }
        public decimal? Valor { get; set; }
        public decimal? Saldofinal { get; set; }

        public virtual Cuentum IdcuentaNavigation { get; set; } = null!;
    }
}
