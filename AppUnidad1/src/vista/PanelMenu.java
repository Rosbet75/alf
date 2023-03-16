package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {

	private JButton botonRegistrar;
	private JButton botonConsultar;
	private JButton botonModificar;
	private JButton botonEliminar;
	private JButton botonListar;

	public PanelMenu() {
		setBackground(new Color(128, 128, 192));
		setLayout(new GridLayout(5, 1, 0, 0));

		botonRegistrar = new JButton("Registrar");
		botonRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(botonRegistrar);

		botonConsultar = new JButton("Consultar");
		botonConsultar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(botonConsultar);

		botonModificar = new JButton("Modificar");
		botonModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(botonModificar);

		botonEliminar = new JButton("Eliminar");
		botonEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(botonEliminar);

		botonListar = new JButton("Listar");
		botonListar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(botonListar);

	}

	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}

	public JButton getBotonConsultar() {
		return botonConsultar;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public JButton getBotonListar() {
		return botonListar;
	}

}