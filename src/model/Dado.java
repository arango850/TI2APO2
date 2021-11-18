package model;

public class Dado {

	private int min;
	private int max;
	
	public Dado(int min,int max) {
		this.min=min;
		this.max=max;
	}
	
	public int resultadoDado() {
		int resultado=0;
		resultado= (int) Math.floor(Math.random()*(max-min+1)+min);
		
		return resultado;
		
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
	
}
