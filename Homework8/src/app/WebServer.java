package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		WebAppContext ctx = new WebAppContext("src", "/");
		server.setHandler(ctx);
		server.start();
		server.join();
	}
}
