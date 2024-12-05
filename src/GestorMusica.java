import java.util.ArrayList;
import java.util.List;

public class GestorMusica {
    private List<ListaDeReproducción> listas;
    private List<Artista> artistas;
    private List<Cancion> canciones;

    public GestorMusica() {
        listas = new ArrayList<>();
        artistas = new ArrayList<>();
        canciones = new ArrayList<>();
    }

    public void cargarListasDesdeArchivo(String file) {
    }

    public void crearLista(String nombre) {
        listas.add(new ListaDeReproducción(nombre));
    }

    public void crearArtista(String nombre, String biografia) {
        artistas.add(new Artista(nombre, biografia));
    }

    public void crearCancion(String titulo, String duracion, Artista artista) {
        Cancion nuevaCancion = new Cancion(titulo, duracion, artista);
        canciones.add(nuevaCancion);
    }

    public void agregarCancionALista(String nombreLista, Cancion cancion) {
        for (ListaDeReproducción lista : listas) {
            if (lista.getNombre().equals(nombreLista)) {
                lista.agregarCancion(cancion);
                break; 
            }
        }
    }

    public List<ListaDeReproducción> getListas() {
        return listas;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }
}