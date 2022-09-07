package AA9;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Videojuegos implements Calculos{
	private String Titulo;
	private int Cantidad_Registros,Precio;
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public int getCantidad_Registros() {
		return Cantidad_Registros;
	}
	public void setCantidad_Registros(int cantidad_Registros) {
		Cantidad_Registros = cantidad_Registros;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	public Videojuegos(String titulo, int cantidad_Registros, int precio) {
		super();
		Titulo = titulo;
		Cantidad_Registros = cantidad_Registros;
		Precio = precio;
	}
	@Override
	public String toString() {
		return "Videojuegos [Titulo=" + Titulo + ", Cantidad_Registros=" + Cantidad_Registros + ", Precio=" + Precio
				+ "]";
	}
	
	@Override
	public void calculartotal() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Videojuegos.txt",true));
			bw.write("Titulo: "+this.Titulo+" | Copias vendidas: "+this.Cantidad_Registros+" | Monto Total: "+this.Precio*this.Cantidad_Registros);
			bw.newLine();
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
