import java.util.*;
import java.util.concurrent.*;
/**
* Clase Consumidor
@Author María Fernanda Hernández Enriquez
*	A01329383
*/
public class Consumidor extends Thread{
/*
*	Declaración  de variables globales
*/
	Bufer bufer;
	Semaphore exclMutua;
	Semaphore lleno;
	Semaphore vacio;
	int num;
/*
*	Constructor con parámetros
*/
	public Consumidor(Bufer bufer, Semaphore exclMutua, Semaphore lleno, Semaphore vacio, int num){
		this.bufer = bufer;
		this.exclMutua = exclMutua;
		this.lleno = lleno;
		this.vacio = vacio;
		this.num = num;
	}
/*
*	Métodos run 
*/
	public void run(){
		int cont = 0;
		int numTemp;
		while(cont <= 15){
			/*
			Pregunta por el permiso de que si puede correr el programa, 
			dependiendo de que otro programa no esté corriendo al mismo 
			tiempo. 
			*/
            vacio.acquireUninterruptibly();
            exclMutua.acquireUninterruptibly();
            /*
            Critical section
            */
            numTemp = bufer.removeBufer();
            System.out.println(numTemp);
            /*
            Permita que otros procesos continues liberando exclMutua. 
            Mientras que la variable full permite que Productor siga 
            produciendo cosas.
			*/        
            lleno.release();
            exclMutua.release();
            /*
            Contador para controlar el ciclo
            */
            cont ++;
		}
	}
}