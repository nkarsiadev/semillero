using Microsoft.EntityFrameworkCore;
using product.API.Exceptions;
using product.API.Infraestructure;
using product.API.Models;

namespace product.API.Services
{
    public class UsuarioService : IUsuarioService
    {
        private readonly masterContext _context;
        public UsuarioService(masterContext context)
        {
            _context = context;
        }
        List<Usuario> IUsuarioService.GetUsuarios()
        {
            List<Usuario> usuarios = _context.Usuario.ToList();
            return usuarios;
        }

        Usuario IUsuarioService.GetUsuario(string ci)
        {
            Usuario usuario = _context.Usuario.FirstOrDefault(usuario => usuario.Ci == ci);
            if (usuario == null)
            {
                throw new UsuarioException("No existe el usuario");
            }
            return usuario;
        }

        Usuario IUsuarioService.PostUsuario(Usuario usuario)
        {
            try
            {
                _context.Usuario.Add(usuario);
                _context.SaveChanges();
            }
            catch (UsuarioException ex)
            {
                throw new UsuarioException(ex.InnerException.ToString());
            }
            return usuario;
        }

        Usuario IUsuarioService.UpdateUsuario(Usuario usuario)
        {
            try
            {
                _context.Entry(usuario).State = EntityState.Modified;
                _context.SaveChanges();
            }
            catch (UsuarioException ex)
            {
                throw new UsuarioException(ex.Message);
            }
            return usuario;
        }

        String IUsuarioService.DeleteUsuario(string ci)
        {
            var usuario = _context.Usuario.FirstOrDefault(u => u.Ci == ci);
            try
            {
                if (usuario != null)
                {
                    _context.Usuario.Remove(usuario);
                    _context.SaveChanges();
                }
                else
                {
                    throw new UsuarioException("No existe el usuario a eliminar");
                }
            }
            catch (UsuarioException ex)
            {
                throw new UsuarioException(ex.Message);
            }
            return ci;
        }
    }
}
