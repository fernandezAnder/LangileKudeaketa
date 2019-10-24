package eredua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;;

public class DbKontsultak {

	
public static ArrayList<String> langileTaulaIrakurri(){
		
		
		PreparedStatement s=null;
		Connection konexioa=Konexioa.getKonexioa();

		try {
			s = konexioa.prepareStatement("select *  from langileak");
			ResultSet rs = s.executeQuery();
		

			
			while (rs.next()) {
			
			}
			s.close(); // PREPAREDSTATEMENT itxi
			konexioa.close(); //DATUBASE konexioa itxi.
			
		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		
		return null;
	}

public static void langileTaulaIdatzi(ArrayList<Langilea> lista_langileak) {
	
	PreparedStatement s=null;
	Connection konexioa=Konexioa.getKonexioa();
	
	try {
		 s =  konexioa.prepareStatement(
				"INSERT INTO `LANGILEAK` (`NAN`, `IZENA`, `ABIZENAK`, `ARDURA`, `ARDURADUNA`,`DEPARTAMENTUAK_DEPART_KOD`)"
						+ " VALUES(?, ?, ?, ?, ?, ?)");
		 for (int i=0;i<lista_langileak.size();i++){
			 
		 	s.setString(1, lista_langileak.get(i).getNan());
		 	s.setString(2, lista_langileak.get(i).getIzena());
		 	s.setString(3, lista_langileak.get(i).getAbizenak());
		 	s.setString(4, lista_langileak.get(i).getArdura());
		 	s.setString(5, lista_langileak.get(i).getArduraduna());
		 	s.setString(6, lista_langileak.get(i).getDepartamentu_kod());
		 	
			s.executeUpdate();
			
		 }


		s.close(); // PREPAREDSTATEMENT itxi
		konexioa.close(); //DATUBASE konexioa itxi.

	} catch (Exception e) {
		System.out.println(e.getMessage());
	}

}

}
