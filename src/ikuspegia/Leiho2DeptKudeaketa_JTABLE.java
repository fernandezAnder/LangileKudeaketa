package ikuspegia;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kontrolatzailea.MetodoakLeihoAldaketa;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Leiho2DeptKudeaketa_JTABLE extends JFrame {

		private static final long serialVersionUID = 1L;
		private JButton btnKargatuFitxategia;
		private JTable table;
		/**
		 * @author talde6
		 */
		public Leiho2DeptKudeaketa_JTABLE() {
		
			//panelaren propietateak
//			setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
			getContentPane().setLayout(null);
			this.setBounds(350,50,600,600);
			this.setTitle("6.taldearen langileen kudeaketa");
			this.setResizable(false); // neurketak ez aldatzeko
			this.setSize(new Dimension(600, 600));
			
			JButton btnIrten = new JButton("Irten");
			btnIrten.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MetodoakLeihoAldaketa.lehenengoLeihoa();
				}
			});
			btnIrten.setBounds(424, 513, 89, 23);
			getContentPane().add(btnIrten);
			
			JLabel lblDepartamentuKudeaketa = new JLabel("Departamentu Kudeaketa");
			lblDepartamentuKudeaketa.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblDepartamentuKudeaketa.setBounds(140, 25, 297, 43);
			getContentPane().add(lblDepartamentuKudeaketa);
			
			btnKargatuFitxategia = new JButton("Kargatu fitxategia");
			btnKargatuFitxategia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MetodoakLeihoAldaketa.bostgarrenLeihoa();
					dispose();
					
				}
			});
			btnKargatuFitxategia.setBounds(62, 499, 125, 23);
			getContentPane().add(btnKargatuFitxategia);
			
			JPanel panel = new JPanel();
			panel.setBounds(62, 129, 506, 314);
			getContentPane().add(panel);
			
			table = new JTable();
			panel.add(table);
			taulaFormatua();

		}
		private void taulaFormatua() {
			String[]columnas= {
					"NAN", "IZENA", "ABIZENAK", "ARDURA", "ARDURADUNA", "DEPARTAMENTUAK_DEPART_KOD"
				};
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
		


//			for (Apartamentua e:apartlista) {
//						columnas[0]=Integer.toString(e.getM2());
//						columnas[1]=Integer.toString(e.getSolairua());
//						columnas[2]=Integer.toString(e.getOstatu_id());
//						columnas[3]=e.getIzena();
//						columnas[4]=e.getHerria();
//						columnas[5]=e.getHelbidea();
//						columnas[6]=Integer.toString(e.getPosta_kod());
//						columnas[7]=e.getOstatu_mota();
//						columnas[8]=Integer.toString( e.getGela_kop());
//						columnas[9]=Integer.toString(e.getErreserba_kop());
//						columnas[10]=Integer.toString(e.getOspea());
//						columnas[11]=Integer.toString(e.getKomun_kop());
//						columnas[12]=Double.toString(e.getPrezioa());
//						t1.addRow(columnas);	
//				}	
		}		
	}

	

