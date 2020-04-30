/**
María Fernanda Hernández Enriquez
A01329383
Final.
Sistemas Operativos
Alberto Oliart Ros
*/
public class Creador{
/*
	Atributos.
*/
  private int num;
  private String[] lineas;
  private int tipo;

  public Creador(int n, String[] l, int t){
    num = n;
    lineas = l;
    tipo = t;
  }

  public void main(){
    /*
		Atributos.
	*/
    Reading rm;
    Simulation rn;

    rm = new Reading(num, lineas);
    rm.initialize();
    rn = new Simulation( rm.getNum(), rm.getPros(), tipo );
    rn.simulate();
  }
}
