import java.util.Scanner;
/**
  María Fernanda Hernández Enriquez
  A01329383
*/

public class Creador{

  public void main(int num, String[] lines){
    
    //Definir variables y objetos    
    
    Proceso[] pros;
    Runtime r1, r2;
    Imprimir imp;
    Scanner in;
    int rrt;          

    imp = new Imprimir();
    rrt = 8;

    //Definición de los procesos y la simulación
    pros = new Proceso[num];
    imp.mainh(01); System.out.print(num+"\n"); imp.newline();

    pros = sortProcess(num, fillProcess(imp, lines, num, pros));
    imp.mainh(21); imp.newline();
    r1 = new Runtime(false, pros, 0, num);
    imp.mainh(31);
    r1.simulate();

    imp.separator();

    pros = sortProcess(num, fillProcess(imp, lines, num, pros));
    imp.mainh(21); imp.newline();
    r2 = new Runtime(true, pros, 8, num);
    imp.mainh(32);
    r2.simulate();
  }

  /* Complete la matriz de procesos con sus tiempos de ráfagas diseñados.*/
  public Proceso[] fillProcess(Imprimir imp, String[] lines, int num, Proceso[] pros){
    String[] values;
    int time;           
    int[] burst;       
    int i, j;

    // Separating the commas to fill -values, which is used to create a process.
    for (i=0; i<num; i++){
      values = lines[i].split(",");
      time = Integer.parseInt( values[0] );
      burst = new int[values.length-1];

      for (j=1; j<values.length; j++)
        burst[j-1] = Integer.parseInt( values[j] );

      imp.mainh(11); System.out.println(i);
      pros[i] = new Proceso(time, burst);
    }

    return pros;
  }

  /* Ordena los procesos para que comiencen en orden.*/
  public Proceso[] sortProcess(int num, Proceso[] pros){
    Proceso aux;
    int i, j;
    for (i=1; i<num; i++)
      for (j=i; j>0; j--)
        if (pros[j].getTime() < pros[j-1].getTime()){
          aux = pros[j];
          pros[j] = pros[j-1];
          pros[j-1] = aux;
        }

    return pros;
  }

}
