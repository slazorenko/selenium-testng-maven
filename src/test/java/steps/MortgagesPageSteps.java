package steps;

import interfaces.ASteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MortgagesPageSteps extends CommonSteps implements ASteps {

    private final String URL = "http://www.ia.ca/mortgage";

    private final String calculateButtonXpath = "(//*[@class='section-cliquable section-cliquable-versements '])";

    public String getURL() {
        return this.URL;
    }

    public String getCalculateButtonXpath() {
        return this.calculateButtonXpath;
    }

    public WebDriver getPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        return driver;
    }
}
