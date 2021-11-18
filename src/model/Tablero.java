package model;

public class Tablero {

	public Node first;
	public Node last;
	
	private int n;
	private int m; 
	private char charGlobal= 'A';
	private int intGlobal= 1;
	
	public Tablero() {
		first= new Node(0,0);
	}
	
	
	public void crearTablero(int n, int m) {
		this.n=n;
		this.m=m;
		
		crearFilasM(0,0,first);
		last= derecha((numNodos()-1),first);
		setValues(first,0);
	}
	
	public void crearFilasM(int i, int j, Node first) {
		crearColumnaN(i, j+1, first, first.getDown());
		
		if(i+1 < n) {
			Node nextRow = new Node (i+1, j);
			first.setUp(nextRow);
			nextRow.setDown(first);
			crearFilasM(i+1, j, nextRow);
		}
	}
	
	public void crearColumnaN(int i, int j, Node prev, Node down) {
		if(j<m) {
			Node newNode = new Node(i,j);
			prev.setNext(newNode);
			newNode.setPrev(prev);
			
			if(down != null) {
				down= down.getNext();
				down.setUp(newNode);
				newNode.setDown(down);
			}
			crearColumnaN(i,j+1,newNode, down);
		}
	}
	
	public void setValues(Node first, int n) {
		if(n<= numNodos()) {
			Node current = derecha(n, first);
			if(current != null) {
				n++;
				current.setValue(n);
				setValues(first, n);
			}
		}
	}
	
	public Node last(Node last, int i) {
		if(last.getNext()!=null) {
			return last;
		}else {
			if(i>1) {
				return last(last.getPrev(), i-1);
			}else {
				return last;
			}
		}
	}
	
	public Node derecha( int i, Node node) {
		if(i>0) {
			if(node.getNext()!=null) {
				return derecha(i-1, node.getNext());
			}else {
				if(node.getUp()!=null) {
					return izquierda(i-1, node.getUp());
				}else {
					return null;
				}
			}
		} else {
			return node;
		}
	}
	
	public Node izquierda(int i, Node node) {
		if(i>0) {
			if(node.getPrev()!=null) {
				return izquierda(i-1, node.getPrev());
			}else {
				if(node.getUp()!= null) {
					return derecha(i-1, node.getUp());
				}else {
					return null;
				}
			}
		}else {
			return node;
		}
	}
	
	public void agregarJugadores(String jugadoresA[], int i) {
		if(i<jugadoresA.length) {
			Jugador jugador= new Jugador((jugadoresA[i].charAt(0)));
			first.addPlayer(jugador);
			agregarJugadores(jugadoresA, i+1);
		}
	}
	
	public Node buscarJugadores(int n, int m, Node node) {
		if(node.iHaveYourPlayer(n)==true) {
			return node;
		}else {
			m= (m+1);
			Node current= derecha(m,first);
			if(current!=null) {
				return buscarJugadores(n,m,current);
			}else {
				return null;
			}
		}
	}
	
	public void crearEscalerasYSerpientes(int serpientes, int escaleras) {
		if((2*serpientes + 2*escaleras)<= numNodos()) {
			crearSerpientes(serpientes);
			crearEscaleras(escaleras);
		}
		
	}
	
	public void crearSerpientes(int nSerpientes) {
		if(nSerpientes>0) {
			Dado dado= new Dado(0, numNodos()-1);
			int i= dado.resultadoDado();
			Node cabeza= buscarNodo(i);
			
			i= dado.resultadoDado();
			Node cola= buscarNodo(i);
			if(verificarSerpiente(cabeza,cola)==true) {
				cabeza.setSerpientes(new Linked(charGlobal,cola,cabeza));
				cola.setSerpientes(new Linked(charGlobal,cola,cabeza));
				charGlobal= (char) (charGlobal+1);
				crearSerpientes(nSerpientes-1);
			}else {
				crearSerpientes(nSerpientes);
			}
			
		}
	}
	
	public boolean verificarSerpiente(Node cabeza, Node cola) {
		if(cabeza!=cola) {
			if(cabeza!=cola) {
				if(cabeza.getSerpientes()==null ) {
					if(cabeza.getEscaleras()==null) {
						if(cola.getSerpientes()==null) {
							if(cola.getEscaleras()==null) {
								if(cabeza.getValue()> cola.getValue()) {
									return true;	
								}else {
									return false;
								}
								
							}else {
								return false;
							}
						}else {
							return false;
						}
					}else {
						return false;
					}
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	public Node buscarNodo(int i) {
		return derecha(i, first);
	}
	
	
	
	public void crearEscaleras(int nEscaleras) {
		if(nEscaleras>0) {
			Dado dado= new Dado(1, numNodos()-1);
			int i= dado.resultadoDado();
			Node inicio= buscarNodo(i);
			i= dado.resultadoDado();
			Node fin= buscarNodo(i);
			if(verificarEscaleras(inicio,fin)==true) {
				inicio.setEscaleras(new Linked(intGlobal, inicio,fin));
				fin.setEscaleras(new Linked(intGlobal, inicio, fin));
				intGlobal++;
				crearEscaleras(nEscaleras-1);
				
			}else {
				crearEscaleras(nEscaleras);
			}
		}
	}
	
	public boolean verificarEscaleras(Node inicio, Node fin) {
		if(inicio != fin) {
			if(inicio != last) {
				if(inicio.getSerpientes()==null) {
					if(inicio.getEscaleras()==null) {
						if(fin.getSerpientes()==null) {
							if(fin.getEscaleras()==null) {
								if(inicio.getValue()< fin.getValue()) {
									return true;
								}else {
									return false;
								}
							}else {
								return false;
							}
						}else {
							return false;
						}
					}else {
						return false;
					}
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public int numNodos() {
		return n*m;
	}
	
	public void setNumbersPlayers() {
		first.setNumberPlayers();
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}
	
	public void setNumberPlayers() {
		first.setNumberPlayers();
	}
	
	
	public Node buscarJugador(int i) {
		return buscarJugadores(i, 0, first);
	}
	
	public int getNumbersPlayers() {
		return first.getTotalJ();
	}
	
	
	public String toStringRow1(Node firstRow) {
		String out = "";

		if(firstRow != null) {
			out += toStringCol1(firstRow) + "\n";
			out += toStringRow1(firstRow.getDown());
		}

		return out;
	}

	public String toStringCol1(Node current) {
		String out = "";

		if(current != null) {
			out += current.tableroSimple();
			out += toStringCol1(current.getNext());
		}

		return out;
	}

	public String toStringRow2(Node firstRow) {
		String out = "";

		if(firstRow != null) {
			out += toStringCol2(firstRow) + "\n";
			out += toStringRow2(firstRow.getDown());
		}

		return out;
	}

	public String toStringCol2(Node current) {
		String out = "";

		if(current != null) {
			out += current.tableroCompleto();
			out += toStringCol2(current.getNext());
		}

		return out;
	}
		
	
	public String completeBoard() {
		String out = "";
		Node n = last(last, m);
		out += toStringRow2(n);
		

		return out;
	}
	
	public String simpleBoard() {
		String out = "";
		Node n = last(last, m);
		out += toStringRow1(n);

		return out;
	}
	
	
	
}
