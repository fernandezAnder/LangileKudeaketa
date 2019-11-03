package ikuspegia;

import java.util.ArrayList;
import java.util.Vector;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import kontrolatzailea.MetodoakLeihoAldaketa;
import eredua.Langilea;
import jdk.nashorn.internal.runtime.ListAdapter;

public class Leiho2DeptKudeaketa_JTABLE extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static final Vector constante = null;
	private JButton btnKargatuFitxategia, btnIrten = new JButton("Irten"), plus = new JButton("+"), btnReload = new JButton("Reload");
	private JTable table;
	private JLabel lblDepartamentuKudeaketa = new JLabel("Langile Kudeaketa");
	private JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel t1 = new DefaultTableModel();
	private String[] columnas = new String[6];
	
	private final JButton btnInsert = new JButton("Insert"), btnUpdate = new JButton("Update"),
			btnDelete = new JButton("Delete");

	public Leiho2DeptKudeaketa_JTABLE() {
		this.setBounds(350, 50, 600, 600);
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
		scrollPane.setBounds(12, 97, 720, 299);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setBorder(null);
		taulaFormatua();
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		lblDepartamentuKudeaketa.setForeground(Color.BLACK);
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
				

			}
		});
		getContentPane().add(btnKargatuFitxategia);

		plus.setForeground(Color.BLACK);
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.addRow(constante);
			}
		});
		plus.setFont(new Font("Tahoma", Font.BOLD, 11));
		plus.setBounds(738, 109, 47, 35);
		getContentPane().add(plus);
		btnInsert.setForeground(Color.BLACK);

		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Langilea langile = new Langilea(
						t1.getValueAt(table.getSelectedRow(), 0).toString(),
						t1.getValueAt(table.getSelectedRow(), 1).toString(),
						t1.getValueAt(table.getSelectedRow(), 2).toString(),
						t1.getValueAt(table.getSelectedRow(), 3).toString(),
						t1.getValueAt(table.getSelectedRow(), 4).toString(),
						t1.getValueAt(table.getSelectedRow(), 5).toString());
				kontrolatzailea.MetodoakBBDD.langileTaulaIdatzi(langile);
			}
		});
		btnInsert.setBounds(113, 409, 89, 23);
		getContentPane().add(btnInsert);
		btnUpdate.setForeground(Color.BLACK);

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Langilea langile = new Langilea(
						t1.getValueAt(table.getSelectedRow(), 0).toString(),
						t1.getValueAt(table.getSelectedRow(), 1).toString(),
						t1.getValueAt(table.getSelectedRow(), 2).toString(),
						t1.getValueAt(table.getSelectedRow(), 3).toString(),
						t1.getValueAt(table.getSelectedRow(), 4).toString(),
						t1.getValueAt(table.getSelectedRow(), 5).toString());
				kontrolatzailea.MetodoakBBDD.langileTaulaAldatu(langile);
			}
		});
		btnUpdate.setBounds(352, 409, 89, 23);
		getContentPane().add(btnUpdate);
		btnDelete.setForeground(Color.BLACK);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Langilea langile = new Langilea(
						t1.getValueAt(table.getSelectedRow(), 0).toString(),
						t1.getValueAt(table.getSelectedRow(), 1).toString(),
						t1.getValueAt(table.getSelectedRow(), 2).toString(),
						t1.getValueAt(table.getSelectedRow(), 3).toString(),
						t1.getValueAt(table.getSelectedRow(), 4).toString(),
						t1.getValueAt(table.getSelectedRow(), 5).toString());
				kontrolatzailea.MetodoakBBDD.langileTaulaEzabatu(langile);
			}
		});
		btnDelete.setBounds(574, 409, 89, 23);
		getContentPane().add(btnDelete);
		btnReload.setForeground(Color.BLACK);

		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taulaEzabatu();
				MetodoakLeihoAldaketa.lista_langileak = kontrolatzailea.MetodoakBBDD.langileTaulaIrakurri();
				columnas = new String [6];
				taulaBete(columnas);
			}
		});
		btnReload.setBounds(634, 62, 129, 23);
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
		for (int i = 0; i < MetodoakLeihoAldaketa.lista_langileak.size(); i++) {
			columnas[0] = MetodoakLeihoAldaketa.lista_langileak.get(i).getNan();
			columnas[1] = MetodoakLeihoAldaketa.lista_langileak.get(i).getIzena();
			columnas[2] = MetodoakLeihoAldaketa.lista_langileak.get(i).getAbizenak();
			columnas[3] = MetodoakLeihoAldaketa.lista_langileak.get(i).getArdura();
			columnas[4] = MetodoakLeihoAldaketa.lista_langileak.get(i).getArduraduna();
			columnas[5] = MetodoakLeihoAldaketa.lista_langileak.get(i).getDepartamentu_kod();
			t1.addRow(columnas);
		}
	}
	private void taulaEzabatu() {
		while (t1.getRowCount() > 0)
		{
		t1.removeRow(0);
		}
		
	}
}
