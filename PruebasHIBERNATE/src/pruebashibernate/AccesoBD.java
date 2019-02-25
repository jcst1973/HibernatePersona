package pruebashibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class AccesoBD {
			private static SessionFactory sessionFactory;
			public static void setUp() throws Exception {
			// A SessionFactory is set up once for an application!
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			try {
				sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			}
			catch (Exception e) {
				// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				System.out.println(e.getMessage());
				StandardServiceRegistryBuilder.destroy( registry );
			}
		}
		public static void insertarPersona(Persona p)
		{
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			s.save(p);
			s.getTransaction().commit();
			
			/*Query consulta=s.createQuery("FROM Persona WHERE nombre='pepe'");
			List<Persona>lista=consulta.list();
			for (Persona persona : lista) {
				System.out.println(persona.getNombre()+" "+persona);
				
			}*/
			
			
			
		}
		public static List<Persona> devolverPersonas(String nombre)
		{
			//Con BD usamos SQL->Hablo de tablas y de campos de tabla
			//Con Hibernate usamos HQL->Hablo de objetos(entidades) y de propiedades.
			Session s=sessionFactory.openSession();
			Query q=null;
			if (nombre.equals(""))
			{
				 q=s.createQuery("FROM Persona");
			}
			else
			{
				q=s.createQuery("FROM Persona WHERE nombre='"+nombre+"'");	
			}
			
			List<Persona> lista=q.list();
			return lista;
			
		}
		
}

