package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Desarrollador {
	
	@Id
	private int codigo;
	@Column
	private String nombre;
	@Column
	private int anho;
	
	
	
	public Desarrollador(int codigo, String nombre, int anho) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.anho = anho;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getAnho() {
		return anho;
	}



	public void setAnho(int anho) {
		this.anho = anho;
	}
	
	
	
	

}
