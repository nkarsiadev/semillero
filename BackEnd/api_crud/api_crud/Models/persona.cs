namespace api_crud.Models
{
    public class persona
    {
        public int id { get; set; }
        protected int ci { get; set; }
        protected string nombres { get; set; }
        protected string apellidos { get; set; }

        public persona(int id, int ci, string nombres, string apellidos)
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
