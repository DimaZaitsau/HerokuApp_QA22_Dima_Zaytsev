import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Checkboxes {

    WebElement driver;

    @Test
    public void testCheckboxes()    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkbox = driver.findElements(By.cssSelector("[type = checkbox]"));

        Assert.assertEquals(checkbox.get(0).isSelected(), false);
        checkbox.get(0).click();
        Assert.assertEquals(checkbox.get(0).isSelected(), true);

        Assert.assertEquals(checkbox.get(1).isSelected(), true);
        checkbox.get(1).click();
        Assert.assertEquals(checkbox.get(1).isSelected(), false);

        driver.quit();
    }
}
