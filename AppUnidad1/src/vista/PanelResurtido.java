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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import modelo.Producto;
import modelo.RenglonResurtido;
import modelo.Resurtido;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelResurtido extends JPanel {
	private JTextField busquedaField;
	private JTextField textField;
	private JCheckBox chckbxBusquedaPorCodigo;
	private JSpinner spinner;
	private JButton btnAgregarAlCarrito;

	//===========
	private ArrayList<RenglonResurtido> renglonresurtido;

	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JScrollPane scrollPane;
	private List<Producto> listaProductos;
	private int totalProductos;
	//private JTable tabla;
	private ModeloTabla modeloTabla;

	/**
	 * Create the panel.
	 */
	public PanelResurtido(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
		this.totalProductos = listaProductos.size();
		this.modeloTabla = new ModeloTabla();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 80, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNombreDeProducto = new JLabel("Nombre de producto");
		GridBagConstraints gbc_lblNombreDeProducto = new GridBagConstraints();
		gbc_lblNombreDeProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeProducto.gridx = 0;
		gbc_lblNombreDeProducto.gridy = 0;
		add(lblNombreDeProducto, gbc_lblNombreDeProducto);

		chckbxBusquedaPorCodigo = new JCheckBox("Busqueda por codigo");
		GridBagConstraints gbc_chckbxBusquedaPorCodigo = new GridBagConstraints();
		gbc_chckbxBusquedaPorCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxBusquedaPorCodigo.gridx = 1;
		gbc_chckbxBusquedaPorCodigo.gridy = 0;
		add(chckbxBusquedaPorCodigo, gbc_chckbxBusquedaPorCodigo);

		busquedaField = new JTextField();
		GridBagConstraints gbc_busquedaField = new GridBagConstraints();
		gbc_busquedaField.insets = new Insets(0, 0, 5, 5);
		gbc_busquedaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_busquedaField.gridx = 0;
		gbc_busquedaField.gridy = 1;
		add(busquedaField, gbc_busquedaField);
		busquedaField.setColumns(10);

		JLabel lblProductosDisponibles = new JLabel("Productos Disponibles");
		GridBagConstraints gbc_lblProductosDisponibles = new GridBagConstraints();
		gbc_lblProductosDisponibles.insets = new Insets(0, 0, 5, 0);
		gbc_lblProductosDisponibles.gridx = 1;
		gbc_lblProductosDisponibles.gridy = 1;
		add(lblProductosDisponibles, gbc_lblProductosDisponibles);

		spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 0;
		gbc_spinner.gridy = 2;
		add(spinner, gbc_spinner);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable(modeloTabla);
		scrollPane.setViewportView(table);

		JLabel lblPrecio = new JLabel("Precio");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 3;
		add(lblPrecio, gbc_lblPrecio);

		JLabel lblProductosEnSeleccion = new JLabel("Productos en Seleccion");
		GridBagConstraints gbc_lblProductosEnSeleccion = new GridBagConstraints();
		gbc_lblProductosEnSeleccion.insets = new Insets(0, 0, 5, 0);
		gbc_lblProductosEnSeleccion.gridx = 1;
		gbc_lblProductosEnSeleccion.gridy = 3;
		add(lblProductosEnSeleccion, gbc_lblProductosEnSeleccion);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		btnAgregarAlCarrito = new JButton("Agregar al carrito");
		btnAgregarAlCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(spinner.getValue().toString()) != 0) {
					
				}
			}
		});
		GridBagConstraints gbc_btnAgregarAlCarrito = new GridBagConstraints();
		gbc_btnAgregarAlCarrito.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregarAlCarrito.gridx = 0;
		gbc_btnAgregarAlCarrito.gridy = 5;
		add(btnAgregarAlCarrito, gbc_btnAgregarAlCarrito);

	}
	public void agregarCarrito() {


	}
	public Resurtido getResurtido() {

		return null;

	}
	private class ModeloTabla extends AbstractTableModel {

		private Object[][] productos;
		private final String[] ENCABEZADOS = { "Codigo de Barras", "Nombre", "Marca", "Presentacion", "Cantidad",
				"Contenido", "Unidad de medida", "Categoria", "Precio de venta", "Descripcion", "Stock maximo",
		"Stock minimo" };

		public ModeloTabla() {
			productos = new Object[totalProductos][12];
			for (int i = 0; i < totalProductos; i++) {
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

		@Override
		public String getColumnName(int columnIndex) {
			return ENCABEZADOS[columnIndex];
		}

		@Override
		public int getRowCount() {
			return totalProductos;
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

}
