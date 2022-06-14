package pichincha.com.backtarea.Exception;

public class UsuarioServiceException extends Exception {
    public UsuarioServiceException(String message) {
        super(message);
    }
}

// finali se valida si esta siendo leido un archivo, carga, lectura,
// no aplicar TryCatsh, en definicion de variables