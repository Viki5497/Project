package org.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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
		
		List<String> cc = new LinkedList<String>();
		List<Long> li = new LinkedList<Long>();
		//List<Object> ch = new ArrayList<Object>();
		for (int i = 0; i < products.size(); i++) {
			WebElement content = products.get(i);
			WebElement rate = price.get(i);
			
			String name = content.getText();
			//cc.add(name);
			
			long cost = Integer.parseInt(rate.getText().replaceAll(",", ""));
			li.add(cost);
			cc.add(name+"-"+cost);
		}
		//Sorting
		Collections.sort(cc);
		for (int i = 0; i < cc.size(); i++) {
			System.out.println(cc.get(i));
		}
		driver.close();
	}
}
