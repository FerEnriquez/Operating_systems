/**
María Fernanda Hernández Enriquez 
A01329383
*	Clase Chef
*	Define a una persona encargada de preparar cierta cantidad
*	de alimentos, mientras los comensales esperan.
*	No puede preparar alimentos mientras los comensales consumen.
*/
import java.util.concurrent.*;
public class Chef extends Thread{
	/*
	Declaración de variables
	*/
	private Plato plato;
	private int comida;
	/*
		Constructor
	*/
	public Chef(Plato plato, int comida){
		this.plato = plato;
		this.comida = comida;
	}
	/*
		Método run
	*/
	public void run(){
		int cont = 0;
		Comensal comensal;
		while(true){
			try{
				Thread.sleep(60000);
			}catch(InterruptedException ie){
				cont++;
				if(cont > comida){
					System.out.println("Comida total");
					System.exit(0);
				}
				plato.cocinar();
				comensal = plato.getComensal();
				comensal.interrupt();
			}
		}
	}
}