package Companyassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
    protected WebDriver driver;
    protected List<String> tabs;

    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/");
        Thread.sleep(5000);
        driver.findElement(By.id("dreamButton")).click();
        Thread.sleep(3000);

        Set<String> allTabs = driver.getWindowHandles();
        tabs = new ArrayList<>(allTabs);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
