package servlets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;	
import java.util.TimerTask;

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
			writer.println("<h1>Item must not be null, please insert something</h1>");
			resp.setHeader("Refresh","3;url=/form");
		} else {
			buffWriter.write(req.getParameter("item"));
			buffWriter.newLine();
			writer.println("<h1>Item<em> " + req.getParameter("item") + " </em> added to the file</h1>");
			resp.setHeader("Refresh","3;url=/form");
		}
		resp.setStatus(HttpServletResponse.SC_OK);
		buffWriter.flush();
		buffWriter.close();

	}

}
