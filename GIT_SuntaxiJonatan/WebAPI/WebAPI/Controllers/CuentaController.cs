using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebAPI.Data;
using WebAPI.Models;

namespace WebAPI.Controllers
{
    public class CuentaController : ApiController
    {
        // GET api/<controller>
        public List<Cuenta> Get()
        {
            return CuentaData.Listar();
        }
        // GET api/<controller>/5
        public Cuenta Get(int id)
        {
            return CuentaData.Obtener(id);
        }

        // POST api/<controller>
        public bool Post([FromBody] Cuenta oUsuario)
        {
            return CuentaData.Registrar(oUsuario);
        }

        // PUT api/<controller>/5
        public bool Put([FromBody] Cuenta oUsuario)
        {
            return CuentaData.Modificar(oUsuario);
        }

        // DELETE api/<controller>/5
        public bool Delete(int id)
        {
            return CuentaData.Eliminar(id);
        }
    }
}