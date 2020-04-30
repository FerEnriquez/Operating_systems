/**
María Fernanda Hernández Enriquez
A01329383
Final.
Sistemas Operativos
Alberto Oliart Ros
*/
import java.util.Queue;
import java.util.PriorityQueue;

public class Simulation{
/*
	Atributos.
*/
  //Procesos que se están corriendo
  private Queue<Integer> cpu; 
  //Memoria de asignación
  private Memoria mem;  
  private Printing pr;  
  private int time;
  //Indice de los procesos que han entrado           
  private int ind;            
  //Número de procesos que han salido
  private int exits;          

  private int num;            
  private Proceso[] pros;     
  private int type;           

/*
	Constructores.
*/
  public Simulation(int n, Proceso[] p, int t){
    cpu = new PriorityQueue<Integer>(n);
    mem = new Memoria(256, t);
    pr = new Printing();
    time = 0;
    exits = 0;

    num = n;
    pros = p;
    type = t;

    pr.separador();
    pr.runtime(type);
    pr.nuevaLinea();
  }

/*
	Metodos.
*/
  public void simulate(){
    while (exits < num){

      if (ind < num)
        entradaSistema();

     cpuAction();

      time ++;
    }

    pr.runtimeTerminado();
    pr.nuevaLinea();
  }

  private void entradaSistema(){
    /*
	Atributos.
	*/
    Proceso p;

    while (ind < num){
      p = pros[ind];
      if ( (time - p.getEntrada()) >= 0 ){

        if ( mem.assign( p.getName(), p.getBits(), type ) ){
          pr.runtimeEntrada(p.getName(), time);
          pr.memoriaStatus( mem.getRam() );

          cpu.add(ind);
          ind ++;

          pr.nuevaLinea();
        }
        else
          break;
      }
      else
        break;
    }
  }

  private void cpuAction(){
    /*
	Atributos.
	*/
    int c;

    if (cpu.peek() != null){
      c = cpu.peek();
      pros[c].advanceCPU();

      if (pros[c].esTerminado() ){
        pr.runtimeExit( pros[c].getName(), time);
        mem.deallocate( pros[c].getName() );
        pr.memoriaStatus( mem.getRam() );

        cpu.poll();
        exits ++;

        pr.nuevaLinea();
      }
    }
  }
}
