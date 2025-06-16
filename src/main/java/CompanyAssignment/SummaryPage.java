package CompanyAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage {
    WebDriver driver;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
    public String getGoodDreamsText() {
    	return driver.findElement(By.xpath("//table/tbody/tr[1]")).getText();
    }

    public String getBadDreamsText() {
    	return driver.findElement(By.xpath("//table/tbody/tr[2]")).getText();
    }

    public String getTotalDreamsText() {
        return driver.findElement(By.xpath("//table/tbody/tr[3]")).getText();
    }

    public String getRecurringDreamsText() {
    	return driver.findElement(By.xpath("//table/tbody/tr[5]")).getText();
    }
}
