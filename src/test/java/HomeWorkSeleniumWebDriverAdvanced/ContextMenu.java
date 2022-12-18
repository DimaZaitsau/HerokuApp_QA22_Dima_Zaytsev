package HomeWorkSeleniumWebDriverAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ContextMenu {

    WebDriver driver;

    @Test
    public void testContextMenu() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement tapToWindow = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(tapToWindow).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.getText();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();

        driver.quit();
    }
}
