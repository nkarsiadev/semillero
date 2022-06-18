using System.ComponentModel.DataAnnotations;

namespace api_crud.Models
{
    public class cuenta
    {
        [Key]
        public int IDCUENTA { get; set; }
        public string? TIPOCUENTA { get; set; }
        public string? NROCUENTA { get; set; }
        public Decimal SALDO { get; set; }
    }
}
