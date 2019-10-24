package ikuspegia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kontrolatzailea.MetodoakLeihoAldaketa;

public class Leiho3EnpleKudeaketa extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField txtSaberBorrar;
	private char letra;
	private JTextField txt_nan, txtIzena, txtAbizena, txtArduraduna, txtArdura;
	private JLabel lblArdura, lblArduraduna, lblNan, lblIzena, lblabizenak, lblDepartamentuKodea;
	private JComboBox cbDeptKod;
	private JButton btnGorde, btnEzeztatu;
	/**
	 * Ongietorria ematen duen panela sortu
	 * @author talde3
	 */
	public Leiho3EnpleKudeaketa() {
	
		//panelaren propietateak
//		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		
		txt_nan = new JTextField();
		txt_nan.setBounds(41, 74, 124, 27);
		getContentPane().add(txt_nan);
		txt_nan.setColumns(10);
		
		lblNan = new JLabel("NAN");
		lblNan.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNan.setForeground(Color.BLACK);
		lblNan.setBounds(41, 46, 66, 27);
		getContentPane().add(lblNan);
		
		lblIzena = new JLabel("Izena");
		lblIzena.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIzena.setForeground(Color.BLACK);
		lblIzena.setBounds(41, 139, 66, 21);
		getContentPane().add(lblIzena);
		
		txtIzena = new JTextField();
		txtIzena.setColumns(10);
		txtIzena.setBounds(41, 167, 124, 27);
		getContentPane().add(txtIzena);
		
		lblabizenak = new JLabel("Abizenak");
		lblabizenak.setFont(new Font("Dialog", Font.BOLD, 16));
		lblabizenak.setForeground(Color.BLACK);
		lblabizenak.setBounds(268, 139, 124, 21);
		getContentPane().add(lblabizenak);
		
		txtAbizena = new JTextField();
		txtAbizena.setForeground(Color.BLACK);
		txtAbizena.setColumns(10);
		txtAbizena.setBounds(268, 167, 228, 27);
		getContentPane().add(txtAbizena);
		
		lblArdura = new JLabel("Ardura");
		lblArdura.setFont(new Font("Dialog", Font.BOLD, 16));
		lblArdura.setForeground(Color.BLACK);
		lblArdura.setBounds(42, 341, 66, 27);
		getContentPane().add(lblArdura);
		
		txtArdura = new JTextField();
		txtArdura.setColumns(10);
		txtArdura.setBounds(42, 375, 124, 27);
		getContentPane().add(txtArdura);
		
		lblArduraduna = new JLabel("Arduraduna");
		lblArduraduna.setFont(new Font("Dialog", Font.BOLD, 16));
		lblArduraduna.setForeground(Color.BLACK);
		lblArduraduna.setBounds(270, 341, 143, 27);
		getContentPane().add(lblArduraduna);
		
		txtArduraduna = new JTextField();
		txtArduraduna.setForeground(Color.BLACK);
		txtArduraduna.setColumns(10);
		txtArduraduna.setBounds(270, 375, 124, 27);
		getContentPane().add(txtArduraduna);
		
		cbDeptKod = new JComboBox();
		cbDeptKod.setFont(new Font("Dialog", Font.BOLD, 16));
		cbDeptKod.setForeground(Color.BLACK);
		cbDeptKod.setBounds(159, 265, 159, 42);
		getContentPane().add(cbDeptKod);
		
		lblDepartamentuKodea = new JLabel("Departamentu kodea");
		lblDepartamentuKodea.setForeground(Color.BLACK);
		lblDepartamentuKodea.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDepartamentuKodea.setBounds(145, 220, 200, 33);
		getContentPane().add(lblDepartamentuKodea);
		
		btnGorde = new JButton("Gorde");
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
		
		
		
		
		
		
		txtSaberBorrar = new JTextField();
		txtSaberBorrar.setText("SABER BORRAR");
		txtSaberBorrar.setBounds(10, 11, 86, 20);
		getContentPane().add(txtSaberBorrar); 
		txtSaberBorrar.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				letra = e.getKeyChar();
				// bakarrik karakter bat (V,v,M,m) sartzekoa
				if (txtSaberBorrar.getText().length() > 5 || letra != 'E' && letra != 'e' && letra != 'G' && letra != 'g')
					e.consume(); // ez du godetzen
			}
		});
		
		getContentPane().add(txtSaberBorrar);
		txtSaberBorrar.setColumns(10);
		
	}		
}
