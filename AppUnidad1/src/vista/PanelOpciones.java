package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel {
	private JButton botonContinuar;
	private JButton botonAceptar;
	private JButton botonCancelar;

	public PanelOpciones() {
		setBackground(new Color(128, 128, 128));

		botonAceptar = new JButton("Aceptar");
		botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(botonAceptar);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(botonCancelar);

		botonContinuar = new JButton("Continuar");
		botonContinuar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(botonContinuar);

	}

	public JButton getBotonContinuar() {
		return botonContinuar;
	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

}
