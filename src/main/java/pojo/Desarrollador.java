package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Desarrollador {
	
	@Id
	private int codigo;
	@Column
	private String nombre;
	@Column
	private int anho;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CodDes", foreignKey = @ForeignKey(foreignKeyDefinition = "fkVidToDes"))	
	private List<Videojuego> listaVideojuegos = new ArrayList<Videojuego>();
	
	
	

	public Desarrollador(int codigo, String nombre, int anho, List<Videojuego> listaVideojuegos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.anho = anho;
		this.listaVideojuegos = listaVideojuegos;
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




	public List<Videojuego> getListaVideojuegos() {
		return listaVideojuegos;
	}




	public void setListaVideojuegos(List<Videojuego> listaVideojuegos) {
		this.listaVideojuegos = listaVideojuegos;
	}



	

}
