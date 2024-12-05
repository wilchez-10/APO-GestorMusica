import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class PanelListas extends JPanel {
    private GestorMusica gestor;
    private DefaultListModel<ListaDeReproducción> modeloListas;

    public PanelListas(GestorMusica gestor) {
        this.gestor = gestor;
        setLayout(new BorderLayout());

        modeloListas = new DefaultListModel<>();
        JList<ListaDeReproducción> listaListas = new JList<>(modeloListas);
        add(new JScrollPane(listaListas), BorderLayout.CENTER);

        JTextField nombreField = new JTextField(10);
        JButton btnAgregarLista = new JButton("Crear Lista");

        btnAgregarLista.addActionListener((ActionEvent e) -> {
            String nombre = nombreField.getText();
            if (!nombre.isEmpty()) {
                ListaDeReproducción nuevaLista = new ListaDeReproducción(nombre);
                gestor.crearLista(nombre);
                modeloListas.addElement(nuevaLista);
                nombreField.setText("");
            }
        });

        JPanel panelFormulario = new JPanel();
        panelFormulario.add(new JLabel("Nombre de Lista:"));
        panelFormulario.add(nombreField);
        panelFormulario.add(btnAgregarLista);
        add(panelFormulario, BorderLayout.SOUTH);
    }
}