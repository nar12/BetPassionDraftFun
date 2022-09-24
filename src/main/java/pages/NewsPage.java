package pages;

import common.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NewsPage {
    WebDriver WD;
    @FindBy(xpath = "//a[@href='/news']")
    WebElement news;


    public NewsPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    public NewsPage openNewsPage() {
        WaitElement.waitToBeClickable(WD, news).click();

        return this;
    }

    public NewsPage checkNewsPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/news", WD.getCurrentUrl());

        return this;
    }
}
