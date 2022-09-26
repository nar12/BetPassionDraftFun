package pages;

import common.WaitElement;
import org.openqa.selenium.By;
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

    //@FindBy(xpath = "//span[text()='873']//..//..//..//..//div[@class='tournament-button-state']//button")
    //WebElement tournament;


    public TournamentPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    public TournamentPage openTournamentPage() {
        WaitElement.waitToBeClickable(WD, tournamentBtn).click();

        return this;
    }

    public TournamentPage checkTournamentPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/tournament", WD.getCurrentUrl());

        return this;
    }

    public TournamentPage openGameTypeFilter() throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);
        gameTypeFilter.click();

        return this;
    }

    public TournamentPage openStatusFilter() throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);
        statusFilter.click();

        return this;
    }

    public TournamentPage openBuyInFilter() throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);
        buyInTypeFilter.click();

        return this;
    }

    public TournamentPage openTournamentTypeFilter() throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);
        tournamentTypeFilter.click();

        return this;
    }

    public TournamentPage clickTournamentFreerollCheckBox() {
        freerollCheckbox.click();

        return this;
    }

    public TournamentPage clickTournamentRegularCheckBox() {
        regularCheckbox.click();

        return this;
    }

    public TournamentPage registerInTournament(String id) throws InterruptedException {
        WD.switchTo().frame(iframe);
        Thread.sleep(2000);
        WD.findElement(By.
                        xpath(String.
                                format("//span[text()='%s']//..//..//..//..//div[@class='tournament-button-state']//button", id))).
                click();

        WD.findElement(By.xpath("//label[@for='coinBalance']")).click();

        WD.findElement(By.xpath("//div[(@class='modal__buttons ')]//*[text()='Register']")).click();
        Thread.sleep(1000);
        WD.findElement(By.xpath("//button[contains(@class,'button button--tertiary')]")).click();
        return this;
    }
}
