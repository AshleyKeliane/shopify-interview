package dict;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Hashtable;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Get extends HttpServlet {

	private Map<String, String> dict = new Hashtable<String, String>();

	public void init()
			throws UnavailableException {
		String filename = "/Users/keliane/Downloads/lab3/template-part2/web/data/words.csv";
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream(filename);
		if (is != null) {
			// TODO complete the implementation
			// reading the file and populating the dictionary
			BufferedReader reader = new BufferedReader(new InputStream (is,StandardCharsets.UTF_8));
			String br;
			br=reader.readLine();
			while (br != null){
				String[] parts = br.split("\\|");
				if (parts.length==2){
					String word = parts[0].trim();
					String definition = parts[1].trim();
					dict.put(word, definition);
				}


			}
		}
	}

	public void doGet(HttpServletRequest requete, HttpServletResponse reponse)
			throws ServletException, IOException {

		reponse.setContentType("text/html; charset=\"UTF-8\"");
		PrintWriter doc = reponse.getWriter();

		doc.println("<!DOCTYPE html");
		doc.println("	  PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
		doc.println("	  \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		doc.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"fr-CA\">");
		doc.println("  <head>");
		doc.println("    <title>Dictionnaire Latin-Anglais</title>");
		doc.println("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
		doc.println("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/default.css\" media=\"all\" />");
		doc.println("  </head>");
		doc.println("  <body>");
		doc.println("    <div class=\"note\">");
		doc.println("      <p>");
		doc.println("	<form action=\"http://localhost:8080/dict/get\" method=\"get\">");
		doc.println("	  <table border=\"0\" cellpadding=\"5\">");
		doc.println("	    <tr>");
		doc.println("	      <td><label for=\"mot\">Entrez un mot Latin :</label></td>");
		doc.println("	      <td><input type=\"text\" size=\"30\" name=\"mot\" value=\"adprobus\"/></td>");
		doc.println("	    </tr>");
		doc.println("	    <tr>");
		doc.println("	      <td><input type=\"submit\" value=\"Soumettre\" /></td> ");
		doc.println("	      <td></td>");
		doc.println("	    </tr>");
		doc.println("	    <tr>");

		// TODO complete the implementation
		// getting the word from the request and sending the response with the
		// definition

		doc.println("	    </tr>");
		doc.println("	  </table>");
		doc.println("	</form>");
		doc.println("      </p>");
		doc.println("    </div>");
		doc.println("  </body>");
		doc.println("</html>");

		doc.close();
	}



}
