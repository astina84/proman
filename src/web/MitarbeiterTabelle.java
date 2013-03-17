package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MitarbeiterTabelle
 */
@WebServlet("/MitarbeiterTabelle")
public class MitarbeiterTabelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MitarbeiterTabelle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<MitarbeiterDTO> mitarbeiterListe = new MitarbeiterDAO().findAll();
		Iterator<MitarbeiterDTO> it = mitarbeiterListe.iterator();
		while (it.hasNext()) {
		   MitarbeiterDTO mitarbeiter = (MitarbeiterDTO) it.next();
		   
		   out.println("<table><tr>" +
		   		"<td>" + mitarbeiter.getIdMitarbeiter() + "</td>" +
		   		"<td>" + mitarbeiter.getVorname() + "</td>" +
		   		"<td>" + mitarbeiter.getNachname() + "</td>" +
		   		"<td>" + mitarbeiter.getGeburtsdatum() + "</td>" +
		   		"<td>" + mitarbeiter.getSozialversicherungsNr() + "</td>" +
		   		"<td>" + mitarbeiter.getStraﬂe() + "</td>" +
		   		"<td>" + mitarbeiter.getPlz() + "</td>" +
		   		"<td>" + mitarbeiter.getOrt() + "</td>" +
		   		"<td>" + mitarbeiter.getEmail() + "</td>" +
		   		"<td>" + mitarbeiter.getTelefonnummer() + "</td>" +
		   		"<td>" + mitarbeiter.getUsername() + "</td>" +
		   		"<td>" + mitarbeiter.getPassword() + "</td></tr></table>");
		   		   
		}
	}

}
