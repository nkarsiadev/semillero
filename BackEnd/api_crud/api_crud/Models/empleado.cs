namespace api_crud.Models
{
    public class empleado : persona
    {
        public int Id { get; set; }
        public string codigoInterno { get; set; }
        public string cargo { get; set; }
        public empleado(int id, int ci, string nombres, string apellidos) : base(id, ci, nombres, apellidos)
        {
            this.id = id;
            this.ci = ci;
            this.nombres = nombres;
            this.apellidos = apellidos;
        }
        public int identificacion => id;
        public int cedula => ci;
        public string nombre => nombres;
        public string apellido => apellidos;


    }
}
