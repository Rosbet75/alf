package modelo;

import java.time.LocalDate;

public class UniVenta {
	private String codigoBarra;
	private int cantidad;
	private float precio;
	private LocalDate fechaCad;
	public UniVenta(String codigoBarra, float precio) {
		super();
		this.fechaCad = LocalDate.now();
		this.codigoBarra = codigoBarra;
		this.precio = precio;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getPrecioTotal() {
		return precio * cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public LocalDate getFechaCad() {
		return fechaCad;
	}
	public void setFechaCad(LocalDate fechaCad) {
		this.fechaCad = fechaCad;
	}
	
}
