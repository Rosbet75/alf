package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Venta implements Serializable{
	private static int gen = 0;
	private int folio;
	private ArrayList<UniVenta> lista;
	private LocalDate fecha;
	public Venta() {
		
	}
	public Venta(ArrayList<UniVenta> lista) {
		super();
		this.folio = gen;
		count();
		this.lista = lista;
		this.fecha = LocalDate.now();
	}
	
	private void count() {
		gen++;
	}

	public static int getGen() {
		return gen;
	}

	public static void setGen(int gen) {
		Venta.gen = gen;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public ArrayList<UniVenta> getLista() {
		return lista;
	}

	public void setLista(ArrayList<UniVenta> lista) {
		this.lista = lista;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public float total() {
		float total = 0;
		for(UniVenta uni: lista) {
			total += uni.getPrecioTotal();
		}
		return total;
	}
	@Override
	public String toString() {
		return "Venta [folio=" + folio + ", lista=" + lista + ", fecha=" + fecha + "]";
	}
	
}
