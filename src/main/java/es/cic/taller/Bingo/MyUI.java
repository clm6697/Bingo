package es.cic.taller.Bingo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	List<Carton> cartones = new ArrayList<>();
	
	GeneradorNumerosBingo generadorNumerosBingo = new GeneradorNumerosBingo(); 
	 
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	
    	final HorizontalLayout layoutGrande = new HorizontalLayout();
        final VerticalLayout layoutVertical1 = new VerticalLayout();
        final HorizontalLayout layout2 = new HorizontalLayout();
       
        //TextField para introducir el numero de cartones deseados
        TextField textoNumeroCartones = new TextField();
        textoNumeroCartones.setPlaceholder("Numero Cartones");
        
        //Boton que confirma el numero de cartones seleccionados 
        Button botonNumeroCartones = new Button("Seleccion");
        //Generamos los cartones deseados, dentro del arrray cartones
        botonNumeroCartones.addClickListener(e -> {
        	
        		String numCartonesString = textoNumeroCartones.getValue();
        		int numCartones = Integer.parseInt(numCartonesString);
        		generarCartones(numCartones);
        		botonNumeroCartones.setEnabled(false);
        		for (Carton c: cartones) {
        			CartonLayout cartonLayout = new CartonLayout(c);
        			layoutVertical1.addComponent(cartonLayout);
        		}
        		});
        
        //Boton que genera la bola que vamos a usar en esta partida
        Button botonGenerarBola = new Button("Generar Numero!");
        botonGenerarBola.addClickListener(e -> {
        	int bolaJugada = generadorNumerosBingo.dameBola();
        	
        	buscarNumeroCarton(bolaJugada);
        		if(buscarBingo()) {
        			botonGenerarBola.setEnabled(false);
        		}        	
        });
        
        
        layout2.addComponents(textoNumeroCartones, botonNumeroCartones);
        layoutVertical1.addComponents(layout2, botonGenerarBola);
        setContent(layoutVertical1);
        
       
    }
    

	private void generarCartones(int numCartones) {
        for (int i=0; i<numCartones; i++) {
        	cartones.add(new Carton(i +1));
        }
    }
    
    private void buscarNumeroCarton(int bolaJugada) {
//    	cartones.forEach(c -> c.marcar(bolaJugada));
    	
    	for(Carton c: cartones) {
    		c.marcar(bolaJugada);
    	}
    }
    
    private boolean buscarBingo() {
    	for(Carton c: cartones) {
    		if(c.esBingo()) {
    			return true;
    		}
    		
    	}
    	return false;
    }
    
    
    
        
      
    

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
