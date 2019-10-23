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
import org.xml.sax.SAXException;

public class FitxKudeaketa {

	// .csv an dauden lerroak arraylist batean sartu
	public static ArrayList<Langilea> irakurriLangileakCSV() {
		// bariableak
		ArrayList<Langilea> lista_langileak = new ArrayList<Langilea>();
		FileReader fitxeroa = null;
		BufferedReader br = null;
		try { //aurkitzen duen ala ez
			fitxeroa = new FileReader("src/fitxategiak/langileak.csv");
			br = new BufferedReader(fitxeroa);
			// Langilearen bariableak
			
			String katea[];
			String nan="";
			String izena="";
			String abizenak="";
			String ardura="";
			String arduraduna="";
			String departamentuak_depart_kod="";

			try {
				
				String linea = br.readLine();
				while ((linea = br.readLine()) != null) {
					// lerro zuriak ez irakurtzeko
					katea = linea.split(",");
					nan = katea[0].replace("\"", "");
					izena = katea[1].replace("\"", "");
					abizenak = katea[2].replace("\"", "");
					ardura = katea[3].replace("\"", "");
					ardura = katea[4].replace("\"", "");
					departamentuak_depart_kod = katea[5].replace("\"", "");
					 
					Langilea langilea = new Langilea (nan, izena, abizenak, ardura, arduraduna, departamentuak_depart_kod);		
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
	public static int idatziLangileakCSV( ArrayList<Langilea> lista_langileak ) {
		int idatzita = 0;
		File d = new File("src/fitxategiak/langileak.csv");
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(d, true);
			bw = new BufferedWriter(fw);
			bw.newLine();
			for (int i =0;i<lista_langileak.size();i++) {
				bw.write(
					lista_langileak.get(i).getNan() + ",\""
					+ lista_langileak.get(i).getIzena() + "\",\""
					+ lista_langileak.get(i).getAbizenak() + "\",\""
					+ lista_langileak.get(i).getArdura() + "\",\""
					+ lista_langileak.get(i).getArduraduna() + "\",\""
					+ lista_langileak.get(i).getDepartamentu_kod()+ "\"");
					bw.flush(); // csv-an idatzitakoa gortzeko
					}
			idatzita = 1;
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return idatzita;
	}

	// .xml an dauden lerroak arraylist batean sartu
		public static ArrayList<Departamentua> irakurriOharrak() {
			// bariableak
			ArrayList<Departamentua> lista_oharrak = new ArrayList<Departamentua>();
			File fitxeroa = new File("src/Oharrak.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			Document doc = null;

			String data = "", ordua = "", nori = "", nork = "", titulua = "", edukia = "";

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
							data = eElement.getElementsByTagName("data").item(0).getTextContent();
							ordua = eElement.getElementsByTagName("ordua").item(0).getTextContent();
							nori = eElement.getElementsByTagName("nori").item(0).getTextContent();
							nork = eElement.getElementsByTagName("nork").item(0).getTextContent();
							titulua = eElement.getElementsByTagName("titulua").item(0).getTextContent();
							edukia = eElement.getElementsByTagName("edukia").item(0).getTextContent();
							//Oharra oharra = new Oharra(data, ordua, nori, nork, titulua, edukia);
							//lista_oharrak.add(oharra);
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
			return lista_oharrak;
		}

	// .xml aren amaieran idazten du.
		public static int idatziOharrak(Departamentua oharra) {
			int idatzita = 0;

			ArrayList<Departamentua> lista_oharrak = new ArrayList<Departamentua>();

			lista_oharrak = irakurriOharrak();
			lista_oharrak.add(oharra);

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
				for (int i = 0; i < lista_oharrak.size(); i++) {
					Element row = ficheroXML.createElement("row");

		/*			Element data = ficheroXML.createElement("data");
					Text datatext = ficheroXML.createTextNode(lista_oharrak.get(i).getData() + "\n");
					data.appendChild(datatext);
					row.appendChild(data);

					Element ordua = ficheroXML.createElement("ordua");
					Text orduatext = ficheroXML.createTextNode(lista_oharrak.get(i).getOrdua() + "\n");
					ordua.appendChild(orduatext);
					row.appendChild(ordua);

					Element nori = ficheroXML.createElement("nori");
					Text noritext = ficheroXML.createTextNode(lista_oharrak.get(i).getNori() + "\n");
					nori.appendChild(noritext);
					row.appendChild(nori);

					Element nork = ficheroXML.createElement("nork");
					Text norktext = ficheroXML.createTextNode(lista_oharrak.get(i).getNork() + "\n");
					nork.appendChild(norktext);
					row.appendChild(nork);

					Element titulua = ficheroXML.createElement("titulua");
					Text tituluatext = ficheroXML.createTextNode(lista_oharrak.get(i).getTitulua() + "\n");
					titulua.appendChild(tituluatext);
					row.appendChild(titulua);

					Element edukia = ficheroXML.createElement("edukia");
					Text edukiatext = ficheroXML.createTextNode(lista_oharrak.get(i).getEdukia() + "\n");
					edukia.appendChild(edukiatext);
					row.appendChild(edukia);
*/
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
/*
		public class OharrakKudeatu {
			static ArrayList<Oharra> lista_oharrak = new ArrayList<Oharra>();

			// .json an dauden lerroak arraylist batean sartu
			public static ArrayList<Oharra> irakurriOharrak() {
				JSONParser jsonParser = new JSONParser();

				try (FileReader reader = new FileReader("src/Oharrak.json")) {
					Object obj = jsonParser.parse(reader);
					JSONArray employeeList = (JSONArray) obj;
					employeeList.forEach(emp -> parseOharrakObject((JSONObject) emp));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return lista_oharrak;
			}

			private static void parseOharrakObject(JSONObject employee) {
				JSONObject oharraObject = (JSONObject) employee.get("oharra");

				String data = (String) oharraObject.get("data");
				String ordua = (String) oharraObject.get("ordua");
				String nori = (String) oharraObject.get("nori");
				String nork = (String) oharraObject.get("nork");
				String titulua = (String) oharraObject.get("titulua");
				String edukia = (String) oharraObject.get("edukia");

				Oharra oharra = new Oharra(data, ordua, nori, nork, titulua, edukia);
				lista_oharrak.add(oharra);
			}

			// .json aren amaieran idazten du.
			public static int idatziOharrak(Oharra oharra) {
				int idatzita = 0;
				lista_oharrak.add(oharra);

				JSONObject oharraDetails = new JSONObject();
				JSONArray employeeList = new JSONArray();
				JSONObject oharraObject = new JSONObject();
				
				for (int i = 0; i < lista_oharrak.size(); i++) {
					oharraDetails = new JSONObject();
					oharraObject = new JSONObject();
					
					oharraDetails.put("data", lista_oharrak.get(i).getData());
					oharraDetails.put("ordua", lista_oharrak.get(i).getOrdua());
					oharraDetails.put("nori", lista_oharrak.get(i).getNori());
					oharraDetails.put("nork", lista_oharrak.get(i).getNork());
					oharraDetails.put("titulua", lista_oharrak.get(i).getTitulua());
					oharraDetails.put("edukia", lista_oharrak.get(i).getEdukia());

					oharraObject.put("oharra", oharraDetails);
					employeeList.add(oharraObject);

				}
				try (FileWriter file = new FileWriter("src/Oharrak.json")) {
					file.write(employeeList.toJSONString());
					file.flush();
					idatzita = 1;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return idatzita;
			}
*/

}
