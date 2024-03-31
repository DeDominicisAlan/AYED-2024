package ejercicio10;

public class Mujer extends Persona {
	private boolean embarazo;

	public Mujer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mujer(String nombre, int edad, boolean esp, boolean embarazo) {
		super(nombre, edad, esp);
		this.embarazo = embarazo;
	}

	public boolean estaEmbarazada() {
		return embarazo;
	}

	public void setEmbarazo(boolean embarazo) {
		this.embarazo = embarazo;
	}

	@Override
	public String toString() {
		return super.toString() + " Embarazo?" + embarazo;
	}
	
	

}
