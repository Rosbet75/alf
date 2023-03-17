package modelo;

import java.util.Date;

public class RenglonResurtido {
	private String codigoBarra;
	private int cantidad;
	private float precio;
	private Date fechaCad;
	
	
	public RenglonResurtido(String codigoBarra, int cantidad, float precio, Date fechaCad) {
		super();
		this.codigoBarra = codigoBarra;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fechaCad = fechaCad;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

}
