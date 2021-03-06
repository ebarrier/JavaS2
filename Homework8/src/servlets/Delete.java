package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		File tempFile = new File("tempList.txt");
		Path pathTemp = tempFile.toPath();

		if (!Files.exists(pathTemp)) {
			Files.createFile(pathTemp);
		}

		BufferedWriter tempWriter = null;
		try {tempWriter = Files.newBufferedWriter(pathTemp);
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}

		File file = new File("list.txt");
		Path pathFile = file.toPath();

		if (!Files.exists(pathFile)) {
			Files.createFile(pathFile);
		}
		
		BufferedReader fileReader = null;
		try {fileReader = Files.newBufferedReader(pathFile);
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

		String lineToRem = req.getParameter("id");
		
		
		for (String line; (line = fileReader.readLine()) != null;) {
			if (line.equals(lineToRem)) {
				continue;
			} else {
				tempWriter.write(line);
				tempWriter.newLine();
			}
		}
		fileReader.close();
		tempWriter.flush();
		tempWriter.close();
		
		Files.copy(pathTemp, pathFile, StandardCopyOption.REPLACE_EXISTING);
		Files.delete(pathTemp);

		PrintWriter writer = resp.getWriter();
		resp.setHeader("content-type", "text/html");
		writer.println("<h1>Item<em> " + req.getParameter("id") + " </em> removed from file</h1>");
		resp.setHeader("Refresh","3;url=/form");
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
