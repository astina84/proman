package web;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class MitarbeiterDAO extends DataAccessObject {

	public MitarbeiterDTO find(Long id) {
		   ResultSet rs = null;
		   PreparedStatement statement = null;
		   Connection connection = null;
		   try {
		      connection = getConnection();
		      String sql = "select * from Mitarbeiter where id=?";
		      statement = connection.prepareStatement(sql);
		      statement.setLong(1, id.longValue());
		      rs = statement.executeQuery();
		      if (!rs.next()) {
		         return null;
		      }
		      return read(rs);
		   }
		   catch (SQLException e) {
		      throw new RuntimeException(e);
		   }
		   finally {
		      close(rs, statement, connection);
		   }
		}
	
	private MitarbeiterDTO read(ResultSet rs) throws SQLException {
		
		   Long id = new Long(rs.getLong("idMitarbeiter"));
		   String vorname = rs.getString("vorname");
		   String nachname = rs.getString("nachname");
		   String geburtsdatum = rs.getString("geburtsdatum");
		   String sozialversicherungsNr = rs.getString("sozialversicherungsNr");
		   String straﬂe = rs.getString("straﬂe");
		   int plz = rs.getInt("plz");		 
		   String ort = rs.getString("ort");
		   String email = rs.getString("email");
		   String telefonnummer = rs.getString("telefonnummer");
		   String username = rs.getString("username");
		   String password = rs.getString("password");
		  		  		   
		   MitarbeiterDTO mitarbeiter = new MitarbeiterDTO();
		   
		   mitarbeiter.setIdMitarbeiter(id);
		   mitarbeiter.setVorname(vorname);
		   mitarbeiter.setNachname(nachname);
		   mitarbeiter.setGeburtsdatum(geburtsdatum);
		   mitarbeiter.setSozialversicherungsNr(sozialversicherungsNr);
		   mitarbeiter.setStraﬂe(straﬂe);
		   mitarbeiter.setPlz(plz);
		   mitarbeiter.setOrt(ort);
		   mitarbeiter.setEmail(email);
		   mitarbeiter.setTelefonnummer(telefonnummer);
		   mitarbeiter.setUsername(username);
		   mitarbeiter.setPassword(password);
		   	
		   return mitarbeiter;
		}
	
	public List<MitarbeiterDTO> findAll() {
		   LinkedList<MitarbeiterDTO> mitarbeiterListe = new LinkedList<MitarbeiterDTO>();
		   ResultSet rs = null;
		   PreparedStatement statement = null;
		   Connection connection = null;
		   try {
		      connection = getConnection();
		      String sql = "select * from news_item order by id";
		      statement = connection.prepareStatement(sql);
		      rs = statement.executeQuery();
		      while (rs.next()) {
		    	  MitarbeiterDTO mitarbeiter = read(rs);
		    	  mitarbeiterListe.add(mitarbeiter);
		      }
		      return mitarbeiterListe;
		   }
		   catch (SQLException e) {
		      throw new RuntimeException(e);
		   } 
		   finally {
		      close(rs, statement, connection);
		   }
		}
	
}
