using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace product.API.Models
{
    public partial class Usuario
    {
        public Usuario()
        {
            Cuenta = new HashSet<Cuenta>();
        }

        public string Ci { get; set; } = null!;
        public string Nombre { get; set; } = null!;
        public string Apellido { get; set; } = null!;
        public DateTime FechaNacimiento { get; set; }
        public double SalarioPromedio { get; set; }

        public virtual ICollection<Cuenta>? Cuenta { get; set; }
    }
}
