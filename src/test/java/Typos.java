import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Typos {

    WebElement driver;

    @Test
    public void testTypos() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/typos");

        List<WebElement> text = driver.findElements(By.tagName("p"));
        Assert.assertEquals(text.size(), 2);
        Assert.assertEquals(text.get(0).getText(), "This example demonstrates a typo being introduced. It does it randomly on each page load.");

        try {
            Assert.assertEquals(text.get(1).getText(), "Sometimes you'll see a typo, other times you won't.");
        } catch (AssertionError e)  {
            System.out.println("Text hav error.");
        }

        driver.quit();
    }
}
