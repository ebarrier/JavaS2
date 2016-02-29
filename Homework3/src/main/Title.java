package main;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Title {
	
	static ArrayList<String> titles;
	
	public static ArrayList<String> titles() {
		Elements titleH1 = Main.doc.select("h1.tt3");
		Elements titleH2 = Main.doc.select("h2.tt6");
		Elements titleH3 = Main.doc.select("h3[class=\"\"]");
		
		ArrayList<Elements> listTitles = new ArrayList<Elements>();
		listTitles.add(titleH1);
		listTitles.add(titleH2);
		listTitles.add(titleH3);
		
		//clean titles from unwanted text
		for (Elements elements : listTitles) {
			for (Element element2 : elements.select("span")) {
				element2.remove();				
			}
		}
		
		titles = new ArrayList<String>();
		for (Elements elements : listTitles) {
			for (Element element : elements) {
				titles.add(element.text());
			}
		}
		
		System.out.println(titles);
		
//		System.out.println(titleH2);
//		System.out.println(titleH3);
//		System.out.println(titleH1);
		
//		H1 = titleH1.text();
//		H2 = titleH2.text();
//		H3 = titleH3.text();
//		System.out.println(H1);
//		System.out.println(H2);
//		System.out.println(H3);
		return titles;
	}

	public static void printTitle() {
		titles();
	}
}
