package AA9;

public class Principal {
	public static void main(String[] args) {
		Videojuegos DarkSouls3 = new Videojuegos("Dark Souls 3",10000,5);
		Videojuegos TheLastOfUs = new Videojuegos("The Last Of Us",50000,10);
		Videojuegos FIFA2022 = new Videojuegos("FIFA 2022",60000,15);
		Videojuegos MarioBross = new Videojuegos("Dark Souls 3",45000,1);
		Videojuegos DOOM2 = new Videojuegos("DOOM 2",100000,1);
		Videojuegos HORIZON = new Videojuegos("HORIZON",50000,5);
		
		System.out.println(DarkSouls3.toString());
		System.out.println(TheLastOfUs.toString());
		System.out.println(FIFA2022.toString());
		System.out.println(MarioBross.toString());
		System.out.println(DOOM2.toString());
		System.out.println(HORIZON.toString());
		
		DarkSouls3.calculartotal();
		TheLastOfUs.calculartotal();
		FIFA2022.calculartotal();
		MarioBross.calculartotal();
		DOOM2.calculartotal();
		HORIZON.calculartotal();
	}
}
