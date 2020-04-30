import java.util.*;
import java.util.concurrent.*;
/**
* 	Clase Productor
	@Autor María Fernanda Hernández Enriquez
*	A01329383
*/

public class Productor extends Thread{
/**
*	Se declaran las variables
*/
	public Bufer bufer;
	public Semaphore exclMutua;
	public Semaphore lleno;
	public Semaphore vacio;
	public int num;
	int cont = 0;
/**
*	Constructor con parámetros 
*/
	public Productor(Bufer bufer, Semaphore exclMutua, Semaphore lleno, 
		Semaphore vacio, int num){
		this.bufer = bufer;
		this.exclMutua = exclMutua;
		this.lleno = lleno;
		this.vacio = vacio;
		this.num = num;
	}
/**
*	Método run
*/
	public void run(){
		int numTem;
		while (cont <= 7){
			/*
			Pregunta por un permiso para run, asegurandose que no haya
			otro proceso corriendo en el mismo tiempo.
			*/
			lleno.acquireUninterruptibly();
            exclMutua.acquireUninterruptibly();
			/*
			Critical section
			*/
			num = (int)(Math.random()*100)+1;
			bufer.addBufer(num);

			vacio.release();
			exclMutua.release();

			cont--;
		}
	}
}