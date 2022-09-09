import java.time.LocalDate;
import java.util.Scanner;
import java.net.URL;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.util.Scanner;
import org.json.*;
public class Chocolate extends Golosina implements Produccion{
	String Nombre;
	int Cantidad;
	
	
	public Chocolate(String definicion, int calorias, String nombre, int cantidad) {
		super(definicion, calorias);
		Nombre = nombre;
		Cantidad = cantidad;
	}
	

	@Override
	public String toString() {
		return "Chocolate [Nombre=" + Nombre + ", Cantidad=" + Cantidad + ", Definicion=" + Definicion + ", Calorias="
				+ Calorias + "]";
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public int getCantidad() {
		return Cantidad;
	}


	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	
	@Override
	public void ProduccionActiva() {
		try {
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/28");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("HttpResponse "+conn.getResponseCode());
			}else {
				StringBuilder respuesta = new StringBuilder();
				Scanner teclado = new Scanner(url.openStream());
				while(teclado.hasNext()) {
					respuesta.append(teclado.nextLine());
				}
				teclado.close();
				
				JSONObject jo = new JSONObject(respuesta.toString());
				
				JSONObject TemperaturasComunidad = jo.getJSONArray("ciudades").getJSONObject(0).getJSONObject("temperatures");
				int TemperaturaMaxima = TemperaturasComunidad.getInt("max");
				if(TemperaturaMaxima<=40) {
					System.out.println("Debido a que no hace mucho calor se puede hacer Chocolate");
					System.out.println("Esto es lo que se producira el dia de hoy");
					System.out.println("Nombre					CANTIDAD PRODUCIDA");
					System.out.println("- Chocolate Blanco			1000");
					System.out.println("- Choclate Negro				1500");
					System.out.println("- Chocolate con almendras		1200");
					System.out.println("- Chocolate con castañas de caju	1300");
					System.out.println("- Chocolate en rama			100");
					System.out.println("- Chocolate con 70% de cacao		1500");
					try {
						LocalDate fecha = LocalDate.now();
						File fichero = new File("salida_"+fecha+".txt");
						if(fichero.exists()) {
							fichero.delete();
						}
						BufferedWriter bw = new BufferedWriter(new FileWriter("salida_"+fecha+".txt",true));
						bw.write("Nombre					CANTIDAD PRODUCIDA");
						bw.newLine();
						bw.write("-Chocolate Blanco			1000");
						bw.newLine();
						bw.write("- Choclate Negro			1500");
						bw.newLine();
						bw.write("- Chocolate con almendras		1200");
						bw.newLine();
						bw.write("- Chocolate con castañas de caju	1300");
						bw.newLine();
						bw.write("- Chocolate en rama			100");
						bw.newLine();
						bw.write("- Chocolate con 70% de cacao		1500");
						bw.newLine();
						bw.close();
						
						File jenkins = new File("JenkinsAA14");
						if(jenkins.exists()) {
							jenkins.delete();
						}
						BufferedWriter bw2 = new BufferedWriter(new FileWriter("JenkinsAA14",true));
						StringBuilder sb = new StringBuilder();
						sb.append("import java.time.LocalDate\r\n");
						sb.append("pipeline{\r\n");
						sb.append("agent any\r\n");
						sb.append("stages{\r\n");
						sb.append("stage('Build'){\r\n");
						sb.append("steps{\r\n");
						sb.append("script{\r\n");
						sb.append("println 'En la fecha de ' + LocalDate.now() + ' Se han producido estos chocolates'\r\n");
						sb.append("println 'Nombre					CANTIDAD PRODUCIDA'\r\n");
						sb.append("println '- Chocolate Blanco			1000'\r\n");
						sb.append("println '- Choclate Negro				1500'\r\n");
						sb.append("println '- Chocolate con almendras		1200'\r\n");
						sb.append("println '- Chocolate con castañas de caju	1300'\r\n");
						sb.append("println '- Chocolate en rama			100'\r\n");
						sb.append("println '- Chocolate con 70% de cacao		1500'\r\n");
						sb.append("}\r\n");
						sb.append("}\r\n");
						sb.append("}\r\n");
						sb.append("}\r\n");
						sb.append("}\r\n");
						bw2.write(sb.toString());
						bw2.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					System.out.println("Debido a las altas temperaturas hoy no se podra Realizar Chocolate");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
