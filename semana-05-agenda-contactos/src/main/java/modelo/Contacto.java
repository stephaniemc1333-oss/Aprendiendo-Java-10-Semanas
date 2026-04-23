package modelo;

import exception.DatoInvalidoException;

public class Contacto {

    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    public Contacto(String id, String nombre, String telefono, String email, String direccion) {
        setId(id);
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
        this.direccion = direccion;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty())
            throw new DatoInvalidoException("id", "vacio");
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty())
            throw new DatoInvalidoException("nombre", "vacio");
        this.nombre = nombre;
    }

    public void setTelefono(String tel) {
        if (tel.length() < 7 || tel.length() > 8)
            throw new DatoInvalidoException("telefono", "debe tener 7-8 digitos");
        this.telefono = tel;
    }

    public void setEmail(String email) {
        if (!email.contains("@") && !email.isEmpty())
            throw new DatoInvalidoException("email", "debe tener @");
        this.email = email;
    }

    public String getId() { return id; }

    public String toString() {
        return id + " | " + nombre + " | " + telefono + " | " + email;
    }
}
