import java.util.*;
import java.util.concurrent.*; 
/**
Problema 1 
*	Crear dos hilos, uno de porductor y otro consumidor. En donde el hilo producto 
*	genere número aleatorios de uno a cien y ponerlos en una variable compartida. 
*	El hilo consumidor debe leer los valores generados por el hilo consumidor e 
*	imprimirlos. La ejecución debe terminar cuando salga el número 50. 
	@Autor María Fernanda Hernández Enriquez
*	A01329383
*/
/**
Instrucciones para compilar
*	Compilar con la instrucción "javac Problema1.java"
*	Inicializar el programa con la instruccion "java Problema1"
*/	

public class Problema1 extends Thread{
/**
*	Declaración de variables globales
*/
	public String nombre;
	public boolean proceso;
	public static int turno = 0;
	public static int numCompartido;
	public int act,sig;

	public static void main (String[] args){
		Problema1 productor = new Problema1 (false, 0, 1);
		Problema1 consumidor = new Problema1(true, 1, 0);

		productor.start();
		consumidor.start();
	}
/*
*	Constructor con parámetros
*/
	public Problema1(boolean proceso, int act, int sig){
		this.proceso = proceso;
		this.act = act;
		this.sig = sig;
	}
/*
*	Método run
*/
	public void run(){
		do{
			//BussyWaiting
			//Proceso del productor
			if(!proceso){

				while(turno != act){};
				turno = act;
				numCompartido = (int)(Math.random() * 100)+1;
				turno = sig;
			}
			//Proceso del consumidor
			else{
				while(turno != act){};
				turno = act;
				System.out.println("No." + numCompartido);
				numCompartido = 0;
				turno = sig;
			}
			if(numCompartido == 50){
				System.exit(0);
			}

		} while(numCompartido != 50);
	}
}