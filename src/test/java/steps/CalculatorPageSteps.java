package steps;

import interfaces.ASteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorPageSteps extends CommonSteps implements ASteps {

    private final String URL = "https://ia.ca/mortgage-payment-calculator";

    private final String priceSliderXpath = "(//*[@class='slider-handle min-slider-handle custom'])[1]";
    private final String purchasePriceTextBoxXpath = "//*[@id='PrixPropriete']";
    private final String purchasePricePlusButtonXpath = ".//*[@id='PrixProprietePlus']";

    private final String paymentSliderXpath = "(//*[@class='slider-handle min-slider-handle custom'])[2]";
    private final String downPaymentTextBoxXpath = ".//*[@id='MiseDeFond']";
    private final String downPaymentPlusButtonXpath = ".//*[@id='MiseDeFondPlus']";

    private final String amortDropDownListXpath = "//*[@id='Amortissement']";
    private final String paymentFreqDropDownListXpath = "//*[@id='FrequenceVersement']";
    private final String interestRateTextBoxXpath = "//*[@id='TauxInteret']";

    private final String calculateButtonXpath = "//button[contains(.,'Calculate')]";


    public WebDriver getPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        return driver;
    }

    public String getURL() {
        return this.URL;
    }

    public String getPriceSliderXpath() {
        return this.priceSliderXpath;
    }

    public String getPurchasePriceTextBoxXpath() {
        return this.purchasePriceTextBoxXpath;
    }

    public String getPurchasePricePlusButtonXpath() {
        return this.purchasePricePlusButtonXpath;
    }

    public String getPaymentSliderXpath() {
        return this.paymentSliderXpath;
    }

    public String getDownPaymentTextBoxXpath() {
        return this.downPaymentTextBoxXpath;
    }

    public String getDownPaymentPlusButtonXpath() {
        return this.downPaymentPlusButtonXpath;
    }

    public String getAmortDropDownListXpath() {
        return this.amortDropDownListXpath;
    }

    public String getPaymentFreqDropDownListXpath() {
        return this.paymentFreqDropDownListXpath;
    }

    public String getInterestRateTextBoxXpath() {
        return this.interestRateTextBoxXpath;
    }

    public String getCalculateButtonXpath() {
        return this.calculateButtonXpath;
    }

}
