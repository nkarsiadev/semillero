using System.ComponentModel.DataAnnotations;

namespace API_V2.Models
{
    public class Cliente 
    {
        [Key]
        public int CLIIDCLIENTE { get; set; }

        public string CLICEDULA { get; set; }
        public string CLITELEFONO { get; set; }
        public string CLICORREO { get; set; }
    }
}
