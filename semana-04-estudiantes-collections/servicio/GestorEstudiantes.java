package servicio;

import modelo.Estudiante;
import java.util.*;

public class GestorEstudiantes {
    // Tres colecciones con roles distintos
    private HashMap<String, Estudiante> porCarnet; 
    private TreeSet<Estudiante> ranking;             
    private ArrayList<String> historial;             
    public GestorEstudiantes() {
        porCarnet = new HashMap<>();
        ranking = new TreeSet<>();
        historial = new ArrayList<>();
    }
    
    public boolean agregar(Estudiante e) {
        if (porCarnet.containsKey(e.getCarnet())) {
            return false; // Carnet duplicado
        }
        porCarnet.put(e.getCarnet(), e);
        ranking.add(e);
        historial.add("AGREGAR: " + e.getCarnet() + " - " + e.getNombre());
        return true;
    }

    public Estudiante buscar(String carnet) {
        return porCarnet.get(carnet);
    }

    public boolean actualizarPromedio(String carnet, double nuevoPromedio) {
        Estudiante e = porCarnet.get(carnet);
        if (e == null) return false;
        
        ranking.remove(e);
        e.setPromedio(nuevoPromedio);
        ranking.add(e);
        
        historial.add("ACTUALIZAR: " + carnet + " nuevo promedio " + nuevoPromedio);
        return true;
    }

    public boolean eliminar(String carnet) {
        Estudiante e = porCarnet.remove(carnet);
        if (e == null) return false;
        
        ranking.remove(e);
        historial.add("ELIMINAR: " + carnet + " - " + e.getNombre());
        return true;
    }
    
    public void mostrarRanking() {
        System.out.println("\n=== RANKING DE ESTUDIANTES ===");
        if (ranking.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        int pos = 1;
        for (Estudiante e : ranking) {
            System.out.printf("%3d. %s\n", pos++, e);
        }
    }
    
    public void mostrarTop5() {
        System.out.println("\n=== TOP 5 ESTUDIANTES ===");
        if (ranking.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        List<Estudiante> lista = new ArrayList<>(ranking);
        lista.sort((e1, e2) -> Double.compare(e2.getPromedio(), e1.getPromedio()));
        
        int limite = Math.min(5, lista.size());
        for (int i = 0; i < limite; i++) {
            System.out.printf("%3d. %s\n", i + 1, lista.get(i));
        }
    }
    
    public void filtrarPorCarrera(String carrera) {
        System.out.println("\n=== ESTUDIANTES DE " + carrera.toUpperCase() + " ===");
        boolean encontrado = false;
        for (Estudiante e : ranking) {
            if (e.getCarrera().equalsIgnoreCase(carrera)) {
                System.out.println("   " + e);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay estudiantes en esa carrera.");
        }
    }
    
    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADISTICAS ===");
        if (ranking.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        int total = porCarnet.size();
        double suma = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        
        for (Estudiante e : ranking) {
            suma += e.getPromedio();
            if (e.getPromedio() < min) min = e.getPromedio();
            if (e.getPromedio() > max) max = e.getPromedio();
        }
        
        double promedioGeneral = suma / total;
        
        System.out.println("    Total estudiantes: " + total);
        System.out.printf("    Promedio general: %.2f\n", promedioGeneral);
        System.out.printf("    Peor promedio: %.1f\n", min);
        System.out.printf("    Mejor promedio: %.1f\n", max);
    }
    
    public void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL DE OPERACIONES ===");
        if (historial.isEmpty()) {
            System.out.println("No hay operaciones registradas.");
            return;
        }
        for (String op : historial) {
            System.out.println("   " + op);
        }
    }
    
    public void cargarDatosPrueba() {
        agregar(new Estudiante("2021001", "Ana Torres", "Sistemas", 75.5));
        agregar(new Estudiante("2021002", "Carlos Quispe", "Industrial", 88.0));
        agregar(new Estudiante("2021003", "Maria Condori", "Sistemas", 92.3));
    }
    
    public int getTotalEstudiantes() { return porCarnet.size(); }
}