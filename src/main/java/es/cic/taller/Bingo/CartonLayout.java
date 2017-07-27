package es.cic.taller.Bingo;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

public class CartonLayout  extends GridLayout{

	private Carton carton;
	
	HorizontalLayout horizontal = new HorizontalLayout();
    
	private List<Image> imagenes = new ArrayList<>();
	
	public CartonLayout(Carton carton) {
		carton.setCartonLayout(this);
		this.carton = carton;
		this.setRows(3);
		this.setColumns(5);
		
		inicializaObjetoImagenes();
		iniciazaNumero();
		
	}

	public void marcarViualmente(int i, String nombre) {
		Resource source = getImageResource(nombre);
		imagenes.get(i).setSource(source);
	}
	
	
	private void inicializaObjetoImagenes() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0 ; j < 5; j++)  {
				Image aux = new Image();
				imagenes.add(aux);
				addComponent(aux, j, i);
			}
		}
	}

	private  void iniciazaNumero() {
		for (int a = 0; a < 15; a++) {
			Numero numero = carton.cogerNumeroPosicion(a);

			Image image = imagenes.get(a);
			Resource resource = getImageResource(numero.getNombreFichero());
			image.setSource(resource);
		}
	}
	

	
	public static  Resource getImageResource(String nombreRecurso) {
		String basePath = VaadinService.getCurrent()
				.getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basePath + "/images/" + nombreRecurso));
		return resource;
		
	}
	
}
