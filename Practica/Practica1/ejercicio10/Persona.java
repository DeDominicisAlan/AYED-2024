package ejercicio10;

public abstract class Persona {
	private String nombre;
	private int edad;
	private boolean esp;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, int edad, boolean esp) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.esp = esp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isEsp() {
		return esp;
	}

	public void setEsp(boolean esp) {
		this.esp = esp;
	}

	@Override
	public String toString() {
		return "Nombre:" + nombre + ", edad:" + edad + ", necesidad especial o movilidad reducida?" + esp + "]";
	}
	
	
	
}

