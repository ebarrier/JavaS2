package main;

import java.io.FileWriter;
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
		File.addEntry();
		
		System.out.println();
		File.printFile();
				
		FileWriter file1 = new FileWriter("file1.txt", true);
		file1.write(File.entry.getString("Date"));
		file1.write("\n");
		for (int i = 0; i < File.entry.getJSONArray("Link").length(); i++) {
			file1.write(File.entry.getJSONArray("Main_title").getString(i));
			file1.write("\n");
			file1.write(File.entry.getJSONArray("Link").getString(i));
			file1.write("\n");
		}
		file1.write("\n");
		file1.flush();
		file1.close();
		
		FileWriter file2 = new FileWriter("Json.txt", true);
		file2.write(File.entry.toString());
		file2.write("\n");
		file2.flush();
		file2.close();
		
	}
	

}
