package HomeWorkSeleniumWebDriverAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicControls {

    @Test
    public void testDynamicControls() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@label='blah']"));
        Assert.assertEquals(checkbox.size(), 1);
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        WebElement text = driver.findElement(By.id("message"));
        Assert.assertEquals(text.getText(), "It's gone!");

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(By.id("checkbox")).size();
        Assert.assertEquals(numberOfElements, 0, "Элемент присутствует на странице");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement disableInput = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        Assert.assertEquals(disableInput.isEnabled(), false);
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='message']/text()")));
        Assert.assertEquals(disableInput.isEnabled(), true);

        driver.quit();
    }
}