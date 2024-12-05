import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
    private GestorMusica gestor;

    public VentanaPrincipal() {
        gestor = new GestorMusica();
        setTitle("Gestor de Colecciones de Música");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Artistas", new PanelArtistas(gestor));
        tabbedPane.addTab("Canciones", new PanelCanciones(gestor));
        tabbedPane.addTab("Listas de Reproducción", new PanelListas(gestor));

        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaPrincipal::new);
    }
}