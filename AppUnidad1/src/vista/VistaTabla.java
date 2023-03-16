package vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import modelo.Producto;

public class VistaTabla extends JPanel {

	private List<Producto> listaProductos;
	private int totalProductos;
	private JTable tabla;
	private ModeloTabla modeloTabla;
	private JScrollPane scp_jScrollPane;

	public VistaTabla(List<Producto> listaProductos) {
		setLayout(new BorderLayout());
		this.listaProductos = listaProductos;
		this.totalProductos = listaProductos.size();
		this.modeloTabla = new ModeloTabla();
		tabla = new JTable(modeloTabla);
		scp_jScrollPane = new JScrollPane(tabla);
		add(scp_jScrollPane, BorderLayout.CENTER);
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
