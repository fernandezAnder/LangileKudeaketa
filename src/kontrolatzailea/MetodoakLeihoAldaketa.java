package kontrolatzailea;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import ikuspegia.*;

public class MetodoakLeihoAldaketa {

	/**
	 * Leiho aldaketa1
	 * @author talde3
	 */
	public static void lehenengoLeihoa() {
		Leiho1OngiEtorria Leiho1 = new Leiho1OngiEtorria();
		Leiho1.setVisible(true);
	}

	/**
	 * Leiho aldaketa2
	 * @author talde3
	 */
	public static void bigarrenLeihoa() {
	//	Leiho2AukeratuOstatu Leiho2 = new Leiho2AukeratuOstatu();
		//Leiho2.setVisible(true);
	}

	// Leiho6-ko metodoak
	/**
	 * Leiho aldaketaren 5 segunduak itxaroteko
	 * @author talde3
	 */
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
