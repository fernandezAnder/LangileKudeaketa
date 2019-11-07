package kontrolatzailea;

import java.util.ArrayList;

import eredua.Langilea;

public class MetodoakFitxIrakurri {
	
	public static ArrayList<Langilea> irakurriLangileakXMLMet(String helbidea) {
		System.out.println(helbidea);
		return eredua.FitxKudeaketaLangilea.irakurriLangileakXML(helbidea);
	}
	public static ArrayList<Langilea> irakurriLangileakCSVMet(String helbidea) {
		return eredua.FitxKudeaketaLangilea.irakurriLangileakCSV(helbidea);
	}
	
	public static ArrayList<Langilea> irakurriLangileakJSONMet(String helbidea) {
		return eredua.FitxKudeaketaLangilea.irakurriLangileakJSON(helbidea);
	}
}
