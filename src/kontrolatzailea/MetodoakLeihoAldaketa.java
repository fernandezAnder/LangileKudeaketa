package kontrolatzailea;

import eredua.*;
import ikuspegia.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class MetodoakLeihoAldaketa {
	public static ArrayList<Langilea> lista_langileak; //bariable globala
	
	public static void lehenengoLeihoa() {
		Leiho1OngiEtorria Leiho1 = new Leiho1OngiEtorria();
		Leiho1.setVisible(true);
		
		/**
		 * CSV FITXATEGITIK IRAKURTZEN DUEN FROGA EGITEKO 
		 */
		lista_langileak = eredua.FitxKudeaketaLangilea.irakurriLangileakCSV();
		MetodoakLeihoAldaketa.frogaLeihoa();
		
		
	}
		

	public static void bigarrenLeihoa() {
		Leiho2DeptKudeaketa Leiho2 = new Leiho2DeptKudeaketa();
		Leiho2.setVisible(true);
	}

	public static void hirugarrenLeihoa() {
		Leiho3EnpleKudeaketa Leiho3 = new Leiho3EnpleKudeaketa();
		Leiho3.setVisible(true);
	}
	
	public static void laugarrenLeihoa() {
		Leiho4Txostenak Leiho4 = new Leiho4Txostenak();
		Leiho4.setVisible(true);
	}
	public static void bostgarrenLeihoa() {
		Leiho5FitxKargatu Leiho5 = new Leiho5FitxKargatu();
		Leiho5.setVisible(true);
		
	}
	public static void frogaLeihoa() {
		Leiho2DeptKudeaketa_JTABLE froga = new Leiho2DeptKudeaketa_JTABLE();
		froga.setVisible(true);
	}

	// Leiho6-ko metodoak

	public static void Leiho_segunduak() {
		for (int i = 1; i <= 5; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		lehenengoLeihoa();
	}

}
