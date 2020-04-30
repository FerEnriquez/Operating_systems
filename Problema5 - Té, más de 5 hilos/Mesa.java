/**
María Fernanada Hernández Enriquez 
A01329383
*	Clase Mesa
*	Define la clase de los espacios a crear para que los clientes 
*	las puedan ocupar.
*/
public class Mesa{
	/*
	Declaración de varibales
	*/
	private int mesaDis; //Número de mesas disponibles
	private boolean cerrado; //Status del establecimiento, true: cerrado, false: abierto
	private int mesaTotal; //Numero de mesas totales

	/*
		Constructor
	*/
	public Mesa(int mesaTotal){
		this.mesaTotal = mesaTotal;
		this.mesaDis = mesaTotal;
		this.cerrado = false;
	}
	/*
		Método status
		Define si el establecimiento esta cerrado o abierto.
	*/
	public boolean status(){
		return cerrado;
	}
	/*
		Método llegar
		Define cuando un cliente llega, con la condición de si puede 
		usar una mesa disponible, o no.
	*/
	public void llegar (int cliente){
		mesaDis --;
		System.out.println("Cliente No."+cliente+" esta tomando te en la mesa No."+mesaDis);
		if(mesaDis < 1 && !cerrado){
			System.out.println("Ya no hay lugares. Cerrado.");
			cerrado = true;
		}
	}
	/*
		Método tiempo
		Define mediante un método de número aleatorios la cantidad de tiempo
		que ocupa un cliente en beber su té-
	*/
	public int tiempo(){
		return (int)(Math.random()+100)+100;
	}
	/*
		Método irse
		Define cuando un cliente de una mesa, y ésta pasa a un estado disponible
	*/
	public void irse(int cliente){
		mesaDis++;
		System.out.println("Cliente No."+cliente+" dejo la mesa. Disponibles: "+mesaDis);
		if(mesaDis > (mesaTotal-1) && cerrado){
			System.out.println("Hay lugares. Abierto.");
			cerrado = false;
		}
	}

}
