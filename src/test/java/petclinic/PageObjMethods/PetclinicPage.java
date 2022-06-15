package petclinic.PageObjMethods;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

import petclinic.Generic.TestBase.testBase;

public class PetclinicPage extends testBase{
  private WebDriver driver = petclinic.Generic.TestBase.BrowserConfig.getDriver();
  private Map<String, Object> vars;
  JavascriptExecutor js;
 
  public void setUp() {
   // driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  
  public void tearDown() {
    driver.quit();
  }
  
  public void untitled() {
    driver.get("applicationURL");
    driver.manage().window().setSize(new Dimension(1296, 696));
    driver.findElement(By.cssSelector("li:nth-child(3) > a")).click();
    driver.findElement(By.linkText("Add Owner")).click();
    driver.findElement(By.id("firstName")).click();
    driver.findElement(By.id("firstName")).sendKeys("Harshita");
    driver.findElement(By.id("lastName")).click();
    driver.findElement(By.id("lastName")).sendKeys("Sinha");
    driver.findElement(By.id("address")).click();
    driver.findElement(By.id("address")).sendKeys("gh");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("hvj");
    driver.findElement(By.id("telephone")).click();
    driver.findElement(By.id("telephone")).sendKeys("9990000");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(3)")).click();
    driver.findElement(By.id("firstName")).click();
    driver.findElement(By.id("firstName")).click();
    {
      WebElement element = driver.findElement(By.id("firstName"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("firstName")).sendKeys("hdfjh");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.close();
    
  }
}

