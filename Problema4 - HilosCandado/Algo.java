import java.util.*;

public class Algo extends Thread{

	public String Id;
	//Tiempo de espera
	public int t;
	
	public Algo(String i){
		Id = i;
	}
	public void run(){
		try{
			sleep(1000);
			System.out.println(Id);
		}catch(InterruptedException e){ }
	}
	public static void main (String[] args){
		Algo a1 = new Algo("uno");
		Algo a2 = new Algo("dos");
		Algo a3 = new Algo("tres");

		a1.start();
		a2.start();
		a3.start();
		System.out.println("se acabo");
	}

}