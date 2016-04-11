package com.mycompany;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class ItemForm extends Form {

	public ItemForm(String id) {
		super(id);
//		setDefaultModel(new CompoundPropertyModel(this));
		
		add(new TextField("itemForm", Model.of("")));
	}
	

}
