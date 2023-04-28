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
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.IODataFile;
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
		//		listaProductos.add(new Producto());
		//		listaProductos.add(new Producto());
		//		listaProductos.add(new Producto());
		listaProductos.add(new Producto("1","asdf","adsfasdf", "asdfdsa",13, "asdfafe","adsfasdf","adsfasdf",34.55,"asdfeasdf",3434,2455555));

		List<Resurtido> listaResurtido = new ArrayList<>();
		listaResurtido.add(new Resurtido());
		listaResurtido.add(new Resurtido());
		listaResurtido.add(new Resurtido());

		List<Venta> listaVenta = new ArrayList<>();
		listaVenta.add(new Venta());
		listaVenta.add(new Venta());
		listaVenta.add(new Venta());
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	IODataFile.writeObjectToFile("/home/ozymandias/git/alf/AppUnidad1/src/recursos/files/listaProductos.dat",(Object) listaProductos);
            	IODataFile.writeObjectToFile("/home/ozymandias/git/alf/AppUnidad1/src/recursos/files/listaResurtido.dat",(Object) listaResurtido);
            	IODataFile.writeObjectToFile("/home/ozymandias/git/alf/AppUnidad1/src/recursos/files/listaVenta.dat", (Object) listaVenta);
                System.exit(0);
            }
        });
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
					contentPane.removeAll();
					contentPane.add(panelMenu, BorderLayout.WEST);
					contentPane.repaint();
					repaint();

					panelEncabezado = new PanelEncabezado("Registrar un producto",
							"El producto se anexara al catalogo.");
					panelCapturaProductos = new PanelCapturaProductos();
					panelOpciones = new PanelOpciones();
					JButton aceptar = panelOpciones.getBotonAceptar();
					JButton cancelar = panelOpciones.getBotonCancelar();
					panelOpciones.getBotonContinuar().setVisible(false);
					aceptar.addActionListener(t -> {
						listaProductos.add(panelCapturaProductos.getProducto());
						panelCapturaProductos.clear();

					});
					cancelar.addActionListener(g -> {
						contentPane.remove(panelCapturaProductos);
						contentPane.remove(panelOpciones);
						contentPane.remove(panelEncabezado);
						contentPane.repaint();
						repaint();

					});
					contentPane.add(panelEncabezado, BorderLayout.NORTH);
					contentPane.add(panelCapturaProductos, BorderLayout.CENTER);
					contentPane.add(panelOpciones, BorderLayout.SOUTH);
					setVisible(true);
					contentPane.repaint();
					repaint();

				});
				botonResurtir = panelMenu.getBotonResurtir();
				botonResurtir.addActionListener(s -> {
					if(!(listaProductos.isEmpty())) {

						contentPane.removeAll();
						contentPane.add(panelMenu, BorderLayout.WEST);
						contentPane.repaint();
						repaint();
						panelEncabezado = new PanelEncabezado("Resurtir Productos", "El producto se sumara al inventario");
						panelResurtido = new PanelResurtido(listaProductos);
						panelOpciones = new PanelOpciones();
						JButton aceptar = panelOpciones.getBotonAceptar();
						aceptar.addActionListener(d->{
							Resurtido resurtido = panelResurtido.getResurtido();
							listaResurtido.add(resurtido);
							contentPane.remove(panelEncabezado);
							contentPane.remove(panelResurtido);
							contentPane.remove(panelOpciones);
							contentPane.repaint();
							repaint();
							
						});
						JButton cancelar = panelOpciones.getBotonCancelar();
						cancelar.addActionListener( k -> {
							contentPane.remove(panelEncabezado);
							contentPane.remove(panelResurtido);
							contentPane.remove(panelOpciones);
							contentPane.repaint();
							repaint();
						});
						panelOpciones.getBotonContinuar().setVisible(false);

						contentPane.add(panelEncabezado, BorderLayout.NORTH);
						contentPane.add(panelResurtido, BorderLayout.CENTER);
						contentPane.add(panelOpciones, BorderLayout.SOUTH);
						setVisible(true);
						contentPane.repaint();
						repaint();

					}else {
						JOptionPane.showMessageDialog(null, "La lista de productos esta vacia");
					}
				});

				botonVenta = panelMenu.getBotonVenta();
				botonVenta.addActionListener(s -> {
					if(!(listaProductos.isEmpty())) {
						contentPane.removeAll();
						contentPane.add(panelMenu, BorderLayout.WEST);
						contentPane.repaint();
						repaint();
						panelEncabezado = new PanelEncabezado("Vender Productos", "El producto se sumara al inventario");
						panelVenta = new PanelVenta(listaProductos);
						panelOpciones = new PanelOpciones();
						JButton aceptar = panelOpciones.getBotonAceptar();
						aceptar.addActionListener(h -> {
							Venta venta = panelVenta.getVenta();
							System.out.println(venta.toString());
							listaVenta.add(venta);
							contentPane.remove(panelEncabezado);
							contentPane.remove(panelVenta);
							contentPane.remove(panelOpciones);
							contentPane.repaint();
							repaint();
						});
						JButton cancelar = panelOpciones.getBotonCancelar();
						cancelar.addActionListener(k -> {
							contentPane.remove(panelEncabezado);
							contentPane.remove(panelVenta);
							contentPane.remove(panelOpciones);
							contentPane.repaint();
							repaint();
						});
						panelOpciones.getBotonContinuar().setVisible(false);
						
						contentPane.add(panelEncabezado, BorderLayout.NORTH);
						contentPane.add(panelVenta, BorderLayout.CENTER);
						contentPane.add(panelOpciones, BorderLayout.SOUTH);
						setVisible(true);
						contentPane.repaint();
						repaint();
					} else {
						JOptionPane.showMessageDialog(null, "La lista de productos esta vacia");
					}
				});
				botonModificar = panelMenu.getBotonModificar();
				botonModificar.addActionListener(s -> {
					if(!(listaProductos.isEmpty())) {
						contentPane.removeAll();
						contentPane.add(panelMenu, BorderLayout.WEST);
						contentPane.repaint();
						repaint();
						if(!listaProductos.isEmpty()) {
							panelEncabezado = new PanelEncabezado("Modificar Productos", "Modifica las caracteristicas de un producto");
							panelModificar = new VentanaModificar();
							var buscar = panelModificar.getBuscar();
							buscar.addActionListener(b -> {
								String cod = panelModificar.getBusqueda().getText().trim();
								for(int i = 0; i<listaProductos.size(); i++) {
									if(listaProductos.get(i).getCodigoBarras().equals(cod)) {
										panelModificar.setProducto(listaProductos.get(i));
									}
								}
							});
							panelOpciones = new PanelOpciones();
							var cancelar = panelOpciones.getBotonAceptar();
							cancelar.addActionListener(f -> {
								contentPane.remove(panelEncabezado);
								contentPane.remove(panelModificar);
								contentPane.remove(panelOpciones);
								contentPane.repaint();
								repaint();
							});
							var aceptar = panelOpciones.getBotonCancelar();
							aceptar.addActionListener(d -> {
								String cod = panelModificar.getBusqueda().getText().trim();
								for(int i = 0; i<listaProductos.size(); i++) {
									if(listaProductos.get(i).getCodigoBarras().equals(cod)) {
										listaProductos.add(i, panelModificar.getProducto());
										break;
									}
								}
							});
							panelOpciones.getBotonContinuar().setVisible(false);
							cancelar.addActionListener(h -> {
								contentPane.remove(panelEncabezado);
								contentPane.remove(panelModificar);
								contentPane.remove(panelOpciones);
								contentPane.repaint();
								repaint();
							});
							List<String> dawn = new ArrayList();

							for(Producto producto: listaProductos) {
								dawn.add(producto.getCodigoBarras());
							}
							panelModificar.setOrigen(dawn);
							JList<String> list = panelModificar.getList();
							list.addListSelectionListener(new ListSelectionListener () {

								@Override
								public void valueChanged(ListSelectionEvent e) {
									// TODO Auto-generated method stub
									panelModificar.getBusqueda().setText(list.getSelectedValue());
									String codigo = panelModificar.getBusqueda().getText();
									for(Producto producto:listaProductos) {
										if(producto.getCodigoBarras().equals(codigo)) {
											panelModificar.setProducto(producto);
											panelOpciones.getBotonAceptar().setVisible(true);
											break;
										}
									}
								}

							});
							contentPane.add(panelEncabezado, BorderLayout.NORTH);
							contentPane.add(panelModificar, BorderLayout.CENTER);
							contentPane.add(panelOpciones, BorderLayout.SOUTH);
							setVisible(true);
							contentPane.repaint();
							repaint();
						} else {
							JOptionPane.showMessageDialog(null, "la lista de productos esta vacia");
						}
					} else {
						JOptionPane.showMessageDialog(null, "La lista de productos esta vacia");
					}
				});
				botonConsultar = panelMenu.getBotonConsultar();
				botonConsultar.addActionListener(s -> {
					if(!listaProductos.isEmpty()) {
						contentPane.removeAll();
						contentPane.add(panelMenu, BorderLayout.WEST);
						contentPane.repaint();
						repaint();
						panelEncabezado = new PanelEncabezado("Consultar Productos", "El producto se mostrara en pantalla");
						panelConsultar = new VentanaConsulta();
						List<String> dawn = new ArrayList();

						for(Producto producto: listaProductos) {
							dawn.add(producto.getCodigoBarras());
						}
						panelConsultar.setOrigen(dawn);
						panelOpciones = new PanelOpciones();
						JButton botonBuscar = panelConsultar.getBotonBuscar();
						botonBuscar.addActionListener(d -> {
							String codigo = panelConsultar.getBusqueda().getText();
							for(Producto producto:listaProductos) {
								if(producto.getCodigoBarras().equals(codigo)) {
									panelConsultar.setConsulta(producto);
									break;
								}
							}
						});
						JList<String> list = panelConsultar.getList();
						list.addListSelectionListener(new ListSelectionListener () {

							@Override
							public void valueChanged(ListSelectionEvent e) {
								// TODO Auto-generated method stub
								panelConsultar.getBusqueda().setText(list.getSelectedValue());
								String codigo = panelConsultar.getBusqueda().getText();
								for(Producto producto:listaProductos) {
									if(producto.getCodigoBarras().equals(codigo)) {
										panelConsultar.setConsulta(producto);
										break;
									}
								}
							}

						});
						panelOpciones.getBotonCancelar().setVisible(false);
						panelOpciones.getBotonContinuar().setVisible(false);
						panelOpciones.getBotonAceptar().addActionListener(d ->{
							contentPane.remove(panelEncabezado);
							contentPane.remove(panelConsultar);
							contentPane.remove(panelOpciones);
							contentPane.repaint();
							repaint();
						});
						contentPane.add(panelEncabezado, BorderLayout.NORTH);
						contentPane.add(panelConsultar, BorderLayout.CENTER);
						contentPane.add(panelOpciones, BorderLayout.SOUTH);
						setVisible(true);
						contentPane.repaint();
						repaint();
					} else {
						JOptionPane.showMessageDialog(null, "la lista de productos esta vacia");
					}
				});
				botonEliminar = panelMenu.getBotonEliminar();
				botonEliminar.addActionListener(s ->{
					if(!(listaProductos.isEmpty())) {
						contentPane.removeAll();
						contentPane.add(panelMenu, BorderLayout.WEST);
						contentPane.repaint();
						repaint();
						boolean truth = false;
						panelEncabezado = new PanelEncabezado("Eliminar Productos", "Elimina productos de la base de datos");
						panelConsultar = new VentanaConsulta();
						panelOpciones = new PanelOpciones();
						JButton botonBuscar = panelConsultar.getBotonBuscar();
						botonBuscar.addActionListener(d -> {
							String codigo = panelConsultar.getBusqueda().getText();
							for(Producto producto:listaProductos) {
								if(producto.getCodigoBarras().equals(codigo)) {
									panelConsultar.setConsulta(producto);
									panelOpciones.getBotonAceptar().setVisible(true);
									panelOpciones.repaint();
									break;
								}
							}

						});
						panelOpciones.getBotonCancelar().addActionListener(g -> {
							contentPane.remove(panelEncabezado);
							contentPane.remove(panelConsultar);
							contentPane.remove(panelOpciones);
							contentPane.repaint();
							repaint();
						});
						panelOpciones.getBotonContinuar().setVisible(false);
						panelOpciones.getBotonAceptar().setVisible(false);
						panelOpciones.getBotonAceptar().addActionListener(d ->{
							if(JOptionPane.showConfirmDialog(null, "estas seguro?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								for(int i = 0; i<listaProductos.size(); i++) {
									if(listaProductos.get(i).getCodigoBarras().equals(panelConsultar.getBusqueda().getText().trim())) {
										listaProductos.remove(i);
										break;
									}
								}
							}
						});
						List<String> dawn = new ArrayList();

						for(Producto producto: listaProductos) {
							dawn.add(producto.getCodigoBarras());
						}
						panelConsultar.setOrigen(dawn);
						JList<String> list = panelConsultar.getList();
						list.addListSelectionListener(new ListSelectionListener () {

							@Override
							public void valueChanged(ListSelectionEvent e) {
								// TODO Auto-generated method stub
								panelConsultar.getBusqueda().setText(list.getSelectedValue());
								String codigo = panelConsultar.getBusqueda().getText();
								for(Producto producto:listaProductos) {
									if(producto.getCodigoBarras().equals(codigo)) {
										panelConsultar.setConsulta(producto);
										panelOpciones.getBotonAceptar().setVisible(true);
										break;
									}
								}
							}

						});
						contentPane.add(panelEncabezado, BorderLayout.NORTH);
						contentPane.add(panelConsultar, BorderLayout.CENTER);
						contentPane.add(panelOpciones, BorderLayout.SOUTH);
						setVisible(true);
						contentPane.repaint();
						repaint();
					} else {
						JOptionPane.showMessageDialog(null, "La lista de productos esta vacia");
					}
				});
				//				botonModificar = panelMenu.getBotonModificar();
				//				botonEliminar = panelMenu.getBotonEliminar();
				botonListar = panelMenu.getBotonListar();
				botonListar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!(listaProductos.isEmpty())) {
							contentPane.removeAll();
							contentPane.add(panelMenu, BorderLayout.WEST);
							contentPane.repaint();
							repaint();
							// TODO anadir argumento al constructor
							contentPane.add(new PanelEncabezado("Listar Productos", "Listado de todos los productos registrados"), BorderLayout.NORTH);
							contentPane.add(new VistaTabla(listaProductos), BorderLayout.CENTER);
							setVisible(true);
							contentPane.repaint();
							repaint();
						} else {
							JOptionPane.showMessageDialog(null, "La lista de productos esta vacia");
						}
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
