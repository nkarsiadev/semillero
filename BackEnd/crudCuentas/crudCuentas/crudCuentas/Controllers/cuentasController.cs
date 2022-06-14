using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using crudCuentas.Data;
using crudCuentas.Models;

namespace crudCuentas.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class cuentasController : ControllerBase
    {
        private readonly crudCuentasContext _context;

        public cuentasController(crudCuentasContext context)
        {
            _context = context;
        }

        // GET: api/cuentas
        [HttpGet]
        public async Task<ActionResult<IEnumerable<cuentas>>> Getcuentas()
        {
          if (_context.cuentas == null)
          {
              return NotFound();
          }
            return await _context.cuentas.ToListAsync();
        }

        // GET: api/cuentas/5
        [HttpGet("{id}")]
        public async Task<ActionResult<cuentas>> Getcuentas(int id)
        {
          if (_context.cuentas == null)
          {
              return NotFound();
          }
            var cuentas = await _context.cuentas.FindAsync(id);

            if (cuentas == null)
            {
                return NotFound();
            }

            return cuentas;
        }

        // PUT: api/cuentas/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> Putcuentas(int id, cuentas cuentas)
        {
            if (id != cuentas.id)
            {
                return BadRequest();
            }

            _context.Entry(cuentas).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!cuentasExists(id))
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
        public async Task<ActionResult<cuentas>> Postcuentas(cuentas cuentas)
        {
          if (_context.cuentas == null)
          {
              return Problem("Entity set 'crudCuentasContext.cuentas'  is null.");
          }
            _context.cuentas.Add(cuentas);
            await _context.SaveChangesAsync();

            return CreatedAtAction("Getcuentas", new { id = cuentas.id }, cuentas);
        }

        // DELETE: api/cuentas/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> Deletecuentas(int id)
        {
            if (_context.cuentas == null)
            {
                return NotFound();
            }
            var cuentas = await _context.cuentas.FindAsync(id);
            if (cuentas == null)
            {
                return NotFound();
            }

            _context.cuentas.Remove(cuentas);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool cuentasExists(int id)
        {
            return (_context.cuentas?.Any(e => e.id == id)).GetValueOrDefault();
        }
    }
}
