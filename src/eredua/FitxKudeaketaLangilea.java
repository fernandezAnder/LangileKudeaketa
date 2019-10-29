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
	public static ArrayList<Langilea> irakurriLangileakCSV() {
		// bariableak
		ArrayList<Langilea> lista_langileak = new ArrayList<Langilea>();
		FileReader fitxeroa = null;
		BufferedReader br = null;
		try { // aurkitzen duen ala ez
			fitxeroa = new FileReader("src/fitxategiak/langileak.csv");
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
	public static int idatziLangileakCSV(ArrayList<Langilea> lista_langileak) {
		int idatzita = 0;
		File d = new File("src/fitxategiak/langileak.csv");
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
	public static ArrayList<Langilea> irakurriOharrakXML() {
		// bariableak
		ArrayList<Langilea> lista_langilea = new ArrayList<Langilea>();
		File fitxeroa = new File("src/Oharrak.xml");
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
				doc = dBuilder.parse(fitxeroa);
				doc.getDocumentElement().normalize();
				NodeList lista = doc.getElementsByTagName("langilea");

				for (int temp = 0; temp < lista.getLength(); temp++) {
					Node nNode = lista.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						nan = eElement.getElementsByTagName("nan").item(0).getTextContent();
						izena = eElement.getElementsByTagName("izena").item(0).getTextContent();
						abizenak = eElement.getElementsByTagName("abizenak").item(0).getTextContent();
						ardura = eElement.getElementsByTagName("ardura").item(0).getTextContent();
						arduraduna = eElement.getElementsByTagName("arduraduna").item(0).getTextContent();
						departamentuak_depart_kod = eElement.getElementsByTagName("departamentuak_depart_kod").item(0)
								.getTextContent();
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
	public static int idatziOharrakXML(Langilea langilea) {
		int idatzita = 0;

		ArrayList<Langilea> lista_langilea = new ArrayList<Langilea>();

		lista_langilea = irakurriOharrakXML();
		lista_langilea.add(langilea);

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
			for (int i = 0; i < lista_langilea.size(); i++) {
				Element row = ficheroXML.createElement("langilea");

				Element nan = ficheroXML.createElement("nan");
				Text nantext = ficheroXML.createTextNode(lista_langilea.get(i).getNan() + "\n");
				nan.appendChild(nantext);
				row.appendChild(nan);

				Element abizenak = ficheroXML.createElement("abizenak");
				Text abizenaktext = ficheroXML.createTextNode(lista_langilea.get(i).getAbizenak() + "\n");
				abizenak.appendChild(abizenaktext);
				row.appendChild(abizenak);

				Element ardura = ficheroXML.createElement("ardura");
				Text arduratext = ficheroXML.createTextNode(lista_langilea.get(i).getArdura() + "\n");
				ardura.appendChild(arduratext);
				row.appendChild(ardura);

				Element arduraduna = ficheroXML.createElement("arduraduna");
				Text arduradunatext = ficheroXML.createTextNode(lista_langilea.get(i).getArduraduna() + "\n");
				arduraduna.appendChild(arduradunatext);
				row.appendChild(arduraduna);

				Element departamentuak_depart_kod = ficheroXML.createElement("departamentuak_depart_kod");
				Text departamentuak_depart_kodtext = ficheroXML
						.createTextNode(lista_langilea.get(i).getDepartamentu_kod() + "\n");
				departamentuak_depart_kod.appendChild(departamentuak_depart_kodtext);
				row.appendChild(departamentuak_depart_kod);

				raiz.appendChild(row);
			}

		} catch (Exception e) {

		}

		ficheroXML.normalizeDocument();

		Source source = new DOMSource(ficheroXML);
		Result result = new StreamResult(new File("src/Oharrak.xml"));
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
	public static ArrayList<Langilea> irakurriOharrakJSON(String helbidea) {
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
				NodeList lista = doc.getElementsByTagName("row");

				for (int temp = 0; temp < lista.getLength(); temp++) {
					Node nNode = lista.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						nan = eElement.getElementsByTagName("nan").item(0).getTextContent();
						izena = eElement.getElementsByTagName("izena").item(0).getTextContent();
						abizenak = eElement.getElementsByTagName("abizenak").item(0).getTextContent();
						ardura = eElement.getElementsByTagName("ardura").item(0).getTextContent();
						arduraduna = eElement.getElementsByTagName("arduraduna").item(0).getTextContent();
						departamentu_kod = eElement.getElementsByTagName("departamentu_kod").item(0).getTextContent();
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
	public static int idatziOharrak(Langilea langilea, String helbidea) {
		int idatzita = 0;

		ArrayList<Langilea> lista_langilea = new ArrayList<Langilea>();

		lista_langilea = irakurriOharrakJSON(helbidea);
		lista_langilea.add(langilea);

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
			for (int i = 0; i < lista_langilea.size(); i++) {
				Element row = ficheroXML.createElement("langilea");

				Element nan = ficheroXML.createElement("nan");
				Text nanText = ficheroXML.createTextNode(lista_langilea.get(i).getNan() + "\n");
				nan.appendChild(nanText);
				row.appendChild(nan);

				Element izena = ficheroXML.createElement("izena");
				Text izenaText = ficheroXML.createTextNode(lista_langilea.get(i).getIzena() + "\n");
				izena.appendChild(izenaText);
				row.appendChild(izena);

				Element abizenak = ficheroXML.createElement("abizenak");
				Text abizenakText = ficheroXML.createTextNode(lista_langilea.get(i).getAbizenak() + "\n");
				abizenak.appendChild(abizenakText);
				row.appendChild(abizenak);

				Element ardura = ficheroXML.createElement("ardura");
				Text arduraText = ficheroXML.createTextNode(lista_langilea.get(i).getArdura() + "\n");
				ardura.appendChild(arduraText);
				row.appendChild(ardura);

				Element arduraduna = ficheroXML.createElement("arduraduna");
				Text arduradunaText = ficheroXML.createTextNode(lista_langilea.get(i).getArduraduna() + "\n");
				arduraduna.appendChild(arduradunaText);
				row.appendChild(arduraduna);

				Element departamentu_kod = ficheroXML.createElement("departamentu_kod");
				Text departamentu_kodText = ficheroXML.createTextNode(lista_langilea.get(i).getDepartamentu_kod() + "\n");
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
