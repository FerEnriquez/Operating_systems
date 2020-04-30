/**
María Fernanda Hernández Enriquez
A01329383
Final.
Sistemas Operativos
Alberto Oliart Ros
*/
public class Printing{
  	/*
		Métodos.
	*/
  public void procesoTotal(int num){
    System.out.println("Proceso encontrado: "+num);
  }

  public void procesoCreado(char nombre, int entrada, int exit, int bits){
    System.out.println("El proceso "+nombre+" se ha creado. Entrada: "+entrada+" Exits:"+exit+" Memoria: "+bits);
  }

  public void runtime(int type){
    System.out.print("[\t\t\t\t\t\t]\n[\t\t\t\t\t\t]\n[\t\t\t\t\t\t]\n[   Tipo de simulacion: ");
    switch(type){
      case 1: System.out.print("Best-Fit");   break;
      case 2: System.out.print("Worst-Fit");  break;
      case 3: System.out.print("First-Fit");  break;
      case 4: System.out.print("Next-Fit");   break;
    }
    System.out.print("\t]\n[\t\t\t\t\t\t]\n[\t\t\t\t\t\t]\n[\t\t\t\t\t\t]\n");
  }

  public void runtimeEntrada(char nombre, int time){
    System.out.println("El proceso "+nombre+" ha entrado al sistema en: "+time);
  }
  public void runtimeExit(char nombre, int time){
    System.out.println("El proceso "+nombre+" ha salido del sistema en: "+time);
  }
  public void runtimeTerminado(){
    System.out.println("[\t\t\t\t\t\t]\n[\t\t\t\t\t\t]\n[\t\t\t\t\t\t]\n[\t   La simulacion ha terminado.\t\t]\n[\t\t\t\t\t\t]\n[\t\t\t\t\t\t]\n[\t\t\t\t\t\t]\n");
  }

  public void memoriaStatus(String data){
    System.out.println("\tMemoria: "+data);
  }

  public void print(String s){
    System.out.print(s);
  }
  public void nuevaLinea(){
    System.out.print("\n");
  }
  public void separador(){
    System.out.println("_________________________________________________");
  }
}
