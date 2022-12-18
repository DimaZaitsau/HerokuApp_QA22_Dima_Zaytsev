package HomeWorkSeleniumWebDriverAdvanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class FileDownload {

    WebDriver driver;
    @Test()
    public void testFileDownload() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/download");

        driver.findElement(By.xpath("//a[text()='logotitle.jpeg']")).click();
        Thread.sleep(5000);

        File folder = new File(System.getProperty("user.dir"));

        File[] listOfFile = folder.listFiles();
        boolean found = false;
        File downloadFile = null;

        for (File listOFFile : listOfFile)  {
            if (listOFFile.isFile())    {
                String fileName = listOFFile.getName();
                System.out.println("File" + listOFFile.getName());
                if (fileName.matches("logotitle.jpeg")) {
                    downloadFile = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Download document is not found");
        downloadFile.deleteOnExit();


        driver.quit();
    }
}
