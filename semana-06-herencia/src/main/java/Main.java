import modelo.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contacto> lista = new ArrayList<>();

    public static void main(String[] args) {

        int op;

        do {
            System.out.println("\n=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar Contacto Personal");
            System.out.println("2. Agregar Contacto Profesional");
            System.out.println("3. Listar Contactos");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    agregarPersonal();
                    break;

                case 2:
                    agregarProfesional();
                    break;

                case 3:
                    listar();
                    break;

                case 4:
                    System.out.println("Fin del programa...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (op != 4);
    }

    static void agregarPersonal() {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Telefono: ");
        String telefono = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Apodo: ");
        String apodo = sc.nextLine();

        ContactoPersonal cp =
            new ContactoPersonal(nombre, telefono, email, apodo);

        lista.add(cp);

        System.out.println("Contacto personal agregado.");
    }

    static void agregarProfesional() {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Telefono: ");
        String telefono = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Empresa: ");
        String empresa = sc.nextLine();

        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        ContactoProfesional cp =
            new ContactoProfesional(nombre, telefono, email, empresa, cargo);

        lista.add(cp);

        System.out.println("Contacto profesional agregado.");
    }

    static void listar() {

        if (lista.isEmpty()) {
            System.out.println("No existen contactos.");
            return;
        }

        System.out.println("\n=== LISTA DE CONTACTOS ===");

        for (Contacto c : lista) {
            System.out.println(c);
        }
    }
}