// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
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
public class GooglesearchTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void googlesearch() {
    // Test name: google-search
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("https://www.google.es/");
    // 2 | setWindowSize | 843x774 | 
    driver.manage().window().setSize(new Dimension(843, 774));
    // 3 | selectFrame | name=q | 
    {
      WebElement element = driver.findElement(By.name("q"));
      driver.switchTo().frame(element);
    }
    // 4 | click | css=#introAgreeButton .RveJvd | 
    driver.findElement(By.cssSelector("#introAgreeButton .RveJvd")).click();
    // 5 | selectFrame | relative=parent | 
    driver.switchTo().defaultContent();
    // 6 | type | name=q | selenium
    driver.findElement(By.name("q")).sendKeys("selenium");
    // 7 | sendKeys | name=q | ${KEY_ENTER}
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    // 8 | click | xpath=//span[contains(.,'Selenium WebDriver')] | 
    driver.findElement(By.xpath("//span[contains(.,\'Selenium WebDriver\')]")).click();
  }
}
