package spring;

public class usuario {
	private String Nombre;
	private int ID;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public usuario(String nombre, int iD) {
		super();
		Nombre = nombre;
		ID = iD;
	}
	
}
