package modelo;

public class ContactoPersonal extends Contacto {

    private String apodo;

    public ContactoPersonal(
            String nombre,
            String telefono,
            String email,
            String apodo) {

        super(nombre, telefono, email);

        this.apodo = apodo;
    }

    @Override
    public String toString() {

        return "[PERSONAL] "
                + super.toString()
                + " | Apodo: "
                + apodo;
    }
}