package tests.UI;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.*;

public class BaseTest {
    public WebDriver webDriver;
    public GuidePage guidePage;
    public HomePage homePage;
    public LoginPage loginPage;
    public NewsPage newsPage;
    public RegistrationPage registrationPage;
    public RulesPage rulesPage;
    public TournamentPage tournamentPage;
    public static final String FACEBOOK_URL = "https://www.facebook.com/NoiSiamoPassione";
    public static final String INSTAGRAM_URL = "https://www.instagram.com/betpassion.it/";
    public static final String TELEGRAM_URL = "https://t.me/betpassionofficial";
    public static final String YOUTUBE_URL = "https://www.youtube.com/results?search_query=betpassion.info";
    public static final String COOKIE_POLICY_URL = "https://www.iubenda.com/privacy-policy/30380830/cookie-policy";
    public static final String PRIVACY_POLICY_URL = "https://www.iubenda.com/privacy-policy/30380830";
    public static final String TERMINI_URL = "https://www.iubenda.com/termini-e-condizioni/30380830";
    public static final String USERNAME = "nar12";
    public static final String WRONG_USERNAME = "nar121";
    public static final String PASSWORD = "asd456";
    public static final String WRONG_PASSWORD = "asd4561";

    @BeforeClass
    public void startBrowser() {
        webDriver = Config.createWebDriver();
        homePage = new HomePage(webDriver);
        guidePage = new GuidePage(webDriver);
        loginPage = new LoginPage(webDriver);
        newsPage = new NewsPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        rulesPage = new RulesPage(webDriver);
        tournamentPage = new TournamentPage(webDriver);
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}
