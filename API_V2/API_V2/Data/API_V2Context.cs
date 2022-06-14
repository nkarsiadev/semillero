using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using API_V2.Models;

namespace API_V2.Data
{
    public class API_V2Context : DbContext
    {
        public API_V2Context (DbContextOptions<API_V2Context> options)
            : base(options)
        {
        }

        public DbSet<API_V2.Models.Persona>? Persona { get; set; }

        public DbSet<API_V2.Models.Cuenta>? Cuenta { get; set; }

        public DbSet<API_V2.Models.Cliente>? Cliente { get; set; }
    }
}
