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

		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		BufferedWriter buffWriter = new BufferedWriter(fileWriter);
		if (req.getParameter("item").trim().isEmpty()) {
			writer.println("Item must not be null, please insert something");
			resp.setHeader("form", "/form");
		} else {
			buffWriter.write(req.getParameter("item"));
			buffWriter.newLine();
			writer.println("Item<strong> " + req.getParameter("item") + " </strong> added to the file");
		}
		resp.setStatus(HttpServletResponse.SC_OK);
		buffWriter.flush();
		buffWriter.close();

	}

}
