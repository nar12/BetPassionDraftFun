package UI.pages;

import common.WaitElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TournamentPage {
    WebDriver WD;
    @FindBy(xpath = "//a[@href='/tournament']")
    WebElement tournamentBtn;
    @FindBy(xpath = "//iframe[@class='social-tournament']")
    WebElement iframe;
    @FindBy(xpath = "//div[@title='gameType']")
    WebElement gameTypeFilter;
    @FindBy(xpath = "//div[@title='tournamentType']")
    WebElement tournamentTypeFilter;
    @FindBy(xpath = "//div[@title='status']")
    WebElement statusFilter;
    @FindBy(xpath = "//div[@title='buyIn']")
    WebElement buyInTypeFilter;
    @FindBy(xpath = "//span[text()='Freeroll']/following-sibling::div[@class='checkbox']")
    WebElement freerollCheckbox;
    @FindBy(xpath = "//span[text()='regular']/following-sibling::div[@class='checkbox']")
    WebElement regularCheckbox;
    @FindBy(xpath = "//div[@class='tournament-item '][1]//div[@class='tournament-button-state']//button")
    WebElement firstTournamentRegisterBtn;
    @FindBy(xpath = "//label[@for='coinBalance']")
    WebElement coinBalanceCheckBox;
    @FindBy(xpath = "//div[(@class='modal__buttons ')]//*[text()='Register']")
    WebElement secondRegisterInTournamentBtn;
    @FindBy(xpath = "//button[contains(@class,'button button--tertiary')]")
    WebElement successRegInTourCloseBtn;

    //@FindBy(xpath = "//span[text()='873']//..//..//..//..//div[@class='tournament-button-state']//button")
    //WebElement tournament;


    public TournamentPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    @Step("Open tournament page")
    public TournamentPage openTournamentPage() {
        WaitElement.waitToBeClickable(WD, tournamentBtn).click();

        return this;
    }

    @Step("Check tournament page was open")
    public TournamentPage checkTournamentPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/tournament", WD.getCurrentUrl());

        return this;
    }

    @Step("Open game type filter")
    public TournamentPage openGameTypeFilter() throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);
        gameTypeFilter.click();

        return this;
    }

    @Step("Open status filter")
    public TournamentPage openStatusFilter() throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);
        statusFilter.click();

        return this;
    }

    @Step("Open buy in filter")
    public TournamentPage openBuyInFilter() throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);
        buyInTypeFilter.click();

        return this;
    }

    @Step("Open tournament type filter")
    public TournamentPage openTournamentTypeFilter() throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);
        tournamentTypeFilter.click();

        return this;
    }

    @Step("Choose freeroll tournaments")
    public TournamentPage clickTournamentFreerollCheckBox() {
        freerollCheckbox.click();

        return this;
    }

    @Step("Choose regular tournaments")
    public TournamentPage clickTournamentRegularCheckBox() {
        regularCheckbox.click();

        return this;
    }

    @Step("Registration in first tournament")
    public TournamentPage registerInFirstTournament() throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);

        firstTournamentRegisterBtn.click();
        coinBalanceCheckBox.click();
        secondRegisterInTournamentBtn.click();
        Thread.sleep(1000);
        successRegInTourCloseBtn.click();
        return this;
    }
}
