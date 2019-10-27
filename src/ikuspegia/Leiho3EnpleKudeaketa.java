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
	private JTextField txtSaberBorrar;
	private char letra;
	private JTextField txtNan, txtIzena, txtAbizena, txtArduraduna;
	private JLabel lblArdura, lblArduraduna, lblNan, lblIzena, lblabizenak, lblDepartamentuKodea, lblDerrigorrezNan,
			lblDerrigorrezIzena, lblDerrigorrezAbizenak, lblDerrigorrezDeptKod, lblDerrigorrezArdura;;
	private JComboBox jcbDeptKod, jcbArdura;
	private JButton btnGorde, btnEzeztatu;
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

		txtNan = new JTextField();
		txtNan.setBounds(41, 74, 124, 27);
		getContentPane().add(txtNan);
		txtNan.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letraNan = e.getKeyChar();
				String cadena = e.toString();
				// bakarrik karakter bat (V,v,M,m) sartzekoa
				if (txtSaberBorrar.getText().length() > 5
						|| letraNan != 'E' && letraNan != 'e' || cadena.matches("[^ @/\\=]"))
					e.consume(); // ez du godetzen
				
				// bakarrik karakter bat (V,v,M,m) sartzekoa
				/*if (txtNan.getText().length() > 9 || cadena.matches("[@/\\=]")) {
					e.consume(); // ez du godetzen
					
				}*/
			}
		});
		txtNan.setColumns(10);

		lblNan = new JLabel("NAN");
		lblNan.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNan.setForeground(Color.BLACK);
		lblNan.setBounds(41, 46, 47, 27);
		getContentPane().add(lblNan);

		lblIzena = new JLabel("Izena");
		lblIzena.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIzena.setForeground(Color.BLACK);
		lblIzena.setBounds(41, 139, 56, 21);
		getContentPane().add(lblIzena);

		txtIzena = new JTextField();
		txtIzena.setColumns(10);
		txtIzena.setBounds(41, 167, 124, 27);
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
		jcbDeptKod.setBounds(159, 265, 159, 42);
		/* DEPARTAMENTU KODEAK JARRI BEHAR DIRA, EZ froga */
		for (int i = 0; i < froga.size(); i++) {
			System.out.println(froga.get(i));
			jcbDeptKod.addItem(froga.get(i));
		}
		getContentPane().add(jcbDeptKod);

		lblDepartamentuKodea = new JLabel("Departamentu kodea");
		lblDepartamentuKodea.setForeground(Color.BLACK);
		lblDepartamentuKodea.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDepartamentuKodea.setBounds(145, 220, 200, 33);
		getContentPane().add(lblDepartamentuKodea);

		btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if (txt_nan, txtIzena, txtAbizena, txtArduraduna;
				if (!txtNan.getText().equals("") && !txtIzena.getText().equals("") && !txtAbizena.getText().equals("") && !txtArduraduna.getText().equals(""))
					System.out.println(); // llamar metodo subir datos
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
		lblDerrigorrezNan.setBounds(83, 46, 16, 15);
		getContentPane().add(lblDerrigorrezNan);

		lblDerrigorrezIzena = new JLabel("*");
		lblDerrigorrezIzena.setForeground(Color.RED);
		lblDerrigorrezIzena.setBounds(91, 139, 16, 15);
		getContentPane().add(lblDerrigorrezIzena);

		lblDerrigorrezAbizenak = new JLabel("*");
		lblDerrigorrezAbizenak.setForeground(Color.RED);
		lblDerrigorrezAbizenak.setBounds(350, 139, 16, 15);
		getContentPane().add(lblDerrigorrezAbizenak);

		lblDerrigorrezDeptKod = new JLabel("*");
		lblDerrigorrezDeptKod.setForeground(Color.RED);
		lblDerrigorrezDeptKod.setBounds(339, 220, 16, 15);
		getContentPane().add(lblDerrigorrezDeptKod);

		lblDerrigorrezArdura = new JLabel("*");
		lblDerrigorrezArdura.setForeground(Color.RED);
		lblDerrigorrezArdura.setBounds(103, 352, 16, 15);
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

		txtSaberBorrar = new JTextField();
		txtSaberBorrar.setText("SABER BORRAR");
		txtSaberBorrar.setBounds(10, 11, 86, 20);
		getContentPane().add(txtSaberBorrar);
		txtSaberBorrar.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				letra = e.getKeyChar();
				// bakarrik karakter bat (V,v,M,m) sartzekoa
				if (txtSaberBorrar.getText().length() > 5
						|| letra != 'E' && letra != 'e' && letra != 'G' && letra != 'g')
					e.consume(); // ez du godetzen
			}
		});

		getContentPane().add(txtSaberBorrar);
		txtSaberBorrar.setColumns(10);
		
		
	}
}
