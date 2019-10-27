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
	public Leiho5FitxKargatu() {
	
		//panelaren propietateak
//		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		
		JLabel lblMenuNagusia = new JLabel("Fitxategia Kargatu\r\n");
		lblMenuNagusia.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblMenuNagusia.setBounds(30, 31, 251, 49);
		getContentPane().add(lblMenuNagusia);
		
		JButton btnIrten = new JButton("Irten");
		btnIrten.setBounds(447, 510, 89, 23);
		getContentPane().add(btnIrten);
		
		JLabel lblMota = new JLabel("Mota: ");
		lblMota.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMota.setBounds(38, 154, 55, 23);
		getContentPane().add(lblMota);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(103, 157, 28, 20);
		getContentPane().add(comboBox);
		
		JLabel lblRuta = new JLabel("Ruta: ");
		lblRuta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRuta.setBounds(38, 207, 55, 23);
		getContentPane().add(lblRuta);
		
		textField = new JTextField();
		textField.setBounds(101, 210, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnKargatu = new JButton("Kargatu");
		btnKargatu.setBounds(294, 510, 89, 23);
		getContentPane().add(btnKargatu);
		
		JButton button = new JButton("...");
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
		button.setBounds(192, 209, 28, 23);
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
