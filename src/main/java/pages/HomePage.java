package pages;

import common.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;

public class HomePage {
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

    public HomePage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public HomePage openBetPassSite() {
        WD.get("https://betpassionfun.draft10.com/");

        return this;
    }

    public HomePage openTournamentPage() {
        WaitElement.waitToBeClickable(WD, tournamentBtn).click();

        return this;
    }

    public HomePage checkTournamentPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/tournament", WD.getCurrentUrl());

        return this;
    }

    public HomePage openGuidePage() {
        WaitElement.waitToBeClickable(WD, guideBtn).click();

        return this;
    }

    public HomePage checkGuidePageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/guide", WD.getCurrentUrl());

        return this;
    }

    public HomePage openNewsPage() {
        WaitElement.waitToBeClickable(WD, newsBtn).click();

        return this;
    }

    public HomePage checkNewsPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/news", WD.getCurrentUrl());

        return this;
    }

    public HomePage openRulesPage() {
        WaitElement.waitToBeClickable(WD, rulesBtn).click();

        return this;
    }

    public HomePage checkRulesPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/rules", WD.getCurrentUrl());

        return this;
    }

    public HomePage openLoginForm() {
        WaitElement.waitToBeClickable(WD, loginBtn).click();

        return this;
    }

    public HomePage checkLoginPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/login", WD.getCurrentUrl());

        return this;
    }

    public HomePage openRegistrationForm() {
        WaitElement.waitToBeClickable(WD, registerBtn).click();

        return this;
    }

    public HomePage openLanguagesList() {
        WaitElement.waitToBeClickable(WD, languagesBtn).click();

        return this;
    }

    public HomePage checkRegPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/register", WD.getCurrentUrl());

        return this;
    }
    public HomePage changeLanguage(String language){
        openLanguagesList();
        WD.findElement(By.xpath(String.format("//div[text()='%s']",language))).click();

        return this;
    }

    public HomePage CheckLanguages(String language) throws InterruptedException {
        ArrayList<String> languagesAssertion = new ArrayList<>();
        ArrayList<WebElement> allElements = new ArrayList<>();
        allElements.add(loginBtn);
        switch(language){
            case "English":
                languagesAssertion.add("Log In");
                break;
            case "Italian":
                languagesAssertion.add("Accedi");
                break;
            case "Japanese":
                languagesAssertion.add("ログイ");
                break;
            case "Turkish":
                languagesAssertion.add("Giris");
                break;
            case "Spanish":
                languagesAssertion.add("Entrar");
                break;
            default:
                Assert.fail("Incorrect language");
        }
        changeLanguage(language);
        for (int i = 0; i < allElements.size(); ++i) {
            Thread.sleep(750);
            Assert.assertEquals((allElements.get(i)).getText(),languagesAssertion.get(i));
        }
        return this;
    }

    public HomePage clickSignUp1000PP() {
        WaitElement.waitToBeClickable(WD, signUp1000PPBtn).click();

        return this;
    }

    public HomePage clickFacebook() {
        WaitElement.waitToBeClickable(WD, facebookBtn).click();

        return this;
    }


    public HomePage clickInstagram() {
        WaitElement.waitToBeClickable(WD, instagramBtn).click();

        return this;
    }


    public HomePage clickTelegram() {
        WaitElement.waitToBeClickable(WD, telegramBtn).click();

        return this;
    }


    public HomePage clickYoutube() {
        WaitElement.waitToBeClickable(WD, youtubeBtn).click();
        return this;
    }


    public HomePage clickCookiePolicy() {
        WaitElement.waitToBeClickable(WD, cookiePolicyBtn).click();

        return this;
    }


    public HomePage clickPrivacyPolice() {
        WaitElement.waitToBeClickable(WD, privacyPolicyBtn).click();

        return this;
    }


    public HomePage clickTermini() {
        WaitElement.waitToBeClickable(WD, terminiBtn).click();

        return this;
    }

    public HomePage checkMediaPageWasOpen(String url) {
        ArrayList<String> tabs = new ArrayList<>(WD.getWindowHandles());
        WD.switchTo().window(tabs.get(1));
        Assert.assertEquals(WD.getCurrentUrl(), url);
        WD.close();
        WD.switchTo().window(tabs.get(0));

        return this;
    }
}
