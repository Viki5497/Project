package org.day1;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CostSorting {
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
		Set<String> pr = new TreeSet<String>();
		Set<String> pe = new TreeSet<String>();
		Set<String> co = new TreeSet<String>();	
		for (int i = 0; i < products.size(); i++) {
			WebElement content = products.get(i);
			WebElement rate = price.get(i);
			String name = content.getText();
			pr.add(name);
			String cost = rate.getText();
			pe.add(cost);
			String concat = name + " - " + cost;
			co.add(concat);
		}
		for (String st : co) {
			System.out.println(st);
		}	
		driver.close();
	}

}
