namespace Api_db.Models
{
    public class Response
    {
        public string respuesta { get; set; }
        public string error { get; set; }

        public Response(string respuesta, string error)
        {
            this.respuesta = respuesta;
            this.error = error;
        }
    }
}
