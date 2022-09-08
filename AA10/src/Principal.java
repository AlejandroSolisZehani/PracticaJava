import org.json.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String nombre;
		System.out.println("Introduce tu nombre");
		nombre=teclado.nextLine();
		System.out.println("Hola "+nombre+" Voy a enseñarte los datos de un municipio");
		teclado.close();
		try {
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/28");
			StringBuilder sb = new StringBuilder();
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("HttpResponse "+conn.getResponseCode());
			}else {
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()) {
					sb.append(sc.nextLine());
				}
				sc.close();
				System.out.println(sb);
			}
			StringBuilder Jenkins = new StringBuilder();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
