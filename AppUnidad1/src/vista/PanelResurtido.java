package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelResurtido extends JPanel {
	private JTextField busquedaField;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JCheckBox chckbxBusquedaPorCodigo;
	private JSpinner spinner;
	private JButton btnAgregarAlCarrito;

	/**
	 * Create the panel.
	 */
	public PanelResurtido() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 80, 0, 0};
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
		
		JLabel lblPrecio = new JLabel("Precio");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 2;
		gbc_lblPrecio.gridy = 3;
		add(lblPrecio, gbc_lblPrecio);
		
		JLabel lblProductosEnSeleccion = new JLabel("Productos en Seleccion");
		GridBagConstraints gbc_lblProductosEnSeleccion = new GridBagConstraints();
		gbc_lblProductosEnSeleccion.insets = new Insets(0, 0, 5, 0);
		gbc_lblProductosEnSeleccion.gridx = 4;
		gbc_lblProductosEnSeleccion.gridy = 3;
		add(lblProductosEnSeleccion, gbc_lblProductosEnSeleccion);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		table_1 = new JTable();
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.insets = new Insets(0, 0, 5, 0);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 4;
		gbc_table_1.gridy = 4;
		add(table_1, gbc_table_1);
		
		btnAgregarAlCarrito = new JButton("Agregar al carrito");
		GridBagConstraints gbc_btnAgregarAlCarrito = new GridBagConstraints();
		gbc_btnAgregarAlCarrito.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregarAlCarrito.gridx = 2;
		gbc_btnAgregarAlCarrito.gridy = 5;
		add(btnAgregarAlCarrito, gbc_btnAgregarAlCarrito);

	}
}
