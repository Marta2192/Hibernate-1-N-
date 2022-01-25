import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import pojo.Desarrollador;
import pojo.Videojuego;

public class Principal {

	public static void main(String[] args) {

		//Creación de los objetos
		Videojuego vid1 = new Videojuego(10, "Uncharted", "Accion", null);
		Videojuego vid2 = new Videojuego(20, "Crash Bandicoot", "Plataformas", null);
		Videojuego vid3 = new Videojuego(30, "Street Fighter II", "Lucha", null);
		
		ArrayList<Videojuego> lista1 = new ArrayList<Videojuego>();

		lista1.add(vid1);
		lista1.add(vid2);

		ArrayList<Videojuego> lista2 = new ArrayList<Videojuego>();
		
		lista2.add(vid3);
		
		Desarrollador des1 = new Desarrollador(1, "Naughty Dog", 1984, lista1);
		Desarrollador des2 = new Desarrollador(2, "Capcom", 1979, lista2);
		
		vid1.setDesarrollador(des1);
		vid2.setDesarrollador(des1);
		vid3.setDesarrollador(des2);
		

		//Creación del SessionFactory
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		//Creamos la sesión
		Session sesion = sf.openSession();
		
		//Comenzamos la transacción
		sesion.beginTransaction();
		
			sesion.save(vid1);
			sesion.save(vid2);
			sesion.save(vid3);
			
			sesion.save(des1);
			sesion.save(des2);
		
		
		sesion.getTransaction().commit();
		
		//Cerramos objetos
		sesion.close();
		sf.close();
	}

}
