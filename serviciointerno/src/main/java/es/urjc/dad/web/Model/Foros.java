package es.urjc.dad.web.Model;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Foros {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String titulo;
	
	@ManyToOne
	private Usuario usuario;
	
	@Lob
	@JsonIgnore
	private Blob imagen;
	

	
	
	//******************************//
	
	//private String user;
	private String Asunto;
	private String Cuerpo;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Mensaje> mensajes;

	@ManyToOne
	private Usuario creador;
	
	//******************************//	

	
	public Foros() {

	}

	public Foros(String title, String text) {
		super();
		this.Asunto = title;
		this.Cuerpo = text;
		mensajes = new ArrayList<Mensaje>();
	}
	
	public Foros(String title, String text,List<Mensaje> mensajes ) {
		super();
		this.Asunto = title;
		this.Cuerpo = text;
		mensajes = mensajes;
	}
	
	public void AñadirMensaje(Mensaje mensaje) {
		mensajes.add(mensaje);
	}
	
	public List<Mensaje>  getMensajes() {
		return mensajes;
	}


	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}
	
	public String getAsunto() {
		return Asunto;
	}

	public void setAsunto(String Asunto) {
		this.Asunto = Asunto;
	}

	public String getCuerpo() {
		return Cuerpo;
	}

	public void setCuerpo(String Cuerpo) {
		this.Cuerpo = Cuerpo;
	}
	
	@Override
	public String toString() {
		return "Post [id="+id+", user=" + "user" + ", title=" + Asunto + ", text=" + Cuerpo + "]";
	}
}
