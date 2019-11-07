package ikuspegia;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import eredua.Langilea;


public class Leiho4Txostenak extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea arrayTxtA;
	private ArrayList<Langilea> ateraLangileak = null;
	private JButton btnIrten, btnFitxeroaSortu;
	private JScrollPane scrollPane;
	
	public Leiho4Txostenak() {
		//panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(100, 100, 300, 300);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(400, 550));

		ateraLangileak = kontrolatzailea.MetodoakBBDD.langileTaulaIrakurri();
		
		//TEXTAREA
		arrayTxtA = new JTextArea();
		arrayTxtA.setEditable(false);
		for (int i = 0; i < ateraLangileak.size(); i++) {
			arrayTxtA.setText(arrayTxtA.getText() + ateraLangileak.get(i).toString());
		}
		arrayTxtA.setBounds(26, 11, 558, 503);
		
		scrollPane = new JScrollPane(arrayTxtA);
		scrollPane.setBounds(10, 11, 374, 470);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);

		//BOTOIA
		btnIrten = new JButton("Irten");
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontrolatzailea.MetodoakLeihoAldaketa.lehenengoLeihoa();
				dispose();
			}
		});
		btnIrten.setBounds(295, 492, 89, 23);
		getContentPane().add(btnIrten);
		
		
		btnFitxeroaSortu = new JButton("Fitxeroa sortu");
		btnFitxeroaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Fitxeroa ondo sortuta", "XML fitxeroa sortuta", 0);

			}
		});
		btnFitxeroaSortu.setBounds(10, 492, 128, 23);
		getContentPane().add(btnFitxeroaSortu);

		
	}
	
}
