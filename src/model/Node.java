package model;

public class Node {

	private int value;
	
	private int n;
	private int m;
	
	
	public Linked serpientes;
	public Linked escaleras;
	
	private Node next;
	private Node prev;
	private Node up;
	private Node down;
	
	public Jugador jugadores;
	
	private int totalJ=0;
	

	
	
	public Node(int n, int m) {
		this.n=n;
		this.m=m;
		
	}
	
	public void addPlayer(Jugador jugadoress) {
		if(jugadores==null) {
			jugadores=jugadoress;
		}else {
			addPlayer(jugadores, jugadoress);
		}
	}
	
	public void addPlayer(Jugador current, Jugador jugadoress ) {
		if(current.getNextJugador()==null) {
			current.setNextJugador(jugadoress);
		}else {
			addPlayer(current.getNextJugador(),jugadoress);
		}
	}
	
	public Jugador moverJugador(int n) {
		if(jugadores.getNumPlayer()==n) {
			Jugador jugador= jugadores;
			jugadores= jugadores.getNextJugador();
			
			jugador.setNextJugador(null);
			
			return jugador;
		} else {
			return moverJugador(n,jugadores);
		}
	}
	
	public Jugador moverJugador(int n, Jugador jugadores) {
		if(jugadores.getNextJugador() !=null) {
			if(jugadores.getNextJugador().getNumPlayer()==n) {
				Jugador jugador= jugadores.getNextJugador();
				jugador.setNextJugador(jugador.getNextJugador().getNextJugador());
				
				return jugador;
			} else {
				return moverJugador(n,jugadores.getNextJugador());
			}
		}else {
			if(jugadores.getNumPlayer()==n) {
				Jugador jugador =jugadores;
				jugador= null;
				return jugador;
			}else {
				return null;
			}
		}
	}
	
	public void setNumberPlayers() {
		setNumbersPlayer(jugadores, 1);
	}
	
	public int getTotalJ() {
		getTotalJS(jugadores);
		return totalJ;
	}
	
	public void getTotalJS(Jugador jugador) {
		if(jugador==null) {
			totalJ+=0;
		}else {
			totalJ++;
			getTotalJS(jugador.getNextJugador());
		}
	}
	
	public void setNumbersPlayer(Jugador jugador, int i) {
		if(jugador!=null) {
			jugador.setNumPlayer(i);
			setNumbersPlayer(jugador.getNextJugador(),i+1);
		}
	}
	
	public boolean iHaveYourPlayer(int p) {
		return iHaveYourPlayer(p, jugadores);
	}

	public boolean iHaveYourPlayer(int p, Jugador jugadores) {
		// TODO Auto-generated method stub
		if(jugadores==null) {
			return false;
		}else {
			if(jugadores.getNumPlayer()==p) {
				return true;
			}else {
				return iHaveYourPlayer(p,jugadores.getNextJugador());
			}
		}
		
	}

	public String toStringPlayers(Jugador jugador) {
		String out="";
		if(jugador!=null) {
			out += jugador.toString();
			out += toStringPlayers(jugador.getNextJugador());
		}
		
		return out;
	}
	
	public String toStringEscalerasySerpientes(Linked linked) {
		String out ="";
		if(linked!= null) {
			out += linked.toString();
		}
		return out;
	}
	
	public String tableroSimple() {
		String serpiente = toStringEscalerasySerpientes(serpientes);
		String escalera = toStringEscalerasySerpientes(escaleras);
		String out="";
		if(value >= 10) {
			out += value;
		}else {
			out += " " + value;
		}if(serpiente.equals("")) {
			out= " " + out;
		}else {
			out += serpiente;
		}if(escalera.equals("")) {
			out = " " + out;
		}else {
			out += escalera;
		}
		out+= " ";
		
		return "("+out+")";
	}
	
	public String tableroCompleto() {
		String serpiente = toStringEscalerasySerpientes(serpientes);
		String escalera = toStringEscalerasySerpientes(escaleras);
		String jugador = toStringPlayers(jugadores);
		String out="";
		
		if(serpiente.equals("")) {
			out= " " + out;
		}else {
			out += serpiente;
		}if(escalera.equals("")) {
			out = " " + out;
		}else {
			out += escalera;
		}if(jugador.equals("")) {
			out = " "+ out+ " ";
		}else {
			out += jugador + "";
		}
		
		
		return "("+out+")";
	}
	
	
	
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public Linked getSerpientes() {
		return serpientes;
	}

	public void setSerpientes(Linked serpientes) {
		this.serpientes = serpientes;
	}

	public Linked getEscaleras() {
		return escaleras;
	}

	public void setEscaleras(Linked escaleras) {
		this.escaleras = escaleras;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}

	public Jugador getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador jugadores) {
		this.jugadores = jugadores;
	}
	
	
	
	
	
	
}
