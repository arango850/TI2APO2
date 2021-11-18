package model;

public class Linked {

	private char nSerpientes;
	private int nEscaleras;
	
	private Node start;
	private Node end;
	
	
	
	
	public char getnSerpientes() {
		return nSerpientes;
	}

	public void setnSerpientes(char nSerpientes) {
		this.nSerpientes = nSerpientes;
	}

	public int getnEscaleras() {
		return nEscaleras;
	}

	public void setnEscaleras(int nEscaleras) {
		this.nEscaleras = nEscaleras;
	}

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	public Linked(char nSerpientes, Node start, Node end) {
		this.nSerpientes=nSerpientes;
		this.start=start;
		this.end=end;
		
	}
	
	public Linked(int nEscaleras, Node start, Node end) {
		this.nEscaleras=nEscaleras;
		this.start=start;
		this.end=end;
	}
	
	public String toString() {
		if(nEscaleras==0) {
			return "" + nSerpientes;
		}else {
			return ""+ nEscaleras;
		}
	}
}
