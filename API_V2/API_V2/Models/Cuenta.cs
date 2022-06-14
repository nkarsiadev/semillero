using System.ComponentModel.DataAnnotations;

namespace API_V2.Models
{
    public class Cuenta
    {
        [Key]
        public int CUEIDCUENTA { get; set; }
        public string CUENUMERO { get; set; }
        public decimal CUESALDO { get; set; }
        
    }
}
