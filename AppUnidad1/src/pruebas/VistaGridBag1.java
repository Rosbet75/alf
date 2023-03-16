package pruebas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VistaGridBag1 extends JFrame {

	private JPanel panel;
	private JPanel panelAux;

	public static void main(String[] args) {

		new VistaGridBag1();

	}

	public VistaGridBag1() {
		inicializar();
		setVisible(true);
	}

	private void inicializar() {

		changeLaF("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Vista GBL1");
		setSize(420, 410);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		panel = new JPanel(gbl);

		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.fill = GridBagConstraints.BOTH;

		panelAux = new JPanel();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		panelAux.setBackground(new Color(20, 20, 255));
		panel.add(new JButton("Arriba"), gbc);

		panelAux = new JPanel();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		panelAux.setBackground(new Color(60, 60, 255));
		panel.add(new JButton("Derecha"), gbc);

		panelAux = new JPanel();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		panelAux.setBackground(new Color(100, 100, 255));
		panel.add(new JButton("Abajo"), gbc);

		panelAux = new JPanel();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		panel.add(new JButton("Izquierda"), gbc);

		panelAux = new JPanel();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		panel.add(new JButton("Centro"), gbc);

		setContentPane(panel);
		setLocationRelativeTo(null);
	}

	private void changeLaF(String laf) {
		try {
			UIManager.setLookAndFeel(laf);
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
