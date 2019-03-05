package com.example.demo;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class XmlJsonComparisionLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlJsonComparisionLibraryApplication.class, args);
		try {
			new ResponseComparator().getData(new File("C:\\Users\\Lokesh\\Desktop\\XmlJsonComparisionLibrary\\file1.txt"), new File("C:\\Users\\Lokesh\\Desktop\\XmlJsonComparisionLibrary\\file2.txt"));
		} catch (RestClientException | IOException e) {
			e.printStackTrace();
		}
	}

}
