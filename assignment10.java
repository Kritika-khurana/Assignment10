import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class assignment10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ineuron-courses.vercel.app/login");

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ineuron@ineuron.ai");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ineuron");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Actions a = new Actions(driver);
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("//span[text()='Manage']"))).perform();

		driver.findElement(By.xpath("//span[text()='Manage Courses']")).click();
		a.moveToElement(driver.findElement(By.xpath("//div[@class='manage-course']"))).perform();
		driver.findElement(By.xpath("//div[@class='manage-btns']/button[3]")).click();
		driver.findElement(By.id("thumbnail")).sendKeys("C:\\Users\\kriti\\OneDrive\\Desktop\\New folder\\test.JPG");
		driver.findElement(By.id("name")).sendKeys("Playwright");
		driver.findElement(By.id("description")).sendKeys("UI automation tool");
		driver.findElement(By.id("instructorNameId")).sendKeys("Kritika");
		driver.findElement(By.id("price")).sendKeys("5000");
		driver.findElement(By.xpath("//input[@name='startDate']")).click();

		WebElement date = driver.findElement(By.xpath("//div[contains(@class,'current-month')]"));
		while (!date.getText().equals("August 2023")) {
			driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();

			System.out.println(date.getText());

		}

		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class='react-datepicker__week']//div[@role='option']"));

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i).getText());

			if (list.get(i).getText().equals("10")) {
				list.get(i).click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@name='endDate']")).click();

		WebElement enddate = driver.findElement(By.xpath("//div[contains(@class,'current-month')]"));
		while (!enddate.getText().equals("November 2023")) {
			driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();

			System.out.println(enddate.getText());

		}
		List<WebElement> list2 = driver
				.findElements(By.xpath("//div[@class='react-datepicker__week']//div[@role='option']"));

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list2.get(i).getText());

			if (list2.get(i).getText().equals("10")) {
				list2.get(i).click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[@class='menu-btn']")).click();

		List<WebElement> l = driver.findElements(By.xpath("//div[@class='menu-items']/button"));

		for (int i = 0; i < l.size(); i++) {

			if (l.get(i).getText().equals("Testing"))

			{
				l.get(i).click();
				break;
			}

		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='action-btn']")).click();


		
		List<WebElement> courses=   driver.findElements(By.xpath("//div[@class='main-container']//tr//td[2]"));
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		System.out.println(courses.size());
		
		  for(int i=0;i<courses.size();i++) {
			  
			  System.out.println(courses.get(i).getText());
		  if(courses.get(i).getText().equals("Playwright"))
		  { System.out.println("its is present"); break; 
		  } 
		  }
		 	

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,800)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[contains(text(),'Playwright')]//parent::tr/td/input")).click();

		driver.findElement(By.xpath("//td[contains(text(),'Playwright')]//parent::tr/td/button")).click();

		
		  for(int i=0;i<courses.size();i++) {
			  System.out.println(courses.size());
		  if(!courses.get(i).getText().equals("Playwright"))  { 
			
			  
			  System.out.println("it is deleted"); 
			  } 
		  break;
		  } 
		  }
		 

	}
