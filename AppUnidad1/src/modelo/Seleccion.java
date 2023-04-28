package modelo;

import java.util.Date;

public class Seleccion {
	private Producto producto;
	private int cantidad;
	private double precio;
	private Date date;
	
	public Seleccion (Producto producto, int cantidad, double precio, Date date) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.date = date;
	}

	public Seleccion() {
		
	}
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
