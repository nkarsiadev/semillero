namespace product.API.Exceptions
{
    public class UsuarioException : Exception
    {
        public UsuarioException(string msg) : base(msg){}
        public UsuarioException(string msg, Exception? innerException) : base(msg, innerException) { }

    }
}
