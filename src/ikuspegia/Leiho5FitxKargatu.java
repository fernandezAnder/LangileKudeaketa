package ikuspegia;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import kontrolatzailea.MetodoakLeihoAldaketa;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class Leiho5FitxKargatu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel lblMenuNagusia, lblMota, lblRuta;
	private JComboBox comboBox; 
	private JButton btnIrten, btnKargatu, button;
	
	public Leiho5FitxKargatu() {
		//panelaren propietateak
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		
		
		lblMenuNagusia = new JLabel("Fitxategia Kargatu\r\n");
		lblMenuNagusia.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblMenuNagusia.setBounds(188, 22, 251, 49);
		getContentPane().add(lblMenuNagusia);
		
		btnIrten = new JButton("Irten");
		btnIrten.setBounds(447, 510, 89, 23);
		getContentPane().add(btnIrten);
		
		lblMota = new JLabel("Mota: ");
		lblMota.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMota.setBounds(35, 127, 55, 23);
		getContentPane().add(lblMota);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBox.setBounds(100, 130, 98, 20);
		getContentPane().add(comboBox);
		
		lblRuta = new JLabel("Ruta: ");
		lblRuta.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRuta.setBounds(35, 180, 55, 23);
		getContentPane().add(lblRuta);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 18));
		textField.setBounds(98, 183, 407, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnKargatu = new JButton("Kargatu");
		btnKargatu.setBounds(294, 510, 89, 23);
		getContentPane().add(btnKargatu);
		
		button = new JButton("...");
		button.setFont(new Font("Dialog", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(button);
				File fitxategia = jf.getSelectedFile();
				if (fitxategia != null) {
					textField.setText(fitxategia.getAbsolutePath());
				}
			}
		});
		button.setBounds(515, 182, 28, 23);
		getContentPane().add(button);
		
		
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}		
}
