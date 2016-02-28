package main;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Main {
	
	static String baseUrl = "http://www.lemonde.fr";
	static Document doc;
	static Elements mainArticle;
	
	public static void main(String[] args) throws IOException { 
		
		doc = Jsoup.connect(baseUrl).get();
		mainArticle= Main.doc.select("article.titre_une"); //select news headline
		
		Date date = new Date();
		System.out.println(date);
		
		Link.printLink();
		Title.printTitle();
		
//		JSONObject entry = new JSONObject();
//		entry.put("Date",date);
//		entry.put("Link",linkHref);
//		entry.put("Main_title",mainTitle);
	}
	

}
