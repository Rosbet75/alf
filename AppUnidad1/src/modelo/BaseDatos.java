package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

	private static BaseDatos baseDatos;
	private String nombre;
	private String usuario;
	private String password;
	private String protocolo;
	private String driver;
	private Connection conexion;
	private boolean isConnected;
	private BaseDatos(String nombre, String usuario, String password, String protocolo, String driver) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
		this.protocolo = protocolo;
		this.driver = driver;
		try {
			Class.forName(this.driver);
			this.conexion = DriverManager.getConnection(this.protocolo + nombre, usuario, password);
			isConnected = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return conexion;
	}
	public boolean isConnected() {
		return isConnected;
	}
	public void close() {
		if(isConnected) {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static BaseDatos newInstance(String nombre, String usuario, String password, String protocolo, String driver) {
		return baseDatos != null ? baseDatos : new BaseDatos(nombre, usuario, password, protocolo, driver);
		
	}
}
