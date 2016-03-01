package main;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class File {
	
	static JSONObject entry = new JSONObject();
	
	public static JSONObject addEntry() throws JSONException, IOException{
		
		if (entry.equals(entry)) {
			entry.put("Date",Today.date());
			entry.put("Link",Link.links());
			entry.put("Main_title",Title.titles());			
		} else {
			entry.accumulate("Date",Today.date());
			entry.accumulate("Link",Link.links());
			entry.accumulate("Main_title",Title.titles());	
		}
		
		return entry;
	}
	
	public static void printFile() {
		System.out.println(entry);
	}

}
