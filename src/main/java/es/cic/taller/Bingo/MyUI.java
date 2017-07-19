package es.cic.taller.Bingo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.jsoup.nodes.BooleanAttribute;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
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

	List<CrearCartones> cartones;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	cartones = new ArrayList<>();
    	
        final VerticalLayout layout = new VerticalLayout();
        
        
        TextField textoNumeroCartones = new TextField();
        textoNumeroCartones.setPlaceholder("Numero Cartones");
        
        Button botonNumeroCartones = new Button("Seleccion");
        botonNumeroCartones.addClickListener(event -> /*Solucionar errores*/
        		String numCartonesString = textoNumeroCartones.getValue();
        		int numCartones = Integer.parseInt(numCartonesString);
        		);
        
        botonGenerarBola = new Button("Bingo!");
        botonGenerarBola.addClickListener(event -> /* Codigo generar la bola */);
        
        
        layout.addComponents(textoNumeroCartones);
        setContent(layout);
        
        
       
        
        
        for (int i=0; i<numCartones; i++) {
        	cartones.add(new CrearCartones());
        	String nombre = "Carton"+(i+1);
        	cartones.get(i).setNombre(nombre);
        }
        
      //Añadir botones numero cartones y generar bola con listener  
       
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
