namespace api_crud.Models
{
    public class cliente : persona
    {
        public int id { get; set; }
        public string codigo { get; set; }
        public string direccion { get; set; }
        public string categoria { get; set; }

        public cliente(int id, int ci, string nombres, string apellidos) : base(id, ci, nombres, apellidos)
        {
            this.id = id;
            this.ci = ci;
            this.nombres = nombres;
            this.apellidos = apellidos;
        }
    }
}
