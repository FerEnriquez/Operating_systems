import java.util.*;

public class Algo2 extends Thread{

	public String Id;
	public int cont; //Contador
	public int turno; 
	public int i, j;

	public Algo2(int c, int t){
		i = c;
		j = t;

		//Id = i;
		//cont = 0;
	}

	public void run(){
		 int k;
		 while( turno != 0);
		 k = cont;
		 turno = j;


		 while(k < 100){
		 	while (turno != i){
		 		cont++;
		 		System.out.println("Id = " + Id + "cont = " + cont);
		 		k = cont;

		 		turno = j;
		 	}
		 }

		/*
		for(int i = 0; i < 100; i++){
			cont++;
			System.out.println("Id = " + Id + "cont = " + cont);
		}
		*/
	}

	public static void main(String[] args){
		Algo2 a1 = new Algo2(0,1);
		Algo2 a2 = new Algo2(1,0);

		/*
		Algo2 a1 = new Algo2("uno");
		Algo2 a2 = new Algo2("dos");
		Algo2 a3 = new Algo2("tres");
		*/
		a1.start();
		a2.start();
		//a3.start();
		System.out.println("se acabo");
	}
}