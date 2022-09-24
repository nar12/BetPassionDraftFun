package tests;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BetPass;
import pages.RulesPage;

public class TestRulesPage {
    public static WebDriver webDriver;
    public RulesPage rulesPage;

    public BetPass betPass;

    @BeforeClass
    public void startBrowser() {
        webDriver = Config.createWebDriver();
        betPass = new BetPass(webDriver);
        rulesPage = new RulesPage(webDriver);
    }

    @BeforeMethod
    public void openBetPassSite() {
        betPass.
                openBetPassSite();
    }

    @Test(description = "Check rules page was open")
    public void openRulesPage() {
        rulesPage.
                openRulesPage().
                checkRulesPageWasOpen();
    }

    @Test
    public void checkGuideWrapText() {
        rulesPage.
                openRulesPage().
                checkRulesPageWasOpen().
                checkRulesWrapIsDisplayed().
                checkTextOfRulesWrap();
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}
