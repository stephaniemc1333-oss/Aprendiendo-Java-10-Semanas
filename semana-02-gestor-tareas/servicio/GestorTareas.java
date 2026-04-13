package servicio;

import modelo.Tarea;
import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<Tarea> tareas;
    private int proximoId;
    
    public GestorTareas() {
        tareas = new ArrayList<>();
        proximoId = 1;
    }
    
    public void agregar(String titulo, String descripcion) {
        Tarea nueva = new Tarea(proximoId, titulo, descripcion);
        tareas.add(nueva);
        System.out.println(" Tarea agregada con ID: " + proximoId);
        proximoId++;
    }
    
    public void listar() {
        if (tareas.isEmpty()) {
            System.out.println("📭 No hay tareas");
            return;
        }
        System.out.println("\n=== LISTA DE TAREAS ===");
        for (Tarea t : tareas) {
            t.mostrarInfo();
        }
    }
    
    public void listarPendientes() {
        System.out.println("\n=== TAREAS PENDIENTES ===");
        for (Tarea t : tareas) {
            if (!t.estaCompletada()) t.mostrarInfo();
        }
    }
    
    public void listarCompletadas() {
        System.out.println("\n=== TAREAS COMPLETADAS ===");
        for (Tarea t : tareas) {
            if (t.estaCompletada()) t.mostrarInfo();
        }
    }
    
    public void completar(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.completar();
                return;
            }
        }
        System.out.println(" No se encontró tarea con ID: " + id);
    }
    
    public void eliminar(int id) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == id) {
                tareas.remove(i);
                System.out.println(" Tarea eliminada");
                return;
            }
        }
        System.out.println(" No se encontró tarea con ID: " + id);
    }
    
    public void mostrarEstadisticas() {
        int total = tareas.size();
        int completadas = 0;
        for (Tarea t : tareas) {
            if (t.estaCompletada()) completadas++;
        }
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println(" Total: " + total);
        System.out.println(" Completadas: " + completadas);
        System.out.println(" Pendientes: " + (total - completadas));
    }
}