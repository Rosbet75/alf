package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Venta {
	private static int gen = 0;
	private int folio;
	private ArrayList<UniVenta> lista;
	private Date fecha;
	public Venta(int folio, ArrayList<UniVenta> lista, Date fecha) {
		super();
		this.folio = gen;
		count();
		this.lista = lista;
		this.fecha = fecha;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public float total() {
		float total = 0;
		for(UniVenta uni: lista) {
			total += uni.getPrecioTotal();
		}
		return total;
	}
	
}