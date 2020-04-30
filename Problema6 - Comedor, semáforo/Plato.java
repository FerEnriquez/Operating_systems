/**
María Fernanda Hernández Enriquez 
A01329393
*	Clase Plato
*	Define las porciones de comida que hará el chef para los comensales.
*/
public class Plato{
	/*
	Declaración de variables
	*/
	private int turno;
	private int[] noPlatos;
	private Comensal comensal;
	private int comida;
	/*
		Constructor
	*/
	public Plato(int comida){
		this.turno = -1;
		this.comida = comida;
	}
	/*
		Método comer
		Define cuando un comensal en especifico toma e ingiere su comida
	*/
	public void comer(int comensal){
		System.out.println("Comensal No."+comensal+" comiendo plato No."+noPlatos[turno]+"Platos disponibles:"+turno);
		turno--;
	}
	/*
		Método ver
		Muestra el turno
	*/
	public boolean ver(){
		return turno < 0;
	}
	/*
		Método setComensal
		Actualiza los valores del siguiente comensal
	*/
	public void setComensal(Comensal comensal){
		System.out.println("Comensal No."+comensal.getComensal()+" se quedó sin comida.");
		this.comensal = comensal;
	}
	/*
		Método getComensal
		Muestra los valores del comensal actual
	*/
	public Comensal getComensal(){
		System.out.println("Comensal No."+comensal.getComensal()+" fue servido por el chef.");
		return comensal;
	}
	/*
		Método cocinar
		Crea cierta cantidad de platillos
		Hechos por el chef, mientras los comensales esperan
	*/
	public void cocinar(){
		int num = (int)(Math.random()* comida) + 1;
		noPlatos = new int[num];
		turno = num - 1;
		for(int i = 0; i < num; i++){
			noPlatos[i] = (int)(Math.random() * 20) + 1;
		}
		System.out.println("El chef preparó "+num+" platillos.");
	}

}