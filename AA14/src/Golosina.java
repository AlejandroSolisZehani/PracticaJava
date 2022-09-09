
public class Golosina {
	String Definicion;
	int Calorias;
	public String getDefinicion() {
		return Definicion;
	}
	public void setDefinicion(String definicion) {
		Definicion = definicion;
	}
	public int getCalorias() {
		return Calorias;
	}
	public void setCalorias(int calorias) {
		Calorias = calorias;
	}
	public Golosina(String definicion, int calorias) {
		super();
		Definicion = definicion;
		Calorias = calorias;
	}
	@Override
	public String toString() {
		return "Golosina [Definicion=" + Definicion + ", Calorias=" + Calorias + "]";
	}
	
	
}
