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
		      String sql = "select * from Mitarbeiter where idMitarbeiter=?";
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
	
	public MitarbeiterDTO find(String username) {
		   ResultSet rs = null;
		   PreparedStatement statement = null;
		   Connection connection = null;
		   try {
		      connection = getConnection();
		      String sql = "select * from Mitarbeiter where username=?";
		      statement = connection.prepareStatement(sql);
		      statement.setString(1, username);
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
	
	public MitarbeiterDTO checkPassword(String username,String password) {
		   ResultSet rs = null;
		   PreparedStatement statement = null;
		   Connection connection = null;
		   try {
		      connection = getConnection();
		      String sql = "select * from Mitarbeiter where Username=? and Password=?";
		      statement = connection.prepareStatement(sql);
		      statement.setString(1, username);
		      statement.setString(2, password);
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
		  		  		   
		   MitarbeiterDTO mitarbeiterDTO = new MitarbeiterDTO();
		   
		   mitarbeiterDTO.setIdMitarbeiter(id);
		   mitarbeiterDTO.setVorname(vorname);
		   mitarbeiterDTO.setNachname(nachname);
		   mitarbeiterDTO.setGeburtsdatum(geburtsdatum);
		   mitarbeiterDTO.setSozialversicherungsNr(sozialversicherungsNr);
		   mitarbeiterDTO.setStraﬂe(straﬂe);
		   mitarbeiterDTO.setPlz(plz);
		   mitarbeiterDTO.setOrt(ort);
		   mitarbeiterDTO.setEmail(email);
		   mitarbeiterDTO.setTelefonnummer(telefonnummer);
		   mitarbeiterDTO.setUsername(username);
		   mitarbeiterDTO.setPassword(password);
		   	
		   return mitarbeiterDTO;
		}
	
	public List<MitarbeiterDTO> findAll() {
		   LinkedList<MitarbeiterDTO> mitarbeiterListe = new LinkedList<MitarbeiterDTO>();
		   ResultSet rs = null;
		   PreparedStatement statement = null;
		   Connection connection = null;
		   try {
		      connection = getConnection();
		      String sql = "select * from Mitarbeiter order by idMitarbeiter";
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
	
	   public void update(MitarbeiterDTO mitarbeiterDTO)
	   {
	      PreparedStatement statement = null;
	      Connection connection = null;
	      try
	      {
	         connection = getConnection();
	         String sql = "update Mitarbeiter set " + "Vorname=?, Nachname=?, Geburtsdatum=?, SozialversicherungsNr=?, Straﬂe=?, PLZ=?, Ort=?, Email=?, Telefonnummer=?, Username=?, Password=? where id=?";
	         statement = connection.prepareStatement(sql);
	         statement.setString(1, mitarbeiterDTO.getVorname());
	         statement.setString(2, mitarbeiterDTO.getNachname());
	         statement.setString(3, mitarbeiterDTO.getGeburtsdatum());
	         statement.setString(4, mitarbeiterDTO.getSozialversicherungsNr());
	         statement.setString(5, mitarbeiterDTO.getStraﬂe());
	         statement.setInt(6, mitarbeiterDTO.getPlz());
	         statement.setString(7, mitarbeiterDTO.getOrt());
	         statement.setString(8, mitarbeiterDTO.getEmail());
	         statement.setString(9, mitarbeiterDTO.getTelefonnummer());
	         statement.setString(10, mitarbeiterDTO.getUsername());
	         statement.setString(11, mitarbeiterDTO.getPassword());
	         statement.setLong(12, mitarbeiterDTO.getIdMitarbeiter().longValue());
	         statement.execute();
	      } catch (SQLException e)
	      {
	         throw new RuntimeException(e);
	      } finally
	      {
	         close(statement, connection);
	      }
	   }
	
	   public void create(MitarbeiterDTO mitarbeiterDTO)
	   {
	      Long id = getUniqueId();
	      mitarbeiterDTO.setIdMitarbeiter(id);
	      PreparedStatement statement = null;
	      Connection connection = null;
	      try
	      {
	         connection = getConnection();
	         String sql = "insert into Mitarbeiter " 
	         + "(idMitarbeiter, Vorname, Nachname, Geburtsdatum, SozialversicherungsNr, Straﬂe, PLZ, Ort, Email, Telefonnummer, Username, Password  ) "
	         + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	         statement = connection.prepareStatement(sql);
	         statement.setLong(1, mitarbeiterDTO.getIdMitarbeiter().longValue());
	         statement.setString(2, mitarbeiterDTO.getVorname());
	         statement.setString(3, mitarbeiterDTO.getNachname());
	         statement.setString(4, mitarbeiterDTO.getGeburtsdatum());
	         statement.setString(5, mitarbeiterDTO.getSozialversicherungsNr());
	         statement.setString(6, mitarbeiterDTO.getStraﬂe());
	         statement.setInt(7, mitarbeiterDTO.getPlz());
	         statement.setString(8, mitarbeiterDTO.getOrt());
	         statement.setString(9, mitarbeiterDTO.getEmail());
	         statement.setString(10, mitarbeiterDTO.getTelefonnummer());
	         statement.setString(11, mitarbeiterDTO.getUsername());
	         statement.setString(12, mitarbeiterDTO.getPassword());
	         
	         statement.executeUpdate();
	      } catch (SQLException e)
	      {
	         throw new RuntimeException(e);
	      } finally
	      {
	         close(statement, connection);
	      }
	   }
	   
	   public void delete(MitarbeiterDTO mitarbeiterDTO)
	   {
	      PreparedStatement statement = null;
	      Connection connection = null;
	      try
	      {
	         connection = getConnection();
	         String sql = "delete from Mitarbeiter where id=?";
	         statement = connection.prepareStatement(sql);
	         Long id = mitarbeiterDTO.getIdMitarbeiter();
	         statement.setLong(1, id.longValue());
	         statement.executeUpdate();
	      } catch (SQLException e)
	      {
	         throw new RuntimeException(e);
	      } finally
	      {
	         close(statement, connection);
	      }
	   }
}
