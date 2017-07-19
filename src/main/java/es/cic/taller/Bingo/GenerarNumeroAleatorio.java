package es.cic.taller.Bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerarNumeroAleatorio {
	List<Integer> numeros = new ArrayList<>();
	public GenerarNumeroAleatorio() {
		for(int i=1; i<=90; i++) {
			numeros.add(i);
		
		}
		Collections.shuffle(numeros);
	}
}
