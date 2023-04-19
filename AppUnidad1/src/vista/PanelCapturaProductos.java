package vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelo.Producto;

// Guardar las DESCRIPCIONES en la clase CATALOGO
public class PanelCapturaProductos extends JPanel {
	private JTextField txt_codigoBarras;
	private JTextField txt_nombre;
	private JTextField txt_descripcion;
	private JComboBox cb_marca;
	private JComboBox cb_presentacion;
	private JSpinner sp_cantidad;
	private JSpinner sp_contenido;
	private JComboBox cb_unidadMedida;
	private JComboBox cb_categoria;
	private JSpinner sp_precioVenta;
	private JSpinner sp_stockMax;
	private JSpinner sp_stockMin;

	public PanelCapturaProductos() {
		setLayout(new GridLayout(7, 0, 0, 0));

		JPanel pan_1 = new JPanel();
		pan_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pan_1.setBackground(UIManager.getColor("Panel.background"));
		add(pan_1);

		JLabel lbl_codigoBarras = new JLabel("Codigo de barras");
		lbl_codigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_1.add(lbl_codigoBarras);
		

		txt_codigoBarras = new JTextField();
		txt_codigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_1.add(txt_codigoBarras);
		txt_codigoBarras.setColumns(10);
		txt_codigoBarras.addKeyListener(new KeyAdapter() {
			   public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  // ignore event
			      }
			   }
			});

		JPanel pan_2 = new JPanel();
		pan_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pan_2.setBackground(UIManager.getColor("Panel.background"));
		add(pan_2);

		JLabel lbl_nombre = new JLabel("Nombre");
		lbl_nombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_2.add(lbl_nombre);

		txt_nombre = new JTextField();
		txt_nombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_2.add(txt_nombre);
		txt_nombre.setColumns(10);

		JLabel lbl_marca = new JLabel("Marca");
		lbl_marca.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_2.add(lbl_marca);

		cb_marca = new JComboBox();
		cb_marca.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_2.add(cb_marca);

		JPanel pan_3 = new JPanel();
		pan_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pan_3.setBackground(UIManager.getColor("Panel.background"));
		add(pan_3);

		JLabel lbl_presentacion = new JLabel("Presentacion");
		lbl_presentacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_3.add(lbl_presentacion);

		cb_presentacion = new JComboBox();
		cb_presentacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_3.add(cb_presentacion);

		JLabel lbl_cantidad = new JLabel("Cantidad");
		lbl_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_3.add(lbl_cantidad);

		sp_cantidad = new JSpinner();
		sp_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_3.add(sp_cantidad);

		JPanel pan_4 = new JPanel();
		pan_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pan_4.setBackground(UIManager.getColor("Panel.background"));
		add(pan_4);

		JLabel lbl_contenido = new JLabel("Contenido");
		lbl_contenido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_4.add(lbl_contenido);

		sp_contenido = new JSpinner();
		sp_contenido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_4.add(sp_contenido);

		JLabel lbl_unidadMedida = new JLabel("Unidad de medida");
		lbl_unidadMedida.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_4.add(lbl_unidadMedida);

		cb_unidadMedida = new JComboBox();
		cb_unidadMedida.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_4.add(cb_unidadMedida);

		JPanel pan_5 = new JPanel();
		pan_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pan_5.setBackground(UIManager.getColor("Panel.background"));
		add(pan_5);

		JLabel lbl_categoria = new JLabel("Categoria");
		lbl_categoria.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_5.add(lbl_categoria);

		cb_categoria = new JComboBox();
		cb_categoria.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_5.add(cb_categoria);

		JLabel lbl_precioVenta = new JLabel("Precio de venta");
		lbl_precioVenta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_5.add(lbl_precioVenta);

		sp_precioVenta = new JSpinner();
		sp_precioVenta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_5.add(sp_precioVenta);

		JPanel pan_6 = new JPanel();
		pan_6.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pan_6.setBackground(UIManager.getColor("Panel.background"));
		add(pan_6);

		JLabel lbl_descripcion = new JLabel("Descripcion");
		lbl_descripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_6.add(lbl_descripcion);

		txt_descripcion = new JTextField();
		txt_descripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_6.add(txt_descripcion);
		txt_descripcion.setColumns(10);

		JPanel pan_7 = new JPanel();
		pan_7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pan_7.setBackground(UIManager.getColor("Panel.background"));
		add(pan_7);

		JLabel lbl_stockMax = new JLabel("Stock max.");
		lbl_stockMax.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_7.add(lbl_stockMax);

		sp_stockMax = new JSpinner();
		sp_stockMax.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_7.add(sp_stockMax);

		JLabel lbl_stockMin = new JLabel("Stock min.");
		lbl_stockMin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_7.add(lbl_stockMin);

		sp_stockMin = new JSpinner();
		sp_stockMin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan_7.add(sp_stockMin);
		
		ArrayList<String> categorias = new ArrayList<>();
		ArrayList<String> unidades = new ArrayList<>();
		ArrayList<String> marcas = new ArrayList<>();
		ArrayList<String> presentacion = new ArrayList<>();
		File file = new File("/home/ozymandias/git/alf/AppUnidad1/src/recursos/files/Marcas.txt");
		try {
			Scanner scanner = new Scanner(file);
			do {
				cb_marca.addItem(scanner.nextLine().trim());
				
			}while(scanner.hasNext());
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file = new File("/home/ozymandias/git/alf/AppUnidad1/src/recursos/files/Presentacion.txt");
		try {
			Scanner scanner = new Scanner(file);
			do {
				cb_presentacion.addItem(scanner.nextLine().trim());
			} while(scanner.hasNext());
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file = new File("/home/ozymandias/git/alf/AppUnidad1/src/recursos/files/Tipos.txt");
		try {
			Scanner scanner = new Scanner(file);
			do {
				cb_categoria.addItem(scanner.nextLine().trim());
				
			} while(scanner.hasNext());
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		file = new File("/home/ozymandias/git/alf/AppUnidad1/src/recursos/files/Unidadmedida.txt");
		try {
			Scanner scanner = new Scanner(file);
			do {
				cb_unidadMedida.addItem(scanner.nextLine().trim());
			} while(scanner.hasNext());
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Producto getProducto() {
		String codigoBarras = txt_codigoBarras.getText();
		String nombre = txt_nombre.getText();
		String marca =(String) cb_marca.getSelectedItem();
		String presentacion = (String) cb_presentacion.getSelectedItem();
		int cantidad = Integer.parseInt(sp_cantidad.getValue().toString());
		String contenido = sp_contenido.getValue().toString();
		String unidadMedida = cb_unidadMedida.getSelectedItem().toString();
		String categoria = cb_categoria.getSelectedItem().toString();
		double precioVenta = Double.parseDouble(sp_precioVenta.getValue().toString());
		String descripcion = txt_descripcion.getText();
		int stockMaximo = Integer.parseInt(sp_stockMax.getValue().toString());
		int stockMinimo = Integer.parseInt(sp_stockMin.getValue().toString());
		
		return new Producto(codigoBarras, nombre, marca, presentacion, cantidad, contenido, unidadMedida, categoria, precioVenta,descripcion,stockMaximo, stockMinimo);
				
	}
	public void clear() {
		txt_codigoBarras.setText("");
		txt_nombre.setText("");
		txt_descripcion.setText("");
		cb_categoria.setSelectedIndex(0);
		cb_marca.setSelectedIndex(0);
		sp_cantidad.setValue(0);
		sp_contenido.setValue(0);
		cb_unidadMedida.setSelectedIndex(0);
		cb_categoria.setSelectedIndex(0);
		sp_precioVenta.setValue(0);
		sp_stockMax.setValue(0);
		sp_stockMin.setValue(0);
	}
	

}
