package controllers;

import java.util.List;

import models.Eventos;
import models.Rutina;
import models.Usuario;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
    	render();
    }
    
    public static void login(String username, String password){
    	
    	System.out.println(username);
		System.out.println(password);
		
 	    Usuario user=Usuario.find("byIdentificadorAndPassword",username,password).first();
 	   
		String resultado;
		
    	if(user!=null){
    	    resultado="Encontrado";
    	}
        else{
    		resultado="No encontrado";
    	}
    	System.out.println(resultado);
    	renderText(resultado);
    	
    }
    
    public static void busquedaRutina(String dato0, String dato1)
    {
    	System.out.println(dato0);
    	System.out.println(dato1);
    	Rutina ruti = Rutina.find("byDuracionAndObjetivo",dato0, dato1).first();
    	System.out.println(ruti);
    	renderXml(ruti); 	  
    }
    
    public static void busquedaUsuario(String dato0)
    {
    	System.out.println(dato0);
    	Usuario user = Usuario.find("byIdentificador",dato0).first();
    	System.out.println(user);
    	renderXml(user); 	  
    }
    
    public static void obtenerEventos()
    {
    	List<Eventos> eventos= Eventos.findAll();
    	System.out.println(eventos);
        renderXml(eventos);
    }
    
    public static void registroAndroid(String id, String pas, String pasw,String nom,int eda,String gen,float est,int pes) {
    	System.out.println(id);
    	System.out.println(pas);
    	System.out.println(pasw);
    	System.out.println(nom);
    	System.out.println(eda);
    	System.out.println(gen);
    	System.out.println(est);
    	System.out.println(pes);
    	Usuario user=new Usuario(id,pas,nom,eda,gen,est,pes);
    	validation.required(id);
    	validation.required(pas);
    	validation.required(pasw);
    	validation.required(nom);
    	validation.required(eda);
    	validation.required(gen);
    	validation.required(est);
    	validation.required(pes);
        validation.equals(pas,pasw);
        if(validation.hasErrors()) {
            renderText("Error al rellenar campos");
        }
        user.create(); 	
    	renderText("Exito al crear usuario");
    	
    }

}