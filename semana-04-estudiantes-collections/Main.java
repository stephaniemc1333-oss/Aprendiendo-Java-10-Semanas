import modelo.Estudiante;
import servicio.GestorEstudiantes;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static GestorEstudiantes gestor = new GestorEstudiantes();
    
    public static void main(String[] args) {
        gestor.cargarDatosPrueba();
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    buscarEstudiante();
                    break;
                case 3:
                    actualizarPromedio();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;
                case 5:
                    gestor.mostrarRanking();
                    break;
                case 6:
                    gestor.mostrarTop5();
                    break;
                case 7:
                    filtrarPorCarrera();
                    break;
                case 8:
                    gestor.mostrarEstadisticas();
                    break;
                case 9:
                    gestor.mostrarHistorial();
                    break;
                case 0:
                    System.out.println(" ¡Hasta luego!");
                    break;
                default:
                    System.out.println(" Opción inválida");
            }
        } while (opcion != 0);
        
        scanner.close();
    }
    
    static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║   SISTEMA DE ESTUDIANTES         ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ 1.   Agregar estudiante          ║");
        System.out.println("║ 2.   Buscar por carnet           ║");
        System.out.println("║ 3.   Actualizar promedio         ║");
        System.out.println("║ 4.   Eliminar estudiante         ║");
        System.out.println("║ 5.   Ver ranking completo        ║");
        System.out.println("║ 6.   Ver top 5                   ║");
        System.out.println("║ 7.   Filtrar por carrera         ║");
        System.out.println("║ 8.   Estadísticas                ║");
        System.out.println("║ 9.   Historial                   ║");
        System.out.println("║ 0.   Salir                       ║");
        System.out.println("╚══════════════════════════════════╝");
    }
    
    static void agregarEstudiante() {
        System.out.println("\n--- AGREGAR ESTUDIANTE ---");
        System.out.print("Carnet: ");
        String carnet = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();
        System.out.print("Promedio: ");
        double promedio = scanner.nextDouble();
        scanner.nextLine();
        
        boolean ok = gestor.agregar(new Estudiante(carnet, nombre, carrera, promedio));
        if (ok) {
            System.out.println(" Estudiante registrado correctamente.");
        } else {
            System.out.println(" Error: El carnet ya existe.");
        }
    }
    
    static void buscarEstudiante() {
        System.out.print("\nCarnet a buscar: ");
        String carnet = scanner.nextLine();
        Estudiante e = gestor.buscar(carnet);
        if (e != null) {
            System.out.println(" Encontrado: " + e);
        } else {
            System.out.println(" Carnet no encontrado.");
        }
    }
    
    static void actualizarPromedio() {
        System.out.print("\nCarnet: ");
        String carnet = scanner.nextLine();
        System.out.print("Nuevo promedio: ");
        double nuevoProm = scanner.nextDouble();
        scanner.nextLine();
        
        boolean ok = gestor.actualizarPromedio(carnet, nuevoProm);
        if (ok) {
            System.out.println(" Promedio actualizado correctamente.");
        } else {
            System.out.println(" Carnet no encontrado.");
        }
    }
    
    static void eliminarEstudiante() {
        System.out.print("\nCarnet a eliminar: ");
        String carnet = scanner.nextLine();
        boolean ok = gestor.eliminar(carnet);
        if (ok) {
            System.out.println(" Estudiante eliminado correctamente.");
        } else {
            System.out.println(" Carnet no encontrado.");
        }
    }
    
    static void filtrarPorCarrera() {
        System.out.print("\nCarrera: ");
        String carrera = scanner.nextLine();
        gestor.filtrarPorCarrera(carrera);
    }
    
    static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print(" Ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}