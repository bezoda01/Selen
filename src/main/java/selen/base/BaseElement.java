package selen.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selen.waits.ExplicitWaits;

import static selen.Loggerr.*;
import static selen.driver.Driver.*;

public class BaseElement {

    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    protected WebElement findElement() {
        log("Search elements - " + name);
        return getDriver().findElement(locator);
    }

    public void click() {
        log("Click on - " + name);
        findElement().click();
    }

    public String getText() {
        log("Return field text - " + name);
        return findElement().getText();
    }

    public String getTextAttribute(String attribute) {
        log("Return attribute value - " + name);
        return findElement().getAttribute(attribute);
    }

    public ExplicitWaits waits() {
        return new ExplicitWaits(locator);
    }

    public By getLocator() {
        return locator;
    }
}
