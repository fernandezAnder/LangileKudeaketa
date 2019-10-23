package eredua;

import java.sql.Connection;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;;

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

public static void langileTaulaIdatzi() {
	
	PreparedStatement s=null;
	Connection konexioa=Konexioa.getKonexioa();
	
	try {
		 s =  konexioa.prepareStatement(
				"INSERT INTO `langileak` (`nan`, `izena`, `abizenak`, `ardura`, `arduraduna`,`departamentuak`,`depart_kod`)"
						+ " VALUES(?, ?, ?, ?, ?, ?, ?)");
//		s.setString(1, bezeroa.getDni());
//		s.setString(2, bezeroa.getIzena());
//		s.setString(3, bezeroa.getAbizena());
//		s.setString(4, bezeroa.getData());
//		s.setString(5, bezeroa.getPasahitza());
//		s.setString(6, );
//		s.setString(7, );

		s.executeUpdate();
		s.close(); // PREPAREDSTATEMENT itxi
		konexioa.close(); //DATUBASE konexioa itxi.

	} catch (Exception e) {
		System.out.println(e.getMessage());
	}

}

}
