package ikuspegia;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import kontrolatzailea.MetodoakLeihoAldaketa;

public class Leiho1OngiEtorria extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnDepartamentuKudeaketa, btnEnplegatuKudeaketa, btnTxostenakSortu;
	public Leiho1OngiEtorria() {
	
		//panelaren propietateak
//		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		
		btnDepartamentuKudeaketa = new JButton("DEPARTAMENTU KUDEAKETA");
		btnDepartamentuKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.bigarrenLeihoa(); 
				dispose();
			}
		});
		btnDepartamentuKudeaketa.setBounds(160, 108, 250, 39);
		getContentPane().add(btnDepartamentuKudeaketa);
		
		btnEnplegatuKudeaketa = new JButton("ENPLEGATU KUDEAKETA");
		btnEnplegatuKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.hirugarrenLeihoa();
				dispose();
			}
		});
		btnEnplegatuKudeaketa.setBounds(160, 168, 250, 39);
		getContentPane().add(btnEnplegatuKudeaketa);
		
		btnTxostenakSortu = new JButton("TXOSTENAK SORTU");
		btnTxostenakSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.laugarrenLeihoa();
				dispose();
			}
		});
		btnTxostenakSortu.setBounds(160, 247, 250, 39);
		getContentPane().add(btnTxostenakSortu);
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		
	}		
}
