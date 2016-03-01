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
		
		
//		OutputStreamWriter writer = new OutputStreamWriter(
//                new FileOutputStream("YourFile.txt"));
//		writer.write(File.entry.toString());
//		writer.flush();
//		writer.close();
		
		FileWriter file = new FileWriter("file1.txt", true);
//		file.write(Today.date());
//		file.write(Title.titles().toString());
//		file.write(Link.links().toString());
//		file.write("\r\n");
//		file.write("\r\n");
		file.write(File.entry.getString("Date"));
		file.write("\n");
		for (int i = 0; i < File.entry.getJSONArray("Link").length(); i++) {
			file.write(File.entry.getJSONArray("Main_title").getString(i));
			file.write("\n");
			file.write(File.entry.getJSONArray("Link").getString(i));
			file.write("\n");
		}
		file.write("\n");
		file.flush();
		file.close();
	}
	

}
