using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace PlantillaApi.Models
{
    [Table("cuentas")]
    public class Cuentas
    {
        [Key]
        public int Numcuenta { get; set; }
        public string? Tipo { get; set; }

        public int? Ci { get; set; } 
    }
}
