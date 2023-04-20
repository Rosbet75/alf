package vista;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import modelo.Producto;

public class VentanaConsulta extends JPanel {
	private JTextField busqueda;
	private JTextField cajaNombre;
	private JTextField cajaMarca;
	private JTextField cajaPresentacion;
	private JTextField cajaCantidad;
	private JTextField cajaContenido;
	private JTextField cajaUnidadMedida;
	private JTextField cajaCategoria;
	private JTextField cajaPrecioVenta;
	private JTextField cajaDescripcion;
	private JTextField cajaStockMaximo;
	private JTextField cajaStockMinimo;
	private JButton botonBuscar;
	private JScrollPane listaOpciones;
	private JList<String> origen;
	/**
	 * Create the panel.
	 */
	public VentanaConsulta() {
		origen = new JList<>();
		
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Producto ");
		add(lblNewLabel, "2, 2, 45, 1");
		
		busqueda = new JTextField();
		busqueda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		add(busqueda, "2, 4, 20, 1, fill, default");
		busqueda.setColumns(10);
		busqueda.addKeyListener(new KeyAdapter() {
			   public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  // ignore event
			      }
			   }
			});
		
		botonBuscar = new JButton("Buscar");
		add(botonBuscar, "4, 6, 15, 1");
		
		JSeparator separator = new JSeparator();
		add(separator, "2, 8, 44, 1");
		
		JLabel lblNombre = new JLabel("Nombre");
		add(lblNombre, "4, 10, 9, 1");
		
		JLabel lblCategoria = new JLabel("Categoria");
		add(lblCategoria, "14, 10, 9, 1");
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		add(separator_1, "26, 10, 1, 23");
		
		cajaNombre = new JTextField();
		cajaNombre.setEditable(false);
		add(cajaNombre, "4, 12, 9, 1, fill, default");
		cajaNombre.setColumns(10);
		
		cajaCategoria = new JTextField();
		cajaCategoria.setEditable(false);
		add(cajaCategoria, "14, 12, 9, 1, fill, default");
		cajaCategoria.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		add(lblMarca, "4, 14, 9, 1");
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de Venta");
		add(lblPrecioDeVenta, "14, 14, 9, 1");
		
		cajaMarca = new JTextField();
		cajaMarca.setEditable(false);
		add(cajaMarca, "4, 16, 9, 1, fill, default");
		cajaMarca.setColumns(10);
		
		cajaPrecioVenta = new JTextField();
		cajaPrecioVenta.setEditable(false);
		add(cajaPrecioVenta, "14, 16, 9, 1, fill, default");
		cajaPrecioVenta.setColumns(10);
		
		JLabel lblPresentacion = new JLabel("Presentacion");
		add(lblPresentacion, "4, 18, 9, 1");
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		add(lblDescripcion, "14, 18, 9, 1");
		
		cajaPresentacion = new JTextField();
		cajaPresentacion.setEditable(false);
		add(cajaPresentacion, "4, 20, 9, 1, fill, default");
		cajaPresentacion.setColumns(10);
		
		cajaDescripcion = new JTextField();
		cajaDescripcion.setEditable(false);
		add(cajaDescripcion, "14, 20, 9, 1, fill, default");
		cajaDescripcion.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		add(lblCantidad, "4, 22, 9, 1");
		
		JLabel lblStockMaximo = new JLabel("Stock Maximo");
		add(lblStockMaximo, "14, 22, 9, 1");
		
		cajaCantidad = new JTextField();
		cajaCantidad.setEditable(false);
		add(cajaCantidad, "4, 24, 9, 1, fill, default");
		cajaCantidad.setColumns(10);
		
		cajaStockMaximo = new JTextField();
		cajaStockMaximo.setEditable(false);
		add(cajaStockMaximo, "14, 24, 9, 1, fill, default");
		cajaStockMaximo.setColumns(10);
		
		JLabel lblContenido = new JLabel("Contenido");
		add(lblContenido, "4, 26, 9, 1");
		
		JLabel lblStockMinimo = new JLabel("Stock Minimo");
		add(lblStockMinimo, "14, 26, 9, 1");
		
		cajaContenido = new JTextField();
		cajaContenido.setEditable(false);
		add(cajaContenido, "4, 28, 9, 1, fill, default");
		cajaContenido.setColumns(10);
		
		cajaStockMinimo = new JTextField();
		cajaStockMinimo.setEditable(false);
		add(cajaStockMinimo, "14, 28, 9, 1, fill, default");
		cajaStockMinimo.setColumns(10);
		
		JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida");
		add(lblUnidadDeMedida, "4, 30, 9, 1");
		
		cajaUnidadMedida = new JTextField();
		cajaUnidadMedida.setEditable(false);
		add(cajaUnidadMedida, "4, 32, 9, 1, fill, default");
		cajaUnidadMedida.setColumns(10);

	}
	public void setConsulta(Producto producto) {
//		private JTextField busqueda;
//		private JTextField cajaNombre;
//		private JTextField cajaMarca;
//		private JTextField cajaPresentacion;
//		private JTextField cajaCantidad;
//		private JTextField cajaContenido;
//		private JTextField cajaUnidadMedida;
//		private JTextField cajaCategoria;
//		private JTextField cajaPrecioVenta;
//		private JTextField cajaDescripcion;
//		private JTextField cajaStockMaximo;
//		private JTextField cajaStockMinimo;
//		private JCheckBox chkBusquedaCodigo;
//		private JButton botonBuscar;
		cajaNombre.setText(producto.getNombre());
		cajaMarca.setText(producto.getMarca());
		cajaPresentacion.setText(producto.getPresentacion());
		cajaCantidad.setText(String.valueOf(producto.getCantidad()));
		cajaContenido.setText(producto.getContenido());
		cajaUnidadMedida.setText(producto.getUnidadMedida());
		cajaCategoria.setText(producto.getCategoria());
		cajaPrecioVenta.setText(String.valueOf(producto.getPrecioVenta()));
		cajaDescripcion.setText(producto.getDescripcion());
		cajaStockMaximo.setText(String.valueOf(producto.getStockMaximo()));
		cajaStockMinimo.setText(String.valueOf(producto.getStockMinimo()));
	}
	public JTextField getBusqueda() {
		return busqueda;
	}
	public void setBusqueda(JTextField busqueda) {
		this.busqueda = busqueda;
	}
	public JTextField getCajaNombre() {
		return cajaNombre;
	}
	public void setCajaNombre(JTextField cajaNombre) {
		this.cajaNombre = cajaNombre;
	}
	public JTextField getCajaMarca() {
		return cajaMarca;
	}
	public void setCajaMarca(JTextField cajaMarca) {
		this.cajaMarca = cajaMarca;
	}
	public JTextField getCajaPresentacion() {
		return cajaPresentacion;
	}
	public void setCajaPresentacion(JTextField cajaPresentacion) {
		this.cajaPresentacion = cajaPresentacion;
	}
	public JTextField getCajaCantidad() {
		return cajaCantidad;
	}
	public void setCajaCantidad(JTextField cajaCantidad) {
		this.cajaCantidad = cajaCantidad;
	}
	public JTextField getCajaContenido() {
		return cajaContenido;
	}
	public void setCajaContenido(JTextField cajaContenido) {
		this.cajaContenido = cajaContenido;
	}
	public JTextField getCajaUnidadMedida() {
		return cajaUnidadMedida;
	}
	public void setCajaUnidadMedida(JTextField cajaUnidadMedida) {
		this.cajaUnidadMedida = cajaUnidadMedida;
	}
	public JTextField getCajaCategoria() {
		return cajaCategoria;
	}
	public void setCajaCategoria(JTextField cajaCategoria) {
		this.cajaCategoria = cajaCategoria;
	}
	public JTextField getCajaPrecioVenta() {
		return cajaPrecioVenta;
	}
	public void setCajaPrecioVenta(JTextField cajaPrecioVenta) {
		this.cajaPrecioVenta = cajaPrecioVenta;
	}
	public JTextField getCajaDescripcion() {
		return cajaDescripcion;
	}
	public void setCajaDescripcion(JTextField cajaDescripcion) {
		this.cajaDescripcion = cajaDescripcion;
	}
	public JTextField getCajaStockMaximo() {
		return cajaStockMaximo;
	}
	public void setCajaStockMaximo(JTextField cajaStockMaximo) {
		this.cajaStockMaximo = cajaStockMaximo;
	}
	public JTextField getCajaStockMinimo() {
		return cajaStockMinimo;
	}
	public void setCajaStockMinimo(JTextField cajaStockMinimo) {
		this.cajaStockMinimo = cajaStockMinimo;
	}
	
	public JButton getBotonBuscar() {
		return botonBuscar;
	}
	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}
	public void fillList(ArrayList<Producto> listaProductos) {
		
	}
}
