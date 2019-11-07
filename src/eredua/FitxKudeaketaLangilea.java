package eredua;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import jdk.nashorn.internal.parser.JSONParser;

public class FitxKudeaketaLangilea {

	// .csv an dauden lerroak arraylist batean sartu
	public static ArrayList<Langilea> irakurriLangileakCSV(String helbidea) {
		// bariableak
		ArrayList<Langilea> lista_langileak = new ArrayList<Langilea>();
		FileReader fitxeroa = null;
		BufferedReader br = null;
		try { // aurkitzen duen ala ez
			fitxeroa = new FileReader(helbidea);
			br = new BufferedReader(fitxeroa);
			// Langilearen bariableak

			String katea[];
			String nan = "";
			String izena = "";
			String abizenak = "";
			String ardura = "";
			String arduraduna = "";
			String departamentuak_depart_kod = "";

			try {

				String linea = br.readLine();
				while ((linea = br.readLine()) != null) {
					// lerro zuriak ez irakurtzeko
					katea = linea.split(",");
					nan = katea[0].replace("\"", "");
					izena = katea[1].replace("\"", "");
					abizenak = katea[2].replace("\"", "");
					ardura = katea[3].replace("\"", "");
					arduraduna = katea[4].replace("\"", "");
					departamentuak_depart_kod = katea[5].replace("\"", "");

					Langilea langilea = new Langilea(nan, izena, abizenak, ardura, arduraduna,
							departamentuak_depart_kod);
					lista_langileak.add(langilea);
				}
				br.close();
				fitxeroa.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			JOptionPane.showConfirmDialog(null, "Ez da fitxeroa aurkitzen", "Bai-ra eman", 0);
		}

		return lista_langileak;
	}

	// .csv aren amaieran idazten du.
	public static int idatziLangileakCSV(ArrayList<Langilea> lista_langileak,String helbidea) {
		int idatzita = 0;
		File d = new File(helbidea);
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(d, true);
			bw = new BufferedWriter(fw);
			bw.newLine();
			for (int i = 0; i < lista_langileak.size(); i++) {
				bw.write(lista_langileak.get(i).getNan() + ",\"" + lista_langileak.get(i).getIzena() + "\",\""
						+ lista_langileak.get(i).getAbizenak() + "\",\"" + lista_langileak.get(i).getArdura() + "\",\""
						+ lista_langileak.get(i).getArduraduna() + "\",\""
						+ lista_langileak.get(i).getDepartamentu_kod() + "\"");
				bw.flush(); // csv-an idatzitakoa gortzeko
			}
			idatzita = 1;
		} catch (IOException e) {
			// e.printStackTrace();
		}
		return idatzita;
	}

	// .xml an dauden lerroak arraylist batean sartu
	public static ArrayList<Langilea> irakurriLangileakXML(String helbidea) {
		// bariableak
		ArrayList<Langilea> lista_langilea = new ArrayList<Langilea>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc = null;

		String nan = "";
		String izena = "";
		String abizenak = "";
		String ardura = "";
		String arduraduna = "";
		String departamentuak_depart_kod = "";
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			try {
				doc = dBuilder.parse(helbidea);
				doc.getDocumentElement().normalize();
				NodeList lista = doc.getElementsByTagName("LANGILEAK");

				for (int temp = 0; temp < lista.getLength(); temp++) {
					Node nNode = lista.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						nan = eElement.getElementsByTagName("NAN").item(0).getTextContent();
						izena = eElement.getElementsByTagName("IZENA").item(0).getTextContent();
						abizenak = eElement.getElementsByTagName("ABIZENAK").item(0).getTextContent();
						ardura = eElement.getElementsByTagName("ARDURA").item(0).getTextContent();
						arduraduna = eElement.getElementsByTagName("ARDURADUNA").item(0).getTextContent();
						departamentuak_depart_kod = eElement.getElementsByTagName("DEPARTAMENTUAK_DEPART_KOD").item(0).getTextContent();
						Langilea oharra = new Langilea(nan, izena, abizenak, ardura, arduraduna,
								departamentuak_depart_kod);
						lista_langilea.add(oharra);
					}
				}
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		System.out.println();
		return lista_langilea;
	}

