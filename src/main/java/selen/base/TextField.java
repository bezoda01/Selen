package selen.base;

import org.openqa.selenium.By;

import static selen.Loggerr.*;

public class TextField extends BaseElement {
    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        log("Отправляем текст - " + text);
        findElement().sendKeys(text);
    }
}
