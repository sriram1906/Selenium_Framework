package Keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Keywords {
	FirefoxDriver driver;
	Properties p1; 
	FileInputStream fs;
	
	public Keywords() throws IOException
	{
		p1 = new Properties();
		
		fs = new FileInputStream("./config.properties");
	}
	
	public void LaunchBrowser(String a,String b)
	{
		
		System.setProperty("webdriver.gecko.driver","/Users/sriram/Downloads/geckodriver");
		driver = new FirefoxDriver();
		//driver.close();
	}
	
	public void LaunchURL(String URL,String b)
	{
		driver.get(URL);
		
	}
	
	public void ClickLink(String b,String locator) throws IOException
	{
		//driver.get(URL);
		//driver.findElementByLinkText(getObject(locator)).click();
		WebElement e = getObject(locator);
		e.click();
		
	}
	
	public void CloseBrowser(String a,String b)
	{
		System.out.println("yes");
		driver.manage().window().fullscreen();
		driver.get("http://www.google.com");
		
	}
	
	public WebElement getObject(String element) 
	{
		WebElement e = null;
		try {
			p1.load(fs);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (element.contains("LinkText"))
		{
			e = driver.findElementByLinkText(p1.getProperty(element));
		}
		else if (element.contains("XPath"))
		{
			//data = p1.getProperty(element);
			e = driver.findElementByXPath(p1.getProperty(element));
		}
		
		return e;
	}

}
