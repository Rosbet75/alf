package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOTextFile {

	public static List<String> getFileElements(File archivo) {
		var datos = new ArrayList<String>();
		try {
			Scanner entrada = new Scanner(archivo);
			while (entrada.hasNext()) {
				String dato = entrada.nextLine();
				datos.add(dato);
			}
			entrada.close();
			return datos;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
