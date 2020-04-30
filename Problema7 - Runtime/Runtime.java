import java.util.Queue;
import java.util.PriorityQueue;
/**
  María Fernanda Hernández Enriquez 
  A01329383
*/

public class Runtime{

  //Definir variables y objetos
  
  private Imprimir imp;
  private boolean tipo;       
  private Proceso[] pros;
  private int rrt;
  private int ind;            
  private Queue<Integer> cpu;
  private Queue<Integer> es;
  private int c, e;           
  private int sysTime;
  private int cpuTime;       
  private boolean exit;

  // Constructores

  public Runtime(boolean tipo, Proceso[] pros, int rrt, int num){
    imp = new Imprimir();
    this.tipo = tipo;
    this.pros = pros;
    this.rrt = rrt;

    ind = 0;
    cpu = new PriorityQueue<Integer>(num+1);
    es = new PriorityQueue<Integer>(num+1);

    sysTime = cpuTime = -1;
    exit = false;
  }

  // Metodos

  public void simulate(){
    imp.runtime(00);
    while (!exit || (cpu.peek()!=null) || (es.peek()!=null)){
      sysTime ++;
      exit = false;
      imp.runtime(01); System.out.print(sysTime+"\n");

      systemHandling();
      cpuHandling();
      e_sHandling();

      imp.newline();
    }

    //Salida del proceso
    for (ind=0; ind<pros.length; ind++){
      System.out.println("Process "+ind);
      pros[ind].status();
      imp.newline();
    }
  }

  private void systemHandling(){
    while(ind<pros.length){
      if (pros[ind].getTime() == sysTime){
        try {
          cpu.add(ind);
          imp.runtime(10, ind);
        } catch(Exception e1){ imp.runtime(02); }

        ind ++;
      } else
        break;
    }
  }

  private void cpuHandling(){
    // Proceso de CPU en la cola y Round Robin handling.
    if (cpu.peek() != null){
      cpuTime ++;
      c = cpu.peek();
      pros[c].reduceBurst();
      pros[c].expandCPU();
      imp.runtime( 20, c, pros[c].getBurst() );

      // Seccion del CPU.
      if (pros[c].getBurst() <= 0){
        //Caso1: con una próxima ráfaga de CPU, haz cola en E/S
        if (pros[c].hasNext()){
          try{
            pros[c].expandIndex();
            es.add( cpu.poll() );
            imp.runtime(22, c);
          } catch(Exception e2){ imp.runtime(03); }
        } 
        //Caso2: sin una próxima ráfada de CPU, salga del sistema
        else {
          pros[c].setExit(sysTime);
          cpu.poll();
          imp.runtime(21, c);
        }

        cpuTime = 0;
        exit = true;
      }

      // Sección Round Robin.
      if (tipo){
        imp.runtime(40, c, cpuTime);
        imp.runtime(41, c, rrt);

        if (cpuTime >= rrt){
          try{
            cpu.add( cpu.poll() );
            imp.runtime(23, c);
          } catch(Exception e3){ imp.runtime(03); }

          cpuTime = 0;
        }
      }
    }
  }

  private void e_sHandling(){
    if (es.peek() != null){
      e = es.peek();
      pros[e].reduceBurst();
      pros[e].expandWT();
      pros[e].expandES();
      imp.runtime( 30, e, pros[e].getBurst() );

      if (pros[e].getBurst() <= 0){
        try{
          pros[e].expandIndex();
          cpu.add( es.poll() );
          imp.runtime(31, e);
        } catch(Exception e4){ imp.runtime(12); }
      }
    }
  }

}
