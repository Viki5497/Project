package org.project;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

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
		
		List<WebElement> phones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		LinkedHashMap<String, Integer> mp =new LinkedHashMap<String, Integer>();
		for (WebElement p : phones) {
			String text = p.getText();
			if (mp.containsKey(text)) {
				Integer count = mp.get(text);
				mp.put(text, count+1);
			}else {
				mp.put(text, 1);
			}
		}
		Set<Entry<String, Integer>> entries = mp.entrySet();
		for (Entry<String, Integer> en : entries) {
			Integer value = en.getValue();
		if (value>1) {
			String key = en.getKey();
			System.out.println(key);
		}
		}
		driver.close();
	}

}
