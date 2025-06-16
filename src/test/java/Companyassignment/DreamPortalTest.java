package Companyassignment;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import CompanyAssignment.DreamDiaryPage;
import CompanyAssignment.HomePage;
import CompanyAssignment.SummaryPage;

public class DreamPortalTest extends BaseTest {

    @Test(priority = 1)
    public void verifyHomePageTitle()  {
        driver.switchTo().window(tabs.get(0));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getTitle(), "Dream Portal", "Home page title mismatch.");
    }

    @Test(priority = 2)
    public void verifyDreamDiaryEntries() {
        driver.switchTo().window(tabs.get(2));
        DreamDiaryPage diaryPage = new DreamDiaryPage(driver);
        Assert.assertEquals(diaryPage.getDreamRows().size(), 10, "Dream entry count mismatch.");
    }

    @Test(priority = 3)
    public void verifyDreamTypes() {
        driver.switchTo().window(tabs.get(1));
        DreamDiaryPage diaryPage = new DreamDiaryPage(driver);
        for (WebElement type : diaryPage.getDreamTypes()) {
            String value = type.getText().trim();
            Assert.assertTrue(value.equals("Good") || value.equals("Bad"), "Invalid type: " + value);
        }
    }

    @Test(priority = 4)
    public void verifyAllColumnsAreFilled() {
        driver.switchTo().window(tabs.get(2));
        DreamDiaryPage diaryPage = new DreamDiaryPage(driver);
        Assert.assertTrue(diaryPage.allColumnsFilled(), "Some rows have missing values.");
    }

    @Test(priority = 5)
    public void verifySummaryStats() throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
        SummaryPage summaryPage = new SummaryPage(driver);

        Assert.assertEquals(summaryPage.getGoodDreamsText(), "Good Dreams 6", "Good Dreams count mismatch");
        Assert.assertEquals(summaryPage.getBadDreamsText(), "Bad Dreams 4", "Bad Dreams count mismatch");
        Assert.assertEquals(summaryPage.getTotalDreamsText(), "Total Dreams 10", "Total Dreams count mismatch");
        Assert.assertEquals(summaryPage.getRecurringDreamsText(), "Recurring Dreams 2", "Recurring Dreams count mismatch");
    }

}