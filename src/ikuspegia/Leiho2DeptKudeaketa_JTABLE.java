package ikuspegia;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import eredua.Langilea;
import jdk.nashorn.internal.runtime.ListAdapter;
import kontrolatzailea.MetodoakLeihoAldaketa;
import sun.swing.MenuItemLayoutHelper.ColumnAlignment;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Leiho2DeptKudeaketa_JTABLE extends JFrame {

		private static final long serialVersionUID = 1L;
		private JButton btnKargatuFitxategia;
		private JTable table;
		JButton btnIrten = new JButton("Irten");
		JLabel lblDepartamentuKudeaketa = new JLabel("Departamentu Kudeaketa");
		JScrollPane scrollPane = new JScrollPane();
		
		/**
		 * @author talde6
		 */
		public Leiho2DeptKudeaketa_JTABLE() {
			this.setBounds(350,50,600,600);
			this.setTitle("6.taldearen langileen kudeaketa");
			this.setResizable(false); // neurketak ez aldatzeko
			this.setSize(new Dimension(600, 600));
			btnIrten.setBounds(424, 513, 89, 23);
			
			
			btnIrten.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MetodoakLeihoAldaketa.lehenengoLeihoa();
				}
			});
			getContentPane().setLayout(null);
			getContentPane().add(btnIrten);
			scrollPane.setBorder(null);
			
			
			scrollPane.setBounds(62, 126, 483, 257);
			getContentPane().add(scrollPane);
			
			table = new JTable();
			table.setBorder(null);
			taulaFormatua();
			table.getTableHeader().setReorderingAllowed(false);
			scrollPane.setViewportView(table);
			
			
			lblDepartamentuKudeaketa.setBounds(140, 25, 297, 43);
			lblDepartamentuKudeaketa.setFont(new Font("Tahoma", Font.BOLD, 22));
			getContentPane().add(lblDepartamentuKudeaketa);
			
			btnKargatuFitxategia = new JButton("Kargatu fitxategia");
			btnKargatuFitxategia.setBounds(62, 499, 125, 23);
			btnKargatuFitxategia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MetodoakLeihoAldaketa.bostgarrenLeihoa();
					dispose();
					
				}
			});
			getContentPane().add(btnKargatuFitxategia);

		}
		public void taulaFormatua() {
			String[]columnas = new String[6];
			
			DefaultTableModel t1= new DefaultTableModel(){
				public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
			};

			table.setModel(t1);
			t1.addColumn("NAN");
			t1.addColumn("IZENA");
			t1.addColumn("ABIZENAK");
			t1.addColumn("ARDURA");
			t1.addColumn("ARDURADUNA");
			t1.addColumn("DEPARTAMENTUAK_DEPART_KOD");
			
			for (int i=0;i<MetodoakLeihoAldaketa.lista_langileak.size();i++) {
					
			columnas[0]=MetodoakLeihoAldaketa.lista_langileak.get(i).getNan();
			columnas[1]=MetodoakLeihoAldaketa.lista_langileak.get(i).getIzena();
			columnas[2]=MetodoakLeihoAldaketa.lista_langileak.get(i).getAbizenak();
			columnas[3]=MetodoakLeihoAldaketa.lista_langileak.get(i).getArdura();
			columnas[4]=MetodoakLeihoAldaketa.lista_langileak.get(i).getArduraduna();
			columnas[5]=MetodoakLeihoAldaketa.lista_langileak.get(i).getDepartamentu_kod();
			t1.addRow(columnas);
			}
		}		
	}

	

