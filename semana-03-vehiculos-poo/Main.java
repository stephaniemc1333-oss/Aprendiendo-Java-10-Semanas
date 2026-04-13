import servicio.GestorVehiculos;
import modelo.*;
import java.util.Scanner;

public class Main {
    static GestorVehiculos gestor = new GestorVehiculos();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // === DEMOSTRACION DE POLIMORFISMO (Parte 1 del documento) ===
        System.out.println("=== DEMOSTRACION DE POLIMORFISMO ===");
        System.out.println("Un solo ArrayList<Vehiculo> con objetos de distinto tipo:\n");
        
        gestor.agregar(new Auto("Toyota", "Corolla", 2024, 4));
        gestor.agregar(new Moto("Honda", "CB500", 2023, false));
        gestor.agregar(new Camion("Volvo", "FH16", 2022, 24.0));
        gestor.agregar(new AutoElectrico("Tesla", "Model 3", 2024, 4, 80));
        gestor.agregar(new MotoElectrica("NIU", "MQi+", 2023, 60));
        
        gestor.demostrarPolimorfismo();
        
        // === MENU INTERACTIVO (Parte 2 del documento) ===
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    gestor.listarTodos();
                    break;
                case 3:
                    filtrarPorTipo();
                    break;
                case 4:
                    gestor.verElectricos();
                    break;
                case 5:
                    gestor.cargarBateriasBajas();
                    break;
                case 6:
                    gestor.demostrarPolimorfismo();
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
    
    static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║   GESTION DE VEHICULOS       ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1.   Agregar vehiculo        ║");
        System.out.println("║ 2.   Listar todos            ║");
        System.out.println("║ 3.   Filtrar por tipo        ║");
        System.out.println("║ 4.   Ver electricos          ║");
        System.out.println("║ 5.   Cargar baterias bajas   ║");
        System.out.println("║ 6.   Demostrar polimorfismo  ║");
        System.out.println("║ 7.   Estadisticas            ║");
        System.out.println("║ 8.   Salir                   ║");
        System.out.println("╚══════════════════════════════╝");
    }
    
    static void agregarVehiculo() {
        System.out.println("\n--- TIPOS DE VEHICULO ---");
        System.out.println("1. Auto");
        System.out.println("2. Moto");
        System.out.println("3. Camion");
        System.out.println("4. Auto Electrico");
        System.out.println("5. Moto Electrica");
        System.out.print("Seleccione tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Año: ");
        int anio = scanner.nextInt();
        
        switch (tipo) {
            case 1:
                System.out.print("Número de puertas: ");
                int puertas = scanner.nextInt();
                gestor.agregar(new Auto(marca, modelo, anio, puertas));
                break;
            case 2:
                gestor.agregar(new Moto(marca, modelo, anio, false));
                break;
            case 3:
                System.out.print("Capacidad (toneladas): ");
                double ton = scanner.nextDouble();
                gestor.agregar(new Camion(marca, modelo, anio, ton));
                break;
            case 4:
                System.out.print("Número de puertas: ");
                int p = scanner.nextInt();
                System.out.print("Nivel de batería (0-100): ");
                int bat = scanner.nextInt();
                gestor.agregar(new AutoElectrico(marca, modelo, anio, p, bat));
                break;
            case 5:
                System.out.print("Nivel de batería (0-100): ");
                int b = scanner.nextInt();
                gestor.agregar(new MotoElectrica(marca, modelo, anio, b));
                break;
            default:
                System.out.println("Tipo inválido");
        }
    }
    
    static void filtrarPorTipo() {
        System.out.println("\n--- FILTRAR POR ---");
        System.out.println("1. Auto");
        System.out.println("2. Moto");
        System.out.println("3. Camion");
        System.out.println("4. Electrico");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        
        switch (tipo) {
            case 1: gestor.listarPorTipo("auto"); break;
            case 2: gestor.listarPorTipo("moto"); break;
            case 3: gestor.listarPorTipo("camion"); break;
            case 4: gestor.listarPorTipo("electrico"); break;
            default: System.out.println("Opción inválida");
        }
    }
    
    static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print(" Ingrese un número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}