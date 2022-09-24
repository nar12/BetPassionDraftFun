package tests;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BetPass;
import pages.NewsPage;

public class TestNewsPage {
    public static WebDriver webDriver;
    public NewsPage newsPage;

    public BetPass betPass;

    @BeforeClass
    public void startBrowser() {
        webDriver = Config.createWebDriver();
        betPass = new BetPass(webDriver);
        newsPage = new NewsPage(webDriver);
    }

    @BeforeMethod
    public void openBetPassSite() {
        betPass.
                openBetPassSite();
    }

    @Test(description = "Check news page was open")
    public void openNewsPage() {
        newsPage.
                openNewsPage().
                checkNewsPageWasOpen();
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}
