package ikuspegia;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Leiho3EnpleKudeaketa extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField txtSaberBorrar;
	private char letra;

	/**
	 * Ongietorria ematen duen panela sortu
	 * @author talde3
	 */
	public Leiho3EnpleKudeaketa() {
	
		//panelaren propietateak
//		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		
		
		txtSaberBorrar = new JTextField();
		txtSaberBorrar.setText("SABER BORRAR");
		txtSaberBorrar.setBounds(96, 56, 86, 20);
		getContentPane().add(txtSaberBorrar); 
		txtSaberBorrar.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				letra = e.getKeyChar();
				// bakarrik karakter bat (V,v,M,m) sartzekoa
				if (txtSaberBorrar.getText().length() > 5 || letra != 'E' && letra != 'e' && letra != 'G' && letra != 'g')
					e.consume(); // ez du godetzen
			}
		});
		
		getContentPane().add(txtSaberBorrar);
		txtSaberBorrar.setColumns(10);
		
	}		
}
