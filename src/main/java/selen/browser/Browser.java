package selen.browser;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import java.util.Set;

import static selen.driver.Driver.*;
import static selen.Loggerr.*;

public class Browser {

    public void quit() {
        getDriver().quit();
        log("driver was killed");
    }

    public void close() {
        getDriver().close();
        log("current window was close");
    }

    public void goTo(String url) {
        getDriver().get(url);
        log("go to " + url);
    }

    public String getCurrentUrl() {
        log("return current url");
        return getDriver().getCurrentUrl();
    }

    public String getPageSource() {
        log("return current page source");
        return getDriver().getPageSource();
    }

    public void switchToNewWindow() {
        getDriver().switchTo().newWindow(WindowType.WINDOW);
        log("switch to new window");
    }

    public void switchToNewTab() {
        getDriver().switchTo().newWindow(WindowType.TAB);
        log("switch to new tab");
    }

    public void switchToFrame(String locator) {
        getDriver().switchTo().frame(locator);
        log("switch to frame with locator - " + locator);
    }

    public String getPageTitle() {
        String title = getDriver().getTitle();
        log("return page title - " + title);
        return title;
    }

    public void addCookie(Cookie cookie) {
        getDriver().manage().addCookie(cookie);
        log(
                "cookie name - "+cookie.getName()+
                     "\ncookie value - "+cookie.getValue());
    }

    public Set<Cookie> getCookies() {
        return getDriver().manage().getCookies();
    }

    public void deleteCookie(String name) {
        getDriver().manage().deleteCookieNamed(name);
        log("deleted cookie - "+name);
    }

    public void deleteCookie() {
        for(Cookie cookie : getCookies()) {
            log(
                    "deleted cookie - "
                         +cookie.getName()+":"
                         +cookie.getValue());
        }
        getDriver().manage().deleteAllCookies();
    }

    public WebDriver.Window window() {
        return getDriver().manage().window();
    }
}
