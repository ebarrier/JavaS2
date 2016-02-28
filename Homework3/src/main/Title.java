package main;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Title {
	
	static String mainTitle;
	
	public static String title() {
		Elements titleH1 = Main.mainArticle.select("h1.tt3"); //select news headline title
		//clean the title from unwanted text
		for (Element element : titleH1.select("span")) {
			element.remove();
		}
		mainTitle = titleH1.text();
		return mainTitle;
	}

	public static void printTitle() {
		title();
		System.out.println(mainTitle);		
	}
}
