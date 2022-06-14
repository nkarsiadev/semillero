using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using api_crud.Models;

namespace api_crud.Data
{
    public class api_crudContext : DbContext
    {
        public api_crudContext (DbContextOptions<api_crudContext> options)
            : base(options)
        {
        }

        public DbSet<api_crud.Models.persona>? persona { get; set; }

        public DbSet<api_crud.Models.usuario>? usuario { get; set; }

        public DbSet<api_crud.Models.cuenta>? cuenta { get; set; }
    }
}
