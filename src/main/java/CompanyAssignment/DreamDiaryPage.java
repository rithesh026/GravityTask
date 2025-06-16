package CompanyAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DreamDiaryPage {
    WebDriver driver;

    public DreamDiaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getDreamRows() {
        return driver.findElements(By.xpath("//table/tbody/tr"));
    }

    public List<WebElement> getDreamTypes() {
        return driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
    }

    public boolean allColumnsFilled() {
        List<WebElement> rows = getDreamRows();
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() != 3) return false;
            for (WebElement col : cols) {
                if (col.getText().trim().isEmpty()) return false;
            }
        }
        return true;
    }
}

