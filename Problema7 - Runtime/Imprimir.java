/**
  María Fernanda Hernández Enriquez 
  A01329383
*/
public class Imprimir{

  // Definir métodos

  public void mainh(int s){
    switch(s){
      case 01: p("Proceso encontrado: "); break;
      case 11: p("Cargando proceso: "); break;
      case 21: p("Ordenando los procesos exitosos.\n"); break;
      case 31: p("Intentando el planificador preventivo FCFS.\n"); break;
      case 32: p("Intentando Round Robin.\n"); break;
    }
  }

  public void runtime(int s){
    switch(s){
      case 00: p("Entrar en el simulador del programa.\n"); break;
      case 01: p("Undades de tiempo: "); break;
      case 02: p("Proceso no agregado a la CPU.\n"); break;
      case 03: p("Proceso no agregado a la E/S.\n"); break;
    }
  }
  public void runtime(int s, int n){
    switch(s){
      case 10: p("Proceso "+n+" entra al sistema.\n"); break;
      case 21: p("Proceso "+n+" sale del sistema.\n"); break;
      case 22: p("Proceso "+n+" cambia a cola E/S.\n"); break;
      case 23: p("Proceso "+n+" alcanzo el tiempo maximo de CPU y se pone en cola.\n"); break;
      case 31: p("Proceso "+n+" cambia la cola de CPU.\n"); break;
    }
  }
  public void runtime(int s, int n, int v){
    switch(s){
      case 20: p("Proceso "+n+" tiene "+v+" CPU segundos restantes.\n"); break;
      case 30: p("Proceso "+n+" tiene "+v+" E/S segundos restantes.\n"); break;
      case 40: p("Proceso "+n+" ha gastado "+v+"/"); break;
      case 41: p(+v+" segundo de CPU fuera del maximo.\n"); break;
    }
  }

  public void newline(){
    System.out.print("\n");
  }
  public void separator(){
    System.out.println("\n____________________________________________\n");
  }
  private void p(String text){
    System.out.print(text);
  }
}
