package ikuspegia;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;

import kontrolatzailea.MetodoakLeihoAldaketa;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Leiho2DeptKudeaketa extends JFrame {

		private static final long serialVersionUID = 1L;
		private JTextField txtDeptKod;
		private JLabel lblDepartKod, lblIzena, lblKokapena , lblEraikuntzaZbk, lblIrakKop;
		private JTextField txtIzena, txtKokapena, txtEraikuntzaZbk, txtIrakKop;
		private JButton btnKargatuFitxategia;
		/**
		 * @author talde6
		 */
		public Leiho2DeptKudeaketa() {
		
			//panelaren propietateak
//			setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
			getContentPane().setLayout(null);
			this.setBounds(350,50,600,600);
			this.setTitle("6.taldearen langileen kudeaketa");
			this.setResizable(false); // neurketak ez aldatzeko
			this.setSize(new Dimension(600, 600));

			
			lblDepartKod = new JLabel("Departamentu kodea:");
			lblDepartKod.setFont(new Font("Dialog", Font.BOLD, 16));
			lblDepartKod.setForeground(Color.BLACK);
			lblDepartKod.setBounds(20, 109, 173, 21);
			getContentPane().add(lblDepartKod);

			txtDeptKod = new JTextField();
			txtDeptKod.setColumns(10);
			txtDeptKod.setBounds(197, 109, 124, 27);
			getContentPane().add(txtDeptKod);

			lblIzena = new JLabel("Izena:");
			lblIzena.setForeground(Color.BLACK);
			lblIzena.setFont(new Font("Dialog", Font.BOLD, 16));
			lblIzena.setBounds(140, 167, 47, 21);
			getContentPane().add(lblIzena);
			
			txtIzena = new JTextField();
			txtIzena.setColumns(10);
			txtIzena.setBounds(197, 167, 124, 27);
			getContentPane().add(txtIzena);
			
			lblKokapena = new JLabel("Kokapena:");
			lblKokapena.setForeground(Color.BLACK);
			lblKokapena.setFont(new Font("Dialog", Font.BOLD, 16));
			lblKokapena.setBounds(110, 253, 89, 21);
			getContentPane().add(lblKokapena);
			
			txtKokapena = new JTextField();
			txtKokapena.setColumns(10);
			txtKokapena.setBounds(209, 253, 124, 27);
			getContentPane().add(txtKokapena);

			lblEraikuntzaZbk = new JLabel("Eraikuntza zenbakia:");
			lblEraikuntzaZbk.setForeground(Color.BLACK);
			lblEraikuntzaZbk.setFont(new Font("Dialog", Font.BOLD, 16));
			lblEraikuntzaZbk.setBounds(35, 333, 164, 21);
			getContentPane().add(lblEraikuntzaZbk);
			
			txtEraikuntzaZbk = new JTextField();
			txtEraikuntzaZbk.setColumns(10);
			txtEraikuntzaZbk.setBounds(209, 333, 124, 27);
			getContentPane().add(txtEraikuntzaZbk);
			
			lblIrakKop = new JLabel("Irakasle kopurua:");
			lblIrakKop.setForeground(Color.BLACK);
			lblIrakKop.setFont(new Font("Dialog", Font.BOLD, 16));
			lblIrakKop.setBounds(62, 420, 139, 21);
			getContentPane().add(lblIrakKop);
			
			txtIrakKop = new JTextField();
			txtIrakKop.setColumns(10);
			txtIrakKop.setBounds(209, 420, 124, 27);
			getContentPane().add(txtIrakKop);
			
			JButton btnIrten = new JButton("Irten");
			btnIrten.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MetodoakLeihoAldaketa.lehenengoLeihoa();
				}
			});
			btnIrten.setBounds(420, 499, 89, 23);
			getContentPane().add(btnIrten);
			
			JLabel lblDepartamentuKudeaketa = new JLabel("Departamentu Kudeaketa");
			lblDepartamentuKudeaketa.setHorizontalAlignment(SwingConstants.CENTER);
			lblDepartamentuKudeaketa.setForeground(Color.BLACK);
			lblDepartamentuKudeaketa.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblDepartamentuKudeaketa.setBounds(10, 25, 578, 43);
			getContentPane().add(lblDepartamentuKudeaketa);
			
			JLabel lblDepartamentuDatuak = new JLabel("Departamentu datuak -----------------------------------------------------------------------------");
			lblDepartamentuDatuak.setBounds(10, 79, 590, 14);
			getContentPane().add(lblDepartamentuDatuak);
			
			JLabel lblKokapena_1 = new JLabel("Kokapena ------------------------------------------------------------------------------------------------");
			lblKokapena_1.setBounds(10, 226, 578, 15);
			getContentPane().add(lblKokapena_1);
			
			btnKargatuFitxategia = new JButton("Kargatu fitxategia");
			btnKargatuFitxategia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MetodoakLeihoAldaketa.bostgarrenLeihoa();
					dispose();
					
				}
			});
			btnKargatuFitxategia.setBounds(62, 499, 159, 23);
			getContentPane().add(btnKargatuFitxategia);

		}		
	}

	

