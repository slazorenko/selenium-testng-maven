package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import steps.MainPageSteps;

import java.util.concurrent.TimeUnit;

public class MainPageTests {

    WebDriver driver;
    MainPageSteps steps = new MainPageSteps();

    @BeforeClass
    public void setUp() {
        driver = new MainPageSteps().getPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Link("http://www.ia.ca")
    @Test(description = "Check main page URL")
    @Description("Check URL of main page")
    @Severity(SeverityLevel.NORMAL)
    private void checkMainPageURL() {
        steps.checkLink(driver.getCurrentUrl(), steps.getURL());
    }

    @Test(description = "Check LOANS button and menu before click")
    @Severity(SeverityLevel.CRITICAL)
    private void checkLoansButtonBeforeClick() {
        WebElement loanButton = driver.findElement(By.xpath(steps.getLoansButtonXpath()));
        steps.checkEnabled(driver, loanButton, true);
        steps.checkVisibility(driver, loanButton, true);
        steps.checkElementText(driver, loanButton, "LOANS");

        WebElement loansMenu = driver.findElement(By.xpath(steps.getLoansMenuXpath()));
        steps.checkVisibility(driver, loansMenu, false);
    }

    @Test(description = "Validate elements after LOANS click")
    @Severity(SeverityLevel.CRITICAL)
    private void checkLoansButtonAfterClick() {
        driver.get(steps.getURL());
        WebElement loanButton = driver.findElement(By.xpath(steps.getLoansButtonXpath()));
        steps.clickElement(driver, loanButton);

        WebElement mortgagesMenuLink = driver.findElement(By.xpath(steps.getMortgagesLinkXpath()));
        steps.checkVisibility(driver, mortgagesMenuLink, true);
        steps.checkAttribute(mortgagesMenuLink, "href", "https://ia.ca/mortgage");
    }

    @Test(description = "Click LOANS button and validate navigated URL")
    @Severity(SeverityLevel.CRITICAL)
    private void clickOnLinkAndNavigate() {
        driver.get(steps.getURL());
        WebElement loanButton = driver.findElement(By.xpath(steps.getLoansButtonXpath()));
        steps.clickElement(driver, loanButton);

        WebElement mortgagesMenuLink = driver.findElement(By.xpath(steps.getMortgagesLinkXpath()));
        steps.clickElement(driver, mortgagesMenuLink);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String url = driver.getCurrentUrl();
        steps.checkLink(url, "https://ia.ca/mortgage");
    }
}
