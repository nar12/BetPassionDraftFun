package pages;

import common.WaitElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewsPage {
    WebDriver WD;
    @FindBy(xpath = "//a[@href='/news']")
    WebElement newsBtn;


    public NewsPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    @Step("Open news page")
    public NewsPage openNewsPage() {
        WaitElement.waitToBeClickable(WD, newsBtn).click();

        return this;
    }

    @Step("Check news page was open")
    public NewsPage checkNewsPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/news", WD.getCurrentUrl());

        return this;
    }
}
