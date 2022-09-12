
public class Provincia extends Capital_Provincia{
	private String Nombre;
	private int Municipios;
	public Provincia(String capital, String nombre, int municipios) {
		super(capital);
		Nombre = nombre;
		Municipios = municipios;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getMunicipios() {
		return Municipios;
	}
	public void setMunicipios(int municipios) {
		Municipios = municipios;
	}
	@Override
	public String toString() {
		return "Provincia [Nombre=" + Nombre + ", Municipios=" + Municipios + " " + ", CapitalProvincia=" + Nombre + " ]";
	}
	
}
