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
	@Before("execution(* generartxt())") //* cualquier generarTxt Antes
	public void log()
	{
		System.out.println("Se va a generar el archivo de cada Pais");
	}
	
	@After("execution(* generartxt())") //Despues
	public void log1()
	{
		usuario Alejandro = new usuario("Alejandro",1);
		System.out.println("Se han generado los archivos. Ahora mostrare los datos del Usuario que los ha creado");
		System.out.println("Nombre Usuario: "+Alejandro.getNombre()+" ID Usuario: "+Alejandro.getID());
	}
	
	
	
}
/*
ASPECTOS: El concepto de aspecto es el ELEMENTO FUNDAMENTAL DEL PARADIGMA. SE EMPLEA PARA DEFINIR
UNA FUNCIONALIDAD TRANSVERSAL!!!!! AL SOFTWARE. 
PUNTO DE CORTE
CONSEJO O ADVICE 
*/