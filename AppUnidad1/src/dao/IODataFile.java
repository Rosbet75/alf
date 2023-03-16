package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IODataFile {

	public static void writeObjectToFile(String ruta, Object obj) {

		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {

			fos = new FileOutputStream(ruta);
			out = new ObjectOutputStream(fos);
			out.writeObject(obj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static Object readObjectFromFile(String ruta) throws Exception {

		ObjectInputStream in = null;
		FileInputStream fis = null;

		try {

			fis = new FileInputStream(ruta);
			in = new ObjectInputStream(fis);
			Object obj = in.readObject();
			return obj;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally { // Antes de ejecutar el return se ejecuta el bloque de finally
			if (fis != null) {
				in.close();
			}

			if (in != null) {
				in.close();
			}
		}

		throw new Exception("EVERYTHING WENT WRONG"); // TODO Fail fast reacomodar esto

	}

}
