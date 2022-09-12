package spring;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main 
{
	public static void main (String [] args)
	{
	Usuario Alejandro = new Usuario("Alejandro","Alejandro@gmail.com",1);
		try (
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
			Canciones servicio = ctx.getBean(Canciones.class);
			servicio.generararchivo();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
