package com.example.demo;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonComparator implements IResponseComparator<String, String> {

	@Override
	public boolean compare(String x, String y) {
		JsonParser parser = new JsonParser();
		JsonElement o1 = parser.parse(x);
		JsonElement o2 = parser.parse(y);
		return o1.toString().equals(o2.toString());
	}

}
