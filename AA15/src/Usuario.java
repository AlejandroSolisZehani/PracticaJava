import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
public class Usuario implements Escribir_Provincias{
	private String Nombre;
	private int ID;
	private LocalDate Fechalogin;
	private ArrayList<Provincia> Provincias = new ArrayList<Provincia>();
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
	public LocalDate getFechalogin() {
		return Fechalogin;
	}
	public void setFechalogin(LocalDate fechalogin) {
		Fechalogin = fechalogin;
	}
	
	public ArrayList<Provincia> getProvincias() {
		return Provincias;
	}
	public void setProvincias(ArrayList<Provincia> provincias) {
		Provincias = provincias;
	}
	public Usuario(String nombre, int iD) {
		super();
		Nombre = nombre;
		ID = iD;
		Fechalogin = LocalDate.now();
	}
	
	
	@Override
	public String toString() {
		return "Usuario [Nombre=" + Nombre + ", ID=" + ID + ", Fechalogin=" + Fechalogin + ", Provincias=" + Provincias
				+ "]";
	}
	@Override
	public void ImplementarProvincias() {
		try {
			File Jenkins = new File("JenkinsFile"+LocalDate.now());
			if(Jenkins.exists()) {
				Jenkins.delete();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter("JenkinsFile"+LocalDate.now(),true));
			StringBuilder sbjenkins = new StringBuilder();
			sbjenkins.append("import java.time.LocalDate\r\n");
			sbjenkins.append("pipeline{\r\n");
			sbjenkins.append("    agent any\r\n");
			sbjenkins.append("    stages{\r\n");
			sbjenkins.append("        stage('main'){\r\n");
			sbjenkins.append("            steps{\r\n");
			sbjenkins.append("                script{\r\n");
			sbjenkins.append("println 'Datos del Usuario ");
			sbjenkins.append("Nombre: "+this.Nombre+" ID: "+this.ID+" Fecha: "+LocalDate.now()+" '\r\n");
			this.Provincias.forEach(
					(x) -> sbjenkins.append("println 'Nombre Provincia: "+x.getNombre()+" | "
							+ "Capital de la Provincia: "+x.getCapital()+"'\r\n")
			);
			
			sbjenkins.append("}\r\n");
			sbjenkins.append("}\r\n");
			sbjenkins.append("}\r\n");
			sbjenkins.append("}\r\n");
			sbjenkins.append("}\r\n");
			bw.write(sbjenkins.toString());
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
