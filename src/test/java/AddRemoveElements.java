import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRemoveElements {

    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver()   {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testElements() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[text() = 'Add Element']"));
        addButton.click();
        addButton.click();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text() = 'Delete']"));
        Assert.assertEquals(deleteButtons.size(), 2);
        deleteButtons.get(0).click();
        List<WebElement> deleteButtons1 = driver.findElements(By.xpath("//button[text() = 'Delete']"));
        Assert.assertEquals(deleteButtons1.size(), 1);
    }
}
