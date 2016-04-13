package com.mycompany;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.value.ValueMap;

public class ListPage extends WebPage {
	
	private List<String> itemList = new ArrayList<String>();
	private Model itemListModel = new Model<>();
	
	public ListPage(final PageParameters parameters) {
		super(parameters);
		
		add(new ItemForm("itemForm"));
		add(new ListView("items", itemList) {
			@Override
			protected void populateItem(ListItem item) {
				item.add(new Label("text", item.getModel()));
//				for (String s : itemList) {
//					add(new Link("removeItem") {						
//						@Override
//						public void onClick() {
//							System.out.println(item.getIndex());
//						}
//					});
//				}
			}	
		});
    }
	
	
	public class ItemForm extends Form<ValueMap> { 

		public ItemForm(String id) {
			super(id, new CompoundPropertyModel<ValueMap>(new ValueMap()));		
			add(new TextField("itemField").setType(String.class));
		}
		
		@Override
	    public final void onSubmit() {
			ValueMap values = getModelObject();
			String itemText = values.getString("itemField");
			itemList.add(itemText);
			values.put("itemField", "");
		}
	}
}
