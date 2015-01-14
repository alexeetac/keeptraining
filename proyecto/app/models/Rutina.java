package models;

import javax.persistence.Entity;
import javax.persistence.Lob;

import play.db.jpa.Model;

@Entity
public class Rutina extends Model {

	//Atributos de clase
	public String duracion;
	public String objetivo;
	public String dieta;
	@Lob
	public String entrenamiento;
	
	//Constructor
	public Rutina(String t, String o, String d, String e)
	{
		this.duracion=t;
		this.objetivo=o;
		this.dieta=d;
		this.entrenamiento=e;
	}
	
}

