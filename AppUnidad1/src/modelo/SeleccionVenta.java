package modelo;

import java.util.Date;

public class SeleccionVenta {
	private Producto producto;
	private int cantidad;
	private int precio;
	private Date date;
	
	
	public SeleccionVenta(Producto producto, int cantidad, int precio, Date date) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.date = date;
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
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
