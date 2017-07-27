package es.cic.taller.Bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class Carton {
	private CartonLayout cartonLayout;
	private String nombre;

	Random rnd = new Random();
	List<Numero> numerosCarton = new ArrayList<>();
	
	public Carton(int numeroCarto) {
		this.nombre = "Carton"+(numeroCarto);
		for (int i=0; i<15; i++) {
			while (true) {
				int aleatorio = rnd.nextInt(90)+1;

				Numero num = new Numero(aleatorio);
			
				if (!numerosCarton.contains(num)) {
					numerosCarton.add(num);
					break;
				}
			}	
		}
	}
	
	
	public void marcar(int valor) {
		for (int i=0; i<15; i++) {
			Numero aux = numerosCarton.get(i);
			if (aux.getNumero()==valor) {
				aux.setMarcado(true);
				cartonLayout.marcarViualmente(i, aux.getNombreFicheroMarcado());

	        	
			}
		}
	}
	
	
	public boolean esBingo() {
		int numeroMarcas = 0;
		boolean bingo = false;
		for (int i=0; i<15; i++) {
			if (numerosCarton.get(i).isMarcado()) {
				numeroMarcas++;
			}
		}
		if (numeroMarcas == 15) {
			bingo=true;
		}
		return bingo;
	}
	
	public Numero cogerNumeroPosicion(int a ) {
		return numerosCarton.get(a);
	}
	
	public int cogerPosicion (int a) {
		int valorPosicion = numerosCarton.get(a).getNumero();
		return valorPosicion;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Numero> getCarton() {
		return numerosCarton;
	}


	public CartonLayout getCartonLayout() {
		return cartonLayout;
	}


	public void setCartonLayout(CartonLayout cartonLayout) {
		this.cartonLayout = cartonLayout;
	}

	
}
