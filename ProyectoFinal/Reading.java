/**
María Fernanda Hernández Enriquez
A01329383
Final.
Sistemas Operativos
Alberto Oliart Ros
*/
import java.util.Scanner;

public class Reading{
/*
	Atributos.
*/
  //Input
  private String[] lines;     
  //Arreglo de procesos
  private Proceso[] pros;
  //Imprimir
  private Printing pr;
  //Total de procesos
  private int num;   

  public Reading(int n, String[] l){
    num = n;
    lines = l;
    pr = new Printing();
    pr.procesoTotal(num);
  }

  public void initialize(){
    pros = new Proceso[num];
    fillProcess();
    sortProcess();
  }

/*
	Accesors.
*/
  public int getNum(){ 
  	return num; 
  }
  public Proceso[] getPros(){  
  	return pros;  
  }

/*
	Métodos.
*/
  private void fillProcess(){

	// Valores temporales para filling.
    int i;
    char nombre;
    int entrada;
    int exit;
    int bits;
    String[] vals;

    for (i=0; i<num; i++){
      vals = lines[i].split(" ");

      nombre = letterValue(i);
      entrada = Integer.parseInt( vals[0] );
      exit = Integer.parseInt( vals[1] );
      bits = Integer.parseInt( vals[2] );

      pr.procesoCreado(nombre, entrada, exit, bits);
      pros[i] = new Proceso(nombre, entrada, exit, bits);
    }
  }

  private void sortProcess(){
//Valores temporales para sorting.
    Proceso aux;
    int i, j;

/*
	Insertion sorting.
*/
    for (i=1; i<num; i++){
      for (j=1; j>0; j--){
        if (pros[j].getEntrada() < pros[j-1].getEntrada()){
          aux = pros[j];
          pros[j] = pros[j-1];
          pros[j-1] = aux;
        }
      }
    }
  }

  private char letterValue(int i){
    return (char)(65 + i);
  }
}
