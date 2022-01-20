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
		Desarrollador des1 = new Desarrollador(1, "Naughty Dog", 1984);
		Desarrollador des2 = new Desarrollador(2, "Capcom", 1979);
		
		Videojuego vid1 = new Videojuego(10, "Uncharted", "Accion", des1);
		Videojuego vid2 = new Videojuego(20, "Street Fighter II", "Lucha", des1);

		//Creación del SessionFactory
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		//Creamos la sesión
		Session sesion = sf.openSession();
		
		//Comenzamos la transacción
		sesion.beginTransaction();
		
			sesion.save(des1);
			sesion.save(des2);
			sesion.save(vid1);
			sesion.save(vid2);
		
		
		sesion.getTransaction().commit();
		
		//Cerramos objetos
		sesion.close();
		sf.close();
	}

}
