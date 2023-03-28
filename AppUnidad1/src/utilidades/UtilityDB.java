package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import registros.DBRecord;

public class UtilityDB {
	public static DBRecord getDatabaseParameters() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("resources/config.properties")));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		String nombre = properties.getProperty("NOMBRE_BD");
		String usuario = properties.getProperty("USUARIO");
		String password = properties.getProperty("PASSWORD");
		String protocolo = properties.getProperty("PROTOCOLO");
		String driver = properties.getProperty("DRIVER");
		
		
		return new DBRecord(nombre, usuario, password, protocolo, driver);
	}
}
