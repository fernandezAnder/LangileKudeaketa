package ikuspegia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import eredua.Langilea;
import kontrolatzailea.Metodoak;
import kontrolatzailea.MetodoakLeihoAldaketa;

public class Leiho3EnpleKudeaketa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNan, txtIzena, txtAbizena, txtArduraduna;
	private JLabel lblArdura, lblArduraduna, lblNan, lblIzena, lblabizenak, lblDepartamentuKodea, lblDerrigorrezNan,
			lblDerrigorrezIzena, lblDerrigorrezAbizenak, lblDerrigorrezDeptKod, lblDerrigorrezArdurana, lblLanarenDatuak, lblLangileDatuak, lblDerrigorrezArdura;
	private JComboBox jcbDeptKod, jcbArdura;
	private JButton btnGorde, btnEzeztatu, btnKargatuFitxategia;
	private ArrayList<String> ardura;
	/**
	 * Ongietorria ematen duen panela sortu
	 * 
	 * @author talde3
	 */
	public Leiho3EnpleKudeaketa() {

		// panelaren propietateak
//		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);

		this.setBounds(350, 50, 600, 600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		lblNan = new JLabel("NAN");
		lblNan.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNan.setForeground(Color.BLACK);
		lblNan.setBounds(41, 46, 47, 27);
		getContentPane().add(lblNan);

		txtNan = new JTextField();
		txtNan.setBounds(41, 74, 124, 27);
		txtNan.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letraNan = e.getKeyChar();
				String cadena = letraNan + "";
			/*	if (txtNan.getText().length() > 8 || !cadena.matches("[0-9A-Z]"))
					e.consume(); // ez du godetzen*/
				
			}
		});
		txtNan.setColumns(10);
		getContentPane().add(txtNan);

		lblIzena = new JLabel("Izena");
		lblIzena.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIzena.setForeground(Color.BLACK);
		lblIzena.setBounds(41, 139, 56, 21);
		getContentPane().add(lblIzena);

		txtIzena = new JTextField();
		txtIzena.setColumns(10);
		txtIzena.setBounds(41, 167, 124, 27);
		txtIzena.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letraIzena = e.getKeyChar();
				String cadena = letraIzena + "";
				/*if (txtIzena.getText().length() > 45 || !cadena.matches("[a-zA-Z]"))
					e.consume(); // ez du godetzen*/
				
			}
		});
		getContentPane().add(txtIzena);

		lblabizenak = new JLabel("Abizenak");
		lblabizenak.setFont(new Font("Dialog", Font.BOLD, 16));
		lblabizenak.setForeground(Color.BLACK);
		lblabizenak.setBounds(268, 139, 86, 21);
		getContentPane().add(lblabizenak);

		txtAbizena = new JTextField();
		txtAbizena.setForeground(Color.BLACK);
		txtAbizena.setColumns(10);
		txtAbizena.setBounds(268, 167, 228, 27);
		txtAbizena.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letraAbizena = e.getKeyChar();
				String cadena = letraAbizena + "";
				/*if (txtAbizena.getText().length() > 45 || !cadena.matches("[a-zA-Z]"))
					e.consume(); // ez du godetzen*/
				
			}
		});
		getContentPane().add(txtAbizena);

		lblArdura = new JLabel("Ardura");
		lblArdura.setFont(new Font("Dialog", Font.BOLD, 16));
		lblArdura.setForeground(Color.BLACK);
		lblArdura.setBounds(42, 352, 66, 27);
		getContentPane().add(lblArdura);

		lblArduraduna = new JLabel("Arduraduna");
		lblArduraduna.setFont(new Font("Dialog", Font.BOLD, 16));
		lblArduraduna.setForeground(Color.BLACK);
		lblArduraduna.setBounds(270, 352, 143, 27);
		getContentPane().add(lblArduraduna);

		txtArduraduna = new JTextField();
		txtArduraduna.setForeground(Color.BLACK);
		txtArduraduna.setColumns(10);
		txtArduraduna.setBounds(270, 386, 124, 27);
		txtArduraduna.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letraArduraduna = e.getKeyChar();
				String cadena = letraArduraduna + "";
				/*if (txtArduraduna.getText().length() > 8 || !cadena.matches("[0-9A-Z]"))
					e.consume(); // ez du godetzen	*/
			}
		});
		getContentPane().add(txtArduraduna);

		ArrayList<String> froga = new ArrayList<String>();
		froga.add("aaa");
		froga.add("bbb");
		froga.add("ccc");
		froga.add("ddd");
		froga.add("eee");

		jcbDeptKod = new JComboBox();
		jcbDeptKod.setFont(new Font("Dialog", Font.PLAIN, 16));
		jcbDeptKod.setForeground(Color.BLACK);
		jcbDeptKod.setBounds(155, 288, 159, 42);
		/* DEPARTAMENTU KODEAK JARRI BEHAR DIRA, EZ froga */
		for (int i = 0; i < froga.size(); i++) {
			System.out.println(froga.get(i));
			jcbDeptKod.addItem(froga.get(i));
		}
		getContentPane().add(jcbDeptKod);

		lblDepartamentuKodea = new JLabel("Departamentu kodea");
		lblDepartamentuKodea.setForeground(Color.BLACK);
		lblDepartamentuKodea.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDepartamentuKodea.setBounds(141, 243, 200, 33);
		getContentPane().add(lblDepartamentuKodea);

		btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtNan.getText().matches("\\d{8}+[A-Z]{1}"))
					lblDerrigorrezNan.setText("* Lehenengo 8 karaktereak zenbakiak izan behar dira eta azkena letra larria");
				else
					lblDerrigorrezNan.setText("*");

				if (txtIzena.getText().matches("[a-zA-Z]"))
					lblDerrigorrezIzena.setText("* Letrak bakarrik");
				else
					lblDerrigorrezIzena.setText("*");

				if (txtAbizena.getText().matches("[a-zA-Z]"))
					lblDerrigorrezAbizenak.setText("* Letrak bakarrik");
				else
					lblDerrigorrezAbizenak.setText("*");

				
				if (!txtArduraduna.getText().matches("\\d{8}+[A-Z]{1}"))
					lblDerrigorrezArdura.setText("NAN bat izan behar da, 8 karakter zenbakiz eta azkena letra larriz");
				else
					lblDerrigorrezArdura.setText("*");


				if (txtNan.getText().matches("\\d{8}+[A-Z]{1}") && !txtIzena.getText().matches("[a-zA-Z]")
						&& txtArduraduna.getText().matches("\\d{8}+[A-Z]{1}") && !txtAbizena.getText().matches("[a-zA-Z]"))
					System.out.println("baaaaiiii"); // llamar metodo subir datos
			}
		});
		btnGorde.setFont(new Font("Dialog", Font.BOLD, 16));
		btnGorde.setForeground(Color.BLACK);
		btnGorde.setBounds(252, 509, 114, 33);
		getContentPane().add(btnGorde);

		btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakLeihoAldaketa.lehenengoLeihoa();
				dispose();
			}
		});
		btnEzeztatu.setForeground(Color.BLACK);
		btnEzeztatu.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEzeztatu.setBounds(416, 509, 114, 33);
		getContentPane().add(btnEzeztatu);


		lblDerrigorrezNan = new JLabel("*");
		lblDerrigorrezNan.setForeground(Color.RED);
		lblDerrigorrezNan.setBounds(83, 46, 447, 15);
		getContentPane().add(lblDerrigorrezNan);

		lblDerrigorrezIzena = new JLabel("*");
		lblDerrigorrezIzena.setForeground(Color.RED);
		lblDerrigorrezIzena.setBounds(91, 139, 167, 15);
		getContentPane().add(lblDerrigorrezIzena);

		lblDerrigorrezAbizenak = new JLabel("*");
		lblDerrigorrezAbizenak.setForeground(Color.RED);
		lblDerrigorrezAbizenak.setBounds(350, 139, 200, 15);
		getContentPane().add(lblDerrigorrezAbizenak);

		lblDerrigorrezDeptKod = new JLabel("*");
		lblDerrigorrezDeptKod.setForeground(Color.RED);
		lblDerrigorrezDeptKod.setBounds(304, 255, 280, 15);
		getContentPane().add(lblDerrigorrezDeptKod);

		lblDerrigorrezArdurana = new JLabel("");
		lblDerrigorrezArdurana.setForeground(Color.RED);
		lblDerrigorrezArdurana.setBounds(367, 361, 183, 15);
		getContentPane().add(lblDerrigorrezArdurana);

		lblDerrigorrezArdura = new JLabel("*");
		lblDerrigorrezArdura.setForeground(Color.RED);
		lblDerrigorrezArdura.setBounds(102, 352, 157, 15);
		lblDerrigorrezArdura.setVisible(false);
		getContentPane().add(lblDerrigorrezArdura);

		
		ardura=Metodoak.arrayListArduraSortu();
		jcbArdura = new JComboBox();
		jcbArdura.setForeground(Color.BLACK);
		jcbArdura.setFont(new Font("Dialog", Font.PLAIN, 16));
		jcbArdura.setBounds(41, 377, 159, 42);
		for (int i = 0; i < ardura.size(); i++) {
			jcbArdura.addItem(ardura.get(i));
		}
		getContentPane().add(jcbArdura);
		
		btnKargatuFitxategia = new JButton("Kargatu fitxategia");
		btnKargatuFitxategia.setFont(new Font("Dialog", Font.BOLD, 13));
		btnKargatuFitxategia.setForeground(Color.BLACK);
		btnKargatuFitxategia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.bostgarrenLeihoa();
				dispose();
			}
		});
		btnKargatuFitxategia.setBounds(41, 509, 188, 31);
		getContentPane().add(btnKargatuFitxategia);

		lblLanarenDatuak = new JLabel("Lanaren datuak -----------------------------------------------------------------------------------------------------------");
		lblLanarenDatuak.setBounds(10, 218, 590, 14);
		getContentPane().add(lblLanarenDatuak);
		
		lblLangileDatuak = new JLabel("Langile datuak ---------------------------------------------------------------------------------------------------------------");
		lblLangileDatuak.setBounds(10, 31, 590, 14);
		getContentPane().add(lblLangileDatuak);
		
		
		
		
	}
}
