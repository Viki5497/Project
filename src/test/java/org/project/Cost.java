package org.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cost {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Driver's\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	WebElement s = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	s.sendKeys("iphone 11");
	WebElement sec = driver.findElement(By.xpath("//input[@value='Go']"));
	sec.click();
	List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	List<Long> li = new ArrayList<Long>();
	Set<Long> pr = new TreeSet<Long>();
	for (int i = 0; i < price.size(); i++) {
		WebElement content = price.get(i);
		String ch = content.getText().replaceAll(",", "");
		long j = Integer.parseInt(ch);
		pr.add(j);
		li.add(j);
	}
	Collections.sort(li);
	System.out.println("Sorted cost");
	for (int i = 0; i < li.size(); i++) {
		System.out.println(li.get(i));	
	}
	System.out.println(li.size()-pr.size());
			li.removeAll(pr);
			System.out.println(li);
		driver.close();
	}
}