package spring;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import org.springframework.stereotype.Service;
@Service
public class Canciones {
	
	public void generararchivo() {
		try {
		File artistas2020 = new File("C:\\Carpeta Trabajo Inicial\\AA16\\Artistas 2020.txt");
		File artistas2021 = new File("C:\\Carpeta Trabajo Inicial\\AA16\\Artistas 2021.txt");
		File canciones2020 = new File("C:\\Carpeta Trabajo Inicial\\AA16\\Canciones 2020.txt");
		File canciones2021 = new File("C:\\Carpeta Trabajo Inicial\\AA16\\Canciones 2020.txt");
		File AA16 = new File("C:\\Carpeta Trabajo Inicial\\AA16\\AA16.txt");
		
		if(AA16.exists()) {
			AA16.delete();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(AA16,true));
		Scanner scartistas20 = new Scanner(artistas2020);
		Scanner scartistas21 = new Scanner(artistas2021);
		Scanner sccanciones20 = new Scanner(canciones2020);
		Scanner sccanciones21 = new Scanner(canciones2021);
		bw.newLine();
		bw.write("Top 10 Canciones de 2020 + Recaudacion de cada una");
		bw.newLine();
		bw.newLine();
		while(sccanciones20.hasNext()) {
			String Linea = sccanciones20.nextLine();
			
			String[] Cancion = Linea.split("-");
			String NombreCancion=Cancion[0];
			String Datos = Cancion[Cancion.length-1];
			String[] Autores = Cancion[Cancion.length-1].split("\t");
			String AutoresOficiales = Autores[0];
			int num = 0;
			if(!Autores[Autores.length-1].isEmpty()) {
				String numero = Autores[Autores.length-1].replace(".", "");
				num = Integer.parseInt(numero);
				Cancion cancion = new Cancion(NombreCancion,AutoresOficiales,num);
				cancion.CalcularRecaudacion();
				bw.write("Nombre Cancion: "+ cancion.getTitulo()+"| Autor / Autores: "+ cancion.getAutor_Autores()+
						" | Visualizaciones: "+cancion.getVisualizaciones()+" | Recaudacion "+cancion.getRecaudacion());
				bw.newLine();
				
			}
			
		}
		sccanciones20.close();
		bw.newLine();
		bw.write("Top 10 Canciones de 2021 + Recaudacion de cada una");
		bw.newLine();
		bw.newLine();
		while(sccanciones21.hasNext()) {
			String Linea = sccanciones21.nextLine();
			
			String[] Cancion = Linea.split("-");
			String NombreCancion=Cancion[0];
			String Datos = Cancion[Cancion.length-1];
			String[] Autores = Cancion[Cancion.length-1].split("\t");
			String AutoresOficiales = Autores[0];
			int num = 0;
			if(!Autores[Autores.length-1].isEmpty()) {
				String numero = Autores[Autores.length-1].replace(".", "");
				num = Integer.parseInt(numero);
				Cancion cancion = new Cancion(NombreCancion,AutoresOficiales,num);
				cancion.CalcularRecaudacion();
				bw.write("Nombre Cancion: "+ cancion.getTitulo()+"| Autor / Autores: "+ cancion.getAutor_Autores()+
						" | Visualizaciones: "+cancion.getVisualizaciones()+" | Recaudacion "+cancion.getRecaudacion());
				bw.newLine();
				
			}
			
			
		}
		
		sccanciones21.close();
		
		bw.newLine();
		bw.write("Top 10 artistas de 2020");
		bw.newLine();
		bw.newLine();
		while(scartistas20.hasNext()) {
			String Linea = scartistas20.nextLine();
			
			bw.write("Artista: "+Linea +"| Nombre: "+Linea);
			bw.newLine();
			
			
			
		}
		scartistas20.close();
		
		bw.newLine();
		bw.write("Top 10 artistas de 2021");
		bw.newLine();
		bw.newLine();
		while(scartistas21.hasNext()) {
			String Linea = scartistas21.nextLine();
			
			bw.write("Artista: "+Linea +"| Nombre: "+Linea);
			bw.newLine();
			
			
			
		}
		scartistas21.close();
		
		
		bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
