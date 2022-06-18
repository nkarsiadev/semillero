namespace manejoErrores
{
    class Program
    {
        static void Main(string[] args)
        {
            Piscina piscina = new Piscina(100);
                 piscina.llenar(5);
            piscina.vaciar(6);
        }
    }

}

