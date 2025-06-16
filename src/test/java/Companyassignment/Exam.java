package Companyassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exam {
	public class DreamPortalTest {
	    WebDriver driver;
	    List<String> tabs;

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

	    @Test(priority = 1)
	    public void verifyHomePageTitle() {
	        driver.switchTo().window(tabs.get(0));
	        String title = driver.getTitle();
	        Assert.assertEquals(title, "Dream Portal", "Home Page title mismatch.");
	    }

	    @Test(priority = 2)
	    public void verifyDreamDiaryEntries() {
	        driver.switchTo().window(tabs.get(2));
	        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
	        Assert.assertEquals(rows.size(), 10, "Dream entry count mismatch.");
	    }

	    @Test(priority = 3)
	    public void verifyDreamTypesAreValid() {
	        driver.switchTo().window(tabs.get(1));
	        List<WebElement> dreamTypes = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
	        for (WebElement typeCell : dreamTypes) {
	            String type = typeCell.getText().trim();
	            Assert.assertTrue(type.equals("Good") || type.equals("Bad"), "Invalid dream type: " + type);
	        }
	    }

	    @Test(priority = 4)
	    public void verifyAllColumnsFilled() {
	        driver.switchTo().window(tabs.get(2));
	        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
	        for (WebElement row : rows) {
	            List<WebElement> cols = row.findElements(By.tagName("td"));
	            Assert.assertEquals(cols.size(), 3, "Row does not have exactly 3 columns.");
	            for (WebElement col : cols) {
	                Assert.assertFalse(col.getText().trim().isEmpty(), "Empty column found in row: " + row.getText());
	            }
	        }
	    }

	    @Test(priority = 5)
	    public void verifySummaryPageStats() throws InterruptedException {
	       
	    	driver.switchTo().window(tabs.get(2));
	        Thread.sleep(5000);
	        String source = driver.getPageSource();
	        Assert.assertTrue(source.contains("Good Dreams: 6"), "Missing 'Good Dreams: 6'");
	        Assert.assertTrue(source.contains("Bad Dreams: 4"), "Missing 'Bad Dreams: 4'");
	        Assert.assertTrue(source.contains("Total Dreams: 10"), "Missing 'Total Dreams: 10'");
	        Assert.assertTrue(source.contains("Recurring Dreams: 2"), "Missing 'Recurring Dreams: 2'");
	        Assert.assertTrue(source.contains("Flying over mountains"), "Missing recurring dream: Flying over mountains");
	        Assert.assertTrue(source.contains("Lost in maze"), "Missing recurring dream: Lost in maze");
	   
	    }

	    @AfterClass
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

}
