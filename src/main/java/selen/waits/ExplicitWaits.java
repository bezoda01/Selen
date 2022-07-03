package selen.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static selen.driver.Driver.getDriver;
import static selen.settings.Settings.timeouts;

public class ExplicitWaits {

    private By locator;

    public ExplicitWaits(By locator) {
        this.locator = locator;
    }

    private final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds((Long) timeouts.get("timeoutCondition")));

    public void ofElementLocated() {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void elementToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void visibilityOfElementLocated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean attributeContains(String attribute, String value) {
        return wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    public static class EWaitsForm {
        private By locator;
        private ExplicitWaits explicitWaits = new ExplicitWaits(locator);

        public EWaitsForm(By locator) {
            this.locator = locator;
        }

        public boolean titleIs(String title) {
            return explicitWaits.wait.until(ExpectedConditions.titleIs(title));
        }
    }
}
