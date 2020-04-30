/**
María Fernanda Hernández Enriquez
A01329383
Final.
Sistemas Operativos
Alberto Oliart Ros

---Problema 1---
Desarrollar un simulador de asignación de memoria usando
particionamiento dinámico. La memoria máxima es de 256kb
con corte de 2kb, cada proceso permitiéndose tener 3 o 10 
rebanas.
Se requieren tres módulos para est+a simulación
-Módulo de asignación de memoria. 
Responsable de la asignación y la deasignación de la memoria
a través de una de las cuatro políticas de asignación: mejor
ajuste, peor ajuste, primer ajuste, siguiente ajuste.
-Módulo de cola de proceso.
Lee un archivo que contiene valores para los procesos que se 
pondrán en cola. Cada proceso tiene valoes, enter-tima, exit-
time y la cantidad de 3 a 10 rebanadas de memoria de 2kb que 
requiere
-Módulo de estado de la memoria.
Informa el estado de la memoria, qué sectores son libres y
cuáles se usan. 
*/
import java.util.Scanner;

public class Final{

  public static void main(String[] args) {
/*
	Atributos.
*/
    Scanner in;
    Creador c;
    String[] lineas;
    int num, i, tipo;
/*
	Número de lineas.
*/
    in = new Scanner(System.in);
    num = Integer.parseInt( in.nextLine() );

/*
	Input.
*/
    lineas = new String[num];
    for (i=0; i<num; i++)
      lineas[i] = in.nextLine();

    for (i=1; i<=4; i++){
      c = new Creador(num, lineas, i);
      c.main();
    }
  }
}
