package ikuspegia;

import java.io.File;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import kontrolatzailea.MetodoakLeihoAldaketa;
import javax.swing.DefaultComboBoxModel;

public class Leiho5FitxKargatu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel lblMenuNagusia, lblMota, lblRuta;
	private JButton btnIrten, btnKargatu, button;
	private JComboBox comboBox;
	private File fitxategia;
	
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
		lblMota.setForeground(Color.BLACK);
		lblMota.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMota.setBounds(38, 154, 55, 23);
		getContentPane().add(lblMota);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.addItem("xml");
		comboBox.addItem("csv");
		comboBox.addItem("json");
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(103, 157, 73, 20);
		getContentPane().add(comboBox);
		
		lblRuta = new JLabel("Ruta: ");
		lblRuta.setForeground(Color.BLACK);
		lblRuta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRuta.setBounds(38, 207, 55, 23);
		getContentPane().add(lblRuta);
		
		textField = new JTextField();
		textField.setBounds(101, 210, 422, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnKargatu = new JButton("Kargatu");
		btnKargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( "xml".equals(comboBox.getSelectedItem().toString())){
				
					kontrolatzailea.MetodoakLeihoAldaketa.lista_langileak = eredua.FitxKudeaketaLangilea.irakurriOharrakXML();
					eredua.DbKontsultak.multiLangileTaulaIdatzi(kontrolatzailea.MetodoakLeihoAldaketa.lista_langileak);
				}else if ("csv".equals(comboBox.getSelectedItem().toString())) {
					kontrolatzailea.MetodoakLeihoAldaketa.lista_langileak = eredua.FitxKudeaketaLangilea.irakurriLangileakCSV(fitxategia.getAbsolutePath());	
					eredua.DbKontsultak.multiLangileTaulaIdatzi(kontrolatzailea.MetodoakLeihoAldaketa.lista_langileak);
				}else if("json".equals(comboBox.getSelectedItem().toString())) {
					
				}else {
					System.out.println("Erroa Aukerarekin");
				}
			}
		});
		btnKargatu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKargatu.setForeground(Color.BLACK);
		btnKargatu.setBounds(260, 493, 123, 40);
		getContentPane().add(btnKargatu);
		
		button = new JButton("...");
		button.setForeground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(button);
				fitxategia = jf.getSelectedFile();
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
