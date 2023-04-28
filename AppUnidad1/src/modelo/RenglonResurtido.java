package modelo;

import java.io.Serializable;
import java.util.Date;

public class RenglonResurtido implements Serializable {
	private String codigoBarra;
	private int cantidad;
	private double precio;
	private Date fechaCad;
	
	
	public RenglonResurtido(String codigoBarra, int cantidad, double precio, Date date) {
		super();
		this.codigoBarra = codigoBarra;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fechaCad = date;
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public double getPrecioTotal() {
		return precio * cantidad;
	}
	public Date getFechaCad() {
		return fechaCad;
	}
	public void setFechaCad(Date fechaCad) {
		this.fechaCad = fechaCad;
	}
	

}
