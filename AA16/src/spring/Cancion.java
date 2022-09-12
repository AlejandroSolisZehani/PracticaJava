package spring;

public class Cancion implements Recaudacion{
	private String Titulo;
	private String Autor_Autores;
	private int Visualizaciones;
	private int Recaudacion;
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAutor_Autores() {
		return Autor_Autores;
	}
	public void setAutor_Autores(String autor_Autores) {
		Autor_Autores = autor_Autores;
	}
	public int getVisualizaciones() {
		return Visualizaciones;
	}
	public void setVisualizaciones(int visualizaciones) {
		Visualizaciones = visualizaciones;
	}
	public int getRecaudacion() {
		return Recaudacion;
	}
	public void setRecaudacion(int recaudacion) {
		Recaudacion = recaudacion;
	}
	public Cancion(String titulo, String autor_Autores, int visualizaciones) {
		super();
		Titulo = titulo;
		Autor_Autores = autor_Autores;
		Visualizaciones = visualizaciones;
	}
	@Override
	public String toString() {
		return "Cancion [Titulo=" + Titulo + ", Autor_Autores=" + Autor_Autores + ", Visualizaciones=" + Visualizaciones
				+ ", Recaudacion=" + Recaudacion + "]";
	}
	@Override
	public void CalcularRecaudacion() {
		this.Recaudacion = this.Visualizaciones*2;
	}
	
}
