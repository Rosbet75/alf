package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import modelo.Producto;

public class VentanaModificar extends JPanel {
	private JTextField nombre;
	private JTextField txt_descripcion;
	private JButton buscar;
	private JTextField busqueda;
	private JComboBox cb_marca;
	private JComboBox cb_presentacion;
	private JSpinner sp_stockMin;
	private JSpinner sp_stockMax;
	private JComboBox cb_categoria;
	private JSpinner sp_cantidad;
	private JSpinner sp_contenido;
	private JSpinner sp_precioVenta;
	private JComboBox cb_unidadMedida;
	private List<String> origen;
	private JList<String> list;
	private DefaultListModel modelx;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public VentanaModificar() {
		modelx = new DefaultListModel();
		origen = new ArrayList<>();
		scrollPane = new JScrollPane();
		list = new JList();
		scrollPane.setViewportView(list);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Producto ");
		add(lblNewLabel, "2, 2, 45, 1");
		
		busqueda = new JTextField();
		add(busqueda, "2, 4, 20, 1, fill, default");
		busqueda.setColumns(10);
		busqueda.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();  // ignore event
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				//list.setVisible(true);
				
				String filter = busqueda.getText().trim();
				modelx.removeAllElements();
				int y;
				if (filter.isEmpty()) {
					modelx.addAll(origen);
					y = 90;
				} else {
					var filteredElements = origen.stream().filter(s -> s.toLowerCase().contains(filter)).toList();
					modelx.addAll(filteredElements);
					y = 20 * filteredElements.size();
				}
				list.setModel(modelx);
				scrollPane.setVisible(true);
			}
		});
		
		this.add(scrollPane,"30, 14, 13, 11, fill, fill");
		scrollPane.setVisible(false);
		
		buscar = new JButton("Buscar");
		add(buscar, "4, 6, 15, 1");
		
		JSeparator separator = new JSeparator();
		add(separator, "2, 8, 44, 1");
		
		JLabel lblNombre = new JLabel("Nombre");
		add(lblNombre, "4, 10, 9, 1");
		
		JLabel lblCategoria = new JLabel("Categoria");
		add(lblCategoria, "14, 10, 9, 1");
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		add(separator_1, "26, 10, 1, 23");
		
		nombre = new JTextField();
		add(nombre, "4, 12, 9, 1, fill, default");
		nombre.setColumns(10);
		
		cb_categoria = new JComboBox();
		add(cb_categoria, "14, 12, 9, 1, fill, default");
		
		JLabel lblMarca = new JLabel("Marca");
		add(lblMarca, "4, 14, 9, 1");
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de Venta");
		add(lblPrecioDeVenta, "14, 14, 9, 1");
		
		cb_marca = new JComboBox();
		add(cb_marca, "4, 16, 9, 1, fill, default");
		
		sp_precioVenta = new JSpinner();
		add(sp_precioVenta, "14, 16, 9, 1");
		
		JLabel lblPresentacion = new JLabel("Presentacion");
		add(lblPresentacion, "4, 18, 9, 1");
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		add(lblDescripcion, "14, 18, 9, 1");
		
		cb_presentacion = new JComboBox();
		add(cb_presentacion, "4, 20, 9, 1, fill, default");
		
		txt_descripcion = new JTextField();
		add(txt_descripcion, "14, 20, 9, 1, fill, default");
		txt_descripcion.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		add(lblCantidad, "4, 22, 9, 1");
		
		JLabel lblStockMaximo = new JLabel("Stock Maximo");
		add(lblStockMaximo, "14, 22, 9, 1");
		
		sp_cantidad = new JSpinner();
		add(sp_cantidad, "4, 24, 9, 1");
		
		sp_stockMax = new JSpinner();
		add(sp_stockMax, "14, 24, 9, 1");
		
		JLabel lblContenido = new JLabel("Contenido");
		add(lblContenido, "4, 26, 9, 1");
		
		JLabel lblStockMinimo = new JLabel("Stock Minimo");
		add(lblStockMinimo, "14, 26, 9, 1");
		
		sp_contenido = new JSpinner();
		add(sp_contenido, "4, 28, 9, 1");
		
		sp_stockMin = new JSpinner();
		add(sp_stockMin, "14, 28, 9, 1");
		
		JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida");
		add(lblUnidadDeMedida, "4, 30, 9, 1");
		
		cb_unidadMedida = new JComboBox();
		add(cb_unidadMedida, "4, 32, 9, 1, fill, default");

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

	public void setProducto(Producto producto) {
		//sp_contenido.setValue(Integer.valueOf(producto.getContenido()));
		nombre.setText(producto.getNombre());
		for(int i = 0; i<cb_categoria.getItemCount(); i++) {
			if(producto.getCategoria().equals(cb_categoria.getItemAt(i))) {
				cb_categoria.setSelectedIndex(i);
				break;
			}
		}
		for(int i = 0; i<cb_marca.getItemCount(); i++) {
			if(producto.getCategoria().equals(cb_marca.getItemAt(i))) {
				cb_marca.setSelectedIndex(i);
				break;
			}
		}
		sp_precioVenta.setValue((producto.getPrecioVenta()));
		for(int i = 0; i<cb_presentacion.getItemCount(); i++) {
			if(producto.getCategoria().equals(cb_presentacion.getItemAt(i))) {
				cb_presentacion.setSelectedIndex(i);
				break;
			}
		}
		txt_descripcion.setText(producto.getDescripcion());
		sp_stockMax.setValue(producto.getStockMaximo());
		sp_stockMin.setValue(producto.getStockMinimo());
		sp_contenido.setValue(producto.getContenido());
		sp_cantidad.setValue(producto.getCantidad());
		for(int i = 0; i<cb_unidadMedida.getItemCount(); i++) {
			if(producto.getCategoria().equals(cb_unidadMedida.getItemAt(i))) {
				cb_unidadMedida.setSelectedIndex(i);
				break;
			}
		}
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}


	public JTextField getDescripcion() {
		return txt_descripcion;
	}

	public void setDescripcion(JTextField descripcion) {
		this.txt_descripcion = descripcion;
	}

	public JTextField getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(JTextField busqueda) {
		this.busqueda = busqueda;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}
	
	public JTextField getTxt_descripcion() {
		return txt_descripcion;
	}

	public void setTxt_descripcion(JTextField txt_descripcion) {
		this.txt_descripcion = txt_descripcion;
	}

	public JComboBox getCb_marca() {
		return cb_marca;
	}

	public void setCb_marca(JComboBox cb_marca) {
		this.cb_marca = cb_marca;
	}

	public JComboBox getCb_presentacion() {
		return cb_presentacion;
	}

	public void setCb_presentacion(JComboBox cb_presentacion) {
		this.cb_presentacion = cb_presentacion;
	}

	public JSpinner getSp_stockMin() {
		return sp_stockMin;
	}

	public void setSp_stockMin(JSpinner sp_stockMin) {
		this.sp_stockMin = sp_stockMin;
	}

	public JSpinner getSp_stockMax() {
		return sp_stockMax;
	}

	public void setSp_stockMax(JSpinner sp_stockMax) {
		this.sp_stockMax = sp_stockMax;
	}

	public JComboBox getCb_categoria() {
		return cb_categoria;
	}

	public void setCb_categoria(JComboBox cb_categoria) {
		this.cb_categoria = cb_categoria;
	}

	public JSpinner getSp_cantidad() {
		return sp_cantidad;
	}

	public void setSp_cantidad(JSpinner sp_cantidad) {
		this.sp_cantidad = sp_cantidad;
	}

	public JSpinner getSp_contenido() {
		return sp_contenido;
	}

	public void setSp_contenido(JSpinner sp_contenido) {
		this.sp_contenido = sp_contenido;
	}

	public JSpinner getSp_precioVenta() {
		return sp_precioVenta;
	}

	public void setSp_precioVenta(JSpinner sp_precioVenta) {
		this.sp_precioVenta = sp_precioVenta;
	}

	public JComboBox getCb_unidadMedida() {
		return cb_unidadMedida;
	}

	public void setCb_unidadMedida(JComboBox cb_unidadMedida) {
		this.cb_unidadMedida = cb_unidadMedida;
	}
	

	public List<String> getOrigen() {
		return origen;
	}

	public void setOrigen(List<String> origen) {
		this.origen = origen;
	}

	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public DefaultListModel getModelx() {
		return modelx;
	}

	public void setModelx(DefaultListModel modelx) {
		this.modelx = modelx;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public Producto getProducto() {
		String codigoBarras = busqueda.getText().trim();
		String nombre = this.nombre.getText();
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
}
