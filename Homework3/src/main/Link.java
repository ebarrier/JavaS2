package main;

import java.io.IOException;

import org.jsoup.nodes.Element;

public class Link {

	static String linkHref;
	
	public static String link() throws IOException {
		Element link = Main.doc.select("a").first(); //select link of news headline
		linkHref = Main.baseUrl + link.attr("href"); //extract and build link of headline
		return linkHref;
	}
	
	public static void printLink() throws IOException {
		link();
		System.out.println(linkHref);
	}
}
