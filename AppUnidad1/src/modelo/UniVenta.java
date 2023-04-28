package modelo;

import java.io.Serializable;

public class UniVenta implements Serializable{
	private String codigoBarra;
	private int cantidad;
	private double precio;
	public UniVenta(String codigoBarra, int cantidad, double precio) {
		super();
		this.codigoBarra = codigoBarra;
		this.precio = precio;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public double getPrecioTotal() {
		return precio * cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
