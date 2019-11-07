package ikuspegia;

import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import kontrolatzailea.MetodoakLeihoAldaketa;

public class Leiho2DeptKudeaketa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblDepartKod, lblIzena, lblKokapena , lblEraikuntzaZbk, lblIrakKop, lblDepartamentuDatuak, lblKokapena_1;
	private JTextField txtIzena, txtEraikuntzaZbk, txtIrakKop;
	private JButton btnKargatuFitxategia, btnEzeztatu, btnGorde, btnTxostenakSortu;
	private JComboBox jcbKokapena, jcbDeptKod;

	public Leiho2DeptKudeaketa() {
		//panelaren propietateak
		//	setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen DEPARTAMENTU kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		lblDepartamentuDatuak = new JLabel("Departamentu datuak -----------------------------------------------------------------------------------------");
		lblDepartamentuDatuak.setForeground(Color.GRAY);
		lblDepartamentuDatuak.setBounds(10, 23, 590, 14);
		getContentPane().add(lblDepartamentuDatuak);

		lblDepartKod = new JLabel("Departamentu kodea:");
		lblDepartKod.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartKod.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDepartKod.setForeground(Color.BLACK);
		lblDepartKod.setBounds(20, 60, 233, 21);
		getContentPane().add(lblDepartKod);

		ArrayList<String> froga = new ArrayList<String>();
		froga.add("aaa");
		froga.add("bbb");
		froga.add("ccc");
		froga.add("ddd");
		froga.add("eee");

		jcbDeptKod = new JComboBox();
		jcbDeptKod.setFont(new Font("Dialog", Font.PLAIN, 16));
		jcbDeptKod.setForeground(Color.BLACK);
		jcbDeptKod.setBounds(258, 60, 124, 27);
		// DEPARTAMENTU KODEAK JARRI BEHAR DIRA, EZ froga /
		for (int i = 0; i < froga.size(); i++)
			jcbDeptKod.addItem(froga.get(i));
		jcbDeptKod.setSelectedIndex(0);
		getContentPane().add(jcbDeptKod);

		lblIzena = new JLabel("Izena:");
		lblIzena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIzena.setForeground(Color.BLACK);
		lblIzena.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIzena.setBounds(20, 118, 233, 21);
		getContentPane().add(lblIzena);

		txtIzena = new JTextField();
		txtIzena.setColumns(10);
		txtIzena.setBounds(258, 118, 124, 27);
		txtIzena.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letraIzena = e.getKeyChar();
				String cadena = letraIzena + "";
				if (txtIzena.getText().length() > 45 || !cadena.matches("[a-zA-Z]"))
					e.consume(); // ez du godetzen

			}
		});
		getContentPane().add(txtIzena);

		lblKokapena_1 = new JLabel("Kokapena --------------------------------------------------------------------------------------------------------");
		lblKokapena_1.setForeground(Color.GRAY);
		lblKokapena_1.setBounds(10, 176, 578, 15);
		getContentPane().add(lblKokapena_1);

		lblKokapena = new JLabel("Kokapena:");
		lblKokapena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKokapena.setForeground(Color.BLACK);
		lblKokapena.setFont(new Font("Dialog", Font.BOLD, 16));
		lblKokapena.setBounds(20, 218, 233, 21);
		getContentPane().add(lblKokapena);

		jcbKokapena = new JComboBox();
		jcbKokapena.setFont(new Font("Dialog", Font.PLAIN, 14));
		jcbKokapena.setForeground(Color.BLACK);
		jcbKokapena.setBounds(258, 212, 205, 33);
		jcbKokapena.addItem("ELORRIETA");
		jcbKokapena.addItem("ERREKA-MARI");
		jcbKokapena.setSelectedIndex(0);

		getContentPane().add(jcbKokapena);

		lblEraikuntzaZbk = new JLabel("Eraikuntza zenbakia:");
		lblEraikuntzaZbk.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEraikuntzaZbk.setForeground(Color.BLACK);
		lblEraikuntzaZbk.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEraikuntzaZbk.setBounds(20, 298, 233, 21);
		getContentPane().add(lblEraikuntzaZbk);

		txtEraikuntzaZbk = new JTextField();
		txtEraikuntzaZbk.setColumns(10);
		txtEraikuntzaZbk.setBounds(258, 296, 124, 27);
		txtEraikuntzaZbk.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letraEraikuntzaZBK = e.getKeyChar();
				String cadena = letraEraikuntzaZBK + "";
				if (txtEraikuntzaZbk.getText().length() > 2 || !cadena.matches("[0-9]"))
					e.consume(); // ez du godetzen

			}
		});
		getContentPane().add(txtEraikuntzaZbk);

		lblIrakKop = new JLabel("Irakasle kopurua:");
		lblIrakKop.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIrakKop.setForeground(Color.BLACK);
		lblIrakKop.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIrakKop.setBounds(20, 385, 233, 21);
		getContentPane().add(lblIrakKop);

		txtIrakKop = new JTextField();
		txtIrakKop.setColumns(10);
		txtIrakKop.setBounds(258, 383, 124, 27);
		txtIrakKop.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letraIrakKop = e.getKeyChar();
				String cadena = letraIrakKop + "";
				if (txtIrakKop.getText().length() > 2 || !cadena.matches("[0-9]"))
					e.consume(); // ez du godetzen

			}
		});
		getContentPane().add(txtIrakKop);

		// botoiak
		btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEzeztatu.setForeground(Color.BLACK);
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.lehenengoLeihoa();
			}
		});
		btnEzeztatu.setBounds(440, 490, 124, 32);
		getContentPane().add(btnEzeztatu);

		btnKargatuFitxategia = new JButton("Kargatu fitxategia");
		btnKargatuFitxategia.setFont(new Font("Dialog", Font.BOLD, 16));
		btnKargatuFitxategia.setForeground(Color.BLACK);
		btnKargatuFitxategia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.bostgarrenLeihoa();
				dispose();
			}
		});
		btnKargatuFitxategia.setBounds(34, 490, 221, 32);
		getContentPane().add(btnKargatuFitxategia);

		btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtIzena.getText().matches("[a-zA-Z]") && txtIrakKop.getText().matches("[0-9]{1,3}") && txtEraikuntzaZbk.getText().matches("[0-9]{1,3}"))
					System.out.println("baaaaiiii"); // llamar metodo subir datos
			}
		});
		btnGorde.setForeground(Color.BLACK);
		btnGorde.setFont(new Font("Dialog", Font.BOLD, 16));
		btnGorde.setBounds(295, 490, 99, 33);
		getContentPane().add(btnGorde);

	}	
}