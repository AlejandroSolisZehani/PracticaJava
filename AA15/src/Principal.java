import org.json.*;
import java.net.URL;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class Principal {
	public static void main(String[] args) {
		Usuario Alejandro = new Usuario("Alejandro Solis Zehani",1);
		System.out.println(Alejandro.toString());
		System.out.println("Ahora vamos a hacer la llamada a la api y asignarle las provincias");
		ArrayList<Provincia> ProvinciasArrayList = new ArrayList<Provincia>();
		try {
			URL url = new URL("https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&rows=0&sort=-provincia&facet=ccaa&facet=provincia");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("HttpResponse "+conn.getResponseCode());
			}else {
				StringBuilder sb = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()) {
					sb.append(sc.nextLine());
				}
				sc.close();
				JSONObject Provincias = new JSONObject(sb.toString());
				JSONArray nose = new JSONArray(Provincias.getJSONArray("facet_groups"));
				JSONArray ProvinciasFinal = new JSONArray(nose.getJSONObject(1).getJSONArray("facets"));
				for(Object ProvinciaObject:ProvinciasFinal) {
					//System.out.println(ProvinciaObject);
					//System.out.println(((JSONObject) ProvinciaObject).getString("name"));
					String Nombre = ((JSONObject) ProvinciaObject).getString("name");
					String Capital = ((JSONObject) ProvinciaObject).getString("path");
					int municipios = ((JSONObject) ProvinciaObject).getInt("count");
					Provincia porvinciaTemporal = new Provincia(Nombre,Capital,municipios);
					ProvinciasArrayList.add(porvinciaTemporal);
				}
				Alejandro.setProvincias(ProvinciasArrayList);
				System.out.println(Alejandro.toString());
				Alejandro.ImplementarProvincias();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			File AA15 = new File("AA15"+LocalDate.now()+".txt");
			if(AA15.exists()) {
				AA15.delete();
			}
			for(int i =0;i<ProvinciasArrayList.size();i++) {
				BufferedWriter bw = new BufferedWriter(new FileWriter("AA15"+LocalDate.now()+".txt",true));
				bw.write(ProvinciasArrayList.get(i).toString());
				bw.newLine();
				bw.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
