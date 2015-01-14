package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Eventos extends Model {
	
	//Atributos de clase
	public String nombre;
	public String objetivo;
	public String fecha;
	public String url;
	

	//Constructor
	public Eventos(String i, String p, String n, String g)
	{
		this.nombre=i;
		this.objetivo=p;
		this.fecha=n;
		this.url=g;

	}

	

	
}
