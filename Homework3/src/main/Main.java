package main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.lemonde.fr/").get();
		Elements titleAll = doc.select("h1.tt3");
		for (Element element : titleAll.select("span")) {
			element.remove();
		}
		String mainTitle = titleAll.text();
	}
	

}
