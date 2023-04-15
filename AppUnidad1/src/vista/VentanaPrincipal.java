package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import modelo.Producto;
import modelo.Resurtido;
import modelo.Venta;

// TODO anadir flags para evitar poner un panel sobre otro
// TODO reacomodar los atributos de esta clase

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	PanelMenu panelMenu;
	private JMenuItem opcionEquipoElectronico;
	private JMenuItem opcionMobiliario;
	private JMenuItem opcionProductos;
	private JMenu menuInventario;

	// PanelMenu
	private JButton botonRegistrar;
	private JButton botonConsultar;
	private JButton botonModificar;
	private JButton botonEliminar;
	private JButton botonListar;
	private JButton botonResurtir;
	private JButton botonVenta;
	// PanelOpciones
	private JButton botonContinuar;
	private JButton botonAceptar;
	private JButton botonCancelar;

	// MenuEncabezado
	private PanelEncabezado panelEncabezado;
	private PanelOpciones panelOpciones;
	private PanelCapturaProductos panelCapturaProductos;
	private PanelResurtido panelResurtido;
	private PanelVenta panelVenta;
	private VentanaConsulta panelConsultar;
	private VentanaModificar panelModificar;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new VentanaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {

		//cambiarApariencia("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		// TODO no hacer esto
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(new Producto());
		listaProductos.add(new Producto());
		listaProductos.add(new Producto());

		List<Resurtido> listaResurtido = new ArrayList<>();
		listaResurtido.add(new Resurtido());
		listaResurtido.add(new Resurtido());
		listaResurtido.add(new Resurtido());

		List<Venta> listaVenta = new ArrayList<>();
		listaVenta.add(new Venta());
		listaVenta.add(new Venta());
		listaVenta.add(new Venta());
		
		setTitle("App GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuInventario = new JMenu("Inventario");
		menuInventario.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(menuInventario);

		opcionProductos = new JMenuItem("Productos");
		opcionProductos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		opcionProductos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panelMenu = new PanelMenu();
				contentPane.add(panelMenu, BorderLayout.WEST);
				botonRegistrar = panelMenu.getBotonRegistrar();
				setVisible(true);

				botonRegistrar.addActionListener(s -> {

					panelEncabezado = new PanelEncabezado("Registrar un producto",
							"El producto se anexara al catalogo.");
					panelCapturaProductos = new PanelCapturaProductos();
					panelOpciones = new PanelOpciones();

					contentPane.add(panelEncabezado, BorderLayout.NORTH);
					contentPane.add(panelCapturaProductos, BorderLayout.CENTER);
					contentPane.add(panelOpciones, BorderLayout.SOUTH);
					setVisible(true);

				});
				botonResurtir = panelMenu.getBotonResurtir();
				botonResurtir.addActionListener(s -> {
					panelEncabezado = new PanelEncabezado("Resurtir Productos", "El producto se sumara al inventario");
					panelResurtido = new PanelResurtido(listaProductos);
					panelOpciones = new PanelOpciones();
					
					contentPane.add(panelEncabezado, BorderLayout.NORTH);
					contentPane.add(panelResurtido, BorderLayout.CENTER);
					contentPane.add(panelOpciones, BorderLayout.SOUTH);
					setVisible(true);
				});

				botonVenta = panelMenu.getBotonVenta();
				botonVenta.addActionListener(s -> {
					panelEncabezado = new PanelEncabezado("Vender Productos", "El producto se sumara al inventario");
					panelVenta = new PanelVenta();
					panelOpciones = new PanelOpciones();
					
					contentPane.add(panelEncabezado, BorderLayout.NORTH);
					contentPane.add(panelVenta, BorderLayout.CENTER);
					contentPane.add(panelOpciones, BorderLayout.SOUTH);
					setVisible(true);
				});
				botonModificar = panelMenu.getBotonModificar();
				botonModificar.addActionListener(s -> {
					panelEncabezado = new PanelEncabezado("Modificar Productos", "Modifica las caracteristicas de un producto");
					panelModificar = new VentanaModificar();
					panelOpciones = new PanelOpciones();
					
					contentPane.add(panelEncabezado, BorderLayout.NORTH);
					contentPane.add(panelModificar, BorderLayout.CENTER);
					contentPane.add(panelOpciones, BorderLayout.SOUTH);
					setVisible(true);
				});
				botonConsultar = panelMenu.getBotonConsultar();
				botonConsultar.addActionListener(s -> {
					panelEncabezado = new PanelEncabezado("Consultar Productos", "El producto se mostrara en pantalla");
					panelConsultar = new VentanaConsulta();
					panelOpciones = new PanelOpciones();
					
					contentPane.add(panelEncabezado, BorderLayout.NORTH);
					contentPane.add(panelConsultar, BorderLayout.CENTER);
					contentPane.add(panelOpciones, BorderLayout.SOUTH);
					setVisible(true);
				});
//				botonModificar = panelMenu.getBotonModificar();
//				botonEliminar = panelMenu.getBotonEliminar();
				botonListar = panelMenu.getBotonListar();
				botonListar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						// TODO anadir argumento al constructor
						contentPane.add(new PanelEncabezado("Listar Productos", "Listado de todos los productos registrados"), BorderLayout.NORTH);
						contentPane.add(new VistaTabla(listaProductos), BorderLayout.CENTER);
						setVisible(true);
					}
				});
			}
		});
		menuInventario.add(opcionProductos);

		opcionMobiliario = new JMenuItem("Mobiliario");
		opcionMobiliario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuInventario.add(opcionMobiliario);

		opcionEquipoElectronico = new JMenuItem("Equipo electronico");
		opcionEquipoElectronico.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuInventario.add(opcionEquipoElectronico);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	private void cambiarApariencia(String apariencia) {
		try {
			UIManager.setLookAndFeel(apariencia);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}

}
