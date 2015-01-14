import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	
	//Eliminar datos antes de testear
    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }
	
	//Test clase usuario
   @Test
    public void crearUsuario() {
	  
    	//Crear usuario
    	new Usuario("Roca", "abcde123", "alex", 20, 1.76, 75,"normal").save();
    	//Buscarlo
    	Usuario user = Usuario.find("byNombre", "alex").first();
    	//Test
    	assertNotNull(user);
    	assertEquals("abcde123",user.password);
    }
   

    //Test clase rutina
    @Test
    public void crearRutina(){
    	
    	//Crear rutina
    	new Rutina("running","maraton","tipoA","tipo1").save();
    	//Buscarlo
    	Rutina plan = Rutina.find("byTipo","running").first(); 	
    	//test
    	assertNotNull(plan);
    	assertEquals("tipoA",plan.dieta);
    }
    
    //Test clase estadisticas
    @Test
    public void crearEstadistica()
    {
    	Usuario user= new Usuario("Roca", "abcde123", "alex", 20, 1.76, 75,"normal").save();
    	//Crear estadistica
    	new Estadistica(user,"running","ruta3",14.3,6.2,10.2).save();
    	//Buscarlo
    	Estadistica ranking = Estadistica.find("byVelocidad",10.2).first();
    	//Test
    	assertNotNull(ranking);
    	assertEquals("ruta3",ranking.ruta);
    }
    
    //Test metodo añadirRutina clase usuario
   @Test
   public void AñadirRutina() {
	   
	   //Crear usuario
	   new Usuario("Roca", "abcde123", "alex", 20, 1.76, 75,"normal").save();
	   //Buscarlo
	   Usuario user = Usuario.find("byNombre", "alex").first();
	   //Utilizar metodo
	   user.añadirRutina("running","maraton","tipoA","tipo1");
	   //Test
	   assertNotNull(user);
	   assertNotNull(user.rutina);
	   assertEquals(user.rutina.tipo, "running");
	   
   }
    
    //Test añadir estadistica desde clase usuario
    @Test
    public void añadirEstadistica()
    {
    	Usuario user= new Usuario("Roca", "abcde123", "alex", 20, 1.76, 75,"normal").save();
    	user.añadirEstadistica("running","ruta3",14.3,6.2,10.2);
    	user.añadirEstadistica("ciclismo","ruta4",20.3,12.2,8.2);
    	assertNotNull(user);
    	assertNotNull(user.estadisticas);
        assertEquals(1, Usuario.count());
        assertEquals(0, Rutina.count());
        assertEquals(2, Estadistica.count());
        
        Estadistica prueba = Estadistica.find("byTipo","running").first();
        assertEquals(prueba.ruta,"ruta3");
        
        List<Estadistica> estadisticasUser = Estadistica.find("byUsuario", user).fetch();
        assertEquals(2, estadisticasUser.size());
    	
    	
    }
}
