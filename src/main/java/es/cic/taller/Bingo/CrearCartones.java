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
			}
			else {
				while (carton.contains(num)) {
					return;
				}
				carton.add(num);
			}	 
		}
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
