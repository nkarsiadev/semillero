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
    public class cuentasController : ControllerBase
    {
        private readonly api_crudContext _context;

        public cuentasController(api_crudContext context)
        {
            _context = context;
        }

        // GET: api/cuentas
        [HttpGet]
        public async Task<ActionResult<IEnumerable<cuenta>>> Getcuenta()
        {
          if (_context.cuenta == null)
          {
              return NotFound();
          }
            return await _context.cuenta.ToListAsync();
        }

        // GET: api/cuentas/5
        [HttpGet("{id}")]
        public async Task<ActionResult<cuenta>> Getcuenta(int id)
        {
          if (_context.cuenta == null)
          {
              return NotFound();
          }
            var cuenta = await _context.cuenta.FindAsync(id);

            if (cuenta == null)
            {
                return NotFound();
            }

            return cuenta;
        }

        // PUT: api/cuentas/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> Putcuenta(int id, cuenta cuenta)
        {
            if (id != cuenta.IDCUENTA)
            {
                return BadRequest();
            }

            _context.Entry(cuenta).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!cuentaExists(id))
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

        // POST: api/cuentas
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<cuenta>> Postcuenta(cuenta cuenta)
        {
          if (_context.cuenta == null)
          {
              return Problem("Entity set 'api_crudContext.cuenta'  is null.");
          }
            _context.cuenta.Add(cuenta);
            await _context.SaveChangesAsync();

            return CreatedAtAction("Getcuenta", new { id = cuenta.IDCUENTA }, cuenta);
        }

        // DELETE: api/cuentas/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> Deletecuenta(int id)
        {
            if (_context.cuenta == null)
            {
                return NotFound();
            }
            var cuenta = await _context.cuenta.FindAsync(id);
            if (cuenta == null)
            {
                return NotFound();
            }

            _context.cuenta.Remove(cuenta);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool cuentaExists(int id)
        {
            return (_context.cuenta?.Any(e => e.IDCUENTA == id)).GetValueOrDefault();
        }
    }
}
