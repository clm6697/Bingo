package es.cic.taller.Bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneradorNumerosBingo {
	List<Integer> listaNumeros = new ArrayList<>();
	Random rndm = new Random();
	
	public GeneradorNumerosBingo() {
		crearListaNumeros();
	}
	
	private List<Integer> crearListaNumeros() {
		for(int i=1; i<=90; i++) {
			listaNumeros.add(i);
		
		}
		Collections.shuffle(listaNumeros);
		return listaNumeros;
	}
	
	private int dameNumeroAzar() {
		int numAzar = rndm.nextInt(this.listaNumeros.size());
		return numAzar;
	}
	
	public int dameBola() {
		int numAzar = dameNumeroAzar();
		return listaNumeros.remove(numAzar);
	}
	
}

