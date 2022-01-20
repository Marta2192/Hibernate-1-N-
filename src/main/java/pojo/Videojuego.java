package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Videojuego {
	
	@Id
	int codigo;
	@Column
	String titulo;
	@Column
	String genero;
	//Relación 1 a 1
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codDes", foreignKey = @ForeignKey(foreignKeyDefinition = "fk_des"))
	Desarrollador desarrollador;
	
	
	public Videojuego(int codigo, String titulo, String genero, Desarrollador desarrollador) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.genero = genero;
		this.desarrollador = desarrollador;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Desarrollador getDesarrollador() {
		return desarrollador;
	}


	public void setDesarrollador(Desarrollador desarrollador) {
		this.desarrollador = desarrollador;
	}
	
	
	
}