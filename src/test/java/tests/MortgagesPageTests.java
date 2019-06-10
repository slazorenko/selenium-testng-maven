package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.MortgagesPageSteps;

import java.util.concurrent.TimeUnit;

public class MortgagesPageTests {

    WebDriver driver;
    MortgagesPageSteps steps = new MortgagesPageSteps();
    private final String URL = "https://ia.ca/mortgage";

    @BeforeClass
    public void setUp() {
        driver = new MortgagesPageSteps().getPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



    @Link("http://www.ia.ca/mortgage")
    @Test(description = "Check page URL")
    @Description("Check URL of mortgages page")
    @Severity(SeverityLevel.BLOCKER)
    private void checkPageURL() {
//        driver.get(URL);
        steps.checkLink(driver.getCurrentUrl(), URL);
    }

    @Test(description = "Check calculator link")
    @Description("Check calculator link")
    @Severity(SeverityLevel.BLOCKER)
    private void checkCalculateLink() throws Exception {
//        driver.get(URL);
        WebElement calcBlock = driver.findElement(By.xpath(steps.getCalculateButtonXpath()));
        steps.checkEnabled(driver, calcBlock, true);
        steps.checkVisibility(driver, calcBlock, true);
        steps.checkAttribute(calcBlock, "href", "https://ia.ca/mortgage-payment-calculator");
    }

    @Test(description = "Navigate to Calculator")
    @Severity(SeverityLevel.CRITICAL)
    private void clickAndNavigate() throws Exception {
//        driver.get(URL);
        WebElement calcBlock = driver.findElement(By.xpath(steps.getCalculateButtonXpath()));
        steps.clickElement(driver, calcBlock);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String url = driver.getCurrentUrl();
        steps.checkLink(url, "https://ia.ca/mortgage-payment-calculator");
    }

}
