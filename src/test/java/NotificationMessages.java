import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NotificationMessages {

    WebElement driver;

    @Test
    public void testNotificationMessages() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");

        WebElement test = driver.findElement(By.xpath("//a[text()='Click here']"));
        test.click();
        WebElement flash = driver.findElement(By.id("flash"));
        flash.getText();
        Assert.assertEquals(flash.getText(), "Action successful\n" + "×");
        driver.quit();
    }
}
