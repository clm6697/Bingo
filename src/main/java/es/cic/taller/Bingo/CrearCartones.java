package es.cic.taller.Bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrearCartones {
	private String nombre;

	Random rnd = new Random();
	List<Numero> carton = new ArrayList<>();
	
	public CrearCartones() {
		
		for (int i=0; i<=14; i++) {
			int aleatorio = rnd.nextInt()*90+1;
			Numero num = new Numero(aleatorio);
		
			if (i==0) {
				carton.add(num);
			}else {
				while (carton.contains(num)) {
					return;
				}
				carton.add(num);
			}	 
		}
	}
	
	public void marcar(int valor) {
		for (int i=0; i<15; i++) {
			if (carton.get(i).getNumero()==valor) {
				carton.get(i).setMarcado(true);
				
			}
		}
	}
	
	public boolean esBingo() {
		int numeroMarcas = 0;
		boolean bingo = false;
		for (int i=0; i<15; i++) {
			if (carton.get(i).isMarcado()) {
				numeroMarcas++;
			}
		}
		if (numeroMarcas == 15) {
			bingo=true;
		}
		return bingo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Numero> getCarton() {
		return carton;
	}

	
}
