/**
María Fernanda Hernández Enriquez
A01329383
Final.
Sistemas Operativos
Alberto Oliart Ros
*/
import java.util.Arrays;
import java.lang.StringBuilder;

public class Memoria{
  	/*
		Atributos.
	*/
  private int tamano;
  //Simulacion de memoria
  private char[] ram;     
  //Que tipo
  private int tipo;      
  private int nf;         

/*
	Constructores.
*/
  public Memoria(int s, int t){
    tamano = s;
    ram = new char[tamano];
    tipo = t;

    nf = 0;
    zeroes();
  }

/*
	Accesors.
*/
  public String getRam(){
    /*
		Atributos.
	*/
    StringBuilder s;
    int i;

    s = new StringBuilder();
    for (i=0; i<tamano; i++){
      if (i%64 == 0)
        s.append("\n");
      s.append( ram[i] );
    }

    return s.toString();
  }

/*
	Métodos.
*/
  public void zeroes(){
    /*
		Atributos.
	*/
    int i;

    for (i=0; i<tamano; i++)
      ram[i] = '-';
  }

  public boolean assign(char nombre, int bits, int tipo){
    switch(tipo){
      case 1: return bestFit(nombre, bits*2, true);
      case 2: return bestFit(nombre, bits*2, false);
      case 3: return firstFit(nombre, bits*2, true);
      case 4: return firstFit(nombre, bits*2, false);
      default: System.out.println("Qué ocurrió.");  return false;
    }
  }

  private void allocate(char nombre, int bits, int at){
    /*
		Atributos.
	*/
    int i;

    for (i=at; i<(at+bits); i++)
      ram[i] = nombre;
  }

  public void deallocate(char nombre){
    /*
		Atributos.
	*/
    int i;
    nf = 0;

    for (i=0; i<tamano; i++)
      if (ram[i] == nombre){
        ram[i] = '-';
      }
  }

  private boolean bestFit(char nombre, int bits, boolean tipo){
    /*
		Atributos.
	*/
		//Posición previa
    int at, auxat;  
    	//Posición actual 
    int to, auxto;  
    boolean grabando;
    boolean terminando;
    int i;

    if (tipo)
      to = auxat = auxto = +999;
    else
      to = auxat = auxto = -999;
    at = 0;
    grabando = terminando = false;

    /*
    	Para el ciclo, revisa todos los valores
    	1) Detecta si hay un espacio abierto
    	2) Detecta si -i está al final del arreglo y todavía está grabando, a lo que el -to índice se convierte en la última posición.
    	3) Detecta si se usa el espacio en el valor en -i, el espacio abierto anterior se convierte en -para indexar
	*/
    for (i=0; i<tamano; i++){
      if ( (ram[i] == '-') && !grabando){
        auxat = i;
        grabando = true;
      }
      else if ( (i == tamano-1) && grabando ){
        auxto = i;
        grabando = false;
        terminando = true;
      }
      else if ( (ram[i] != '-') && grabando){
        auxto = i-1;
        grabando = false;
        terminando = true;
      }
      /*
		Cada vez que se coloca el índice -to, la máquina verifica si el nuevo espacio obtenido es óptimo para su uso.
  		Luego verifica si el espacio es lo suficientemente grande para la solicitud del proceso.
  		Seguido de comprobar si la diferencia entre el nuevo -at y -to es
        1. Más pequeño que el anterior (Best-fit) o
        2. Más grande que el anterior (peor ajuste)
      */
      if (terminando){
        if ( ((auxto-auxat) >= bits))
          if (tipo){
            if ( (auxto-auxat) < (to-at) ){
              at = auxat;
              to = auxto;
            }
          }
          else{
            if ( (auxto-auxat) > (to-at) ){
              at = auxat;
              to = auxto;
            }
          }

        terminando = false;
        auxat = auxto = 0;
      }
    }

    if ( (to != +999) && tipo){
      allocate(nombre, bits, at);
      return true;
    }
    else if ( (to != -999) && !tipo ){
      allocate(nombre, bits, at);
      return true;
    }
    else
      return false;
  }

  private boolean firstFit(char nombre, int bits, boolean tipo){
   	/*
		Atributos.
	*/
    int at, auxat;  
    int to, auxto;  
    boolean grabando;
    boolean terminando;
    int i, cur;

    grabando = terminando = false;
    auxat = auxto = -1;

    /*
    	Primeras búsquedas de ajuste desde el número cero, búsquedas de ajuste siguiente desde el último valor buscado. 
    	Primer ajuste restablece el valor de "última búsqueda" a 0.
    */
    if (tipo)
      nf = 0;
    cur = 0;

    /*
    	Para el ciclo, revisar todos los valores
    	1) Detecta si hay un espacio abierto. 
    	2) Detecta si hay un espacio abierto y sigue agregando valor -cur tamano. 
    	Si se encuentra la cantidad necesaria, sale automáticamente
    	3) Detecta si -i está al final del arreglo y todavía está grabando, a lo que el algoritmo se detiene.
    	4) detecta si el espacio en el valor -i es uso, el valor -cur se restablece y esperando que 
    	se encuentre otro espacio abierto.
    */
    	
    for (i=nf; i<tamano; i++){
      if ( ram[i] == '-' && !grabando){
        auxat = i;
        cur ++;
        grabando = true;
      }
      else if ( ram[i] == '-' && grabando ){
        cur ++;
        if (cur >= bits){
          auxto = i;
          terminando = true;
          break;
        }
      }
      else if ( i == tamano-1 ){
        auxto = i;
        terminando = false;
        break;
      }
      else if ( ram[i] != '-' && grabando ){
        auxto = i;
        cur = 0;
        grabando = false;
      }
    }

    if (terminando){
      at = auxat;
      to = auxto;

      allocate(nombre, bits, at);
      return true;
    }
    else
      return false;
  }
}
