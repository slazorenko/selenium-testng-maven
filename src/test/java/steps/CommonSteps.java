package steps;

import attaches.Attach;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CommonSteps extends Assert{

    @Step("Click on element {element}")
    public void clickElement(WebDriver driver, WebElement element) {
        try {
            element.click();
        }
        finally {
            Attach.attachScreenshot(driver);
        }
    }

    @Step("Drag and Drop element {element}")
    public void dragAndDropElement(WebDriver driver, WebElement element, int X, int Y) {
        try {
            new Actions(driver).dragAndDropBy(element, X, Y).build().perform();
        } finally {
            Attach.attachScreenshot(driver);
        }
    }

    @Step("Select visible value \"{value}\" from dropdown list")
    public void selectVisibleValueFromDropDownList(WebDriver driver, WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(value);
        } finally {
            Attach.attachScreenshot(driver);
        }
    }

    @Step("Select value \"{value}\" from dropdown list")
    public void selectValueFromDropDownList(WebDriver driver, WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } finally {
            Attach.attachScreenshot(driver);
        }
    }

    @Step("Select item by index \"{index}\" from dropdown list")
    public void selectItemIndexFromDropDownList(WebDriver driver, WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
        } finally {
            Attach.attachScreenshot(driver);
        }
    }

    @Step("Send value \"{value}\" to element")
    public void sendValueToElement(WebDriver driver, WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
        } finally {
            Attach.attachScreenshot(driver);
        }
    }


    @Step("Check that element visibility = {expectedVisibility}")
    public void checkVisibility(WebDriver driver, WebElement element, boolean expectedVisibility) {
        try {
            assertEquals(element.isDisplayed(), expectedVisibility);
        } finally {
            Attach.attachScreenshot(driver);
        }
    }

    @Step("Check that element isEnabled  = {expectedState}")
    public void checkEnabled(WebDriver driver, WebElement element, boolean expectedState) {
        try {
            assertEquals(element.isEnabled(), expectedState);
        } finally {
            Attach.attachScreenshot(driver);
        }
    }

    @Step("Check that element text is equals to \"{expectedText}\"")
    public void checkElementText(WebDriver driver, WebElement element, String expectedText) {
        try {
            assertEquals(element.getText(), expectedText);
        } finally {
            Attach.attachScreenshot(driver);
        }
    }

    @Step("Check that element attribute {attributeName} value is equals to \"{expectedAttributeValue}\"")
    public void checkAttribute(WebElement element, String attributeName, String expectedAttributeValue) {
        assertEquals(element.getAttribute(attributeName), expectedAttributeValue);
    }

    @Step("Check that element text is equals to \"{expectedLink}\"")
    public void checkLink(String link, String expectedLink) {
        assertEquals(link, expectedLink);
    }

    @Step("Validate element style attribute: {attrName} value equals to \"{expectedValue}\"")
    public void checkElementAttr(WebElement element, String attrName, String expectedValue) {
        String attrValue = element.getAttribute(attrName);
        assertEquals(attrValue, expectedValue);
    }

}
