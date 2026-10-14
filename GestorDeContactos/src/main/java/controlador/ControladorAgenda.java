package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Agenda;
import modelo.Contacto;
import vista.VistaAgenda;

public class ControladorAgenda implements ActionListener {

    private VistaAgenda vista;
    private Agenda modeloAgenda;

    public ControladorAgenda(VistaAgenda vista, Agenda modeloAgenda) {
        this.vista = vista;
        this.modeloAgenda = modeloAgenda;

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null); // Centrar ventana
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            guardarContacto();
        }

        if (e.getSource() == vista.btnBuscar) {
            buscarContacto();
        }
    }

    private void guardarContacto() {
        String nombre = vista.txtNombre.getText().trim();
        String telefono = vista.txtTelefono.getText().trim();

        if (nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, llene todos los campos para guardar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Contacto nuevo = new Contacto(nombre, telefono);
        modeloAgenda.guardar(nuevo);
        JOptionPane.showMessageDialog(vista, "Contacto guardado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        vista.txtNombre.setText("");
        vista.txtTelefono.setText("");
    }

    private void buscarContacto() {
        String nombreBusqueda = vista.txtBuscarNombre.getText().trim();

        if (nombreBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese un nombre para buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String resultado = modeloAgenda.buscar(nombreBusqueda);

        if (resultado.equals("No encontrado")) {
            JOptionPane.showMessageDialog(vista, "El contacto no fue encontrado.", "Búsqueda", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vista, "Teléfono de " + nombreBusqueda + ": " + resultado, "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
