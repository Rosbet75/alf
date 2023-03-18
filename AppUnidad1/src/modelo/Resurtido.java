package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Resurtido {
	private static int gen = 0;
	private int folio;
	private ArrayList<RenglonResurtido> articulos;
	private LocalDate fecha;
	private String proveedor;
	public Resurtido(ArrayList<RenglonResurtido> articulos, String proveedor) {
		super();
		this.folio = gen;
		count();
		this.articulos = articulos;
		this.fecha = LocalDate.now();
		this.proveedor = proveedor;
	}
	private static void count() {
		//usado para generar folios
		gen++;
	}
	public static int getGen() {
		return gen;
	}
	public static void setGen(int gen) {
		Resurtido.gen = gen;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public ArrayList<RenglonResurtido> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<RenglonResurtido> articulos) {
		this.articulos = articulos;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public float getTotal() {
		//retorna el total de todo el resurtido
		float total = 0;
		for(RenglonResurtido dual: articulos) {
			total += dual.getPrecioTotal();
		}
		return total;
	}
}
