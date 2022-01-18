package com.ali.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.ali.utilities.Driver.js;

public class JSUtils {

    /**
     * When you pass the element, JS will click on that element
     * @param element
     */
    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolling all the way down using JS
     */
    public static void scrollDownByJS() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /**
     * Scroll into view
     * @param element
     */
    public static void scrollIntoViewJS(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }

    public static void changeColor(String color, WebElement element) {
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     *  Returns a border for desired element and adds wait
     * @param element
     * @param waitsecond
     * @return
     */
    public static WebElement highlightElement(WebElement element, int waitsecond) {
        js.executeScript("arguments[0].style.border='3px solid orange'", element);
        ReusableMethods.waitFor(waitsecond);
        return element;
    }

    /**
     * Returns a border for desired element
     * @param element
     * @return WebElement
     */
    public static WebElement highlightElement(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid orange'", element);
        return element;
    }


    /**
     *  Executes the given JavaScript command on given web element
     * @param element
     * @param command
     */
    public static void executeJScommand(WebElement element, String command) {
        js.executeScript(command, element);
    }

    /**
     * executes the given JavaScript command on given web element
     * @param command
     */
    public static void executeJScommand(String command) {
        js.executeScript(command);
    }
}
