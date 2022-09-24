package tests;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BetPass;
import pages.GuidePage;

public class TestGuidePage {
    public static WebDriver webDriver;
    public GuidePage guidePage;

    public BetPass betPass;

    @BeforeClass
    public void startBrowser() {
        webDriver = Config.createWebDriver();
        betPass = new BetPass(webDriver);
        guidePage = new GuidePage(webDriver);
    }

    @BeforeMethod
    public void openBetPassSite() {
        betPass.
                openBetPassSite();
    }

    @Test(description = "Check guide page was open")
    public void openGuidePage() {
        guidePage.
                openGuidePage().
                checkGuidePageWasOpen();
    }

    @Test
    public void checkGuideWrapText() {
        guidePage.
                openGuidePage().
                checkGuidePageWasOpen().
                checkGuideWrapIsDisplayed().
                checkTextOfGuideWrap();
    }

    @Test
    public void checkFirstDropDownText() {
        guidePage.
                openGuidePage().
                checkFirstDropDownText();
    }

    @Test
    public void checkSecondDropDownText() {
        guidePage.
                openGuidePage().
                checkSecondDropDownText();
    }

    @Test
    public void checkThirdDropDownText() {
        guidePage.
                openGuidePage().
                checkThirdDropDownText();
    }

    @Test
    public void checkFourthDropDownText() {
        guidePage.
                openGuidePage().
                checkFourthDropDownText();
    }

    @Test
    public void checkFifthDropDownText() {
        guidePage.
                openGuidePage().
                checkFifthDropDownText();
    }

    @Test
    public void checkSixthDropDownText() {
        guidePage.
                openGuidePage().
                checkSixthDropDownText();
    }

    @Test
    public void checkSeventhDropDownText() {
        guidePage.
                openGuidePage().
                checkSeventhDropDownText();
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}
