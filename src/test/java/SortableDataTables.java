import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SortableDataTables {

    WebElement driver;

    @Test
    public void testSDT()   {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");

        WebElement firstTable11 = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        Assert.assertEquals(firstTable11.getText(), "Smith");

        WebElement firstTable12 = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        Assert.assertEquals(firstTable12.getText(), "John");

        WebElement firstTable22 = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        Assert.assertEquals(firstTable22.getText(), "Frank");

        WebElement firstTable32 = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        Assert.assertEquals(firstTable32.getText(), "Jason");

        WebElement firstTable45 = driver.findElement(By.xpath("//table//tr[4]//td[5]"));
        Assert.assertEquals(firstTable45.getText(), "http://www.timconway.com");

        driver.quit();
    }
}
