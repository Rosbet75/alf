package pruebas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.IOTextFile;
import javax.swing.JScrollPane;

public class VistaLista extends JFrame {

	private JPanel contentPane;
	private JTextField caja;
	private JList list;
	private List<String> origen;
	private int y;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VistaLista frame = new VistaLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaLista() {

		var modelx = new DefaultListModel();
		origen = IOTextFile.getFileElements(new File("src/recursos/assets/Paises.txt"));
		modelx.addAll(origen);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		y = 90;
		caja = new JTextField();
		caja.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String filter = caja.getText().toLowerCase();
				modelx.removeAllElements();

				if (filter.isEmpty()) {
					modelx.addAll(origen);
					y = 90;
				} else {
					var filteredElements = origen.stream().filter(s -> s.toLowerCase().contains(filter)).toList();
					modelx.addAll(filteredElements);
					y = 20 * filteredElements.size();
				}
				list.setBounds(111, 44, 162, y);

			}
		});
		caja.setBounds(111, 22, 162, 20);

		contentPane.add(caja);
		caja.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 44, 162, 90);
		contentPane.add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(192, 192, 192)));
		list.setModel(modelx);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "hola " + list.getSelectedValue());
			}
		});
	}
}
