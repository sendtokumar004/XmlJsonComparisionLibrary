package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ResponseComparator {

	public void getData(File file1, File file2) throws RestClientException, IOException {
		BufferedReader br1 = new BufferedReader(new FileReader(file1));
		BufferedReader br2 = new BufferedReader(new FileReader(file2));

		String st1, st2;
		RestTemplate restTemplate = null;
		while ((st1 = br1.readLine()) != null && (st2 = br2.readLine()) != null) {
			restTemplate = new RestTemplate();
			try {
				ResponseEntity<String> result1 = restTemplate.getForEntity(st1, String.class);
				ResponseEntity<String> result2 = restTemplate.getForEntity(st1, String.class);
				if (result1.getHeaders().getContentType().getType().equals("application/json") || result1.getHeaders().getContentType().getType().equals("application")) {
					if (new JsonComparator().compare(result1.getBody(), result2.getBody())) {
						System.out.println(st1 + " equals " + st2);
					} else {
						System.out.println(st1 + " not equals " + st2);
					}
				} else {
					if (new XmlComparator().compare(st1, st2)) {
						System.out.println(st1 + " equals " + st2);
					} else {
						System.out.println(st1 + " not equals " + st2);
					}
				}
			} catch (Exception e) {
				System.out.println(st1 + " not equals " + st2);
			}

		}

	}

}
