package Interfaz;

import javax.swing.*;

import org.apache.commons.math3.distribution.NormalDistribution;

import java.awt.*;
import java.util.Random;

public class PanelTabla extends JPanel{

	private int etapa = 1;
	private int ronda = 1;
	
	private JTextArea[][] tablaResultados;
	
	public PanelTabla(InterfazPrincipal interfaz){
		inicializarTabla(interfaz);
	}
	
	public void inicializarTabla(InterfazPrincipal interfaz){
		tablaResultados = new JTextArea[9][11];
		setLayout(new GridLayout(9,11));
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 11; j++){
				if(j == 0){
					if( i == 0 ){
						tablaResultados[i][j] = new JTextArea("");
						tablaResultados[i][j].setEditable(false);
					}
					if( i == 1 ){
						tablaResultados[i][j] = new JTextArea("Demanda");
						tablaResultados[i][j].setEditable(false);
					}
					if( i == 2 ){
						tablaResultados[i][j] = new JTextArea("# Trabajadores");
						tablaResultados[i][j].setEditable(false);
					}
					if( i == 3 ){
						tablaResultados[i][j] = new JTextArea("# Contratados");
						tablaResultados[i][j].setEditable(false);
					}
					if( i == 4 ){
						tablaResultados[i][j] = new JTextArea("# Despedidos");
						tablaResultados[i][j].setEditable(false);
					}
					if( i == 5 ){
						tablaResultados[i][j] = new JTextArea("Producción (SKU)");
						tablaResultados[i][j].setEditable(false);
					}
					if( i == 6 ){
						tablaResultados[i][j] = new JTextArea("Inventario (SKU)");
						tablaResultados[i][j].setEditable(false);
					}
					if( i == 7 ){
						tablaResultados[i][j] = new JTextArea("Existencias (SKU)");
						tablaResultados[i][j].setEditable(false);
					}
					if( i == 8 ){
						tablaResultados[i][j] = new JTextArea("Faltantes (SKU)");
						tablaResultados[i][j].setEditable(false);
					}
				}
				else if( j == 1 && i == 2){
					tablaResultados[i][j] = new JTextArea("15");
					tablaResultados[i][j].setEditable(false);
				}
				else if( j == 1 && i == 6){
					tablaResultados[i][j] = new JTextArea("150");
					tablaResultados[i][j].setEditable(false);
				}
				else{
					if(i == 0){
						tablaResultados[i][j] = new JTextArea("" + (j-1));
						tablaResultados[i][j].setEditable(false);
					}
					else if( i == 5){
						tablaResultados[i][j] = new JTextArea("");
						tablaResultados[i][j].setEditable(true);
						tablaResultados[i][j].setBackground(Color.LIGHT_GRAY);
					}
					else{
						tablaResultados[i][j] = new JTextArea("");
						tablaResultados[i][j].setEditable(false);
					}
				}
				tablaResultados[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));;
				add(tablaResultados[i][j]);
			}
		}
	}
	
	public void actualizar(){
		NormalDistribution nd = new NormalDistribution(100,100); // Crea la distribución. Debe colocarse en la sesión del ADMIN!
		double demanda = nd.sample(); // Obtiene un dato de la distribución. Debe colocarse en la sesión del ADMIN! se hace broadcast del numero al "terminar" la ronda
		double producido = Double.parseDouble(tablaResultados[5][ronda].getText()); //Lo que el usuario coloca
		double inventario = Double.parseDouble(tablaResultados[6][ronda].getText()) + producido - demanda; //Inventario (t) = lo que tenía + lo q entra - lo q sale 
		double trabajadores = Math.round(producido/10); // Producido(t) = 10*Workers(t)
		double contratos = 0;
		double despidos = 0;
		if(trabajadores > Double.parseDouble(tablaResultados[2][ronda].getText())){
			contratos = trabajadores - Double.parseDouble(tablaResultados[2][ronda].getText());
			despidos = 0;
		}
		else if(trabajadores < Double.parseDouble(tablaResultados[2][ronda].getText())){
			contratos = 0;
			despidos = - trabajadores + Double.parseDouble(tablaResultados[2][ronda].getText());
		}
		else{
			contratos = 0;
			despidos = 0;
		}
		
		double existencias = Math.max(0, inventario);
		double faltantes = Math.max(0, -inventario);
		
		tablaResultados[1][ronda].setText(Math.round(demanda)+"");
		tablaResultados[3][ronda].setText(Math.round(contratos)+"");
		tablaResultados[4][ronda].setText(Math.round(despidos)+"");
		tablaResultados[5][ronda].setEditable(false);
		if(faltantes > 0){
			tablaResultados[5][ronda].setBackground(Color.RED);
		}
		else{
			tablaResultados[5][ronda].setBackground(Color.GREEN);
		}
		tablaResultados[7][ronda].setText(Math.round(existencias)+"");
		tablaResultados[8][ronda].setText(Math.round(faltantes)+"");
		if(ronda<10){
			tablaResultados[2][ronda+1].setText(Math.round(trabajadores)+"");
			tablaResultados[6][ronda+1].setText(Math.round(inventario)+"");
		}
		ronda++;
	}
}
