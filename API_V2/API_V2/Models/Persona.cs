using System.ComponentModel.DataAnnotations;

namespace API_V2.Models
{
    public class Persona
    {
        [Key]
        public int PERIDPERSONA { get; set; }

        public string PERNOMBRE { get; set; }
        public string PERAPELLIDO { get; set; }
        public int PEREDAD { get; set; }
        
    }
}
