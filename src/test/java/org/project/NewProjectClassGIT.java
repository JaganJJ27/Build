package org.project;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewProjectClassGIT {

	
	
	public WebDriver driver;
	
	@BeforeClass
	private void tc1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jagan Sathish\\eclipse-workspace\\Selenium\\drivers\\"
				+ "chromedriver.exe");

		 driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

	}

	@AfterClass
	 private void quitbrowser() {
	driver.quit();
	}

	@Test
	private void tc2() {
		WebElement txt1 = driver.findElement(By.id("twotabsearchtextbox"));
		txt1.sendKeys("Iphones");
		
		WebElement btn1 = driver.findElement(By.xpath("(//input[@class='nav-input'])[2]"));
		btn1.click();
		
	}
		@Test
		private void tc3() throws InterruptedException {
			List<WebElement> allpho = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			
			List<String> li=new LinkedList<String>();
			for (int i = 0; i < allpho.size(); i++) {
				WebElement x = allpho.get(i);
				String text = x.getText();
				li.add(text);
			}
			
			
		System.out.println("Total No of Products------>" +li.size());
			
			Set<String> se=new LinkedHashSet<String>();
			se.addAll(li);
			

			System.out.println("Total No of Non duplicate Products------->"+se.size());
			Thread.sleep(3000);

		}

		@Test
		private void tc4() throws InterruptedException {
			Thread.sleep(3000);
	WebElement lp = driver.findElement(By.id("low-price"));
	lp.sendKeys("50000");

	WebElement go = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
	go.click();

	List<WebElement> abo50 = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	List<WebElement> mobpri = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	System.out.println("Above 50000 Mobiles");
	System.out.println("====================");
	for (int i = 0; i < mobpri.size(); i++) {
		WebElement x1 = abo50.get(i);
		System.out.println(x1.getText());
		WebElement x2 = mobpri.get(i);
	System.out.println(x2.getText());	
		
	}





		}
		

	
	
	
}
