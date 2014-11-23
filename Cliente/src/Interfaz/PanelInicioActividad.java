package Interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.Component;

import javax.swing.JDesktopPane;

import java.awt.BorderLayout;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;

public class PanelInicioActividad extends JPanel implements ActionListener{

	public static final String ENVIAR = "ENVIAR";
	private PanelTabla tabla;
	
	private InterfazPrincipal interfaz;
	
	private JTextArea txtrEstaEsUna;
	
	private JTextArea textoEscrito;
	
	private JButton btnEnviar;
	/**
	 * Create the panel.
	 */
	public PanelInicioActividad(InterfazPrincipal param) 
	{
		tabla = new PanelTabla(param);
		
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Indicaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(new BorderLayout());
		
		JLabel lblInicio = new JLabel("Inicio:");
		panel.add(lblInicio, BorderLayout.NORTH);
		
		JLabel lblRol = new JLabel("Rol:");
		panel.add(lblRol, BorderLayout.WEST);
		
		JLabel lblInserterol = new JLabel("InserteRol");
		panel.add(lblInserterol, BorderLayout.EAST);
		
		JLabel lblLeaElEnunciado = new JLabel("Lea el enunciado y coloque la cantidad a producir");
		panel.add(lblLeaElEnunciado, BorderLayout.SOUTH);
		add(panel, BorderLayout.NORTH);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Enunciado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout());
		
		txtrEstaEsUna = new JTextArea();
		txtrEstaEsUna.setText("La empresa Thai Utensils vende juegos de cubiertos. El SKU corresponde a un juego de cubiertos. Los históricos de ventas muestran que la demanda del "
				+ "producto es estacionaria y puede aproximarse a una distribución normal ND. La información se muestra a continuación:" + "\n" + "\n" + "- La demanda que no se cubre en un periodo puede cubrirse en periodos "
				+ "subsiguientes. El inventario inicial es de 150 SKUs. " + "\n" + "- Cualquier orden de producción toma 1 mes en producirse (si hay la capacidad) independientemente de las cantidades ordenadas. No se puede adquirir "
				+ "producto de fuentes externas." + "\n" + "- Inicialmente hay 15 trabajadores disponibles en la fábrica. Un trabajador en la planta nunca está inactivo y por lo tanto produce todo el tiempo. No pueden tenerse más "
				+ "de 20 trabajadores ni menos de 5 en ningún periodo. " + "\n" + "- El salario mensual de un trabajador es de $80/trabajador. Contratar un trabajador cuesta $20 y despedirlo cuesta $100. ");
		txtrEstaEsUna.setEditable(false);
		txtrEstaEsUna.setLineWrap(true);
		txtrEstaEsUna.setWrapStyleWord(true);
		panel_1.add(txtrEstaEsUna);
		
		JPanel panel_2 = new JPanel();
		panel_2.add(tabla, BorderLayout.CENTER);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setActionCommand("ENVIAR");
		btnEnviar.addActionListener(this);
		panel_2.add(btnEnviar, BorderLayout.SOUTH);
		add(panel_2, BorderLayout.SOUTH);
		

		interfaz = param;

	}
	
	public String darTextoRespuesta()
	{
		return textoEscrito.getText();
	}
	
	public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( ENVIAR.equals( comando ) )
        {
            tabla.actualizar();
        }
    }

}
