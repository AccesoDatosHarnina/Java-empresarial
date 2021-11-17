package segundo;

import java.util.LinkedList;

public class Accesor {
	public static void main(String[] args) {
		LinkedList<PersonaDTO> personasDtos = null;
		PersonaDAO personaDAO=new PersonaDAO();
		personasDtos=personaDAO.findAll();
		personasDtos.stream().forEach((per) -> {
			System.out.println(per.toString());
		});
	}
}
