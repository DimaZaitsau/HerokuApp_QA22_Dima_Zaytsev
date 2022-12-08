import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Inputs {

    WebElement driver;

    @Test
    public void testInputs()    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");

        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("12345");
        Assert.assertEquals(inputField.getAttribute("value"), "12345");
        inputField.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(inputField.getAttribute("value"), "12346");
        inputField.clear();
        inputField.sendKeys("123");
        inputField.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(inputField.getAttribute("value"), "122");

        inputField.clear();

        inputField.sendKeys("sdhvsj");
        Assert.assertEquals(inputField.getAttribute("value"), "");

        inputField.clear();

        inputField.sendKeys("%%$%$%$$%%$%");
        Assert.assertEquals(inputField.getAttribute("value"), "");

        driver.quit();
    }
}
