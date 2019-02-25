package pruebashibernate;

import java.util.List;

public class HibernatePrincipal {

	public static void main(String[] args) {
		
		try {
			AccesoBD.setUp();
			Persona p=new Persona("ana", "glez", "ana@mail.com");
			AccesoBD.insertarPersona(p);
			List<Persona> lista=AccesoBD.devolverPersonas("ana");
			for (Persona persona : lista) {
				System.out.println("Nombre:"+persona.getNombre()+" "+persona.getApellido());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}

}
