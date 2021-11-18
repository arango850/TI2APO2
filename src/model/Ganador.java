package model;

public class Ganador extends Jugador {
	
	public Ganador(char symbol) {
		super(symbol);
		// TODO Auto-generated constructor stub
	}
	private String name;
	private double puntaje;
	private int value;
	
	
	
	
	
	public Ganador(char symbol, String name, double puntaje, int value) {
		super(symbol);
		this.name = name;
		this.puntaje = puntaje;
		this.value = value;
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	
	
	
	
	
	
	
	

}
