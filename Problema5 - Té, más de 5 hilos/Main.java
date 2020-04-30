import java.util.*;
import java.util.concurrent.*;
/**
Problema 1
María Fernanda Hernández Enriquez 
A01329383
Sistemas operativos

*	En algun lugar de Inglaterra hay un lugar que sirve te. El lugar
*	es pequeno y solo tiene cinco espacios disponibles. Las reglas para entrar
*	a tomar el te son las siguientes: Si llega una persona a tomar te y hay un
*	espacio disponible, lo puede tomar de inmediato. Si algun llegar una
*	persona a tomar te los cinco espacios estan ocupados, esta debe esperar
*	hasta que los cinco hayan salido.
*	Implemente un programa en Java que se comporte tal como esta descrito en el
*	texto. El programa deberia tener mas de 5 hilos para que pueda verse como
*	funciona la solucion propuesta. 
*/
public class Main{
	public static void main(String[] args0){
	/*
		Declarar variables globales
	*/
		int mesaTotal = 5;
		int clienteTotal = 15;
		int turnos = 500;
	/*
		Declarar semaforo
	*/
		Semaphore sem = new Semaphore(1, true);
	/*
		Creación del objeto mesa para crear las mesas dentro del establecimiemto
		y creación de un arreglo de clientes a entrar
	*/
		Mesa mesa = new Mesa(mesaTotal);
		Cliente[] clientes = new Cliente[clienteTotal];
		
		for (int i = 0; i < clientes.length; i++){
			clientes[i] = new Cliente(sem, mesa, i, turnos);
		}

		for(int i = 0; i < clientes.length; i++){
			clientes[i].start();
		}
		sem.drainPermits();		
	} 
}