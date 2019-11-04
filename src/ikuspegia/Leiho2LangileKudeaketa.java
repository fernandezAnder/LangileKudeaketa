package ikuspegia;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import kontrolatzailea.MetodoakLeihoAldaketa;

public class Leiho2LangileKudeaketa extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnEzabatuAldatuLangilea, btnGehituLangilea, btnIrten;
	private JLabel lblLangileKudeaketa;
	public Leiho2LangileKudeaketa() {
	
		//panelaren propietateak
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		
		
		btnEzabatuAldatuLangilea = new JButton("EZABATU EDO ALDATU LANGILEA");
		btnEzabatuAldatuLangilea.setForeground(Color.BLACK);
		btnEzabatuAldatuLangilea.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEzabatuAldatuLangilea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.bigarrenLeihoa(); 	
				dispose();
			}
		});
		btnEzabatuAldatuLangilea.setBounds(147, 220, 306, 67);
		getContentPane().add(btnEzabatuAldatuLangilea);
		
		btnGehituLangilea = new JButton("GEHITU LANGILEA");
		btnGehituLangilea.setForeground(Color.BLACK);
		btnGehituLangilea.setFont(new Font("Dialog", Font.BOLD, 14));
		btnGehituLangilea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.hirugarrenLeihoa();
				dispose();
			}
		});
		btnGehituLangilea.setBounds(147, 112, 306, 67);
		getContentPane().add(btnGehituLangilea);
		
		lblLangileKudeaketa = new JLabel("LANGILE KUDEAKETA");
		lblLangileKudeaketa.setForeground(Color.BLACK);
		lblLangileKudeaketa.setHorizontalAlignment(SwingConstants.CENTER);
		lblLangileKudeaketa.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblLangileKudeaketa.setBounds(0, 35, 600, 66);
		getContentPane().add(lblLangileKudeaketa);
		
		btnIrten = new JButton("Menu nagusira joan");
		btnIrten.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIrten.setForeground(Color.BLACK);
		btnIrten.setBounds(147, 344, 306, 58);
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(btnIrten);

		
	}		
}
