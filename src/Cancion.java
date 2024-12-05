public class Cancion {
    private String titulo;
    private String duracion;
    private Artista artista;

    public Cancion(String titulo, String duracion, Artista artista) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public Artista getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista.getNombre();
    }
}