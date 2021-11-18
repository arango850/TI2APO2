package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.Juego;

public class Main {

	private static Scanner scanner;
	private Juego juego;
	
	public Main() {
		scanner = new Scanner(System.in);
		juego= new Juego();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main= new Main();
		main.menu();
		
	}

	public void menu() {
		// TODO Auto-generated method stub
		int option =0;
		System.out.println("Bienvenido a escaleras y serpientes\n"+
		" Selecciona una opcción\n"+
		"(1) Jugar\n"+
		"(0) Salir\n");
		option= scanner.nextInt();
		scanner.nextLine();
		switch(option) {
			case 1:
					jugar();
				break;
			case 0: 
					System.exit(0);
				break;
				
				
		}
	}

	public void jugar() {
		// TODO Auto-generated method stub
		int option=0;
		System.out.println("Para empezar, digita las opcciones de juego\n"+
		"Selecciona una opcción\n"+
		"(1) Modo normal"+
		"(2) Mode APO");
		option= scanner.nextInt();
		scanner.nextLine();
		switch(option) {
			case 1:
					crearJuego();
			break;
			case 2:
					crearJuegoApo();
			break;
			
		}
	}

	public void crearJuegoApo() {
		// TODO Auto-generated method stub
		System.out.println("Digita como quieres jugar\n"+
		"Recuerda el orden: Alto Ancho Número de serpientes Número de Escaleras Caracteres de jugador");
		String resultados= scanner.nextLine();
		
		ArrayList<String> division = new ArrayList<String>(Arrays.asList(resultados.split(" ")));
		
		String altoS= division.get(0); 
		int alto= Integer.parseInt(altoS);
	
		
		String anchoS= division.get(1);
		int ancho= Integer.parseInt(anchoS);

		
		String serpientesS= division.get(2);
		int serpientes = Integer.parseInt(serpientesS);
		
		
		String escalerasS= division.get(3);
		int escaleras= Integer.parseInt(division.get(3));
		
		
		String jugadores= division.get(4);
		String[] jugadoresA= jugadores.split("");
		
		juego.iniciarJuego(alto, ancho, serpientes, escaleras, jugadoresA);
		System.out.println(juego.printTableroCompleto());
		System.out.println(juego.printTableroSimple());
		
		iniciarJuego();
		
	}

	public void crearJuego() {
		// TODO Auto-generated method stub
		System.out.println("Digita el alto");
		int alto= scanner.nextInt();
		System.out.println("Digita el ancho");
		int ancho= scanner.nextInt();
		System.out.println("Digita el número de serpientes");
		int serpientes= scanner.nextInt();
		System.out.println("Digita el número de escaleras");
		int escaleras= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Digita los caracteres de los jugadores");
		String jugadores= scanner.nextLine();
		String[] jugadoresA= jugadores.split("");
		juego.iniciarJuego(alto, ancho, serpientes, escaleras, jugadoresA);
		juego.printTableroCompleto();
		juego.printTableroSimple();
		
		
		iniciarJuego();
	}

	public void iniciarJuego() {
		// TODO Auto-generated method stub
		if(juego.getGanador()==null) {
			
		
			System.out.print("Presione enter");
			String option = scanner.nextLine();
			scanner.nextLine();
			if(option.equals("menu")) {
				menu();
			}else {
				jugando(option);
				System.out.println(juego.printTableroCompleto());
				iniciarJuego();
			}
			
			
		}else {
			System.out.println("Se acabó el juego");
			System.out.println("El ganador es " + juego.getGanador().getSymbol());
		}
	}
	
	public void jugando(String opccion) {
		if(opccion.equals("")) {
			System.out.println(juego.play());
		} else if((juego.getGanador() == null)){
		
				System.out.println(juego.play());
				System.out.println(juego.printTableroCompleto());
				
				jugando("a");
			
		} else if(opccion.equals("num")) {
			System.out.println(juego.printTableroSimple());
			scanner.nextLine();
		
	}

}}
