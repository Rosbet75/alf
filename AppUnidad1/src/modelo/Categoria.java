package modelo;

// Representa a que categoria pertenece un producto
public class Categoria {

	private String nombre;
	private boolean perecedero;

	public Categoria(String nombre, boolean perecedero) {
		this.nombre = nombre;
		this.perecedero = perecedero;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isPerecedero() {
		return perecedero;
	}

}
