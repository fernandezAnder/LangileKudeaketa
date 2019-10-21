package ikuspegia;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Leiho4Txostenak extends JFrame {
	
	private static final long serialVersionUID = 1L;

	
	public Leiho4Txostenak() {
		//panelaren propietateak
//		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
		this.setTitle("6.taldearen langileen kudeaketa");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
	}
	
}
