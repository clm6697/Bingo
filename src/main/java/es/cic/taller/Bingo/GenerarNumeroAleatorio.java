package es.cic.taller.Bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerarNumeroAleatorio {
	List<Integer> ListaNumeros = new ArrayList<>();
	Random rndm = new Random();
	
	public List<Integer> crearListaNumeros() {
		for(int i=1; i<=90; i++) {
			ListaNumeros.add(i);
		
		}
		Collections.shuffle(ListaNumeros);
		return ListaNumeros;
	}
	
	public int numeroAzar() {
		int numAzar = rndm.nextInt(this.ListaNumeros.size());
		return numAzar;
	}
	
	public int bolaBingo() {
		int bola = this.ListaNumeros.get(numeroAzar());
		return bola;
	}
}
