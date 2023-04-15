package modelo;

// Representa un producto y nada mas
public class Producto {

	private String codigoBarras;
	private String nombre;
	private String marca;
	private String presentacion;
	private int cantidad;
	private String contenido;
	private String unidadMedida;
	private String categoria;
	private double precioVenta; // TODO este atributo no representa al producto
	private String descripcion;
	private int stockMaximo; // TODO este atributo no representa al producto
	private int stockMinimo; // TODO este atributo no representa al producto
	
	public Producto() {
		
	}
	
	public Producto(String codigoBarras, String nombre, String marca, String presentacion, int cantidad,
			String contenido, String unidadMedida, String categoria, double precioVenta, String descripcion,
			int stockMaximo, int stockMinimo) {
		super();
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.marca = marca;
		this.presentacion = presentacion;
		this.cantidad = cantidad;
		this.contenido = contenido;
		this.unidadMedida = unidadMedida;
		this.categoria = categoria;
		this.precioVenta = precioVenta;
		this.descripcion = descripcion;
		this.stockMaximo = stockMaximo;
		this.stockMinimo = stockMinimo;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	
}
