package com.utilities;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.w3c.dom.Document;

public class GetValues {
	public static void main(String[] args) throws IOException {
		List<Element> list=new ArrayList<>();
		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		
		
		
		
		
		
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.gmail.com");

		WebElement element = driver.findElement(By.xpath("//input[@id='Passwd']"));
		
		
//		for (int i = 0; i < ll.size(); i++) {
//			WebElement element2=ll.get(i);
//
//			//System.out.println("getAttribute"+element2.getAttribute("id"));
//
//
//		}


		Connection connect=Jsoup.connect("http://www.gmail.com");
		org.jsoup.nodes.Document document=connect.get();


		String html=document.html();
		org.jsoup.nodes.Document doc=Jsoup.parse(html);
		System.out.println(doc.body().getElementsByTag("input").size());
		
		
		for (int i = 0; i < doc.body().getElementsByTag("input").size(); i++) {
		//	System.out.println("Element Number i::"+i+"   "+doc.body().getAllElements());		
			
			list.add(doc.body().getElementsByTag("input").get(i));
			
			
		}
		System.out.println("List elements::"+list);
		element.sendKeys("Cheese!");
		Sleeper.sleepTightInSeconds(3);;	
		System.out.println("+++++++++++++++++Done");
		driver.quit();
		
		System.setOut(out);
		System.out.println("List elements::"+list);
		
		
		
		
		
		
	}

}
