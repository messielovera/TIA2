package Interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;

public class PanelAdmin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3382494874560799164L;

	/**
	 * Create the panel.
	 */
	public PanelAdmin() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblBienvenidoAdministrador = new JLabel("Bienvenido Administrador");
		add(lblBienvenidoAdministrador, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Preferencias de encuentro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNumeroDeIntegrantes = new JLabel("Numero de integrantes");
		panel.add(lblNumeroDeIntegrantes);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JLabel lblNumeroDeIteraciones = new JLabel("Numero de iteraciones");
		panel.add(lblNumeroDeIteraciones);
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1);
		
		JLabel lblTiempoDeTimeout = new JLabel("Tiempo para decidir");
		panel.add(lblTiempoDeTimeout);
		
		JComboBox comboBox_2 = new JComboBox();
		panel.add(comboBox_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Variable Aleatoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, BorderLayout.SOUTH);

	}

}
