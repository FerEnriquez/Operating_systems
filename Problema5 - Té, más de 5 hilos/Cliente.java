/**
María Fernanda Hernández Enriquez
A01329383
*	Clase Cliente
*	Define un cliente a entrar dentro de un establecimientos
*/
import java.util.concurrent.*;
public class Cliente extends Thread{
	/*
	Declaración de variables
	*/
	private Semaphore sem;
	private Mesa mesa;
	private int cliente;
	private int turnos;

	/*
		Constructor
	*/
	public Cliente(Semaphore sem, Mesa mesa, int cliente, int turnos){
		this.sem = sem;
		this.mesa = mesa;
		this.cliente = cliente;
		this.turnos = turnos;
	}
	/*
		Método run
	*/
	public void run(){
		int cont = 0;
		int t;
		while(true){
			cont++;
			if(cont > turnos){
				System.exit(0);
			}
			sem.acquireUninterruptibly();
			if(!mesa.status()){
				mesa.llegar(cliente);
				t = mesa.tiempo();
				sem.release();
				sem.acquireUninterruptibly();
				
				try{
					Thread.sleep(t);
				}catch(InterruptedException ie){}
				
				mesa.irse(cliente);
				sem.release();
			}
			else{
				sem.release();
			}
		}
	}
}