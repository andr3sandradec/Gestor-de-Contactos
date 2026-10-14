package modelo;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> listaContactos;

    public Agenda() {
        listaContactos = new ArrayList<>();
    }

    public void guardar(Contacto nuevoContacto) {
        listaContactos.add(nuevoContacto);
    }

    public String buscar(String nombreBuscado) {
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return c.getTelefono();
            }
        }
        return "No encontrado";
    }
}