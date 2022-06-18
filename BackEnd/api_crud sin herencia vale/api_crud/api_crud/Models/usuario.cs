using System.ComponentModel.DataAnnotations;

namespace api_crud.Models
{
    public class usuario
    {
        [Key]
        public int IDUSUARIO { get; set; }
        public string? TIPOUSUARIO { get; set; }
        public string? DIRECCION { get; set; }
    }
}
