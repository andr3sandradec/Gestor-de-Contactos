package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Agenda;
import modelo.Contacto;
import vista.VistaAgenda;

public class ControladorAgenda implements ActionListener {
    
    private VistaAgenda vista;
    private Agenda modeloAgenda;

    public ControladorAgenda(VistaAgenda vista, Agenda modeloAgenda) {
        this.vista = vista;
        this.modeloAgenda = modeloAgenda;
        
        // Aqui conecto klos botones con los eventos
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null); 
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Logica de lo que hace el boton guardar
        if (e.getSource() == vista.btnGuardar) {
            String nombre = vista.txtNombre.getText();
            String telefono = vista.txtTelefono.getText();
            
            Contacto nuevo = new Contacto(nombre, telefono);
            modeloAgenda.guardar(nuevo);
            
            vista.txtNombre.setText("");
            vista.txtTelefono.setText("");
            System.out.println("Contacto guardado.");
        }
        
        // Lógica del botón Buscar (Básica)
        if (e.getSource() == vista.btnBuscar) {
            String nombreBusqueda = vista.txtBuscarNombre.getText();
            String resultado = modeloAgenda.buscar(nombreBusqueda);
            
            System.out.println("Resultado de la búsqueda: " + resultado);
        }
    }
}