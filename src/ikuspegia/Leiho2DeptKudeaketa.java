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
			

		}		
	}

	

