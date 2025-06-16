package Companyassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	public static void main(String [] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://arjitnigam.github.io/myDreams/");
		
		String title = driver.getTitle();
		String Exp_title = "Dream Portal";
		Boolean result = title.equals(Exp_title) ;
		if(result)
		{
			System.out.println("Equal title");
		}
		else
		{
			System.out.println("Not equals");
		}
		
		Thread.sleep(5000);
		
		driver.findElementById("dreamButton").click();
		
		Thread.sleep(3000);
		
		Set<String> allTabs = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(allTabs);

        String diaryTab = tabs.get(1);
        String summaryTab = tabs.get(2);

        // Step 3: Switch to Diary Tab
        
        driver.switchTo().window(summaryTab);
        
        System.out.println("Switched to Diary Tab");
        
        
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        int count = rows.size();
        if(count==10)
        {
        	System.out.println("Dream Entries are exactly 10");
        }
        else
        {
        	System.out.println("Dream entries are not exactly 10");
        }
        
        Thread.sleep(5000);
        
        List<WebElement> dreamTypes = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));

        boolean allGoodOrBad = true;

        for (WebElement typeCell : dreamTypes) {
            String type = typeCell.getText().trim();
            if (!(type.equals("Good") || type.equals("Bad"))) {
                allGoodOrBad = false;
                break;
            }
        }

        if (allGoodOrBad) {
            System.out.println("It consists of only 'Good' or 'Bad' dream types.");
        } else {
            System.out.println("It contains invalid dream types.");
        }
        
        List<WebElement> rows1 = driver.findElements(By.xpath("//table/tbody/tr"));

        boolean allRowsValid = true;

        for (WebElement row : rows1) {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            // Get text from each column
            String dreamName = columns.get(0).getText().trim();
            String daysAgo = columns.get(1).getText().trim();
            String dreamType = columns.get(2).getText().trim();

            // Check if any column is empty
            if (dreamName.isEmpty() || daysAgo.isEmpty() || dreamType.isEmpty()) {
                allRowsValid = false;
                System.out.println("❌ Incomplete row found: " + dreamName + " | " + daysAgo + " | " + dreamType);
            }
        }

        if (allRowsValid) {
            System.out.println("All rows have Dream Name, Days Ago, and Dream Type filled.");
        } else {
            System.out.println("Some rows have missing values.");
        }

        
		driver.close();
	}

}
