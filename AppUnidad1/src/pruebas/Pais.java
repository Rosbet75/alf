package pruebas;

import java.io.Serializable;

public class Pais implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nombre;
	private String capital;
	private int extensionTerritorial;
	private int habitantes;
	private String continente;

	public Pais(String codigo, String nombre, String capital, int extensionTerritorial, int habitantes,
			String continente) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.capital = capital;
		this.extensionTerritorial = extensionTerritorial;
		this.habitantes = habitantes;
		this.continente = continente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getExtensionTerritorial() {
		return extensionTerritorial;
	}

	public void setExtensionTerritorial(int extensionTerritorial) {
		this.extensionTerritorial = extensionTerritorial;
	}

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	@Override
	public String toString() {
		return "Pais [codigo=" + codigo + ", nombre=" + nombre + ", capital=" + capital + ", extensionTerritorial="
				+ extensionTerritorial + ", habitantes=" + habitantes + ", continente=" + continente + "]";
	}

}
