package tests.UI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @BeforeMethod
    public void openSite() {
        homePage.
                openBetPassSite();
    }

    @Test(description = "Check main menu pages")
    public void CheckMainPages() {
        homePage.
                openTournamentPage().checkTournamentPageWasOpen().
                openGuidePage().checkGuidePageWasOpen().
                openNewsPage().checkNewsPageWasOpen().
                openRulesPage().checkRulesPageWasOpen().
                openLoginPage().checkLoginPageWasOpen().
                openRegistrationPage().checkRegPageWasOpen();
    }
    @Test(description = "Check all languages")
    public void checkLanguages() throws InterruptedException {
        homePage.
                CheckLanguages("Italian").
                CheckLanguages("English").
                CheckLanguages("Japanese").
                CheckLanguages("Turkish").
                CheckLanguages("Spanish");
    }

    @Test(description = "Check bonus login")
    public void clickSignUp1000PP() {
        homePage.
                clickSignUp1000PP().
                checkRegPageWasOpen();
    }
    @Test(description = "Check footer menu")
    public void CheckMediaPages() {
        homePage.
                clickFacebook().checkMediaPageWasOpen(FACEBOOK_URL).
                clickInstagram().checkMediaPageWasOpen(INSTAGRAM_URL).
                clickTelegram().checkMediaPageWasOpen(TELEGRAM_URL).
                clickYoutube().checkMediaPageWasOpen(YOUTUBE_URL).
                clickCookiePolicy().checkMediaPageWasOpen(COOKIE_POLICY_URL).
                clickPrivacyPolice().checkMediaPageWasOpen(PRIVACY_POLICY_URL).
                clickTermini().checkMediaPageWasOpen(TERMINI_URL);
    }
}
