import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		try {
			File documento = new File("C:\\Carpeta Trabajo Inicial\\AA13\\10pelis.txt");
			File documento2 = new File("C:\\Carpeta Trabajo Inicial\\AA13\\Peliculas_11_20.txt");
			Scanner sc2 = new Scanner(documento2);
			Scanner sc1 = new Scanner(documento);
			int contador = 1;
			String texto;
			BufferedWriter bw = new BufferedWriter(new FileWriter("Top20peliculas.txt",true));
			
			bw.write("Titulo			Recaudacion");
			bw.newLine();
			while(sc1.hasNext()) {
				texto = sc1.nextLine();
				System.out.println(texto);
				bw.write(texto);
				bw.newLine();
			}
			while(sc2.hasNext()) {
				if(contador==1) {
					sc2.nextLine();
					contador++;
				}else {
					texto=sc2.nextLine();
					System.out.println(texto);
					bw.write(texto);
					bw.newLine();
				}
				
			}
			sc1.close();
			sc2.close();
			bw.close();
			
			// AQUI TENEMOS EN CUENTA QUE COMO LOS FICHEROS ESTAN ORDENADOS DE MAYOR A MENOR NO HACE FALTA ORGANIZAR NADA (EN ESTE CONTEXTO)
			StringBuilder Jenkins = new StringBuilder();
			Jenkins.append("import java.time.LocalDate\r\n");
			Jenkins.append("pipeline{\r\n");
			Jenkins.append("agent any \r\n");
			Jenkins.append("stages{ \r\n");
			Jenkins.append("stage('Main'){ \r\n");
			Jenkins.append("steps{ \r\n");
			Jenkins.append("script{ \r\n");
			Jenkins.append("def fecha = LocalDate.now() \r\n");
			Jenkins.append("def texto = '\"Hola Mundo! EL día de hoy es elDia ' + fecha.getDayOfWeek() + '.' \r\n");
			Jenkins.append("def texto2 = ' Este curso me hizo programar mas de lo que me hubiese gustado\" ' \r\n");
			Jenkins.append("println texto \r\n");
			Jenkins.append("println texto2 \r\n");
			Jenkins.append("} \r\n");
			Jenkins.append("} \r\n");
			Jenkins.append("} \r\n");
			Jenkins.append("} \r\n");
			Jenkins.append("} \r\n");
			
			System.out.println(Jenkins.toString());
			BufferedWriter bw2 = new BufferedWriter(new FileWriter("JenkinsfileAA13.txt"));
			bw2.write(Jenkins.toString());
			bw2.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
