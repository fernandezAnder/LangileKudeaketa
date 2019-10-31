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
	private JButton btnIrten, btnKargatu, button;
	private JComboBox comboBox;
	
	public Leiho5FitxKargatu() {	
		//panelaren propietateak
		getContentPane().setLayout(null);
		
		lblMenuNagusia = new JLabel("Fitxategia Kargatu\r\n");
		lblMenuNagusia.setForeground(Color.BLACK);
		lblMenuNagusia.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblMenuNagusia.setBounds(30, 31, 472, 49);
		getContentPane().add(lblMenuNagusia);
		
		btnIrten = new JButton("Irten");
		btnIrten.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIrten.setForeground(Color.BLACK);
		btnIrten.setBounds(447, 493, 89, 40);
		getContentPane().add(btnIrten);
		
		lblMota = new JLabel("Mota: ");
		lblMota.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMota.setBounds(38, 154, 55, 23);
		getContentPane().add(lblMota);
		
		comboBox = new JComboBox();
		comboBox.setBounds(103, 157, 73, 20);
		getContentPane().add(comboBox);
		
		lblRuta = new JLabel("Ruta: ");
		lblRuta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRuta.setBounds(38, 207, 55, 23);
		getContentPane().add(lblRuta);
		
		textField = new JTextField();
		textField.setBounds(101, 210, 422, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnKargatu = new JButton("Kargatu");
		btnKargatu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKargatu.setForeground(Color.BLACK);
		btnKargatu.setBounds(260, 493, 123, 40);
		getContentPane().add(btnKargatu);
		
		button = new JButton("...");
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
		button.setBounds(521, 209, 28, 23);
		getContentPane().add(button);
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}		
}
