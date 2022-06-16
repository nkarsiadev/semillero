using product.API.Models;

namespace product.API.Services
{
    public interface IUsuarioService
    {
        List<Usuario> GetUsuarios();
        Usuario GetUsuario(string numero);
        Usuario PostUsuario(Usuario usuario);
        Usuario UpdateUsuario(Usuario usuario);
        String DeleteUsuario(string numero);
    }
}
