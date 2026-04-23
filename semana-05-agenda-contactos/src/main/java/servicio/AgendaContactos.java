package servicio;

import modelo.Contacto;
import util.ManejadorJSON;
import exception.*;

import java.util.ArrayList;

public class AgendaContactos {

    private ArrayList<Contacto> lista;
    private String ruta = "data/contactos.txt";

    public AgendaContactos() {
        lista = ManejadorJSON.cargar(ruta);
    }

    public void agregar(Contacto c) throws ContactoExistenteException {
        for (Contacto x : lista) {
            if (x.getId().equals(c.getId()))
                throw new ContactoExistenteException(c.getId());
        }
        lista.add(c);
        ManejadorJSON.guardar(lista, ruta);
    }

    public void eliminar(String id) throws ContactoNoEncontradoException {
        boolean eliminado = lista.removeIf(c -> c.getId().equals(id));

        if (!eliminado)
            throw new ContactoNoEncontradoException("No existe");

        ManejadorJSON.guardar(lista, ruta);
    }

    public Contacto buscar(String id) throws ContactoNoEncontradoException {
        for (Contacto c : lista) {
            if (c.getId().equals(id))
                return c;
        }
        throw new ContactoNoEncontradoException("No encontrado");
    }

    public ArrayList<Contacto> listar() {
        return lista;
    }

    public int total() {
        return lista.size();
    }
}