	// .xml aren amaieran idazten du.
	public static int idatziLangileakXML(ArrayList<Langilea> lista_langileak,String helbidea) {
		int idatzita = 0;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		DOMImplementation implementation = builder.getDOMImplementation();

		Document ficheroXML = implementation.createDocument(null, "root", null);
		ficheroXML.setXmlVersion("1.0");

		Element raiz = ficheroXML.getDocumentElement();

		try {
			for (int i = 0; i < lista_langileak.size(); i++) {
				Element row = ficheroXML.createElement("LANGILEAK");

				Element nan = ficheroXML.createElement("NAN");
				Text nantext = ficheroXML.createTextNode(lista_langileak.get(i).getNan() + "\n");
				nan.appendChild(nantext);
				row.appendChild(nan);

				Element abizenak = ficheroXML.createElement("ABIZENAK");
				Text abizenaktext = ficheroXML.createTextNode(lista_langileak.get(i).getAbizenak() + "\n");
				abizenak.appendChild(abizenaktext);
				row.appendChild(abizenak);

				Element ardura = ficheroXML.createElement("ARDURA");
				Text arduratext = ficheroXML.createTextNode(lista_langileak.get(i).getArdura() + "\n");
				ardura.appendChild(arduratext);
				row.appendChild(ardura);

				Element arduraduna = ficheroXML.createElement("ARDURADUNA");
				Text arduradunatext = ficheroXML.createTextNode(lista_langileak.get(i).getArduraduna() + "\n");
				arduraduna.appendChild(arduradunatext);
				row.appendChild(arduraduna);

				Element departamentuak_depart_kod = ficheroXML.createElement("DEPARTAMENTUAK_DEPART_KOD");
				Text departamentuak_depart_kodtext = ficheroXML
						.createTextNode(lista_langileak.get(i).getDepartamentu_kod() + "\n");
				departamentuak_depart_kod.appendChild(departamentuak_depart_kodtext);
				row.appendChild(departamentuak_depart_kod);

				raiz.appendChild(row);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		ficheroXML.normalizeDocument();

		Source source = new DOMSource(ficheroXML);
		Result result = new StreamResult(new File(helbidea));
		Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			idatzita = 1;
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}

		return idatzita;
	}

	// .json an dauden lerroak arraylist batean sartu
	public static ArrayList<Langilea> irakurriLangileakJSON(String helbidea) {
		ArrayList<Langilea> lista_langilea = new ArrayList<Langilea>();
		File fitxeroa = new File(helbidea);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc = null;

		String nan, izena, abizenak, ardura, arduraduna, departamentu_kod;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			try {
				doc = dBuilder.parse(fitxeroa);
				doc.getDocumentElement().normalize();
				NodeList lista = doc.getElementsByTagName("LANGILEAK");

				for (int temp = 0; temp < lista.getLength(); temp++) {
					Node nNode = lista.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						nan = eElement.getElementsByTagName("NAN").item(0).getTextContent();
						izena = eElement.getElementsByTagName("IZENA").item(0).getTextContent();
						abizenak = eElement.getElementsByTagName("ABIZENAK").item(0).getTextContent();
						ardura = eElement.getElementsByTagName("ARDURA").item(0).getTextContent();
						arduraduna = eElement.getElementsByTagName("ARDURADUNA").item(0).getTextContent();
						departamentu_kod = eElement.getElementsByTagName("DEPARTAMENTUAK_DEPART_KOD").item(0).getTextContent();
						Langilea langilea = new Langilea(nan, izena, abizenak, ardura, arduraduna, departamentu_kod);
						lista_langilea.add(langilea);
					}
				}
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		System.out.println();
		return lista_langilea;
	}

	// .xml aren amaieran idazten du.
	public static int idatziLangileak(ArrayList<Langilea> lista_langileak,String helbidea) {
		int idatzita = 0;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		DOMImplementation implementation = builder.getDOMImplementation();

		Document ficheroXML = implementation.createDocument(null, "root", null);
		ficheroXML.setXmlVersion("1.0");

		Element raiz = ficheroXML.getDocumentElement();

		try {
			for (int i = 0; i < lista_langileak.size(); i++) {
				Element row = ficheroXML.createElement("LANGILEAK");

				Element nan = ficheroXML.createElement("NAN");
				Text nanText = ficheroXML.createTextNode(lista_langileak.get(i).getNan() + "\n");
				nan.appendChild(nanText);
				row.appendChild(nan);

				Element izena = ficheroXML.createElement("IZENA");
				Text izenaText = ficheroXML.createTextNode(lista_langileak.get(i).getIzena() + "\n");
				izena.appendChild(izenaText);
				row.appendChild(izena);

				Element abizenak = ficheroXML.createElement("ABIZENAK");
				Text abizenakText = ficheroXML.createTextNode(lista_langileak.get(i).getAbizenak() + "\n");
				abizenak.appendChild(abizenakText);
				row.appendChild(abizenak);

				Element ardura = ficheroXML.createElement("ARDURA");
				Text arduraText = ficheroXML.createTextNode(lista_langileak.get(i).getArdura() + "\n");
				ardura.appendChild(arduraText);
				row.appendChild(ardura);

				Element arduraduna = ficheroXML.createElement("ARDURADUNA");
				Text arduradunaText = ficheroXML.createTextNode(lista_langileak.get(i).getArduraduna() + "\n");
				arduraduna.appendChild(arduradunaText);
				row.appendChild(arduraduna);

				Element departamentu_kod = ficheroXML.createElement("DEPARTAMENTUAK_DEPART_KOD");
				Text departamentu_kodText = ficheroXML.createTextNode(lista_langileak.get(i).getDepartamentu_kod() + "\n");
				departamentu_kod.appendChild(departamentu_kodText);
				row.appendChild(departamentu_kod);

				raiz.appendChild(row);
			}

		} catch (Exception e) {

		}

		ficheroXML.normalizeDocument();

		Source source = new DOMSource(ficheroXML);
		Result result = new StreamResult(new File(helbidea));
		Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			idatzita = 1;
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}


		return idatzita;
	}

	
	
}
