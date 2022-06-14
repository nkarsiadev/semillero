

using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace PlantillaApi.Models
{       
    [Table("usuarios")]
    public class Usuarios
    { 
    
        [Key]
        public int Ci { get; set; }
        public string? Nombres { get; set; }
        public string? Usuario { get; set; }
        public string? Clave { get; set; }


    }
}
