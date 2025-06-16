package CompanyAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By dreamButton = By.id("dreamButton");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickDreamButton() {
        driver.findElement(dreamButton).click();
    }
}