package tests;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BetPass;
import common.Constants;


public class TestHomePage {
    public static WebDriver webDriver;
    public BetPass betPass;

    @BeforeClass
    public void startBrowser() {
        webDriver = Config.createWebDriver();
        betPass = new BetPass(webDriver);
    }

    @BeforeMethod
    public void openSite() {
        betPass.
                openBetPassSite();
    }

    @Test(description = "Check tournament page was open")
    public void openTournamentPage() {
        betPass.
                openTournamentPage().
                checkTournamentPageWasOpen();
    }

    @Test(description = "Check guide page was open")
    public void openGuidePage() {
        betPass.
                openGuidePage().
                checkGuidePageWasOpen();
    }

    @Test(description = "Check news page was open")
    public void openNewsPage() {
        betPass.
                openNewsPage().
                checkNewsPageWasOpen();
    }

    @Test(description = "Check rules page was open")
    public void openRulesPage() {
        betPass.
                openRulesPage().
                checkRulesPageWasOpen();
    }

    @Test(description = "Check Login page was open")
    public void openLoginPage() {
        betPass.
                openLoginForm().
                checkLoginPageWasOpen();
    }

    @Test
    public void openRegistrationPage() {
        betPass.
                openRegistrationForm().
                checkRegPageWasOpen();
    }

    @Test
    public void checkEng() throws InterruptedException {
        betPass.openLanguagesList().chooseEnglishLanguage().checkEnglishLanguage();

    }

    @Test
    public void checkIt() throws InterruptedException {
        betPass.openLanguagesList().chooseItalianLanguage().checkItalianLanguage();
    }

    @Test
    public void checkJp() throws InterruptedException {
        betPass.openLanguagesList().chooseJapaneseLanguage().checkJapaneseLanguage();
    }

    @Test
    public void checkTk() throws InterruptedException {
        betPass.openLanguagesList().chooseTurkishLanguage().checkTurkishLanguage();
    }

    @Test
    public void checkSp() throws InterruptedException {
        betPass.openLanguagesList().chooseSpanishLanguage().checkSpanishLanguage();
    }

    @Test
    public void clickSignUp1000PP() {
        betPass.
                clickSignUp1000PP().
                checkRegPageWasOpen();
    }

    @Test
    public void openFacebookPage() {
        betPass.
                clickFacebook().
                checkMediaPageWasOpen(Constants.FACEBOOK_URL);
    }

    @Test
    public void openInstagramPage() {
        betPass.
                clickInstagram().
                checkMediaPageWasOpen(Constants.INSTAGRAM_URL);
    }

    @Test
    public void openTelegramPage() {
        betPass.
                clickTelegram().
                checkMediaPageWasOpen(Constants.TELEGRAM_URL);
    }

    @Test
    public void openYoutubePage() {
        betPass.
                clickYoutube().
                checkMediaPageWasOpen(Constants.YOUTUBE_URL);
    }

    @Test
    public void openCookiePolicePage() {
        betPass.
                clickCookiePolicy().
                checkMediaPageWasOpen(Constants.COOKIE_POLICY_URL);
    }

    @Test
    public void openPrivacyPolicePage() {
        betPass.
                clickPrivacyPolice().
                checkMediaPageWasOpen(Constants.PRIVACY_POLICY_URL);
    }

    @Test
    public void openTerminiPage() {
        betPass.
                clickTermini().
                checkMediaPageWasOpen(Constants.TERMINI_URL);
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}
