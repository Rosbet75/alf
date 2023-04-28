package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import modelo.Producto;
import modelo.SeleccionVenta;
import modelo.UniVenta;
import modelo.Venta;

public class PanelVenta extends JPanel {
	private JTextField busquedaField;
	private JTable tabla;
	private JTable tabla_seleccion;
	private JSpinner sp_cantidad;
	private JButton btnAgregarAlCarrito;
	private List<Producto> listaProductos;
	private List<SeleccionVenta> listaSeleccion;
	private int selectedRow;
	private boolean allow;
	private int totalProductos;
	private JScrollPane scroll_productos;
	private JScrollPane scroll_seleccion;
	private ModeloTabla modeloTabla;
	private ModeloSeleccion modeloSeleccion;
	
	/**
	 * Create the panel.
	 */
	public PanelVenta(List<Producto> lista) {
		allow = false;
		this.listaProductos = lista;
		this.totalProductos = lista.size();
		this.listaSeleccion = new ArrayList<>();
		this.modeloTabla = new ModeloTabla(this.listaProductos);
		//this.listaSeleccion.add(new Seleccion(new Producto("1","asdf","adsfasdf", "asdfdsa",13, "asdfafe","adsfasdf","adsfasdf",34.55,"asdfeasdf",3434,2455555), 1, 1, new Date()));
		List<Producto> origen = new ArrayList<Producto>();
		origen.addAll(listaProductos);
		origen.toString();
		this.modeloSeleccion = new ModeloSeleccion(this.listaSeleccion);
		
		this.tabla = new JTable(modeloTabla);
		
		this.tabla_seleccion = new JTable(modeloSeleccion);
		
		ListSelectionModel model = tabla.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(! model.isSelectionEmpty()) {
					selectedRow = model.getMinSelectionIndex();
					allow = true;
					//OptionPane.showMessageDialog(null, listaProductos.get(selectedRow));
				}

			}

		});
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 89, 0, 80, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombreDeProducto = new JLabel("Nombre de producto");
		GridBagConstraints gbc_lblNombreDeProducto = new GridBagConstraints();
		gbc_lblNombreDeProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeProducto.gridx = 0;
		gbc_lblNombreDeProducto.gridy = 0;
		add(lblNombreDeProducto, gbc_lblNombreDeProducto);
		
		busquedaField = new JTextField();
		busquedaField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		busquedaField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();  // ignore event
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				String filter = busquedaField.getText().trim();
				listaProductos.clear();
				int y;
				if (filter.isEmpty()) {
					listaProductos.addAll(origen);
					y = 90;
				} else {
					var filteredElements = origen.stream().filter(s -> s.getCodigoBarras().toLowerCase().contains(filter)).toList();

					listaProductos.addAll(filteredElements);
					for(Producto producto: listaProductos) {
						System.out.println(producto.toString());
					}
					y = 20 * filteredElements.size();
				}
				scroll_productos.remove(tabla);
				scroll_seleccion.remove(tabla_seleccion);
				modeloSeleccion = new ModeloSeleccion(listaSeleccion);
				modeloTabla = new ModeloTabla(listaProductos);
				tabla = new JTable(modeloTabla);
				tabla_seleccion = new JTable(modeloSeleccion);
				ListSelectionModel model = tabla.getSelectionModel();
				model.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(! model.isSelectionEmpty()) {
							selectedRow = model.getMinSelectionIndex();
							allow = true;
							//OptionPane.showMessageDialog(null, listaProductos.get(selectedRow));
						}

					}

				});
				tabla.setVisible(true);
				tabla_seleccion.setVisible(true);
				scroll_seleccion.setViewportView(tabla_seleccion);
				scroll_productos.setViewportView(tabla);


				scroll_seleccion.repaint();
				scroll_productos.repaint();
				repaint();
				//listaProductos.toString();
				//				list.setModel(modelx);
				//				scrollPane.setVisible(true);
				allow = false;
			}
		});		
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
		
		//tabla = new JTable();
		scroll_productos.setViewportView(tabla);
		
		JLabel lblProductosEnSeleccion = new JLabel("Productos en Seleccion");
		GridBagConstraints gbc_lblProductosEnSeleccion = new GridBagConstraints();
		gbc_lblProductosEnSeleccion.insets = new Insets(0, 0, 5, 0);
		gbc_lblProductosEnSeleccion.gridx = 1;
		gbc_lblProductosEnSeleccion.gridy = 3;
		add(lblProductosEnSeleccion, gbc_lblProductosEnSeleccion);
		
		btnAgregarAlCarrito = new JButton("Agregar al carrito");
		btnAgregarAlCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(sp_cantidad.getValue().toString()) != 0) {
					if(allow) {
						allow = false;
						Producto producto = listaProductos.get(selectedRow);
						int cantidad = Integer.parseInt(sp_cantidad.getValue().toString());
						DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
						Date date = new Date();
						listaSeleccion.add(new SeleccionVenta(producto, cantidad));
						if(!(listaProductos.isEmpty())) {
							listaProductos.remove(selectedRow);
						}
						//listaProductos.remove(selectedRow);
						//scroll_seleccion.removeAll();
						//scroll_productos.removeAll();
						scroll_productos.remove(tabla);
						scroll_seleccion.remove(tabla_seleccion);
						modeloSeleccion = new ModeloSeleccion(listaSeleccion);
						modeloTabla = new ModeloTabla(listaProductos);
						tabla = new JTable(modeloTabla);
						tabla_seleccion = new JTable(modeloSeleccion);
						ListSelectionModel model = tabla.getSelectionModel();
						model.addListSelectionListener(new ListSelectionListener() {
							@Override
							public void valueChanged(ListSelectionEvent e) {
								if(! model.isSelectionEmpty()) {
									selectedRow = model.getMinSelectionIndex();
									allow = true;
									//OptionPane.showMessageDialog(null, listaProductos.get(selectedRow));
								}

							}

						});
						tabla.setVisible(true);
						tabla_seleccion.setVisible(true);
						scroll_seleccion.setViewportView(tabla_seleccion);
						scroll_productos.setViewportView(tabla);

						sp_cantidad.setValue(0);
						scroll_seleccion.repaint();
						scroll_productos.repaint();
						repaint();

					} else {
						JOptionPane.showMessageDialog(null, "Porfavor selecciona un producto de la lista de productos");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Uno de los campos permanecen sin llenar");
				}
			}
		});
		GridBagConstraints gbc_btnAgregarAlCarrito = new GridBagConstraints();
		gbc_btnAgregarAlCarrito.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregarAlCarrito.gridx = 0;
		gbc_btnAgregarAlCarrito.gridy = 4;
		add(btnAgregarAlCarrito, gbc_btnAgregarAlCarrito);
		
		scroll_seleccion = new JScrollPane();
		GridBagConstraints gbc_scroll_seleccion = new GridBagConstraints();
		gbc_scroll_seleccion.fill = GridBagConstraints.BOTH;
		gbc_scroll_seleccion.gridx = 1;
		gbc_scroll_seleccion.gridy = 4;
		add(scroll_seleccion, gbc_scroll_seleccion);
		
		//tabla_seleccion = new JTable();
		scroll_seleccion.setViewportView(tabla_seleccion);

	}
	public Venta getVenta() {
		ArrayList<UniVenta> articulos = new ArrayList();
		for(SeleccionVenta seleccion: listaSeleccion) {
			articulos.add(new UniVenta(seleccion.getProducto().getCodigoBarras(), seleccion.getCantidad(), seleccion.getProducto().getPrecioVenta()));
		}
		return new Venta(articulos);
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
		private final String[] ENCABEZADOS = {"Codigo de Barras", "Cantidad"};
		private int size;
		public ModeloSeleccion(List<SeleccionVenta> listaSeleccion) {
			productos = new Object[listaSeleccion.size()][2];
			size = listaSeleccion.size();
			if(listaSeleccion.size() != 0) {
				for (int i = 0; i < listaSeleccion.size(); i++) {
					productos[i][0] = listaSeleccion.get(i).getProducto().getCodigoBarras();
					productos[i][1] = listaSeleccion.get(i).getCantidad();
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
