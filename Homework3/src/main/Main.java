package main;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

	public static void main(String[] args) throws IOException {
		
		Date date = new Date();
		System.out.println(date);
		
		String baseUrl= "http://www.lemonde.fr";
		Document doc = Jsoup.connect(baseUrl).get();
		Elements mainArticle= doc.select("article.titre_une"); //select news headline
		Element link = mainArticle.select("a").first(); //select link of news headline
		String linkHref=baseUrl + link.attr("href"); //extract and build link of headline
		System.out.println(linkHref);
//		
//		System.out.println();
//		System.out.println();
		Elements titleH1 = mainArticle.select("h1.tt3"); //select news headline title
		//clean the title from unwanted text
		for (Element element : titleH1.select("span")) {
			element.remove();
		}
		String mainTitle = titleH1.text();
		System.out.println(mainTitle);
	}
	

}
