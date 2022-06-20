package POO_Java_Colecciones;

public class Perro extends Mascota {
	private String raza;

	public Perro(String nombre, int anyos, String raza) {
		super(nombre, anyos);
		this.raza=raza;
	}
	
	public Perro(String nombre, int anyos)
	{
		super(nombre, anyos);
		this.raza="Golden Retriever";
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", nombre=" + nombre + ", anyos=" + anyos + "]";
	}
	
	public String hablar() {
		return this.nombre+" ladra";
	}

}
