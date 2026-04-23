package exception;

public class ContactoExistenteException extends Exception {
    public ContactoExistenteException(String id) {
        super("Ya existe el contacto con ID: " + id);
    }
}