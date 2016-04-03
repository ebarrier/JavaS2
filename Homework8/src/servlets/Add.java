package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class Add extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("list.txt", true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		BufferedWriter buffWriter = new BufferedWriter(fileWriter);

		buffWriter.write(req.getParameter("item"));
		buffWriter.newLine();
		buffWriter.flush();
		buffWriter.close();
		
		PrintWriter writer = resp.getWriter();
		resp.setHeader("content-type", "text/html");
		writer.println("Item<strong> " + req.getParameter("item") + " </strong> added to the file");
		resp.setStatus(HttpServletResponse.SC_OK);
		
		
	}

}
