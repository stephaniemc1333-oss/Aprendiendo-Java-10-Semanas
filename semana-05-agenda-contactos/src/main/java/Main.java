import servicio.AgendaContactos;
import modelo.Contacto;
import exception.*;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static AgendaContactos agenda = new AgendaContactos();

    public static void main(String[] args) {

        int op;

        do {
            System.out.println("\n=== AGENDA ===");
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Total");
            System.out.println("6. Salir");

            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                op = -1;
            }

            switch (op) {
                case 1: agregar(); break;
                case 2: listar(); break;
                case 3: buscar(); break;
                case 4: eliminar(); break;
                case 5: total(); break;
            }

        } while (op != 6);
    }

    static void agregar() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Nombre: ");
            String n = sc.nextLine();
            System.out.print("Tel: ");
            String t = sc.nextLine();
            System.out.print("Email: ");
            String e = sc.nextLine();

            agenda.agregar(new Contacto(id, n, t, e, ""));
            System.out.println("Guardado");

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static void listar() {
        for (Contacto c : agenda.listar())
            System.out.println(c);
    }

    static void buscar() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.println(agenda.buscar(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void eliminar() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();
            agenda.eliminar(id);
            System.out.println("Eliminado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void total() {
        System.out.println("Total: " + agenda.total());
    }
}