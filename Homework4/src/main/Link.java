package main;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Link {

	static ArrayList<String> links;
	
	public static ArrayList<String> links() {
		Elements linksH1 = Main.doc.select("article.titre_une");
		Elements linksH2 = Main.doc.select("article.grid_6*");
		Elements linksH3 = Main.doc.select("div[class=titres_liste]").select("a");
		
//		System.out.println(linksH3);
		
		ArrayList<Elements> listLinks = new ArrayList<Elements>();
		listLinks.add(linksH1);
		listLinks.add(linksH2);
		listLinks.add(linksH3);
		
		links = new ArrayList<String>();
				
		for (Elements elements : listLinks) {
			for (Element element : elements) {
				Elements link = element.select("a[href]"); //select link of news headline
				String linkHref = Main.baseUrl + link.attr("href");
				links.add(linkHref);
			}
		}
//		System.out.println(links);
//		System.out.println("There are " + links.size() + " links");
		
		return links;
	}
	
	public static void printLinks() throws IOException {
		links();
		System.out.println(links);
	}
}
