using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using api_crud.Data;
using api_crud.Models;

namespace api_crud.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class empleadosController : ControllerBase
    {
        private readonly api_crudContext _context;

        public empleadosController(api_crudContext context)
        {
            _context = context;
        }

        // GET: api/empleados
        [HttpGet]
        public async Task<ActionResult<IEnumerable<empleado>>> Getempleado()
        {
          if (_context.empleado == null)
          {
              return NotFound();
          }
            return await _context.empleado.ToListAsync();
        }

        // GET: api/empleados/5
        [HttpGet("{id}")]
        public async Task<ActionResult<empleado>> Getempleado(int id)
        {
          if (_context.empleado == null)
          {
              return NotFound();
          }
            var empleado = await _context.empleado.FindAsync(id);

            if (empleado == null)
            {
                return NotFound();
            }

            return empleado;
        }

        // PUT: api/empleados/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> Putempleado(int id, empleado empleado)
        {
            if (id != empleado.Id)
            {
                return BadRequest();
            }

            _context.Entry(empleado).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!empleadoExists(id))
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

        // POST: api/empleados
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<empleado>> Postempleado(empleado empleado)
        {
          if (_context.empleado == null)
          {
              return Problem("Entity set 'api_crudContext.empleado'  is null.");
          }
            _context.empleado.Add(empleado);
            await _context.SaveChangesAsync();

            return CreatedAtAction("Getempleado", new { id = empleado.Id }, empleado);
        }

        // DELETE: api/empleados/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> Deleteempleado(int id)
        {
            if (_context.empleado == null)
            {
                return NotFound();
            }
            var empleado = await _context.empleado.FindAsync(id);
            if (empleado == null)
            {
                return NotFound();
            }

            _context.empleado.Remove(empleado);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool empleadoExists(int id)
        {
            return (_context.empleado?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
