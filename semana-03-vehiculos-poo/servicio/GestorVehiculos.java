package servicio;

import modelo.*;
import java.util.ArrayList;

public class GestorVehiculos {
    private ArrayList<Vehiculo> vehiculos;
    
    public GestorVehiculos() {
        vehiculos = new ArrayList<>();
    }
    
    public void agregar(Vehiculo v) {
        vehiculos.add(v);
        System.out.println(" Agregado: " + v.getInfo());
    }
    
    public void listarTodos() {
        System.out.println("\n=== TODA LA FLOTA ===");
        if (vehiculos.isEmpty()) {
            System.out.println("📭 No hay vehiculos registrados.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            System.out.println("   " + v.getInfo());
        }
    }
    
    public void listarPorTipo(String tipo) {
        System.out.println("\n=== TIPO: " + tipo.toUpperCase() + " ===");
        boolean hay = false;
        for (Vehiculo v : vehiculos) {
            boolean mostrar = false;
            if (tipo.equalsIgnoreCase("auto") && v instanceof Auto && !(v instanceof AutoElectrico))
                mostrar = true;
            if (tipo.equalsIgnoreCase("moto") && v instanceof Moto && !(v instanceof MotoElectrica))
                mostrar = true;
            if (tipo.equalsIgnoreCase("camion") && v instanceof Camion)
                mostrar = true;
            if (tipo.equalsIgnoreCase("electrico") && v instanceof Electrico)
                mostrar = true;
            if (mostrar) {
                System.out.println("   " + v.getInfo());
                hay = true;
            }
        }
        if (!hay) System.out.println("   No hay vehiculos de este tipo.");
    }
    
    public void verElectricos() {
        System.out.println("\n=== VEHICULOS ELECTRICOS ===");
        boolean hay = false;
        for (Vehiculo v : vehiculos) {
            if (v instanceof Electrico) {
                Electrico e = (Electrico) v;
                System.out.println("   " + v.getInfo() + " | Bateria: " + e.getNivelBateria() + "%");
                hay = true;
            }
        }
        if (!hay) System.out.println("   No hay vehiculos electricos.");
    }
    
    public void cargarBateriasBajas() {
        System.out.println("\n=== CARGANDO BATERIAS BAJAS ===");
        for (Vehiculo v : vehiculos) {
            if (v instanceof Electrico) {
                Electrico e = (Electrico) v;
                if (e.necesitaCarga()) {
                    System.out.print("   " + v.getInfo() + " -> ");
                    e.cargarBateria();
                }
            }
        }
    }
    
    public void demostrarPolimorfismo() {
        System.out.println("\n=== DEMOSTRACION DE POLIMORFISMO ===");
        System.out.println("acelerar() en toda la flota:\n");
        for (Vehiculo v : vehiculos) {
            v.acelerar();
        }
    }
    
    public void mostrarEstadisticas() {
        int total = vehiculos.size();
        int electricos = 0;
        int necesitanCarga = 0;
        
        for (Vehiculo v : vehiculos) {
            if (v instanceof Electrico) {
                electricos++;
                if (((Electrico) v).necesitaCarga()) necesitanCarga++;
            }
        }
        
        System.out.println("\n=== ESTADISTICAS ===");
        System.out.println("    Total vehiculos: " + total);
        System.out.println("    Vehiculos electricos: " + electricos);
        System.out.println("    Necesitan carga: " + necesitanCarga);
    }
    
    public ArrayList<Vehiculo> getFlota() { return vehiculos; }
}