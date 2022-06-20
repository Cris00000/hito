package POO_Java_Colecciones;

public class Mascota {
	protected String nombre;
	protected int anyos;
	public Mascota(String nombre, int anyos) {
		super();
		this.nombre = nombre;
		this.anyos = anyos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAnyos() {
		return anyos;
	}
	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}
	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", anyos=" + anyos + "]";
	}
	
	public String hablar() {
		return this.nombre+" hace sus sonidos";
	}
}
