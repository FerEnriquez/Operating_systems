/**
María Fernanda Hernández Enriquez 
A01329386
*/
public class Proceso{

    //Definir variables
  
    private int tiempo;
    private int[] burst;
    private int pos;
    private int espera;  
    private int exitTime;
    private int cpuTime;
    private int esTime;

    // Constructores
    public Proceso(int ti, int[] bu){
      tiempo = ti;
      burst = bu;

      pos = 0;
      espera = ti;
      exitTime = cpuTime = esTime = 0;
    }

    // Accessors and Mutators
    public int getTime(){ 
      return tiempo; 
    }
    public int getBurst(){ 
      return burst[pos]; 
    }
    public void setExit(int val){ 
      exitTime = val; 
    }

    // Metodos

    public void expandIndex(){ 
      pos ++; 
    }
    public void reduceBurst(){ 
      burst[pos] --; 
    }
    public void expandWT(){ 
      espera ++; 
    }
    public void expandCPU(){ 
      cpuTime ++; 
    }
    public void expandES(){ 
      esTime ++; 
    }

    //Devuelve si hay otra ráfaga del CPU. 
    //Ignora cualquier tiempo ráfaga con E/S
    public boolean hasNext(){
      return (pos+2) < burst.length;
    }

    public void status(){
      System.out.println("Tiempo de espera:\t\t"+espera);
      System.out.println("Tiempo de atención en CPU:\t"+cpuTime);
      System.out.println("Tiempo de atención en E/S:\t"+esTime);
      System.out.println("Tiempo total del sistema:\t"+(exitTime -tiempo));
      System.out.println("Exit tiempo:\t\t"+exitTime);
    }

    public void debug(){
      for (int i=0; i<burst.length; i++)
        System.out.print(burst[i]+" , ");
      System.out.println();
    }
}
