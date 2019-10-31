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
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Leiho2DeptKudeaketa_JTABLE extends JFrame {

		private static final long serialVersionUID = 1L;
		protected static final Vector constante = null;
		private JButton btnKargatuFitxategia;
		private JTable table;
		private JButton btnIrten = new JButton("Irten");
		private JLabel lblDepartamentuKudeaketa = new JLabel("Langile Kudeaketa");
		private JScrollPane scrollPane = new JScrollPane();
		private DefaultTableModel t1= new DefaultTableModel();
		private String[]columnas = new String[6];
		private final JButton btnInsert = new JButton("Insert");
		private final JButton btnUpdate = new JButton("Update");
		private final JButton btnDelete = new JButton("Delete");
		/**
		 * @author talde6
		 */
		public Leiho2DeptKudeaketa_JTABLE() {
			this.setBounds(350,50,600,600);
			this.setTitle("6.taldearen langileen kudeaketa");
			this.setResizable(false); // neurketak ez aldatzeko
			this.setSize(new Dimension(802, 600));
			btnIrten.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnIrten.setForeground(Color.BLACK);
			btnIrten.setBounds(643, 487, 89, 35);
			
			
			btnIrten.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MetodoakLeihoAldaketa.lehenengoLeihoa();
				}
			});
			getContentPane().setLayout(null);
			getContentPane().add(btnIrten);
			scrollPane.setBorder(null);
			
			
			scrollPane.setBounds(37, 126, 695, 257);
			getContentPane().add(scrollPane);
			
			table = new JTable();
			table.setBorder(null);
			taulaFormatua();
			table.getTableHeader().setReorderingAllowed(false);
			scrollPane.setViewportView(table);
			lblDepartamentuKudeaketa.setHorizontalAlignment(SwingConstants.CENTER);
			
			
			lblDepartamentuKudeaketa.setBounds(0, 31, 796, 43);
			lblDepartamentuKudeaketa.setFont(new Font("Tahoma", Font.BOLD, 22));
			getContentPane().add(lblDepartamentuKudeaketa);
			
			btnKargatuFitxategia = new JButton("Kargatu fitxategia");
			btnKargatuFitxategia.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnKargatuFitxategia.setForeground(Color.BLACK);
			btnKargatuFitxategia.setBounds(62, 487, 188, 35);
			btnKargatuFitxategia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MetodoakLeihoAldaketa.bostgarrenLeihoa();
					dispose();
					
				}
			});
			getContentPane().add(btnKargatuFitxategia);
			
			JButton button = new JButton("+");
			button.setForeground(Color.BLACK);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t1.addRow(constante);
				}
			});
			button.setFont(new Font("Tahoma", Font.BOLD, 13));
			button.setBounds(742, 128, 44, 23);
			getContentPane().add(button);
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Langilea langile= new Langilea(
							
					t1.getValueAt(table.getSelectedRow(), 0).toString(),
					t1.getValueAt(table.getSelectedRow(), 1).toString(),
					t1.getValueAt(table.getSelectedRow(), 2).toString(),
					t1.getValueAt(table.getSelectedRow(), 3).toString(),
					t1.getValueAt(table.getSelectedRow(), 4).toString(),
					t1.getValueAt(table.getSelectedRow(), 5).toString()
				);
					//Esta leyendo directamente del modelo en vez del kontrolador. PENDIENTE DE CORREGIR
					eredua.DbKontsultak.langileTaulaIdatzi(langile);
				}
			});
			btnInsert.setBounds(113, 409, 89, 23);
			
			getContentPane().add(btnInsert);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Langilea langile= new Langilea(
							
							t1.getValueAt(table.getSelectedRow(), 0).toString(),
							t1.getValueAt(table.getSelectedRow(), 1).toString(),
							t1.getValueAt(table.getSelectedRow(), 2).toString(),
							t1.getValueAt(table.getSelectedRow(), 3).toString(),
							t1.getValueAt(table.getSelectedRow(), 4).toString(),
							t1.getValueAt(table.getSelectedRow(), 5).toString()
						);
							System.out.println(langile);
				}
			});
			btnUpdate.setBounds(352, 409, 89, 23);
			
			getContentPane().add(btnUpdate);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Langilea langile= new Langilea(
							
							t1.getValueAt(table.getSelectedRow(), 0).toString(),
							t1.getValueAt(table.getSelectedRow(), 1).toString(),
							t1.getValueAt(table.getSelectedRow(), 2).toString(),
							t1.getValueAt(table.getSelectedRow(), 3).toString(),
							t1.getValueAt(table.getSelectedRow(), 4).toString(),
							t1.getValueAt(table.getSelectedRow(), 5).toString()
						);
							System.out.println(langile);
				}
			});
			btnDelete.setBounds(574, 409, 89, 23);
			
			getContentPane().add(btnDelete);
			
			JButton btnReload = new JButton("Reload");
			btnReload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Se esta llamando directamente del paquete vista al modelo. PENDIENTE DE CORREGIR
					MetodoakLeihoAldaketa.lista_langileak = eredua.DbKontsultak.langileTaulaIrakurri();
					taulaBete(columnas);
				}
			});
			btnReload.setBounds(685, 86, 75, 23);
			getContentPane().add(btnReload);

		}
		public void taulaFormatua() {
			

			table.setModel(t1);
			t1.addColumn("NAN");
			t1.addColumn("IZENA");
			t1.addColumn("ABIZENAK");
			t1.addColumn("ARDURA");
			t1.addColumn("ARDURADUNA");
			t1.addColumn("DEPARTAMENTUA");
			
			taulaBete(columnas);
		}
		private void taulaBete(String[] columnas) {
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

	

