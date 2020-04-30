import java.util.*;
import java.util.concurrent.*; 
/**
Problema2	
*	Sincronizar, usando semáforos, tres hilos que debe entrar en orden sucesivo. 
*	Los vamos a llamar Pin, Pon y Papa, los cuales imprimen en la pantalla su
*	nombre en el orden que se muestra. Esto es, primero debe ejecutar Pin, 
*	después Pon y finalmente Papas de manera infinita o, al menos uno 10 ciclos.
	@Autor María Fernanda Hernández Enriquez
*	A01329383
Instrucciones para compilar
*	Compilar con la instrucción "javac Problema2.java"
*	Inicializar el programa con la instruccion "java Problema2"
*/	
public class Problema2 extends Thread{
/*
*	Declaración de variables gobales
*/
	String algo;
	Semaphore Sf;
	int cont = 0;

	public static void main(String args[]){
		Semaphore SemGlobal = new Semaphore(1, true);

		Problema2 pin = new Problema2("Pin", SemGlobal);
		Problema2 pon = new Problema2("Pon", SemGlobal);
		Problema2 papas = new Problema2("Papas", SemGlobal);

		pin.start();
		pon.start();
		papas.start();
	}
/*
*	Constructor con parámetros
*/
	public Problema2(String algo, Semaphore Sf){
		this.algo = algo;
		this.Sf = Sf;
	}
/*
*	Método run
*/
	public void run(){
		do{
			Sf.acquireUninterruptibly();	
			System.out.println(algo);
			Sf.release(1);
			cont++;

		}while(cont != 10);
	}
}