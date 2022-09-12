package spring;

public class Artista extends Persona{
	private String NombreArtistico;

	public String getNombreArtistico() {
		return NombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		NombreArtistico = nombreArtistico;
	}

	public Artista(String nombre, String nombreArtistico) {
		super(nombre);
		NombreArtistico = nombreArtistico;
	}

	@Override
	public String toString() {
		return "Artista [NombreArtistico=" + NombreArtistico + "]";
	}
	
}
