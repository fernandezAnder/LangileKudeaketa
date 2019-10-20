package ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
 
import javax.swing.*;


import kontrolatzailea.MetodoakLeihoAldaketa;

public class Leiho1OngiEtorria extends JFrame {
	private static final long serialVersionUID = 1L;
	/**
	 * Ongietorria ematen duen panela sortu
	 * @author talde3
	 */
	public Leiho1OngiEtorria() {
	
		//panelaren propietateak
//		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		
		JButton btnDepartamentuKudeaketa = new JButton("DEPARTAMENTU KUDEAKETA");
		btnDepartamentuKudeaketa.setBounds(160, 108, 250, 39);
		getContentPane().add(btnDepartamentuKudeaketa);
		
		JButton btnEnplegatuKudeaketa = new JButton("ENPLEGATU KUDEAKETA");
		btnEnplegatuKudeaketa.setBounds(160, 168, 250, 39);
		getContentPane().add(btnEnplegatuKudeaketa);
		
		JButton btnTxostenakSortu = new JButton("TXOSTENAK SORTU");
		btnTxostenakSortu.setBounds(160, 247, 250, 39);
		getContentPane().add(btnTxostenakSortu);
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		
	}		
}
