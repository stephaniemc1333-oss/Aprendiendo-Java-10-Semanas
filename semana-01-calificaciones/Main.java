// Sistema de Calificaciones - Semana 1
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    
    static final int TOTAL_ESTUDIANTES = 5;
    static final int TOTAL_NOTAS = 3;
    static final int NOTA_MINIMA = 0;
    static final int NOTA_MAXIMA = 100;
    static final int NOTA_APROBACION = 51;
    
    static String[] nombres = new String[TOTAL_ESTUDIANTES];
    static int[][] notas = new int[TOTAL_ESTUDIANTES][TOTAL_NOTAS];
    static double[] promedios = new double[TOTAL_ESTUDIANTES];
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CALIFICACIONES ===\n");
        
        for (int i = 0; i < TOTAL_ESTUDIANTES; i++) {
            ingresarEstudiante(i);
        }
        
        calcularTodosLosPromedios();
        mostrarResultados();
        mostrarEstadisticas();
        
        scanner.close();
    }
    
    public static void ingresarEstudiante(int indice) {
        System.out.println("\n--- Estudiante " + (indice + 1) + " ---");
        scanner.nextLine();
        
        System.out.print("Nombre: ");
        nombres[indice] = scanner.nextLine();
        
        for (int j = 0; j < TOTAL_NOTAS; j++) {
            notas[indice][j] = leerNota("Nota " + (j + 1) + ": ");
        }
    }
    
    public static int leerNota(String mensaje) {
        int nota;
        while (true) {
            try {
                System.out.print(mensaje);
                nota = scanner.nextInt();
                
                if (nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA) {
                    return nota;
                } else {
                    System.out.println("Error: La nota debe estar entre " + 
                                       NOTA_MINIMA + " y " + NOTA_MAXIMA);
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido");
                scanner.next();
            }
        }
    }
    
    public static double calcularPromedio(int[] notasEstudiante) {
        int suma = 0;
        for (int nota : notasEstudiante) {
            suma += nota;
        }
        return (double) suma / TOTAL_NOTAS;
    }
    // Calcula todos promedio
    public static void calcularTodosLosPromedios() {
        for (int i = 0; i < TOTAL_ESTUDIANTES; i++) {
            promedios[i] = calcularPromedio(notas[i]);
        }
    }
    
    public static String determinarEstado(double promedio) {
        if (promedio >= NOTA_APROBACION) {
            return "APROBADO";
        } else {
            return "REPROBADO";
        }
    }
    
    public static void mostrarResultados() {
        System.out.println("\n========= RESULTADOS =========");
        System.out.printf("%-15s %4s %4s %4s %8s %-10s\n", 
                          "NOMBRE", "N1", "N2", "N3", "PROM", "ESTADO");
        System.out.println("-".repeat(52));
        
        for (int i = 0; i < TOTAL_ESTUDIANTES; i++) {
            System.out.printf("%-15s %4d %4d %4d %8.2f %-10s\n",
                              nombres[i],
                              notas[i][0],
                              notas[i][1],
                              notas[i][2],
                              promedios[i],
                              determinarEstado(promedios[i]));
        }
    }
    
    public static void mostrarEstadisticas() {
        double sumaPromedios = 0;
        double maxPromedio = promedios[0];
        double minPromedio = promedios[0];
        int aprobados = 0;
        int reprobados = 0;
        
        for (int i = 0; i < TOTAL_ESTUDIANTES; i++) {
            sumaPromedios += promedios[i];
            
            if (promedios[i] > maxPromedio) {
                maxPromedio = promedios[i];
            }
            if (promedios[i] < minPromedio) {
                minPromedio = promedios[i];
            }
            
            if (promedios[i] >= NOTA_APROBACION) {
                aprobados++;
            } else {
                reprobados++;
            }
        }
        
        double promedioGeneral = sumaPromedios / TOTAL_ESTUDIANTES;
        
        System.out.println("\n========= ESTADISTICAS =========");
        System.out.printf("Promedio general del curso: %.2f\n", promedioGeneral);
        System.out.printf("Nota mas alta: %.2f\n", maxPromedio);
        System.out.printf("Nota mas baja: %.2f\n", minPromedio);
        System.out.printf("Aprobados: %d de %d\n", aprobados, TOTAL_ESTUDIANTES);
        System.out.printf("Reprobados: %d de %d\n", reprobados, TOTAL_ESTUDIANTES);
    }
}