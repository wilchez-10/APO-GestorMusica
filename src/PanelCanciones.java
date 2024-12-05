import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class PanelCanciones extends JPanel {
    private GestorMusica gestor;
    private DefaultListModel<Cancion> modeloCanciones;

    public PanelCanciones(GestorMusica gestor) {
        this.gestor = gestor;
        setLayout(new BorderLayout());

        modeloCanciones = new DefaultListModel<>();
        JList<Cancion> listaCanciones = new JList<>(modeloCanciones);
        add(new JScrollPane(listaCanciones), BorderLayout.CENTER);

        JTextField tituloField = new JTextField(10);
        JTextField duracionField = new JTextField(10);
        JTextField artistaField = new JTextField(10);
        JButton btnAgregar = new JButton("Agregar Canción");

        btnAgregar.addActionListener((ActionEvent e) -> {
            String titulo = tituloField.getText();
            String duracion = duracionField.getText();
            String nombreArtista = artistaField.getText();

            if (!titulo.isEmpty() && !nombreArtista.isEmpty()) {
                Artista artistaSeleccionado = gestor.getArtistas().stream()
                        .filter(artista -> artista.getNombre().equalsIgnoreCase(nombreArtista))
                        .findFirst()
                        .orElse(null);

                if (artistaSeleccionado == null) {
                    artistaSeleccionado = new Artista(nombreArtista, "");
                    gestor.crearArtista(nombreArtista, "");
                }

                Cancion nuevaCancion = new Cancion(titulo, duracion, artistaSeleccionado);
                gestor.crearCancion(titulo, duracion, artistaSeleccionado);
                modeloCanciones.addElement(nuevaCancion);
                tituloField.setText("");
                duracionField.setText("");
                artistaField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            }
        });

        JPanel panelFormulario = new JPanel();
        panelFormulario.add(new JLabel("Título:"));
        panelFormulario.add(tituloField);
        panelFormulario.add(new JLabel("Duración:"));
        panelFormulario.add(duracionField);
        panelFormulario.add(new JLabel("Artista:"));
        panelFormulario.add(artistaField);
        panelFormulario.add(btnAgregar);
        add(panelFormulario, BorderLayout.SOUTH);
    }
}