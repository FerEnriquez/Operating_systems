/**
María Fernanda Hernández Enriquez
A0132938
*	Clase Comensal
*	Define una persona que va consumir un platillo que ha sido 
*	preparado previamente por el chef.
*/
import java.util.concurrent.*;
public class Comensal extends Thread{
	/*
	Declaración de variables
	*/
	private Semaphore sem;
	private Plato plato;
	private int comensal;
	private Chef chef;

	/*
		Constructor
	*/
	public Comensal(Semaphore sem, Plato plato, int comensal, Chef chef){
		this.sem = sem;
		this.plato = plato;
		this.comensal = comensal;
		this.chef = chef;
	}
	/*
		Accesor
	*/
	public int getComensal(){
		return comensal;
	}
	/*
		Método run
	*/
	public void run(){
		while(true){
			sem.acquireUninterruptibly();
			if(plato.ver()){
				try{
					plato.setComensal(this);
					chef.interrupt();
					Thread.sleep(5000);
				}catch(InterruptedException ie){}
			}
			plato.comer(comensal);
			sem.release();
		}
	}
}