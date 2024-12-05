import java.util.ArrayList;
import java.util.List;

class ListaDeReproducción {
    private String nombre;
    private List<Cancion> canciones;

    public ListaDeReproducción(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    @Override
    public String toString() {
        return nombre;
    }
}