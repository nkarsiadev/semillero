namespace crudCuentas.Models
{
    public class cuentas
    {
        public int id { get; set; }
        public string? tipoCuenta { get; set; }
        public string? nroCuenta { get; set; }
        public string? estadoCuenta { get; set; }
        public int saldo { get; set; }
    }
}
