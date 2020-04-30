import java.util.*;

public class Algo3 extends Thread{

	public String Id;
	public int i, j;
	public int cont; //Contador
	public int turno;
	public boolean[] flag = new boolean[2];

	public Algo3(int c, int t){
		i = c;
		j = t;
	}

	public void run(){
		 int k;
		 while( turno != 0);
		 k = cont;
		 turno = j;


		 while(k < 100){
		 	flag[i] = true;
		 	while (flag[j]);

		 	cont++;
		 	System.out.println("Id = [" + i + "] cont = " + cont);
		 	
		 	k = cont;
		 	flag[i] = false;
		 	turno = j;
		 	
		 }
	}

	public static void main(String[] args){
		Algo3 a1 = new Algo3(0,1);
		Algo3 a2 = new Algo3(1,0);

		a1.start();
		a2.start();
		System.out.println("se acabo");
	}
}