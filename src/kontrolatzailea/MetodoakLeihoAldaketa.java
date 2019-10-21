package kontrolatzailea;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import ikuspegia.*;

public class MetodoakLeihoAldaketa {

	public static void lehenengoLeihoa() {
		Leiho1OngiEtorria Leiho1 = new Leiho1OngiEtorria();
		Leiho1.setVisible(true);
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
