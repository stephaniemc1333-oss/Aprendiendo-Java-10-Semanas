package modelo;

public class Contacto {

    protected String nombre;
    protected String telefono;
    protected String email;

    public Contacto(String nombre,
                     String telefono,
                     String email) {

        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        return nombre + " | "
                + telefono + " | "
                + email;
    }
}
