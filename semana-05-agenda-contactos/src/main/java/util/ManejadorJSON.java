package util;

import modelo.Contacto;
import java.io.*;
import java.util.ArrayList;

public class ManejadorJSON {

    public static ArrayList<Contacto> cargar(String ruta) {
        ArrayList<Contacto> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 4) {
                    lista.add(new Contacto(
                        datos[0], datos[1], datos[2], datos[3], ""
                    ));
                }
            }
        } catch (Exception e) {
            
        }

        return lista;
    }

    public static void guardar(ArrayList<Contacto> lista, String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Contacto c : lista) {
                pw.println(c.getId() + ";" + c.toString());
            }
        } catch (Exception e) {
            System.out.println("Error guardando archivo");
        }
    }
}