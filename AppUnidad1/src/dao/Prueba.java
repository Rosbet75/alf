package dao;

import static utilidades.UtilityDB.getDatabaseParameters;

import modelo.BaseDatos;
import modelo.Producto;
import registros.DBRecord;
public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBRecord rec = getDatabaseParameters();
		BaseDatos base = BaseDatos.newInstance(rec.Nombre_BD(), rec.usuario(), rec.password(), rec.protocolo(), rec.driver());
		System.out.println(base.isConnected());
		TablaProductos tabla = new TablaProductos(base.getConnection());
		tabla.guardar(new Producto("234124363427856","nombre","unamarca","pres",234,"cont", "gr","cat",453.44,"asdfasdf",390,4 ));
	}

}
