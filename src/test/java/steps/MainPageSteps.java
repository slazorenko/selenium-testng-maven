package steps;

import interfaces.ASteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageSteps extends CommonSteps implements ASteps {

    private final String URL = "https://ia.ca/";

    private final String loansButtonXpath = "//span[contains(.,'Loans')]";
    private final String loansMenuXpath = "(//ul[@class='dropdown-menu dropdown-menu-large'])";
    private final String mortgagesLinkXpath = "//a[contains(.,'Mortgages')]";

    public String getURL() {
        return this.URL;
    }

    public String getLoansButtonXpath() {
        return this.loansButtonXpath;
    }

    public String getLoansMenuXpath() {
        return this.loansMenuXpath;
    }

    public String getMortgagesLinkXpath() {
        return this.mortgagesLinkXpath;
    }

    public WebDriver getPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        return driver;
    }
}
