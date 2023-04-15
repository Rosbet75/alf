package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Producto;

public class TablaProductos {
	private Connection conexion;
	private Statement statement;
	public TablaProductos(Connection conexion) {
		this.conexion = conexion;
		try {
			statement=conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public String guardar(Producto producto) {
		String sql = "insert into producto(codbar,nombre,marca,presentacion,cantidad,contenido,uniMed,categoria,precioVenta,descripcion,stockMaximo,stockMinimo) values('"+
				producto.getCodigoBarras()+"','"+
				producto.getNombre()+"','"+
				producto.getMarca()+"','"+
				producto.getPresentacion()+"','"+
				producto.getCantidad()+"','"+
				producto.getContenido()+"','"+
				producto.getUnidadMedida()+"','"+
				producto.getCategoria()+"','"+
				producto.getPrecioVenta()+"','"+
				producto.getDescripcion()+"','"+
				producto.getStockMaximo()+"','"+
				producto.getStockMinimo()+"')";
				//				producto.getPrecioCompra()+"','"+
		//				product
		try {
			statement.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Ha sido agregado con exito");
			return "Producto registrado con exito";
		} catch(java.sql.SQLIntegrityConstraintViolationException e4) {
			JOptionPane.showMessageDialog(null, "Ya existe producto con ese codigo de barra");
			return e4.toString();
		}catch (SQLException e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
	public List<Producto> getAllElements(){
		ResultSet rs = statement.executeQuery("select * from producto");
		
		
	}
}
