package pruebas;

public class Ayuda {

	public static void main(String[] args) {
		String ayuda = "ayuda ";
		while(true) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ayuda);
			ayuda += ayuda;
			System.out.println("ya no quiero programar");
		}
	}
}
