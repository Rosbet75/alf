package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import modelo.Producto;
import modelo.Seleccion;
import modelo.SeleccionVenta;

public class PanelVenta extends JPanel {
	private JTextField busquedaField;
	private JTable table;
	private JTable table_1;
	private JCheckBox chckbxBusquedaPorCodigo;
	private JSpinner spinner;
	private JButton btnAgregarAlCarrito;
	private List<Producto> listaProductos;
	private List<SeleccionVenta> listaSeleccion;
	private int selectedRow;
	private boolean allow;

	/**
	 * Create the panel.
	 */
	public PanelVenta(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
		this.listaSeleccion = new ArrayList<SeleccionVenta>();
		this.allow = false;
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 89, 0, 80, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombreDeProducto = new JLabel("Nombre de producto");
		GridBagConstraints gbc_lblNombreDeProducto = new GridBagConstraints();
		gbc_lblNombreDeProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeProducto.gridx = 2;
		gbc_lblNombreDeProducto.gridy = 0;
		add(lblNombreDeProducto, gbc_lblNombreDeProducto);
		
		chckbxBusquedaPorCodigo = new JCheckBox("Busqueda por codigo");
		GridBagConstraints gbc_chckbxBusquedaPorCodigo = new GridBagConstraints();
		gbc_chckbxBusquedaPorCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxBusquedaPorCodigo.gridx = 4;
		gbc_chckbxBusquedaPorCodigo.gridy = 0;
		add(chckbxBusquedaPorCodigo, gbc_chckbxBusquedaPorCodigo);
		
		busquedaField = new JTextField();
		GridBagConstraints gbc_busquedaField = new GridBagConstraints();
		gbc_busquedaField.insets = new Insets(0, 0, 5, 5);
		gbc_busquedaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_busquedaField.gridx = 2;
		gbc_busquedaField.gridy = 1;
		add(busquedaField, gbc_busquedaField);
		busquedaField.setColumns(10);
		
		JLabel lblProductosDisponibles = new JLabel("Productos Disponibles");
		GridBagConstraints gbc_lblProductosDisponibles = new GridBagConstraints();
		gbc_lblProductosDisponibles.insets = new Insets(0, 0, 5, 0);
		gbc_lblProductosDisponibles.gridx = 4;
		gbc_lblProductosDisponibles.gridy = 1;
		add(lblProductosDisponibles, gbc_lblProductosDisponibles);
		
		spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 2;
		add(spinner, gbc_spinner);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 4;
		gbc_table.gridy = 2;
		add(table, gbc_table);
		
		JLabel lblProductosEnSeleccion = new JLabel("Productos en Seleccion");
		GridBagConstraints gbc_lblProductosEnSeleccion = new GridBagConstraints();
		gbc_lblProductosEnSeleccion.insets = new Insets(0, 0, 5, 0);
		gbc_lblProductosEnSeleccion.gridx = 4;
		gbc_lblProductosEnSeleccion.gridy = 3;
		add(lblProductosEnSeleccion, gbc_lblProductosEnSeleccion);
		
		btnAgregarAlCarrito = new JButton("Agregar al carrito");
		GridBagConstraints gbc_btnAgregarAlCarrito = new GridBagConstraints();
		gbc_btnAgregarAlCarrito.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregarAlCarrito.gridx = 2;
		gbc_btnAgregarAlCarrito.gridy = 4;
		add(btnAgregarAlCarrito, gbc_btnAgregarAlCarrito);
		
		table_1 = new JTable();
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.insets = new Insets(0, 0, 5, 0);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 4;
		gbc_table_1.gridy = 4;
		add(table_1, gbc_table_1);

	}
	private class ModeloTabla extends AbstractTableModel {

		private Object[][] productos;
		private final String[] ENCABEZADOS = { "Codigo de Barras", "Nombre", "Marca", "Presentacion", "Cantidad",
				"Contenido", "Unidad de medida", "Categoria", "Precio de venta", "Descripcion", "Stock maximo",
		"Stock minimo" };
		private int size;
		
		public ModeloTabla(List<Producto> listaProductos) {
			size = listaProductos.size();
			productos = new Object[listaProductos.size()][12];
			if(listaProductos.size() != 0) {
				for (int i = 0; i < listaProductos.size(); i++) {
					//System.out.println(listaProductos.get(i).toString());
					productos[i][0] = listaProductos.get(i).getCodigoBarras();
					productos[i][1] = listaProductos.get(i).getNombre();
					productos[i][2] = listaProductos.get(i).getMarca();
					productos[i][3] = listaProductos.get(i).getPresentacion();
					productos[i][4] = listaProductos.get(i).getCantidad();
					productos[i][5] = listaProductos.get(i).getContenido();
					productos[i][6] = listaProductos.get(i).getUnidadMedida();
					productos[i][7] = listaProductos.get(i).getCategoria();
					productos[i][8] = listaProductos.get(i).getPrecioVenta();
					productos[i][9] = listaProductos.get(i).getDescripcion();
					productos[i][10] = listaProductos.get(i).getStockMaximo();
					productos[i][11] = listaProductos.get(i).getStockMinimo();
				}
			}
		}

		@Override
		public String getColumnName(int columnIndex) {
			return ENCABEZADOS[columnIndex];
		}

		@Override
		public int getRowCount() {
			return this.size;
		}

		@Override
		public int getColumnCount() {
			return 12;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return productos[rowIndex][columnIndex];
		}

	}
	private class ModeloSeleccion extends AbstractTableModel {

		private Object[][] productos;
		private final String[] ENCABEZADOS = {"Codigo de Barras", "Cantidad", "Precio", "Caducidad"};
		private int size;
		public ModeloSeleccion(List<Seleccion> listaSeleccion) {
			productos = new Object[listaSeleccion.size()][4];
			size = listaSeleccion.size();
			if(listaSeleccion.size() != 0) {
				for (int i = 0; i < listaSeleccion.size(); i++) {
					productos[i][0] = listaSeleccion.get(i).getProducto().getCodigoBarras();
					productos[i][1] = listaSeleccion.get(i).getCantidad();
					productos[i][2] = listaSeleccion.get(i).getPrecio();
					productos[i][3] = listaSeleccion.get(i).getDate().toString();
				}
			}
		}

		@Override
		public String getColumnName(int columnIndex) {
			return ENCABEZADOS[columnIndex];
		}

		@Override
		public int getRowCount() {
			return this.size;
		}

		@Override
		public int getColumnCount() {
			return ENCABEZADOS.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return productos[rowIndex][columnIndex];
		}

	}
}
