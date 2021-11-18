package model;

public class Jugador {

	private char symbol;
	private int numPlayer;
	private int movements;
	
	private Jugador nextJugador;

	public String toString() {
		return ""+ symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getNumPlayer() {
		return numPlayer;
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

	public int getMovements() {
		return movements;
	}

	public void setMovements(int movements) {
		this.movements = movements;
	}

	public Jugador getNextJugador() {
		return nextJugador;
	}

	public void setNextJugador(Jugador nextJugador) {
		this.nextJugador = nextJugador;
	}
	
	public Jugador( char symbol) {
		this.numPlayer=numPlayer;
		this.symbol=symbol;
		this.movements=movements;
	}
	
	
	
	
	
	
	
}
