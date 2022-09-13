import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Usuario Alejandro = new Usuario("Alejandro");
		Juego adivina = (jugador)->{
			Scanner teclado = new Scanner(System.in);
			int NumeroaAdivinar = (int)(Math.random()*1000000+1);
			int intentos = 1;
			int numerousuario;
			boolean acertado = false;
			System.out.println(jugador.getNombre()+" Vamos a jugar a adivinar un numero entre 1 y 1000000");
			while(intentos<6) {
				System.out.println("Si eres un tramposo te ayudo "+NumeroaAdivinar);
				
				
				System.out.println("Introduce el numero que crees que es");
				numerousuario=teclado.nextInt();
				
				if(numerousuario==NumeroaAdivinar) {
					System.out.println("Enhorabuena lo adivinaste");
					acertado=true;
					intentos=6;
				}else {
					System.out.println("Te quedan "+(5-intentos)+" intentos");
				}
				intentos++;
			}
			if(!acertado) {
				System.out.println("No ganaste que mal :(");
			}
			teclado.close();
			
			return 0;
		};
		
		adivina.jugar(Alejandro);
	}
	
}
