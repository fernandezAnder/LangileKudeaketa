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
	private JButton btnEzabatuAldatuLangilea, btnGehituLangilea, btnMenuNagusia;
	private JLabel lblLangileKudeaketa;
	private JLabel asteriskoak1, asteriskoak2;

	public Leiho2LangileKudeaketa() {

		// panelaren propietateak
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		btnEzabatuAldatuLangilea = new JButton("EZABATU EDO ALDATU LANGILEA");
		btnEzabatuAldatuLangilea.setBackground(Color.LIGHT_GRAY);
		btnEzabatuAldatuLangilea.setForeground(Color.BLACK);
		btnEzabatuAldatuLangilea.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEzabatuAldatuLangilea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontrolatzailea.MetodoakLeihoAldaketa.hirugarrenLeihoaEzabatuAldatu();
				dispose();
			}
		});
		btnEzabatuAldatuLangilea.setBounds(148, 291, 306, 67);
		getContentPane().add(btnEzabatuAldatuLangilea);

		btnGehituLangilea = new JButton("GEHITU LANGILEA");
		btnGehituLangilea.setBackground(Color.LIGHT_GRAY);
		btnGehituLangilea.setForeground(Color.BLACK);
		btnGehituLangilea.setFont(new Font("Dialog", Font.BOLD, 14));
		btnGehituLangilea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontrolatzailea.MetodoakLeihoAldaketa.hirugarrenLeihoaGehitu();
				dispose();
			}
		});
		btnGehituLangilea.setBounds(148, 174, 306, 67);
		getContentPane().add(btnGehituLangilea);

		lblLangileKudeaketa = new JLabel("LANGILE KUDEAKETA");
		lblLangileKudeaketa.setForeground(Color.BLACK);
		lblLangileKudeaketa.setHorizontalAlignment(SwingConstants.CENTER);
		lblLangileKudeaketa.setFont(new Font("Tahoma", Font.ITALIC, 27));
		lblLangileKudeaketa.setBounds(0, 49, 600, 66);
		getContentPane().add(lblLangileKudeaketa);

		btnMenuNagusia = new JButton("Menu nagusira joan");
		btnMenuNagusia.setBackground(Color.LIGHT_GRAY);
		btnMenuNagusia.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMenuNagusia.setForeground(Color.BLACK);
		btnMenuNagusia.setBounds(148, 406, 306, 67);
		btnMenuNagusia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontrolatzailea.MetodoakLeihoAldaketa.lehenengoLeihoa();
				dispose();
			}
		});
		getContentPane().add(btnMenuNagusia);
		
		asteriskoak2 = new JLabel("*********************************************************");
		asteriskoak2.setHorizontalAlignment(SwingConstants.CENTER);
		asteriskoak2.setForeground(Color.BLACK);
		asteriskoak2.setFont(new Font("Tahoma", Font.BOLD, 15));
		asteriskoak2.setBounds(0, 92, 600, 66);
		getContentPane().add(asteriskoak2);
		
		asteriskoak1 = new JLabel("*********************************************************");
		asteriskoak1.setHorizontalAlignment(SwingConstants.CENTER);
		asteriskoak1.setForeground(Color.BLACK);
		asteriskoak1.setFont(new Font("Tahoma", Font.BOLD, 15));
		asteriskoak1.setBounds(0, 13, 600, 66);
		getContentPane().add(asteriskoak1);

	}
}
