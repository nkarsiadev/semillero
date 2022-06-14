using System.ComponentModel.DataAnnotations;

namespace product.API.Models
{
    public class Persona
    {
        public Persona(string ci, string nombre, string apellido, DateTime fechaNacimiento )
        {
            Ci = ci;
            Nombre = nombre;
            Apellido = apellido;
            FechaNacimiento = fechaNacimiento;
        }
        [Key]
        public string Ci { get; set; }

        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public DateTime FechaNacimiento { get; set; }
    }
}
