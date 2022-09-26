package pages;

import common.WaitElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;

public class BetPass {
    public WebDriver WD;
    @FindBy(xpath = "//a[@href='/tournament']")
    WebElement tournamentBtn;
    @FindBy(xpath = "//a[@href='/guide']")
    WebElement guideBtn;
    @FindBy(xpath = "//a[@href='/news']")
    WebElement newsBtn;
    @FindBy(xpath = "//a[@href='/rules']")
    WebElement rulesBtn;
    @FindBy(xpath = "//button[@class = 'button btn button--primary-rounded']")
    WebElement loginBtn;
    @FindBy(xpath = "//div[@class='language-selector__flag']")
    WebElement languagesBtn;
    @FindBy(xpath = "//div[text()='English']")
    WebElement english;
    @FindBy(xpath = "//div[text()='Italian']")
    WebElement italian;
    @FindBy(xpath = "//div[text()='Japanese']")
    WebElement japanese;
    @FindBy(xpath = "//div[text()='Turkish']")
    WebElement turkish;
    @FindBy(xpath = "//div[text()='Spanish']")
    WebElement spanish;
    @FindBy(xpath = "//button[@class='home-page__greeting-content--sign-in-button']")
    WebElement signUp1000PPBtn;
    @FindBy(xpath = "//button[@class='button btn button--secondary-rounded']")
    WebElement registerBtn;
    @FindBy(xpath = "//a[@href='https://www.facebook.com/NoiSiamoPassione']")
    WebElement facebookBtn;
    @FindBy(xpath = "//a[@href='https://www.instagram.com/betpassion.it/']")
    WebElement instagramBtn;
    @FindBy(xpath = "//a[@href='https://t.me/betpassionofficial']")
    WebElement telegramBtn;
    @FindBy(xpath = "//a[@href='https://www.youtube.com/results?search_query=betpassion.info']")
    WebElement youtubeBtn;
    @FindBy(xpath = "//a[@href='https://www.iubenda.com/privacy-policy/30380830/cookie-policy']")
    WebElement cookiePolicyBtn;
    @FindBy(xpath = "//a[@href='https://www.iubenda.com/privacy-policy/30380830']")
    WebElement privacyPolicyBtn;
    @FindBy(xpath = "//a[@href='https://www.iubenda.com/termini-e-condizioni/30380830']")
    WebElement terminiBtn;

    public BetPass(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public BetPass openBetPassSite() {
        WD.get("https://betpassionfun.draft10.com/");

        return this;
    }

    public BetPass openTournamentPage() {
        WaitElement.waitToBeClickable(WD, tournamentBtn).click();

        return this;
    }

    public BetPass checkTournamentPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/tournament", WD.getCurrentUrl());

        return this;
    }

    public BetPass openGuidePage() {
        WaitElement.waitToBeClickable(WD, guideBtn).click();

        return this;
    }

    public BetPass checkGuidePageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/guide", WD.getCurrentUrl());

        return this;
    }

    public BetPass openNewsPage() {
        WaitElement.waitToBeClickable(WD, newsBtn).click();

        return this;
    }

    public BetPass checkNewsPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/news", WD.getCurrentUrl());

        return this;
    }

    public BetPass openRulesPage() {
        WaitElement.waitToBeClickable(WD, rulesBtn).click();

        return this;
    }

    public BetPass checkRulesPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/rules", WD.getCurrentUrl());

        return this;
    }

    public BetPass openLoginForm() {
        WaitElement.waitToBeClickable(WD, loginBtn).click();

        return this;
    }

    public BetPass checkLoginPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/login", WD.getCurrentUrl());

        return this;
    }

    public BetPass openRegistrationForm() {
        WaitElement.waitToBeClickable(WD, registerBtn).click();

        return this;
    }

    public BetPass openLanguagesList() {
        WaitElement.waitToBeClickable(WD, languagesBtn).click();

        return this;
    }

    public BetPass checkRegPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/register", WD.getCurrentUrl());

        return this;
    }


    public BetPass chooseItalianLanguage() {
        WaitElement.waitToBeClickable(WD, italian).click();

        return this;
    }

    public BetPass chooseEnglishLanguage() {
        WaitElement.waitToBeClickable(WD, english).click();

        return this;
    }

    public BetPass chooseJapaneseLanguage() {
        WaitElement.waitToBeClickable(WD, japanese).click();

        return this;
    }

    public BetPass chooseTurkishLanguage() {
        WaitElement.waitToBeClickable(WD, turkish).click();

        return this;
    }

    public BetPass chooseSpanishLanguage() {
        WaitElement.waitToBeClickable(WD, spanish).click();

        return this;
    }

    public BetPass checkEnglishLanguage() throws InterruptedException {
        WaitElement.waitVisibilityOf(WD, loginBtn);
        Thread.sleep(750);
        Assert.assertEquals(loginBtn.getAttribute("innerText"), "Log In");

        return this;
    }

    public BetPass checkItalianLanguage() throws InterruptedException {
        WaitElement.waitVisibilityOf(WD, loginBtn);
        Thread.sleep(750);
        Assert.assertEquals(loginBtn.getAttribute("innerText"), "Accedi");

        return this;
    }

    public BetPass checkJapaneseLanguage() throws InterruptedException {
        WaitElement.waitVisibilityOf(WD, loginBtn);
        Thread.sleep(750);
        Assert.assertEquals(loginBtn.getAttribute("innerText"), "ログイ");

        return this;
    }

    public BetPass checkTurkishLanguage() throws InterruptedException {
        WaitElement.waitVisibilityOf(WD, loginBtn);
        Thread.sleep(750);
        Assert.assertEquals(loginBtn.getAttribute("innerText"), "Giris");

        return this;
    }

    public BetPass checkSpanishLanguage() throws InterruptedException {
        WaitElement.waitVisibilityOf(WD, loginBtn);
        Thread.sleep(750);
        Assert.assertEquals(loginBtn.getAttribute("innerText"), "Entrar");

        return this;
    }

    public BetPass clickSignUp1000PP() {
        WaitElement.waitToBeClickable(WD, signUp1000PPBtn).click();

        return this;
    }

    public BetPass clickFacebook() {
        WaitElement.waitToBeClickable(WD, facebookBtn).click();

        return this;
    }


    public BetPass clickInstagram() {
        WaitElement.waitToBeClickable(WD, instagramBtn).click();

        return this;
    }


    public BetPass clickTelegram() {
        WaitElement.waitToBeClickable(WD, telegramBtn).click();

        return this;
    }


    public BetPass clickYoutube() {
        WaitElement.waitToBeClickable(WD, youtubeBtn).click();
        return this;
    }


    public BetPass clickCookiePolicy() {
        WaitElement.waitToBeClickable(WD, cookiePolicyBtn).click();

        return this;
    }


    public BetPass clickPrivacyPolice() {
        WaitElement.waitToBeClickable(WD, privacyPolicyBtn).click();

        return this;
    }


    public BetPass clickTermini() {
        WaitElement.waitToBeClickable(WD, terminiBtn).click();

        return this;
    }

    public BetPass checkMediaPageWasOpen(String url) {
        ArrayList<String> tabs = new ArrayList<>(WD.getWindowHandles());
        WD.switchTo().window(tabs.get(1));
        Assert.assertEquals(WD.getCurrentUrl(), url);
        WD.close();
        WD.switchTo().window(tabs.get(0));

        return this;
    }
}
