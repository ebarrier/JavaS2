package com.mycompany;

import java.util.ArrayList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ListPage extends WebPage {

	private ArrayList<String> list = new ArrayList<>();
	
	public ListPage(final PageParameters parameters) {
		super(parameters);
		
		add(new ItemForm("itemForm"));
		
//		add(new Link("add") {
//
//			@Override
//			public void onClick() {
//				list.add(input);
//			}
//		});

    }
}
