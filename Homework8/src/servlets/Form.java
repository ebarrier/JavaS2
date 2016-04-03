package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Form extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		File file = new File("list.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileReader fileReader = new FileReader(file);
		BufferedReader buffReader = new BufferedReader(fileReader);
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding( "UTF-8" );
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<title>Test</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Items you have in your list:</p>");
		out.println("<ul>");
		for(String line; (line = buffReader.readLine()) != null; ) {
			out.println("<li>" + line +  "    <a href=\"delete?id=" + line + "\">delete</a></li>");
		}
		buffReader.close();
		
		out.println("</ul>");
		
		out.println("<form action=\"add\" method=\"post\">");
		out.println("<input type=\"text\" name=\"item\" placeholder=\"add an item\" />");
		out.println("<input type=\"submit\" name=\"submit\" value=\"Add\" />");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
		resp.setStatus(HttpServletResponse.SC_OK);
	}
	
}