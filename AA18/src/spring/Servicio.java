package spring;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.stereotype.Service;


@Service //Funciones y metodos a implementar USANDO AOP
public class Servicio 
{
	
	public void generartxt()
	{
		
		Interfaz interfaz = () ->{
			File Datos = new File("C:\\Carpeta Trabajo Inicial\\AA18\\INFO_PAISES.txt");
			ArrayList<String> Lineas = new ArrayList<String>();
			try {
				Scanner sc = new Scanner(Datos);
				while(sc.hasNextLine()) {
					Lineas.add(sc.nextLine());
				}
				sc.close();
				Lineas.forEach((x)->System.out.println(x));
				int contador=1;
				String Capital,Clima,Pais,Continente;
				double Salario_Minimo;
				int Habitantes;
				Pais paisEscribir = new Pais("Ejemplo");
				Continente ContinenteEscribir = new Continente("EjemplO");
				Capital CapitalEscribir = new Capital("ejemplo");
				Habitantes HabitantesEscribir = new Habitantes(1);
				Clima ClimaEscribir = new Clima("ejemplo");
				for(int i=0;i<Lineas.size();i++) {
					String[] lineaaux = Lineas.get(i).split(":");
					if(contador>6) {
						contador=1;
					}
					switch(contador) {
					case 1:
						Pais = lineaaux[lineaaux.length-1];
						paisEscribir.setPais(Pais);
						System.out.println(Pais);
						break;
					case 2:
						Continente = lineaaux[lineaaux.length-1];
						ContinenteEscribir.setContinente(Continente);
						System.out.println(Continente);
						break;
						
					case 3:
						Capital = lineaaux[lineaaux.length-1];
						CapitalEscribir.setCapital(Capital);
						System.out.println(Capital);
						break;
						
					case 4:
						String HabitantesAux = lineaaux[lineaaux.length-1];
						HabitantesAux=HabitantesAux.replace(".","");
						HabitantesAux=HabitantesAux.strip();
						Habitantes = Integer.parseInt(HabitantesAux);
						HabitantesEscribir.setHabitantes(Habitantes);
						System.out.println(Habitantes);
						break;
						
					case 5:
						Clima = lineaaux[lineaaux.length-1];
						ClimaEscribir.setClima(Clima);
						System.out.println(Clima);
						break;
						
					case 6:
						String aux = lineaaux[lineaaux.length-1];
						if(aux.equalsIgnoreCase(" jaja")) {
							aux="1000";
						}else{
							String[] aux2= aux.split(" ");
							aux=aux2[aux2.length-1];
							aux=aux.replace(",", "");
						}
						Salario_Minimo = Double.parseDouble(aux);
						Salario_Minimo Salario_MinimoEscribir = new Salario_Minimo(Salario_Minimo);
						Nacion nacion = new Nacion(CapitalEscribir,ClimaEscribir,ContinenteEscribir,HabitantesEscribir,paisEscribir,Salario_MinimoEscribir);
						nacion.PIB();
						System.out.print(nacion.getCapital().getCapital()+" "+nacion.getClima().getClima()+" "+nacion.getContinente().getContinente()+" "+nacion.getHabitantes().getHabitantes()+" "+nacion.getPais().getPais()+" "+nacion.getSalario_minimo().getSalario_Minimo()+" ");
						System.out.print(String.format("%.12f",nacion.getPIB()));
						System.out.println();
						File Archivo = new File("C:\\Carpeta Trabajo Inicial\\AA18\\"+nacion.getPais().getPais()+".txt");
						if(Archivo.exists()) {
							Archivo.delete();
						}
						String PIB =String.format("%.12f",nacion.getPIB());
						PIB = String.format("%.2f",nacion.getPIB());
						BufferedWriter bw = new BufferedWriter(new FileWriter(nacion.getPais().getPais()+".txt",true));
						bw.write(nacion.getCapital().getCapital()+" "+nacion.getClima().getClima()+" "+nacion.getContinente().getContinente()+" "+nacion.getHabitantes().getHabitantes()+" "+nacion.getPais().getPais()+" "+nacion.getSalario_minimo().getSalario_Minimo()+" "+PIB);
						bw.newLine();
						bw.close();
						contador=0;
						break;
					}
					contador++;
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		};
		interfaz.Interfaze();
	}
	
}