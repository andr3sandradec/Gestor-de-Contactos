package main;

import controlador.ControladorAgenda;
import modelo.Agenda;
import vista.VistaAgenda;

public class Main {

    public static void main(String[] args) {

        Agenda miAgenda = new Agenda();

        VistaAgenda miVista = new VistaAgenda();

        ControladorAgenda controlador = new ControladorAgenda(miVista, miAgenda);

        controlador.iniciar();
    }
}
