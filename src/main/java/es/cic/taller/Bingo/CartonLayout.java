package es.cic.taller.Bingo;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class CartonLayout  extends GridLayout{

	
	HorizontalLayout horizontal = new HorizontalLayout();
    
	public CartonLayout() {
	
		
	this.setRows(3);
	this.setColumns(5);
	}
	
public void ArrayToGrid() {
	CrearCartones objetoCarton = new CrearCartones();
	int i;
	int j;
	for (int a=0; a<15; a++) {
		int valorNumerico = objetoCarton.cogerPosicion(a);
		i=a/5;
		j=a%5;
		
		
		
		}
	}
}
