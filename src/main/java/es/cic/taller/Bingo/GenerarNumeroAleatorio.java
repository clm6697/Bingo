package es.cic.taller.Bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerarNumeroAleatorio {
	List<Integer> listaNumeros = new ArrayList<>();
	Random rndm = new Random();
	
	public List<Integer> crearListaNumeros() {
		for(int i=1; i<=90; i++) {
			listaNumeros.add(i);
		
		}
		Collections.shuffle(listaNumeros);
		return listaNumeros;
	}
	
	public int numeroAzar() {
		int numAzar = rndm.nextInt(this.listaNumeros.size());
		return numAzar;
	}
	
	public int bolaBingo() {
		int bola = this.listaNumeros.get(numeroAzar());
		listaNumeros.remove(numeroAzar());
		return bola;
	}
	
}

