package modelo;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private String estado;
    
    public Tarea(int id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = "PENDIENTE";
    }
    
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public void completar() {
        if (!estado.equals("COMPLETADA")) {
            estado = "COMPLETADA";
            System.out.println(" Tarea completada: " + titulo);
        }
    }
    
    public boolean estaCompletada() { return estado.equals("COMPLETADA"); }
    
    public void mostrarInfo() {
       
        System.out.println( " [ID: " + id + "] " + titulo);
        System.out.println("   Descripción: " + descripcion);
        System.out.println("   Estado: " + estado);
        System.out.println("   -----------------------");
    }
}