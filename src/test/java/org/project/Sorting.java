package org.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sorting {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Driver's\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement s = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		s.sendKeys("iphone 11");
		WebElement sec = driver.findElement(By.xpath("//input[@value='Go']"));
		sec.click();
		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		Set<Long> ts = new TreeSet<Long>();
		Map<String, Long> m = new TreeMap<String, Long>();
		for (int i = 0; i < products.size(); i++) {
			WebElement content = products.get(i);
			WebElement rate = price.get(i);
			String name = content.getText();
			long cost = Integer.parseInt(rate.getText().replaceAll(",", ""));
			m.put(name, cost);
		}
		Set<Entry<String, Long>> en = m.entrySet();
		for (Entry<String, Long> x : en) {
			if(x.getKey().contains("Apple iPhone 11")) {
				System.out.println(x);	
			}
		}
		driver.close();
	}
}
