package vista;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class VentanaConsulta extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Create the panel.
	 */
	public VentanaConsulta() {
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
		
		textField = new JTextField();
		add(textField, "2, 4, 20, 1, fill, default");
		textField.setColumns(10);
		
		JCheckBox chckbxBusquedaPorCodigo = new JCheckBox("Busqueda por Codigo");
		add(chckbxBusquedaPorCodigo, "30, 4, 13, 1");
		
		JButton btnNewButton = new JButton("Buscar");
		add(btnNewButton, "4, 6, 15, 1");
		
		JSeparator separator = new JSeparator();
		add(separator, "2, 8, 44, 1");
		
		JLabel lblNombre = new JLabel("Nombre");
		add(lblNombre, "4, 10, 9, 1");
		
		JLabel lblCategoria = new JLabel("Categoria");
		add(lblCategoria, "14, 10, 9, 1");
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		add(separator_1, "26, 10, 1, 23");
		
		textField_1 = new JTextField();
		add(textField_1, "4, 12, 9, 1, fill, default");
		textField_1.setColumns(10);
		
		textField_7 = new JTextField();
		add(textField_7, "14, 12, 9, 1, fill, default");
		textField_7.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		add(lblMarca, "4, 14, 9, 1");
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de Venta");
		add(lblPrecioDeVenta, "14, 14, 9, 1");
		
		textField_2 = new JTextField();
		add(textField_2, "4, 16, 9, 1, fill, default");
		textField_2.setColumns(10);
		
		textField_8 = new JTextField();
		add(textField_8, "14, 16, 9, 1, fill, default");
		textField_8.setColumns(10);
		
		JLabel lblPresentacion = new JLabel("Presentacion");
		add(lblPresentacion, "4, 18, 9, 1");
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		add(lblDescripcion, "14, 18, 9, 1");
		
		textField_3 = new JTextField();
		add(textField_3, "4, 20, 9, 1, fill, default");
		textField_3.setColumns(10);
		
		textField_9 = new JTextField();
		add(textField_9, "14, 20, 9, 1, fill, default");
		textField_9.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		add(lblCantidad, "4, 22, 9, 1");
		
		JLabel lblStockMaximo = new JLabel("Stock Maximo");
		add(lblStockMaximo, "14, 22, 9, 1");
		
		textField_4 = new JTextField();
		add(textField_4, "4, 24, 9, 1, fill, default");
		textField_4.setColumns(10);
		
		textField_10 = new JTextField();
		add(textField_10, "14, 24, 9, 1, fill, default");
		textField_10.setColumns(10);
		
		JLabel lblContenido = new JLabel("Contenido");
		add(lblContenido, "4, 26, 9, 1");
		
		JLabel lblStockMinimo = new JLabel("Stock Minimo");
		add(lblStockMinimo, "14, 26, 9, 1");
		
		textField_5 = new JTextField();
		add(textField_5, "4, 28, 9, 1, fill, default");
		textField_5.setColumns(10);
		
		textField_11 = new JTextField();
		add(textField_11, "14, 28, 9, 1, fill, default");
		textField_11.setColumns(10);
		
		JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida");
		add(lblUnidadDeMedida, "4, 30, 9, 1");
		
		textField_6 = new JTextField();
		add(textField_6, "4, 32, 9, 1, fill, default");
		textField_6.setColumns(10);

	}

}
