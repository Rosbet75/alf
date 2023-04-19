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
	private JCheckBox chckbxBusquedaPorCodigo;
	private JSpinner sp_cantidad;
	private JButton btnAgregarAlCarrito;

	//===========
	private ArrayList<RenglonResurtido> renglonresurtido;

	private JTable tabla_seleccion;
	private JScrollPane scroll_seleccion;
	private JTable tablaProductos;
	private JScrollPane scroll_productos;
	private List<Producto> listaProductos;
	private int totalProductos;
	//private JTable tabla;
	private ModeloTabla modeloTabla;
	private JSpinner sp_precio;

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

		sp_cantidad = new JSpinner();
		GridBagConstraints gbc_sp_cantidad = new GridBagConstraints();
		gbc_sp_cantidad.insets = new Insets(0, 0, 5, 5);
		gbc_sp_cantidad.gridx = 0;
		gbc_sp_cantidad.gridy = 2;
		add(sp_cantidad, gbc_sp_cantidad);

		scroll_productos = new JScrollPane();
		GridBagConstraints gbc_scroll_productos = new GridBagConstraints();
		gbc_scroll_productos.fill = GridBagConstraints.BOTH;
		gbc_scroll_productos.insets = new Insets(0, 0, 5, 0);
		gbc_scroll_productos.gridx = 1;
		gbc_scroll_productos.gridy = 2;
		add(scroll_productos, gbc_scroll_productos);

		tablaProductos = new JTable(modeloTabla);
		scroll_productos.setViewportView(tablaProductos);

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
		
		sp_precio = new JSpinner();
		GridBagConstraints gbc_sp_precio = new GridBagConstraints();
		gbc_sp_precio.insets = new Insets(0, 0, 5, 5);
		gbc_sp_precio.gridx = 0;
		gbc_sp_precio.gridy = 4;
		add(sp_precio, gbc_sp_precio);

		scroll_seleccion = new JScrollPane();
		GridBagConstraints gbc_scroll_seleccion = new GridBagConstraints();
		gbc_scroll_seleccion.fill = GridBagConstraints.BOTH;
		gbc_scroll_seleccion.insets = new Insets(0, 0, 5, 0);
		gbc_scroll_seleccion.gridx = 1;
		gbc_scroll_seleccion.gridy = 4;
		add(scroll_seleccion, gbc_scroll_seleccion);

		tabla_seleccion = new JTable();
		scroll_seleccion.setViewportView(tabla_seleccion);

		btnAgregarAlCarrito = new JButton("Agregar al carrito");
		btnAgregarAlCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(sp_cantidad.getValue().toString()) != 0) {
					listaProductos.add(new Producto());
					modeloTabla = new ModeloTabla();
					tablaProductos = new JTable(modeloTabla);
					scroll_productos.setViewportView(tablaProductos);
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
