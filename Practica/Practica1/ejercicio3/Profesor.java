package ejercicio3;

public class Profesor extends Persona{
	
	private char catedra;
	private String facultad;
	
	
	public Profesor() {
		// TODO Auto-generated constructor stub
	}


	public Profesor(String nombre, String apellido, String email, char catedra, String facultad) {
		super(nombre,apellido,email);
		this.catedra = catedra;
		this.facultad = facultad;
	}

	public char getCatedra() {
		return catedra;
	}


	public void setCatedra(char catedra) {
		this.catedra = catedra;
	}


	public String getFacultad() {
		return facultad;
	}


	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}


	public String tusDatos() {
		return super.toString() + " Catedra: " + getCatedra() + " Facultad: " + getFacultad();
	}

	
	
}
