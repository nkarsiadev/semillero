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
    public class personasController : ControllerBase
    {
        private readonly api_crudContext _context;

        public personasController(api_crudContext context)
        {
            _context = context;
        }

        // GET: api/personas
        [HttpGet]
        public async Task<ActionResult<IEnumerable<persona>>> Getpersona()
        {
          if (_context.persona == null)
          {
              return NotFound();
          }
            return await _context.persona.ToListAsync();
        }

        // GET: api/personas/5
        [HttpGet("{id}")]
        public async Task<ActionResult<persona>> Getpersona(int id)
        {
          if (_context.persona == null)
          {
              return NotFound();
          }
            var persona = await _context.persona.FindAsync(id);

            if (persona == null)
            {
                return NotFound();
            }

            return persona;
        }

        // PUT: api/personas/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> Putpersona(int id, persona persona)
        {
            if (id != persona.ID)
            {
                return BadRequest();
            }

            _context.Entry(persona).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!personaExists(id))
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

        // POST: api/personas
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<persona>> Postpersona(persona persona)
        {
          if (_context.persona == null)
          {
              return Problem("Entity set 'api_crudContext.persona'  is null.");
          }
            _context.persona.Add(persona);
            await _context.SaveChangesAsync();

            return CreatedAtAction("Getpersona", new { id = persona.ID }, persona);
        }

        // DELETE: api/personas/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> Deletepersona(int id)
        {
            if (_context.persona == null)
            {
                return NotFound();
            }
            var persona = await _context.persona.FindAsync(id);
            if (persona == null)
            {
                return NotFound();
            }

            _context.persona.Remove(persona);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool personaExists(int id)
        {
            return (_context.persona?.Any(e => e.ID == id)).GetValueOrDefault();
        }
    }
}
