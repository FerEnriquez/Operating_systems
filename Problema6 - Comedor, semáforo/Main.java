import java.util.*;
import java.util.concurrent.*;
/**
Problema 2
María Fernanda Hernandez Enriquez 
A01329383
Sistemas operativos

*	Existe un comedor en alguna parte del mundo que tiene un cocinero
*	que solo cocina un cierto numero k de raciones a la vez. Cuando termina de
*	cocinar, se va a descansar. Los comensales, que son mas de uno y estan en
*	el comedor, esperan a que las raciones esten listas y se sirven una racion
*	de comida cada uno, con la condicion de que no pueden servirse la comida al
*	mismo tiempo. Cuando un comensal quiere servirse y ya no hay raciones de
*	comida, entonces llama al cocinero que prepara otras k raciones de comida
*	y vuelve al descanso, no sin antes llamar al comensal que quedo esperando.
*	Los comensales no tienen acceso a la comida antes de que el cocinero
*	termine de preparar las k raciones. Disene una solucion a este problema
*	usando semaforos e implementela en Java.
*	Nota: Las raciones de comida pueden ser numeros enteros que tiene valores
*  	entre 1 y 100 (que pueden ser aleatorios o no) en un arreglo de k valores, y
*   	es lo que produce el cocinero. Cada comensal consume una de estas raciones
*  	(numeros) y lo imprime en pantalla. No puede haber dos comensales que
*  	consuman la misma racion, esto es, no pueden leer la misma celda del arreglo.
*/
public class Main{
	public static void main(String[] args){
	/*
	Declarar variables globales
	*/
		int platosTotal = 4;
		int comenTotal = 20;
		int comida = 20;
	/*
	Creación de objetos
	*/
		Semaphore sem = new Semaphore(1,true);
		Plato plato = new Plato(comida);
		Chef chef = new Chef(plato, platosTotal);
		Comensal[] comensales = new Comensal[comenTotal];
		
		for(int i = 0; i < comensales.length; i++){
			comensales[i] = new Comensal(sem, plato, i, chef);
		}
		chef.start();
		for(int i = 0; i < comensales.length; i++){
			comensales[i].start();
		}
		sem.drainPermits();
	}
}

