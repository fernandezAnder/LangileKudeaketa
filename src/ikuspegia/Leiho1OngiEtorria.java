package ikuspegia;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import kontrolatzailea.MetodoakLeihoAldaketa;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Leiho1OngiEtorria extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnDepartamentuKudeaketa, btnEnplegatuKudeaketa, btnTxostenakSortu;
	public Leiho1OngiEtorria() {
	
		//panelaren propietateak
//		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		
		btnDepartamentuKudeaketa = new JButton("DEPARTAMENTU KUDEAKETA");
		btnDepartamentuKudeaketa.setForeground(Color.BLACK);
		btnDepartamentuKudeaketa.setFont(new Font("Dialog", Font.BOLD, 14));
		btnDepartamentuKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.bigarrenLeihoa(); 

				
				dispose();
			}
		});
		btnDepartamentuKudeaketa.setBounds(147, 220, 306, 67);
		getContentPane().add(btnDepartamentuKudeaketa);
		
		btnEnplegatuKudeaketa = new JButton("ENPLEGATU KUDEAKETA");
		btnEnplegatuKudeaketa.setForeground(Color.BLACK);
		btnEnplegatuKudeaketa.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEnplegatuKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.hirugarrenLeihoa();
				dispose();
			}
		});
		btnEnplegatuKudeaketa.setBounds(147, 112, 306, 67);
		getContentPane().add(btnEnplegatuKudeaketa);
		
		btnTxostenakSortu = new JButton("TXOSTENAK SORTU");
		btnTxostenakSortu.setForeground(Color.BLACK);
		btnTxostenakSortu.setFont(new Font("Dialog", Font.BOLD, 14));
		btnTxostenakSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.laugarrenLeihoa();
				dispose();
			}
		});
		btnTxostenakSortu.setBounds(147, 321, 306, 67);
		getContentPane().add(btnTxostenakSortu);
		
		JLabel lblMenuNagusia = new JLabel("MENU NAGUSIA");
		lblMenuNagusia.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblMenuNagusia.setBounds(190, 35, 224, 49);
		getContentPane().add(lblMenuNagusia);
		
		JButton btnIrten = new JButton("Irten");
		btnIrten.setBounds(447, 510, 89, 23);
		getContentPane().add(btnIrten);
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}		
}
