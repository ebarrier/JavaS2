package main;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Title {
	
	private static ArrayList<String> titles;

	public static ArrayList<String> titles() {
		
		Elements titlesH1 = Main.doc.select("article.titre_une").select("h1");
		Elements titlesH2 = Main.doc.select("article.grid_6*").select("h2");
		Elements titlesH3 = Main.doc.select("div[class=titres_liste]").select("a").select("h3");
		
//		Elements titlesH1 = Main.doc.select("h1.tt3");
//		Elements titlesH2 = Main.doc.select("h2.tt6");
//		Elements titlesH3 = Main.doc.select("h3[class=\"\"]");
		
		ArrayList<Elements> listTitles = new ArrayList<Elements>();
		listTitles.add(titlesH1);
		listTitles.add(titlesH2);
		listTitles.add(titlesH3);
		
//		System.out.println(titlesH2);
		
		//clean titles from unwanted text
		for (Elements elements : listTitles) {
			for (Element element2 : elements.select("span")) {
				element2.remove();				
			}
		}
		
		//extract text of each tile and add it to ArrayList
		titles = new ArrayList<String>();
		for (Elements elements : listTitles) {
			for (Element element : elements) {
				titles.add(element.text());
			}
		}
		
//		System.out.println(titles);
//		System.out.println("There are " + titles.size() + " titles");
		
		return titles;
	}

	public static void printTitles() {
		titles();
		System.out.println(titles);
	}
}
