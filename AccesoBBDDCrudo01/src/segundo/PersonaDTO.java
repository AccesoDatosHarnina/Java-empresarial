package segundo;

import java.util.Objects;

//POJO
public class PersonaDTO {

	private int id;
	private String nombreString;
	private String apellidoString;

	public PersonaDTO(int id, String apellidoString, String nombreString) {
		super();
		this.id = id;
		this.nombreString = nombreString;
		this.apellidoString = apellidoString;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreString() {
		return nombreString;
	}

	public void setNombreString(String nombreString) {
		this.nombreString = nombreString;
	}

	public String getApellidoString() {
		return apellidoString;
	}

	public void setApellidoString(String apellidoString) {
		this.apellidoString = apellidoString;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidoString, id, nombreString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaDTO other = (PersonaDTO) obj;
		return Objects.equals(apellidoString, other.apellidoString) && id == other.id
				&& Objects.equals(nombreString, other.nombreString);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombreString=" + nombreString + ", apellidoString=" + apellidoString + "]";
	}

}
