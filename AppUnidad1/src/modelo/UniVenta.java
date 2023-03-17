package modelo;

public class UniVenta {
	private String codigoBarra;
	private int cantidad;
	private float precio;
	public UniVenta(String codigoBarra, float precio) {
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
