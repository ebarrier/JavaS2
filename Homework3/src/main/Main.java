package main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

	public static void main(String[] args) throws IOException {
		Document document = Jsoup.connect("http://www.thehackernews.com").get();
		Elements headlines = document.select("a.entry-title"); // here you can write a CSS selector
		for (Element headline : headlines) {}

	}

}
