package com.framesandwindows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class framesandwindows {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\thasleem\\\\Dropbox\\\\PC\\\\Downloads\\\\chromedriver_win32 (4)\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.way2automation.com/demo.html");
		driver.manage().window().maximize();
		WebElement e=driver.findElement(By.xpath("(//*[text()='Registration'])[1]"));
		if(e.isDisplayed())
		{
			System.out.print("element is displayed"+'\n');
		}
		else
			System.out.print("element is not displayed"+'\n');

		if(e.isEnabled())
		{
			System.out.print("element is enabled"+'\n');

		}
		else
			System.out.print("element is not enabled"+'\n');
		driver.findElement(By.xpath("(//*[text()='Registration'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Set<String> wh=driver.getWindowHandles();
		Iterator<String> i1=wh.iterator();
		ArrayList<String> win=new ArrayList<String>(driver.getWindowHandles());
		System.out.print(win);
		String mainwin=driver.getWindowHandle();
		while(i1.hasNext())


		{
			String childwindow=i1.next();
			if(!mainwin.equalsIgnoreCase(childwindow))
			{


				String child=win.get(1);
				driver.switchTo().window(child);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ameer");
				driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9059590301");
				driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mahammadameer0502@gmail.com");
				driver.findElement(By.xpath("//select[@name='country']")).sendKeys("India");
				driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Hyderabad");
				driver.findElement(By.xpath("//div[@id='load_box']//input[@name='username']")).sendKeys("Ameer241");
				driver.findElement(By.xpath("//div[@id='load_box']//input[@name='password']")).sendKeys("Ameer@241");
				driver.findElement(By.xpath("//div[@id='load_box']//input[@value='Submit']")).click();
				driver.findElement(By.xpath("//div[@id='load_box']//a[@class='fancybox'][normalize-space()='ENTER TO THE TESTING WEBSITE']")).click();
				driver.findElement(By.xpath("//a[@href='frames-and-windows.php']//figure")).click();
				Set<String> wh1=driver.getWindowHandles();
				Iterator<String> i2=wh1.iterator();
				while(i2.hasNext())
				{
					String childwindow1=i2.next();
					if(!mainwin.equalsIgnoreCase(childwindow1) && !childwindow.equalsIgnoreCase(childwindow1));
					{
						String child1=win.get(2);
						driver.switchTo().window(childwindow1);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElement(By.xpath("//div[@id='example-1-tab-1']//iframe[@class='demo-frame']"));
						driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div[1]/ul/li[1]/a")).click();
						driver.findElement(By.xpath("//a[normalize-space()='New Browser Tab']")).click();
						driver.findElement(By.xpath("//a[normalize-space()='Open Seprate New Window']"));
						driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
						driver.close();
					}

				}
			}
		}
	}
}
