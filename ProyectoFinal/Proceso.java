/**
María Fernanda Hernández Enriquez
A01329383
Final.
Sistemas Operativos
Alberto Oliart Ros
*/
public class Proceso{
/*
	Atributos.
*/
  //Reconocimiento más fácil
  private char nombre;   
  //Tiempo de entrada
  private int entrada;  
  //Tiempo de salida  
  private int exit; 
  //Tamaño de memoria pedida 
  private int bits;     
  //Tiempo de uso del CPU
  private int cpu;    

/*
	Constructores.
*/
  public Proceso(char n, int c, int e, int b){
    nombre = n;
    entrada = c;
    exit = e;
    bits = b;
    cpu = 0;
  }

/*
	Accesors.
*/
  public char getName(){  
  	return nombre;  
  }
  public int getEntrada(){ 
  	return entrada;  
  }
  public int getBits(){  
  	return bits;  
  }
  public int getCPU(){  
  	return cpu;  
  }
  public void advanceCPU(){  
  	cpu ++;  
  }

/*
	Métodos.
*/
  public boolean esTerminado(){
    return cpu >= (exit-entrada);
  }
}
