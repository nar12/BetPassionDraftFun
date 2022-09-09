package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BetPass {
    public WebDriver WD;

    public BetPass(WebDriver webDriver) {
        this.WD = webDriver;
    }

    public BetPass openBetPassSite() {
        WD.get("https://betpassionfun.draft10.com/");

        return this;
    }
}
