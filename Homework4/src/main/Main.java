package main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Main {
	
	static String baseUrl = "http://www.lemonde.fr";
	static Document doc;
	
	public static void main(String[] args) throws IOException { 
		
		doc = Jsoup.connect(baseUrl).get();		
		
		Today.printDate();
		Link.printLinks();
		Title.printTitles();
		
//		File.addEntry();
		File.printFile();
	}
	

}
