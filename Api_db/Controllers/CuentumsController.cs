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
    public class CuentumsController : ControllerBase
    {
        private readonly bancoContext _context;

        public CuentumsController(bancoContext context)
        {
            _context = context;
        }

        // GET: api/Cuentums
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Cuentum>>> GetCuenta()
        {
            if (_context.Cuenta == null)
            {
                return NotFound();
            }
            return await _context.Cuenta.ToListAsync();
        }

        // GET: api/Cuentums/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Cuentum>> GetCuentum(int id)
        {
            if (_context.Cuenta == null)
            {
                return NotFound();
            }
            var cuentum = await _context.Cuenta.FindAsync(id);

            if (cuentum == null)
            {
                return NotFound();
            }

            return cuentum;
        }

        // PUT: api/Cuentums/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCuentum(int id, Cuentum cuentum)
        {
            if (id != cuentum.Idcuenta)
            {
                return BadRequest();
            }

            _context.Entry(cuentum).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CuentumExists(id))
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

        // POST: api/Cuentums
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Cuentum>> PostCuentum(Cuentum cuentum)
        {
            if (_context.Cuenta == null)
            {
                return Problem("Entity set 'bancoContext.Cuenta'  is null.");
            }
            _context.Cuenta.Add(cuentum);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (CuentumExists(cuentum.Idcuenta))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetCuentum", new { id = cuentum.Idcuenta }, cuentum);
        }

        // DELETE: api/Cuentums/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteCuentum(int id)
        {
            if (_context.Cuenta == null)
            {
                return NotFound();
            }
            var cuentum = await _context.Cuenta.FindAsync(id);
            if (cuentum == null)
            {
                return NotFound();
            }

            _context.Cuenta.Remove(cuentum);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        [HttpPut("{numCuenta}/{cant}/{tipoTransaccion}")]
        public async Task<ActionResult<Response>> receiveCash(string numCuenta, int cant, string tipoTransaccion)
        {
            var exito = "";
            var error = "";
            DateTime now = DateTime.Now;
            var result = _context.Cuenta.SingleOrDefault(p => p.Numero.Equals(numCuenta));
            if (result != null)
            {
                try
                {
                    if (tipoTransaccion.Equals("transferencia"))
                    {
                        decimal sald = (decimal)(result.Saldo + cant);
                        result.Saldo = result.Saldo + cant;
                        _context.SaveChanges();
                        exito = "Saldo modificado";
                        await actualizaMovimientos(result.Idcuenta, now, cant, sald);
                    }
                    else if (tipoTransaccion.Equals("debito"))
                    {
                        if (result.Saldo - cant >= 0)
                        {
                            decimal sald = (decimal)(result.Saldo - cant);
                            result.Saldo = result.Saldo - cant;
                            _context.SaveChanges();
                            exito = "Saldo modificado";
                            await actualizaMovimientos(result.Idcuenta, now, cant, sald);
                        }
                        else
                        {
                            error = "Saldo insuficiente";
                        }
                    }

                }
                catch (Exception ex)
                {
                    error = "Ocurrio un error..." + ex.Message;
                }
            }
            Response resp = new Response(exito, error);
            return resp;
        }

        private bool CuentumExists(int id)
        {
            return (_context.Cuenta?.Any(e => e.Idcuenta == id)).GetValueOrDefault();
        }

        private async Task<ActionResult<Response>> actualizaMovimientos(int idCuenta, DateTime fecha, decimal valor, decimal saldoFinal)
        {
            int cant = _context.Movientos.Count() + 1;
            var error = "";
            var exito = "";
            Moviento moviento = new Moviento { Idcuenta = idCuenta, Fecha = fecha, Valor = valor, Saldofinal = saldoFinal, Idmovimiento = cant };
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
    }
}
