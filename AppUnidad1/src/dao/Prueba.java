package dao;

import static utilidades.UtilityDB.getDatabaseParameters;

import modelo.BaseDatos;
import registros.DBRecord;
public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBRecord rec = getDatabaseParameters();
		BaseDatos base = BaseDatos.newInstance(rec.Nombre_BD(), rec.usuario(), rec.password(), rec.protocolo(), rec.driver());
		System.out.println(base.isConnected());
	}

}
