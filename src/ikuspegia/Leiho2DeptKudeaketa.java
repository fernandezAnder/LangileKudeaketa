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

public class Leiho2DeptKudeaketa extends JFrame {

		private static final long serialVersionUID = 1L;
		private JTextField txtDeptKod;
		private JLabel lblDepartKod, lblIzena, lblKokapena , lblEraikuntzaZbk, lblIrakKop;
		private JTextField txtIzena, txtKokapena, txtEraikuntzaZbk, txtIrakKop;
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
			lblDepartKod.setBounds(35, 37, 201, 21);
			getContentPane().add(lblDepartKod);

			txtDeptKod = new JTextField();
			txtDeptKod.setColumns(10);
			txtDeptKod.setBounds(82, 59, 124, 27);
			getContentPane().add(txtDeptKod);

			lblIzena = new JLabel("Izena:");
			lblIzena.setForeground(Color.BLACK);
			lblIzena.setFont(new Font("Dialog", Font.BOLD, 16));
			lblIzena.setBounds(35, 118, 63, 21);
			getContentPane().add(lblIzena);
			
			txtIzena = new JTextField();
			txtIzena.setColumns(10);
			txtIzena.setBounds(82, 140, 124, 27);
			getContentPane().add(txtIzena);
			
			lblKokapena = new JLabel("Kokapena:");
			lblKokapena.setForeground(Color.BLACK);
			lblKokapena.setFont(new Font("Dialog", Font.BOLD, 16));
			lblKokapena.setBounds(35, 197, 112, 21);
			getContentPane().add(lblKokapena);
			
			txtKokapena = new JTextField();
			txtKokapena.setColumns(10);
			txtKokapena.setBounds(82, 219, 124, 27);
			getContentPane().add(txtKokapena);

			lblEraikuntzaZbk = new JLabel("Eraikuntza zenbakia:");
			lblEraikuntzaZbk.setForeground(Color.BLACK);
			lblEraikuntzaZbk.setFont(new Font("Dialog", Font.BOLD, 16));
			lblEraikuntzaZbk.setBounds(35, 277, 201, 21);
			getContentPane().add(lblEraikuntzaZbk);
			
			txtEraikuntzaZbk = new JTextField();
			txtEraikuntzaZbk.setColumns(10);
			txtEraikuntzaZbk.setBounds(82, 299, 124, 27);
			getContentPane().add(txtEraikuntzaZbk);
			
			lblIrakKop = new JLabel("Irakasle kopurua:");
			lblIrakKop.setForeground(Color.BLACK);
			lblIrakKop.setFont(new Font("Dialog", Font.BOLD, 16));
			lblIrakKop.setBounds(35, 364, 201, 21);
			getContentPane().add(lblIrakKop);
			
			txtIrakKop = new JTextField();
			txtIrakKop.setColumns(10);
			txtIrakKop.setBounds(82, 386, 124, 27);
			getContentPane().add(txtIrakKop);

		}		
	}

	

