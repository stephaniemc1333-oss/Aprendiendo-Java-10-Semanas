import servicio.GestorTareas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n╔════════════════════════╗");
            System.out.println("║   GESTOR DE TAREAS       ║");
            System.out.println("╠══════════════════════════╣");
            System.out.println("║ 1.    Agregar tarea      ║");
            System.out.println("║ 2.    Listar todas       ║");
            System.out.println("║ 3.    Listar pendientes  ║");
            System.out.println("║ 4.    Listar completadas ║");
            System.out.println("║ 5.    Completar tarea    ║");
            System.out.println("║ 6.    Eliminar tarea     ║");
            System.out.println("║ 7.    Estadísticas       ║");
            System.out.println("║ 8.    Salir              ║");
            System.out.println("╚══════════════════════════╝");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.print(" Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print(" Descripción: ");
                    String desc = scanner.nextLine();
                    gestor.agregar(titulo, desc);
                    break;
                case 2:
                    gestor.listar();
                    break;
                case 3:
                    gestor.listarPendientes();
                    break;
                case 4:
                    gestor.listarCompletadas();
                    break;
                case 5:
                    System.out.print(" ID: ");
                    int id = scanner.nextInt();
                    gestor.completar(id);
                    break;
                case 6:
                    System.out.print(" ID: ");
                    id = scanner.nextInt();
                    gestor.eliminar(id);
                    break;
                case 7:
                    gestor.mostrarEstadisticas();
                    break;
                case 8:
                    System.out.println(" ¡Hasta luego!");
                    break;
                default:
                    System.out.println(" Opción inválida");
            }
        } while (opcion != 8);
        
        scanner.close();
    }
}