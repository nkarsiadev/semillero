using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace manejoErrores
{
    class Piscina
    {
        private int nivel;
        public  int MAX_NIVEL=0;
        public Piscina(int max)
        {
            if (max < 0) max = 0;
            MAX_NIVEL = max;
        }
        public int getNivel()
        {
            return nivel;
        }

        public void vaciar (int cantidad)
        {
            if (cantidad > nivel)
            {
                //throw new Exception("No se puede vaciar la piscina");
                throw new controlngresoException($"la cantidad {cantidad} es mayor que el nivel {nivel}");

            }
   
                nivel = nivel - cantidad;
              

            
        }

        public void llenar(int cantidad)
        {
            if (cantidad > MAX_NIVEL)
            {
                throw new Exception("El llenado no puede superar a {MAX_NIVEL}");
            }
            nivel = nivel + cantidad;
        }


    }
}
