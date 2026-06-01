package modelo;

public class ContactoProfesional extends Contacto {

    private String empresa;
    private String cargo;

    public ContactoProfesional(
            String nombre,
            String telefono,
            String email,
            String empresa,
            String cargo) {

        super(nombre, telefono, email);

        this.empresa = empresa;
        this.cargo = cargo;
    }

    @Override
    public String toString() {

        return "[PROFESIONAL] "
                + super.toString()
                + " | Empresa: "
                + empresa
                + " | Cargo: "
                + cargo;
    }
}