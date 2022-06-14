using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Api_db.Models;
using Newtonsoft.Json;

namespace Api_db.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ClientesController : ControllerBase
    {
        private readonly bancoContext _context;

        public ClientesController(bancoContext context)
        {
            _context = context;
        }

        // GET: api/Clientes
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Cliente>>> GetClientes()
        {
            if (_context.Clientes == null)
            {
                return NotFound();
            }
            return await _context.Clientes.ToListAsync();
        }

        // GET: api/Clientes/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Cliente>> GetCliente(int id)
        {
            if (_context.Clientes == null)
            {
                return NotFound();
            }
            var cliente = await _context.Clientes.FindAsync(id);

            if (cliente == null)
            {
                return NotFound();
            }

            return cliente;
        }

        // PUT: api/Clientes/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCliente(int id, Cliente cliente)
        {
            if (id != cliente.Idcliente)
            {
                return BadRequest();
            }

            _context.Entry(cliente).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ClienteExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Clientes
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Cliente>> PostCliente(Cliente cliente)
        {
            if (_context.Clientes == null)
            {
                return Problem("Entity set 'bancoContext.Clientes'  is null.");
            }
            _context.Clientes.Add(cliente);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (ClienteExists(cliente.Idcliente))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetCliente", new { id = cliente.Idcliente }, cliente);
        }

        // DELETE: api/Clientes/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteCliente(int id)
        {
            if (_context.Clientes == null)
            {
                return NotFound();
            }
            var cliente = await _context.Clientes.FindAsync(id);
            if (cliente == null)
            {
                return NotFound();
            }

            _context.Clientes.Remove(cliente);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        [HttpPut("{id}/{address}")]
        public string ChangeAdress(int id, string address)
        {
            Response resp;
            var exito = "";
            var error = "";
            var result = _context.Clientes.SingleOrDefault(p => p.Idcliente == id);
            if (result != null)
            {
                try
                {
                    result.Direccion = address;
                    _context.SaveChanges();
                    exito = "Direccion modificada";
                }
                catch (Exception ex)
                {
                    error = "Ocurrio un error...";
                }
            }
            resp = new Response(exito, error);
            return JsonConvert.SerializeObject(resp);

            //dotnet ef context scaffold "Data Source = ...." Microsoft.EntityFrameworkCore.SqlServer -o Models
            //Scaffold-DbContext “Server=TuServidor;Database=StoreDB;User ID=TuUsuario;Password=TuContraseña” Microsoft.EntityFrameworkCore.SqlServer -OutputDir Models

            //Para hacer un update:
            //
            //Scaffold-DbContext -Tables Movimiento "Data Source=DESKTOP-3R4Q1SJ\SQLEXPRESS;Initial Catalog=banco;Integrated Security=True;Pooling=False" Microsoft.EntityFrameworkCore.SqlServer -OutputDir Models
        }

        private bool ClienteExists(int id)
        {
            return (_context.Clientes?.Any(e => e.Idcliente == id)).GetValueOrDefault();
        }
    }
}
