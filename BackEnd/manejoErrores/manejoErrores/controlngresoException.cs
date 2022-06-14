using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace manejoErrores
{
    public class controlngresoException : Exception

    {
        public controlngresoException(string mensaje): base(mensaje)
        {
            Console.WriteLine("error al vaciar la piscina: "+ mensaje);

        }
    }
}
