package model;

public class Juego {
	
	private Tablero tablero;
	private Dado dado;
	
	private int turnos=1;
	private int totalJugadores=0;
	
	private Ganador ganador;
	public Juego() {
		dado= new Dado(1,6);
	}
	
	public void iniciarJuego(int n, int m, int serpientes, int escaleras, String jugadoresA[]) {
		tablero=new Tablero();
		tablero.crearTablero(n, m);
		tablero.crearEscalerasYSerpientes(serpientes, escaleras);
		tablero.agregarJugadores(jugadoresA, 0);
		tablero.setNumberPlayers();
		totalJugadores= tablero.getNumbersPlayers();
		
		
	}
	
	public String play() {
		if(turnos<=totalJugadores) {
			String t= esTurno(turnos);
			turnos++;
			return t;
		}else {
			turnos=1;
			return play();
		}
	}
	
	public String esTurno(int i) {
		String out="";
		
		Node nodeB= tablero.buscarJugador(i);
		
		Jugador jugador = nodeB.moverJugador(i);
		
		int dadoR= dado.resultadoDado();
		out+= "El jugador "+ jugador.getSymbol() + " ha sacado "+ dadoR;
		
		Node mover= tablero.buscarNodo(dadoR+ nodeB.getValue()-1);
		
		if(mover != null) {
			if(mover.getSerpientes() != null || mover.getEscaleras() != null) {
				if(mover.getSerpientes() != null) {
					if(mover.getSerpientes().getStart() == mover) {
						mover.addPlayer(jugador);
					} else {
						Node current = mover.getSerpientes().getStart();
						current.addPlayer(jugador);
					}
				} else {
					if(mover.getEscaleras().getStart() == mover) {
						Node current = mover.getEscaleras().getEnd();
						current.addPlayer(jugador);
					} else {
						mover.addPlayer(jugador);
					}
				}
			} else {
				mover.addPlayer(jugador);
			}
			ganador(jugador);
		} else {
			nodeB.addPlayer(jugador);
		}
	
		return out;
		
	}

	
	public void ganador(Jugador jugador) {
		if(getlast().getJugadores()!=null) {
			ganador= new Ganador(jugador.getSymbol());
		}
	}
	
	
	public Node getlast() {
		return tablero.getLast();
	}
	
	public Node getFirst() {
		return tablero.getFirst();
	}

	public Ganador getGanador() {
		return ganador;
	}

	public void setGanador(Ganador ganador) {
		this.ganador = ganador;
	}
	
	public String printTableroSimple() {
		return tablero.simpleBoard();
	}
	
	public String printTableroCompleto() {
		return tablero.completeBoard();
	}
	
		
}
		
	
	
	
	


