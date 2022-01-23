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

		//Creaci�n de los objetos
		Videojuego vid1 = new Videojuego(10, "Uncharted", "Accion");
		Videojuego vid2 = new Videojuego(20, "Street Fighter II", "Lucha");
//		Videojuego vid3 = new Videojuego(30, "Pac-Man", "Arcade");
		
		ArrayList<Videojuego> listaVideojuego1 = new ArrayList<Videojuego>();
//		ArrayList<Videojuego> listVideojuego2 = new ArrayList<Videojuego>();
		listaVideojuego1.add(vid1);
		listaVideojuego1.add(vid2);
//		listVideojuego2.add(vid3);
		
		Desarrollador des1 = new Desarrollador(1, "Naughty Dog", 1984, listaVideojuego1);
		Desarrollador des2 = new Desarrollador(2, "Capcom", 1979, listaVideojuego1);
		

		//Creaci�n del SessionFactory
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		//Creamos la sesi�n
		Session sesion = sf.openSession();
		
		//Comenzamos la transacci�n
		sesion.beginTransaction();
		
			sesion.save(vid1);
			sesion.save(vid2);
//			sesion.save(vid3);
			
			sesion.save(des1);
			sesion.save(des2);
		
		
		sesion.getTransaction().commit();
		
		//Cerramos objetos
		sesion.close();
		sf.close();
	}

}
