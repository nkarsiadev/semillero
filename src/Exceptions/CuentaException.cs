namespace product.API.Exceptions
{
    public class CuentaException : Exception
    {
        public CuentaException(string msg) : base(msg) {}
        public CuentaException(string msg, Exception? innerException) : base(msg, innerException){}
    }
}
