package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.Constants.DURATION_TIME;

public class WaitElement {
    public static WebElement waitVisibilityOf(WebDriver driver, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION_TIME));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    public static WebElement waitToBeClickable(WebDriver driver, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }
}
