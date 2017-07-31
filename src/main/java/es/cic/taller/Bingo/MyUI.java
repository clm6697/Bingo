package es.cic.taller.Bingo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
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
    	
    	
    	///ORDENAR NUMEROS
    	
    	
    	final HorizontalLayout layoutPadre = new HorizontalLayout();
        final VerticalLayout layoutVertical1 = new VerticalLayout();
        final VerticalLayout layoutVertical2 = new VerticalLayout();
        final HorizontalLayout layoutHorizontalNumeroCartones = new HorizontalLayout();
       
        //TextField para introducir el numero de cartones deseados
        TextField textoNumeroCartones = new TextField();
        textoNumeroCartones.setPlaceholder("Número Cartones");
        
        //Boton que confirma el numero de cartones seleccionados 
        Button botonNumeroCartones = new Button("Continuar");
        //Generamos los cartones deseados, dentro del arrray cartones
        botonNumeroCartones.addClickListener(e -> {
        	
        		String numCartonesString = textoNumeroCartones.getValue();
        		int numCartones = Integer.parseInt(numCartonesString);
        		
        		if (numCartones<=0) {
        			Notification.show("Introduce un numero de cartones mayor de cero.", Type.TRAY_NOTIFICATION);
        		}else {
        			generarCartones(numCartones);
            		botonNumeroCartones.setEnabled(false);
            		for (Carton c: cartones) {
            			CartonLayout cartonLayout = new CartonLayout(c);
            			layoutVertical1.addComponent(cartonLayout);
            		}
        		}
        		
        		});
        
        //Boton que genera la bola que vamos a usar en esta partida
        Button botonGenerarBola = new Button("Generar Número");
        botonGenerarBola.addClickListener(e -> {
        	int bolaJugada = generadorNumerosBingo.dameBola();
        	Numero numAux = new Numero(bolaJugada);
        	Image image = new Image();
        	Resource source = CartonLayout.getImageResource(numAux.getNombreFichero());
        	image.setSource(source);
        	layoutVertical2.addComponentAsFirst(image);       	
        	
        	buscarNumeroCarton(bolaJugada);
        		if(buscarBingo()) {
        			botonGenerarBola.setEnabled(false);        	        
        			layoutPadre.removeAllComponents();
        	        Image sample = new Image();
        	        Image agradecimientos = new Image();
        	        
        	        String basePath = VaadinService.getCurrent()
        					.getBaseDirectory().getAbsolutePath();
        	        FileResource resource = new FileResource(new File(basePath + "/images/bingo.gif"));
        	        FileResource resourceA = new FileResource(new File(basePath + "/images/agradecimientos.png"));
        	        
        	        sample.setSource(resource);
        	        agradecimientos.setSource(resourceA);
        			layoutPadre.addComponents(sample,agradecimientos);
        			setContent(layoutPadre);
        		}        	
        });
        
        
        layoutHorizontalNumeroCartones.addComponents(textoNumeroCartones, botonNumeroCartones);
        
        Image sampleBingo = new Image();
        String basePathB = VaadinService.getCurrent()
				.getBaseDirectory().getAbsolutePath();
        FileResource resourceB = new FileResource(new File(basePathB + "/images/bingoF.png"));
        sampleBingo.setSource(resourceB);
        
        layoutVertical1.addComponents(sampleBingo,layoutHorizontalNumeroCartones, botonGenerarBola);
        layoutPadre.addComponents(layoutVertical1,layoutVertical2);
        setContent(layoutPadre);
        
        
       
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
