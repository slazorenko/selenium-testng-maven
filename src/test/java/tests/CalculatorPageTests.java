package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.CalculatorPageSteps;

public class CalculatorPageTests {

    WebDriver driver;
    CalculatorPageSteps steps = new CalculatorPageSteps();
    private final String URL = "https://ia.ca/mortgage-payment-calculator";


    @BeforeClass
    public void setUp() {
        driver = new CalculatorPageSteps().getPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Link("https://ia.ca/mortgage-payment-calculator")
    @Test(description = "Check page URL")
    @Description("Check URL of mortgages page")
    @Severity(SeverityLevel.BLOCKER)
    private void checkPageURL() {
//        driver.get(URL);
        steps.checkLink(driver.getCurrentUrl(), URL);
    }

    @Test(description = "Check \"Purchase price\" slider movement")
    @Description("Check \"Purchase price\" slider movement")
    @Severity(SeverityLevel.CRITICAL)
    private void checkPurchasePriceSliderMovement() {
        WebElement slider = driver.findElement(By.xpath(steps.getPriceSliderXpath()));
        WebElement purchasePrice = driver.findElement(By.xpath(steps.getPurchasePriceTextBoxXpath()));
        int width = slider.getSize().getWidth();
        steps.dragAndDropElement(driver, slider, width * 100, 0);
        steps.checkElementAttr(slider, "style", "left: 100%;");
        steps.checkElementAttr(purchasePrice, "value", "2000000");
    }

    @Test(description = "Check \"Down payment\" slider movement")
    @Description("Check \"Down Payment\" slider movement")
    @Severity(SeverityLevel.CRITICAL)
    private void checkDownPaymentSliderMovement() {
        WebElement slider = driver.findElement(By.xpath(steps.getPaymentSliderXpath()));
        WebElement payment = driver.findElement(By.xpath(steps.getDownPaymentTextBoxXpath()));
        int width = slider.getSize().getWidth();
        steps.dragAndDropElement(driver, slider, width * 100, 0);
        steps.checkElementAttr(slider, "style", "left: 100%;");
        steps.checkElementAttr(payment, "value", "1000000");
    }

    @Test(description = "Check Purchase price Plus button")
    @Description("Check Plus button")
    @Severity(SeverityLevel.CRITICAL)
    private void checkPlusButton() {
        WebElement slider = driver.findElement(By.xpath(steps.getPriceSliderXpath()));
        WebElement purchasePrice = driver.findElement(By.xpath(steps.getPurchasePriceTextBoxXpath()));
        WebElement plusButton = driver.findElement(By.xpath(steps.getPurchasePricePlusButtonXpath()));
        purchasePrice.clear();

        for (int i = 0; i < 2; i++) {
            steps.clickElement(driver, plusButton);
        }
        steps.checkElementAttr(purchasePrice, "value", "500000");
        steps.checkElementAttr(slider, "style", "left: 25%;");
    }

    @Test(description = "Check Weekly Payment Calculation")
    @Description("Check Weekly Payment Calculation")
    @Severity(SeverityLevel.BLOCKER)
    private void checkPaymentCalculation() {
        driver.get(URL);
        WebElement pricePlusBtn = driver.findElement(By.xpath(steps.getPurchasePricePlusButtonXpath()));
        WebElement priceText = driver.findElement(By.xpath(steps.getPurchasePriceTextBoxXpath()));

        while (!priceText.getAttribute("value").equals("500000")) {
            steps.clickElement(driver, pricePlusBtn);
        }
        steps.checkElementAttr(priceText, "value", "500000");

        WebElement paymentPlusBtn = driver.findElement(By.xpath(steps.getDownPaymentPlusButtonXpath()));
        WebElement paymentText = driver.findElement(By.xpath(steps.getDownPaymentTextBoxXpath()));
        while (!paymentText.getAttribute("value").equals("100000")) {//1 step=100000
            steps.clickElement(driver, paymentPlusBtn);
        }

        WebElement amort = driver.findElement(By.xpath(steps.getAmortDropDownListXpath()));
        steps.selectVisibleValueFromDropDownList(driver, amort, "15 years");


        WebElement freq = driver.findElement(By.xpath(steps.getPaymentFreqDropDownListXpath()));
        Select select = new Select(freq);
        steps.selectItemIndexFromDropDownList(driver, freq, 3);

        WebElement interest = driver.findElement(By.xpath(steps.getInterestRateTextBoxXpath()));
        steps.sendValueToElement(driver, interest, "5.0");
    }
}
