/** This file contains a class that contains a main method only. This class is
 * to show how the Producers/Consumers problem works */
import java.util.*;
import java.util.concurrent.*; // Import the adecuate packages for the program.
/**
Problema3
*	Implementar una clase Productor, una clase Consumidor y una clase Bufer, 
*	que es el recurso compartido por los productores y consumidores. Las dos primeras
*	deben extender a Thread y deben tener, como parámetros para su constructor, el
*	Bufer, los semáforos y un entero como identificador.
	@Author María Fernanda Hernández Enriquez
*	A01329383
Instrucciones para compilar
*	Compilar con la instrucción "javac PruebaProdCons.java"
*	Inicializar el programa con la instruccion "java PruebaProdCons"
*/
public class PruebaProdCons {

    public static void main(String args[]) {

	    Semaphore exclMutua = new Semaphore(1, true);
		Semaphore lleno = new Semaphore(5, true);
		Semaphore vacio = new Semaphore(5, true);

		Bufer b = new Bufer(5);
		Productor Prod1 = new Productor(b, exclMutua, lleno, vacio, 1);
		Productor Prod2 = new Productor(b, exclMutua, lleno, vacio, 2);

		Consumidor Cons1 = new Consumidor(b, exclMutua, lleno, vacio, 1);
		Consumidor Cons2 = new Consumidor(b, exclMutua, lleno, vacio, 2);

		vacio.drainPermits(); // We take away all permits to semaphore vacio,
				      // so that consumers may not enter the critical
				      // section when the buffer is empty.

		Prod1.start();
		Cons1.start();
		Prod2.start();
		Cons2.start();
    }
}