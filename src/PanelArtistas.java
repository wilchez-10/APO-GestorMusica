import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class PanelArtistas extends JPanel {
    private GestorMusica gestor;

    public PanelArtistas(GestorMusica gestor) {
        this.gestor = gestor;
        setLayout(new BorderLayout());

        DefaultListModel<Artista> modeloArtistas = new DefaultListModel<>();
        JList<Artista> listaArtistas = new JList<>(modeloArtistas);
        add(new JScrollPane(listaArtistas), BorderLayout.CENTER);

        JTextField nombreField = new JTextField(10);
        JTextField biografiaField = new JTextField(10);
        JButton btnAgregar = new JButton("Agregar Artista");

        btnAgregar.addActionListener((ActionEvent e) -> {
            String nombre = nombreField.getText();
            String biografia = biografiaField.getText();
            if (!nombre.isEmpty()) {
                Artista artista = new Artista(nombre, biografia);
                gestor.crearArtista(nombre, biografia);
                modeloArtistas.addElement(artista);
                nombreField.setText("");
                biografiaField.setText("");
            }
        });

        JPanel panelFormulario = new JPanel();
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(nombreField);
        panelFormulario.add(new JLabel("Biografía:"));
        panelFormulario.add(biografiaField);
        panelFormulario.add(btnAgregar);
        add(panelFormulario, BorderLayout.SOUTH);
    }
}