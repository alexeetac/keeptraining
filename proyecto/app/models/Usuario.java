package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Equals;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	
	//Atributos de clase
	public String identificador;
	public String password;
	public String nombre;
	public int edad;
	public String genero;
	public double estatura;
	public int peso;
	
	
	//Relacion clase Rutina
	@ManyToOne
	public Rutina rutina;  
	
	//Relacion clase Estadistica
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	public List<Estadistica> estadisticas;
	
	//Constructor
	public Usuario(String i, String p, String n, int e,String g,double es, int pe)
	{
		this.identificador=i;
		this.password=p;
		this.nombre=n;
		this.edad=e;
		this.genero=g;
		this.estatura=es;
		this.peso=pe;
	}

	
	//Puedo acceder desde fuera sin instanciar la clase si creo método static (No tengo que hacer el new)
	
	//Añadir una rutina
	public Usuario addRutina(String tipo, String objetivo, String dieta, String entrenamiento)
	{
		this.rutina = new Rutina(tipo,objetivo,dieta,entrenamiento).save();                        
		return this;
	}
	
	//Añadir una estadistica
    public Usuario addEstadistica(String tipo, String ruta, double tiempo, double distancia, double velocidad) {
        Estadistica nuevaEstadistica = new Estadistica(this, tipo, ruta,tiempo,distancia,velocidad).save();
        this.estadisticas.add(nuevaEstadistica);
        this.save();
        return this;
    }
	
	
}
