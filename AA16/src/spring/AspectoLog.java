package spring;

import java.io.File;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component


public class AspectoLog 
{
	@Before("execution(* generararchivo())") //* cualquier generarTxt Antes
	public void log()
	{
		System.out.println("Se esta por generar un archivo Nuevo");
	}
	
	@After("execution(* generararchivo())") //Despues
	public void log1()
	{
		System.out.println("Se ha generado el archivo.");
	}
	
	@Before("execution(* generararchivo())") //* cualquier generarTxt Antes
	public void log2()
	{
		System.out.println("Se Va a comprobar que los ficheros introducidos sean .txt");
		File artistas2020 = new File("C:\\Carpeta Trabajo Inicial\\AA16\\Artistas 2020.txt");
		File artistas2021 = new File("C:\\Carpeta Trabajo Inicial\\AA16\\Artistas 2021.txt");
		File canciones2020 = new File("C:\\Carpeta Trabajo Inicial\\AA16\\Canciones 2020.txt");
		File canciones2021 = new File("C:\\Carpeta Trabajo Inicial\\AA16\\Canciones 2020.txt");
		String art20 = artistas2020.getName();
		String art21 = artistas2021.getName();
		String can20 = canciones2020.getName();
		String can21 =canciones2021.getName();
		if(!art20.contains(".txt")) {
			System.out.println("Los artistas del 2020 no estan en un fichero .txt");
		}
		if(!art21.contains(".txt")) {
			System.out.println("Los artistas del 20201 no estan en un fichero .txt");
		}
		if(!can20.contains(".txt")) {
			System.out.println("Las canciones del 2020 no estan en un fichero .txt");
		}
		if(!can21.contains(".txt")) {
			System.out.println("Las canciones del 2021 no estan en un fichero .txt");
		}
	}
}
/*
ASPECTOS: El concepto de aspecto es el ELEMENTO FUNDAMENTAL DEL PARADIGMA. SE EMPLEA PARA DEFINIR
UNA FUNCIONALIDAD TRANSVERSAL!!!!! AL SOFTWARE. 
PUNTO DE CORTE
CONSEJO O ADVICE 
*/