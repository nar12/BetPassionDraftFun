package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @BeforeMethod
    public void openSite() {
        betPass.
                openBetPassSite();
    }

    @Test(description = "Check main menu pages")
    public void CheckMainPages() {
        betPass.
                openTournamentPage().checkTournamentPageWasOpen().
                openGuidePage().checkGuidePageWasOpen().
                openNewsPage().checkNewsPageWasOpen().
                openRulesPage().checkRulesPageWasOpen().
                openLoginForm().checkLoginPageWasOpen().
                openRegistrationForm().checkRegPageWasOpen();
    }
    @Test(description = "Check all languages")
    public void checkLanguages() throws InterruptedException {
        betPass.
                openLanguagesList().chooseEnglishLanguage().checkEnglishLanguage().
                openLanguagesList().chooseItalianLanguage().checkItalianLanguage().
                openLanguagesList().chooseJapaneseLanguage().checkJapaneseLanguage().
                openLanguagesList().chooseTurkishLanguage().checkTurkishLanguage().
                openLanguagesList().chooseSpanishLanguage().checkSpanishLanguage();

    }

    @Test(description = "Check bonus login")
    public void clickSignUp1000PP() {
        betPass.
                clickSignUp1000PP().
                checkRegPageWasOpen();
    }
    @Test(description = "Check footer menu")
    public void CheckMediaPages() {
        betPass.
                clickFacebook().checkMediaPageWasOpen(FACEBOOK_URL).
                clickInstagram().checkMediaPageWasOpen(INSTAGRAM_URL).
                clickTelegram().checkMediaPageWasOpen(TELEGRAM_URL).
                clickYoutube().checkMediaPageWasOpen(YOUTUBE_URL).
                clickCookiePolicy().checkMediaPageWasOpen(COOKIE_POLICY_URL).
                clickPrivacyPolice().checkMediaPageWasOpen(PRIVACY_POLICY_URL).
                clickTermini().checkMediaPageWasOpen(TERMINI_URL);
    }
}
