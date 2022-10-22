package pages;

import common.WaitElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GuidePage {
    WebDriver WD;
    @FindBy(xpath = "//a[@href='/guide']")
    WebElement guideBtn;
    @FindBy(xpath = "//div[@class='guide__body']")
    WebElement guideWrap;
    @FindBy(xpath = "//div[@class='dropdown-item__title btn']//span[text()='How many places are awarded?']")
    WebElement firstDropDown;
    @FindBy(xpath = "//div[@class='dropdown-item__title btn']//span[text()='How long do casino tournaments last?']")
    WebElement secondDropDown;
    @FindBy(xpath = "//div[@class='dropdown-item__title btn']//span[text()='What happens in the event of a tie? ']")
    WebElement thirdDropDown;
    @FindBy(xpath = "//div[@class='dropdown-item__title btn']//span[text()='How to participate in a tournament']")
    WebElement fourthDropDown;
    @FindBy(xpath = "//div[@class='dropdown-item__title btn']//span[text()='Buy-in Types']")
    WebElement fifthDropDown;
    @FindBy(xpath = "//div[@class='dropdown-item__title btn']//span[text()='Features available for tournaments']")
    WebElement sixthDropDown;
    @FindBy(xpath = "//div[@class='dropdown-item__title btn']//span[text()='Prizes']")
    WebElement seventhDropDown;
    @FindBy(xpath = "//div[@class='dropdown-item__body-text-wrapper']")
    WebElement dropDownText;


    public GuidePage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    @Step("Open guide page")
    public GuidePage openGuidePage() {
        WaitElement.waitToBeClickable(WD, guideBtn).click();

        return this;
    }
    @Step("Check guide page was open")
    public GuidePage checkGuidePageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/guide", WD.getCurrentUrl());

        return this;
    }
    @Step("Check visibility of guide wrap")
    public GuidePage checkGuideWrapIsDisplayed() {
        Assert.assertTrue(guideWrap.isDisplayed());

        return this;
    }
    @Step("Open text of guide wrap")
    public GuidePage checkTextOfGuideWrap() {
        Assert.assertEquals(guideWrap.getAttribute("innerText"), "Betpassionfun\nBetpassionfun, is a new and fun online gaming platform that gives people over the age of 18 the chance to play free Casino Tournaments and win numerous real money prizes in Amazon vouchers.\nWhat is a Casino Tournament and how it works\nThe casino tournament, is a fun competition between players on slot machines and is very similar to the poker tournament. Players can access the tournament through through BFPs (BetpassionFunPoint) obtained through the daily login programme.\nOnce registered for the tournament all participants receive a predetermined number of Spins on one of our fantastic Slots.\nAt the end of these spins, the player will have obtained a score which will be valid for determining the final ranking of the tournament and for the distribution of prizes.\nTournament programme\nAt Betpassionfun you will find the following tournaments:\n• 50€ Daily Guaranteed. To access this tournament you need to pay buy-in of 100 BFP obtainable through the Daily login program\n• 250€ Guaranteed Weekly. To access this one you must win a ticket via the dedicated satellite tournament.\n• Freeroll 10 Ticket GRT for the Weekly tournament. Access to this tournament is totally free and allows you to win a ticket to the €250 weekly tournament.\n• Guaranteed Surprise Tournaments. These are tournaments with guaranteed prizes that will be entered by BetpassionFun at Surprise\nHow is scoring calculated in our tournaments?\nThe players' score is calculated based on the winnings achieved on the Slot with the spins awarded at the start of the tournament\nHow can I check my score and ranking?\nThere are two ways:\n1. During the tournament, directly on the slot via a side widget showing all score, ranking and prize data in real time.\n2. Directly from the casino tournament lobby\nHow many places are awarded?\nThe number of winners and the amount of prizes distributed may be fixed or variable, this always depends on the type of tournament and the number of participants, so we recommend always consulting the prize structures in the detailed tournament lobby.\nHow long do casino tournaments last?\nWhat happens in the event of a tie?\nHow to participate in a tournament\nBuy-in Types\nFeatures available for tournaments\nPrizes");

        return this;
    }
    @Step("Check first dropdown text")
    public GuidePage checkFirstDropDownText() {
        firstDropDown.click();
        firstDropDown.click();
        Assert.assertEquals(dropDownText.getAttribute("innerText"), "The number of winners and the amount of prizes distributed may be fixed or variable, this always depends on the type of tournament and the number of participants, so we recommend always consulting the prize structures in the detailed tournament lobby.");

        return this;
    }
    @Step("Check second dropdown text")
    public GuidePage checkSecondDropDownText() {
        secondDropDown.click();
        Assert.assertEquals(dropDownText.getAttribute("innerText"), "The tournament duration varies from tournament to tournament. All details are accessible in the casino tournament lobby.");

        return this;
    }
    @Step("Check third dropdown text")
    public GuidePage checkThirdDropDownText() {
        thirdDropDown.click();
        Assert.assertEquals(dropDownText.getAttribute("innerText"), "In the event of a tie, the player who registered first in the tournament is placed highest.");

        return this;
    }
    @Step("Check fourth dropdown text")
    public GuidePage checkFourthDropDownText() {
        fourthDropDown.click();
        Assert.assertEquals(dropDownText.getAttribute("innerText"), "• Create a new account at BetpassionFun or log in.\n• Go to the dedicated \"Casino Tournaments\" page.\n• Select a tournament under Registration Status.\n• Register and click Start Tournament.\n• Play, have fun competing with other players, climb the leaderboard and win great prizes in real money in amazon vouchers.");

        return this;
    }
    @Step("Check fifth dropdown text")
    public GuidePage checkFifthDropDownText() {
        fifthDropDown.click();
        Assert.assertEquals(dropDownText.getAttribute("innerText"), "Players can purchase access to the tournament at:\n• Betpassionfun Points. Obtainable through the daily login programme (100BFP at the first Daily Login), or upon completion of certain missions (Account Registration,Mail Validation,Phone Validation)\n• Tickets. Tickets can be awarded via free (satellite) tournaments or via special invitations.");

        return this;
    }
    @Step("Check sixth dropdown text")
    public GuidePage checkSixthDropDownText() {
        sixthDropDown.click();
        Assert.assertEquals(dropDownText.getAttribute("innerText"), "Late Registration. Players have the opportunity to register even after the start of the tournament.");

        return this;
    }
    @Step("Check seventh dropdown text")
    public GuidePage checkSeventhDropDownText() {
        seventhDropDown.click();
        Assert.assertEquals(dropDownText.getAttribute("innerText"), "Casino tournaments may award prizes in:\n• Real money in Amazon Vouchers*\n• BFP(BetpassionFunPoint)\n• Tickets\n*Amazon voucher prizes will be credited within a maximum of 72 hours after the end of the tournament. For more information please contact us on Info@Betpassionfun.it");

        return this;
    }
}
