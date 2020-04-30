/**
*	Esta clase define un Buffer en donde se crea un pila
	@Author María Fernanda Hernández Enriquez
*	A01329383
*/
public class Bufer{	
/*
*	Se declaran variables
*/
	public int elem;
	public int size;
	public static int nums[];
/*
*Constructor con parámetros
*/
	public Bufer(int size){
		this.elem = 0;
		this.size = size;
		this.nums = new int[size];
	}
/*
*	Métodos
*/
	public void addBufer(int num){
		if(elem < size){
			nums[elem] = num;
			elem++;
		}
		else
			System.out.println("Full");
	}

	public int removeBufer(){
		int num = -1;
		if(elem > 0){
			num = nums[0];
			elem--;

			for(int i=0; i<size-1; i++){
				nums[i] = nums[i+1];
			}
		}
		else
			System.out.println("Vacio");
		return num;
	}
}