package selen.js;

import org.openqa.selenium.JavascriptExecutor;

import static selen.driver.Driver.*;
import static selen.js.JScripts.*;

public class JSMethods {
    private static JavascriptExecutor executor = (JavascriptExecutor) getDriver();

    public static void executeScript(String script) {
        executor.executeScript(script);
    }

    public static void executeScript(String script, Object ... arg) {
        executor.executeScript(script, arg);
    }

    public static boolean pageIsLoad() {
        return executor.executeScript(LOADSTATE.getValue()).equals("complete");
    }
}
