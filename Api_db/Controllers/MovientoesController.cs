using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Api_db.Models;

namespace Api_db.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class MovientoesController : ControllerBase
    {
        private readonly bancoContext _context;

        public MovientoesController(bancoContext context)
        {
            _context = context;
        }

        // GET: api/Movientoes
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Moviento>>> GetMovientos()
        {
          if (_context.Movientos == null)
          {
              return NotFound();
          }
            return await _context.Movientos.ToListAsync();
        }

        // GET: api/Movientoes/5
        //[HttpGet("{id}")]
        //public async Task<ActionResult<Moviento>> GetMoviento(int id)
        //{
        //  if (_context.Movientos == null)
        //  {
        //      return NotFound();
        //  }
        //    var moviento = await _context.Movientos.FindAsync(id);

        //    if (moviento == null)
        //    {
        //        return NotFound();
        //    }

        //    return moviento;
        //}

        // PUT: api/Movientoes/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutMoviento(int id, Moviento moviento)
        {
            if (id != moviento.Idmovimiento)
            {
                return BadRequest();
            }

            _context.Entry(moviento).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!MovientoExists(id))
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

        [HttpPost("{idCuenta}/{fecha}/{valor}/{saldoFinal}")]
        public async Task<ActionResult<Response>> PostMove(int idCuenta, DateTime fecha, decimal valor, decimal saldoFinal)
        {
            if (_context.Movientos == null)
            {
                return NotFound();
            }
            int cant = _context.Movientos.Count() + 1;
            var error = "";
            var exito = "";
            Moviento moviento = new Moviento { Idcuenta = idCuenta, Fecha = fecha, Valor = valor, Saldofinal= saldoFinal, Idmovimiento=cant};
            _context.Movientos.Add(moviento);
            try
            {
                await _context.SaveChangesAsync();
                exito = "Se ingreso movimiento con exito!";
            }
            catch (DbUpdateException e)
            {
                error = e.Message;
                
            }
            Response response = new Response(exito, error);
            return response;
        }

        // DELETE: api/Movientoes/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteMoviento(int id)
        {
            if (_context.Movientos == null)
            {
                return NotFound();
            }
            var moviento = await _context.Movientos.FindAsync(id);
            if (moviento == null)
            {
                return NotFound();
            }

            _context.Movientos.Remove(moviento);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        //GET: api/Movientoes/cuenta
        [HttpGet("{accountNumber}")]
        public List<Moviento> getMoveAccount(string accountNumber)
        {
            var exito = "";
            var error = "";
            var idCuenta = _context.Cuenta.Where(p => p.Numero.Equals(accountNumber)).Select(c=>c.Idcuenta).First();
            List<Moviento> movimientosCuenta = new List<Moviento>();
            var result = _context.Movientos.Where(c => c.Idcuenta == idCuenta).Select(c => c).ToList();
            //var cuenta = _context.Cuenta.SingleOrDefault(p => p.Idcuenta.Equals(idCuenta));
            if (result != null)
            {
                try
                {
                    foreach (var item in result)
                    {
                        Moviento movimiento = new Moviento { Idcuenta = item.Idcuenta, Fecha = item.Fecha, Valor=item.Valor, Saldofinal=item.Saldofinal};
                        movimientosCuenta.Add(movimiento);
                        exito += "Movimiento: " + item.Idcuenta + item.Fecha + item.Saldofinal;
                    }

                }
                catch (Exception e)
                {

                    error = "Ocurrio un error " + e.Message;
                }
            }
            Response response = new Response(exito, error);
            return movimientosCuenta;

        }

        private bool MovientoExists(int id)
        {
            return (_context.Movientos?.Any(e => e.Idmovimiento == id)).GetValueOrDefault();
        }
    }
}
