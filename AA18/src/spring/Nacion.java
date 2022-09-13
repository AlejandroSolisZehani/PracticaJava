package spring;

public class Nacion implements CalcularPIB{
	private Capital capital;
	private Clima clima;
	private Continente continente;
	private Habitantes habitantes;
	private Pais pais;
	private Salario_Minimo salario_minimo;
	private double PIB;
	
	public double getPIB() {
		return PIB;
	}
	public void setPIB(double pIB) {
		PIB = pIB;
	}
	public Capital getCapital() {
		return capital;
	}
	public void setCapital(Capital capital) {
		this.capital = capital;
	}
	public Clima getClima() {
		return clima;
	}
	public void setClima(Clima clima) {
		this.clima = clima;
	}
	public Continente getContinente() {
		return continente;
	}
	public void setContinente(Continente continente) {
		this.continente = continente;
	}
	public Habitantes getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(Habitantes habitantes) {
		this.habitantes = habitantes;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Salario_Minimo getSalario_minimo() {
		return salario_minimo;
	}
	public void setSalario_minimo(Salario_Minimo salario_minimo) {
		this.salario_minimo = salario_minimo;
	}
	public Nacion(Capital capital, Clima clima, Continente continente, Habitantes habitantes, Pais pais,
			Salario_Minimo salario_minimo) {
		super();
		this.capital = capital;
		this.clima = clima;
		this.continente = continente;
		this.habitantes = habitantes;
		this.pais = pais;
		this.salario_minimo = salario_minimo;
	}
	
	@Override
	public String toString() {
		return "Nacion [capital=" + capital + ", clima=" + clima + ", continente=" + continente + ", habitantes="
				+ habitantes + ", pais=" + pais + ", salario_minimo=" + salario_minimo + ", PIB=" + PIB + "]";
	}
	@Override
	public void PIB() {
		this.PIB=((double)this.habitantes.getHabitantes()*this.salario_minimo.getSalario_Minimo());
	}
	
}
