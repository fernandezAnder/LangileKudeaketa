package eredua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;;

public class DbKontsultak {

	
public static ArrayList<Langilea> langileTaulaIrakurri(){
		
		ArrayList<Langilea> lista_langilea = new ArrayList<Langilea>();
		PreparedStatement s=null;
		Connection konexioa=Konexioa.getKonexioa();

		try {
			s = konexioa.prepareStatement("select *  from langileak");
			ResultSet rs = s.executeQuery();
			String nan, izena, abizenak, ardura, arduraduna, departamentua;

			
			while (rs.next()) {
			nan = rs.getString(0);
			izena = rs.getString(1);
			abizenak = rs.getString(2);
			ardura= rs.getString(3);
			arduraduna = rs.getString(4);
			departamentua = rs.getString(5);
			Langilea langilea = new Langilea(nan, izena, abizenak, ardura, arduraduna, departamentua);
			lista_langilea.add(langilea);
			}
			s.close(); // PREPAREDSTATEMENT itxi
			konexioa.close(); //DATUBASE konexioa itxi.
			
		}catch(Exception e) {e.getMessage();
		System.out.println(e.getMessage());
		}
		
		return lista_langilea;
	}

public static void langileTaulaIdatzi(Langilea langile) {
	
	PreparedStatement s=null;
	Connection konexioa=Konexioa.getKonexioa();
	
	try {
		 s =  konexioa.prepareStatement(
				"INSERT INTO `LANGILEAK` (`NAN`, `IZENA`, `ABIZENAK`, `ARDURA`, `ARDURADUNA`,`DEPARTAMENTUAK_DEPART_KOD`)"
						+ " VALUES(?, ?, ?, ?, ?, ?)");
		
			 
		 	s.setString(1, langile.getNan());
		 	s.setString(2, langile.getIzena());
		 	s.setString(3, langile.getAbizenak());
		 	s.setString(4, langile.getArdura());
		 	s.setString(5, langile.getArduraduna());
		 	s.setString(6, langile.getDepartamentu_kod());
		 	
			s.executeUpdate();
			
		 


		s.close(); // PREPAREDSTATEMENT itxi
		konexioa.close(); //DATUBASE konexioa itxi.

	} catch (Exception e) {
		System.out.println(e.getMessage());
	}

}

}
