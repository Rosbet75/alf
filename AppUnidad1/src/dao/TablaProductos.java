package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	public boolean existe (String filtro) {
		try {
			return statement.executeQuery("select * from producto where codbar_pro='"+filtro+"'").next();
		} catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	
	public String eliminar(String filtro) {

		String sentenciaSQL="delete from producto where codbar_pro="+filtro;
		try {
			int n = statement.executeUpdate(sentenciaSQL);

			return n== 1 ?"Exito": "Error al eliminar";
		} catch(java.sql.SQLIntegrityConstraintViolationException eFK){
			return eFK.toString();

		}catch (Exception e) {
			return e.toString();
		}
	}
	
	public List<Producto> getAllElements() {
		try {
			ResultSet rs = statement.executeQuery("select * from producto");
			List<Producto> productos = new ArrayList<>();
			
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setCodigoBarras(rs.getString("codbar_pro"));
				producto.setNombre(rs.getString("nom_pro"));
				producto.setMarca(rs.getString("marca_pro"));
				producto.setPresentacion(rs.getString("presen_pro"));
				producto.setContenido(rs.getString("contenido"));
				producto.setUnidadMedida(rs.getString("umedida_pro"));
				producto.setCantidad(rs.getInt("cant_pro"));
				producto.setCategoria(rs.getString("tipo_pro"));
				producto.setPrecioVenta(rs.getDouble("preven_pro"));
				producto.setDescripcion(rs.getString("des_pro"));
				producto.setStockMaximo(rs.getInt("stockmax_pro"));
				producto.setStockMinimo(rs.getInt("stockmin_pro"));
				
				productos.add(producto);
			}
			return productos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
