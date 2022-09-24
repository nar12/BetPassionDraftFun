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
import java.util.ArrayList;

public class BetPass {
    public WebDriver WD;
    @FindBy(xpath = "//a[@href='/tournament']")
    WebElement tournament;
    @FindBy(xpath = "//a[@href='/guide']")
    WebElement guide;
    @FindBy(xpath = "//a[@href='/news']")
    WebElement news;
    @FindBy(xpath = "//a[@href='/rules']")
    WebElement rules;
    @FindBy(xpath = "//button[contains(@class,'button btn button--primary-rounded')]")
    WebElement login;
    @FindBy(xpath = "//div[@class='language-selector__flag']")
    WebElement languages;
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
    WebElement signUp1000PP;
    @FindBy(xpath = "//button[contains(@class,'button btn button--secondary-rounded')]")
    WebElement register;
    @FindBy(xpath = "//a[@href='https://www.facebook.com/NoiSiamoPassione']")
    WebElement facebook;
    @FindBy(xpath = "//a[@href='https://www.instagram.com/betpassion.it/']")
    WebElement instagram;
    @FindBy(xpath = "//a[@href='https://t.me/betpassionofficial']")
    WebElement telegram;
    @FindBy(xpath = "//a[@href='https://www.youtube.com/results?search_query=betpassion.info']")
    WebElement youtube;
    @FindBy(xpath = "//a[@href='https://www.iubenda.com/privacy-policy/30380830/cookie-policy']")
    WebElement cookiePolicy;
    @FindBy(xpath = "//a[@href='https://www.iubenda.com/privacy-policy/30380830']")
    WebElement privacyPolicy;
    @FindBy(xpath = "//a[@href='https://www.iubenda.com/termini-e-condizioni/30380830']")
    WebElement termini;

    public BetPass(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public BetPass openBetPassSite() {
        WD.get("https://betpassionfun.draft10.com/");

        return this;
    }

    public BetPass openTournamentPage() {
        WaitElement.waitToBeClickable(WD, tournament).click();

        return this;
    }

    public BetPass checkTournamentPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/tournament", WD.getCurrentUrl());

        return this;
    }

    public BetPass openGuidePage() {
        WaitElement.waitToBeClickable(WD, guide).click();

        return this;
    }

    public BetPass checkGuidePageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/guide", WD.getCurrentUrl());

        return this;
    }

    public BetPass openNewsPage() {
        WaitElement.waitToBeClickable(WD, news).click();

        return this;
    }

    public BetPass checkNewsPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/news", WD.getCurrentUrl());

        return this;
    }

    public BetPass openRulesPage() {
        WaitElement.waitToBeClickable(WD, rules).click();

        return this;
    }

    public BetPass checkRulesPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/rules", WD.getCurrentUrl());

        return this;
    }

    public BetPass openLoginForm() {
        WaitElement.waitToBeClickable(WD, login).click();

        return this;
    }

    public BetPass checkLoginPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/login", WD.getCurrentUrl());

        return this;
    }

    public BetPass openRegistrationForm() {
        WaitElement.waitToBeClickable(WD, register).click();

        return this;
    }

    public BetPass openLanguagesList() {
        WaitElement.waitToBeClickable(WD, languages).click();

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
        WaitElement.waitVisibilityOf(WD, login);
        Thread.sleep(350);
        Assert.assertEquals(login.getAttribute("innerText"), "Log In");

        return this;
    }

    public BetPass checkItalianLanguage() throws InterruptedException {
        WaitElement.waitVisibilityOf(WD, login);
        Thread.sleep(350);
        Assert.assertEquals(login.getAttribute("innerText"), "Accedi");

        return this;
    }

    public BetPass checkJapaneseLanguage() throws InterruptedException {
        WaitElement.waitVisibilityOf(WD, login);
        Thread.sleep(350);
        Assert.assertEquals(login.getAttribute("innerText"), "ログイ");

        return this;
    }

    public BetPass checkTurkishLanguage() throws InterruptedException {
        WaitElement.waitVisibilityOf(WD, login);
        Thread.sleep(350);
        Assert.assertEquals(login.getAttribute("innerText"), "Giris");

        return this;
    }

    public BetPass checkSpanishLanguage() throws InterruptedException {
        WaitElement.waitVisibilityOf(WD, login);
        Thread.sleep(350);
        Assert.assertEquals(login.getAttribute("innerText"), "Entrar");

        return this;
    }

    public BetPass clickSignUp1000PP() {
        WaitElement.waitToBeClickable(WD, signUp1000PP).click();

        return this;
    }

    public BetPass clickFacebook() {
        WaitElement.waitToBeClickable(WD, facebook).click();

        return this;
    }


    public BetPass clickInstagram() {
        WaitElement.waitToBeClickable(WD, instagram).click();

        return this;
    }


    public BetPass clickTelegram() {
        WaitElement.waitToBeClickable(WD, telegram).click();

        return this;
    }


    public BetPass clickYoutube() {
        WaitElement.waitToBeClickable(WD, youtube).click();
        return this;
    }


    public BetPass clickCookiePolicy() {
        WaitElement.waitToBeClickable(WD, cookiePolicy).click();

        return this;
    }


    public BetPass clickPrivacyPolice() {
        WaitElement.waitToBeClickable(WD, privacyPolicy).click();

        return this;
    }


    public BetPass clickTermini() {
        WaitElement.waitToBeClickable(WD, termini).click();

        return this;
    }

    public BetPass checkMediaPageWasOpen(String url) {
        ArrayList<String> tabs = new ArrayList<String>(WD.getWindowHandles());
        WD.switchTo().window(tabs.get(1));
        Assert.assertEquals(WD.getCurrentUrl(), url);
        WD.close();
        WD.switchTo().window(tabs.get(0));

        return this;
    }
}
