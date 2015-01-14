package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Estadistica extends Model{

	//Atributos de clase
	public String tipo;
	public String ruta;
	public double tiempo;
	public double distancia;
	public double velocidad;
	
    @ManyToOne
    public Usuario usuario;
	
	//Contructor
	public Estadistica(Usuario user, String t, String r, double ti, double d, double v)
	{
		this.usuario=user;
		this.tipo=t;
		this.ruta=r;
		this.tiempo=ti;
		this.distancia=d;
		this.velocidad=v;
	}
	
}
