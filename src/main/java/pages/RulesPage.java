package pages;

import common.WaitElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RulesPage {
    WebDriver WD;
    @FindBy(xpath = "//div[@class='rules__body']")
    WebElement rulesWrap;
    @FindBy(xpath = "//a[@href='/rules']")
    WebElement rulesBtn;


    public RulesPage(WebDriver webDriver) {
        this.WD = webDriver;
        PageFactory.initElements(WD, this);
    }

    @Step("Open rules page")
    public RulesPage openRulesPage() {
        WaitElement.waitToBeClickable(WD, rulesBtn).click();

        return this;
    }

    @Step("Check rules page was open")
    public RulesPage checkRulesPageWasOpen() {
        Assert.assertEquals("https://betpassionfun.draft10.com/rules", WD.getCurrentUrl());

        return this;
    }

    @Step("Check rules wrap visibility")
    public RulesPage checkRulesWrapIsDisplayed() {
        Assert.assertTrue(rulesWrap.isDisplayed());

        return this;
    }

    @Step("Check text of rules wrap")
    public RulesPage checkTextOfRulesWrap() {
        Assert.assertEquals(rulesWrap.getAttribute("innerText"), "Rules\n1. PROMOTING SUBJECT\nPassiongroup Limited with registered office in XXXXXXXXXXX\n2. DELEGATED SUBJECT\nThe delegated party within the meaning of Article 5, third paragraph, of Presidential Decree No 430 of 26 October 2001 is: MAX MARKETING Srl\nRegistered office: Via F. Pontara, 26 - 25062 Concesio (BS) Operating office: Via Cassala, 16/18 - 25126 Brescia\n3. DENOMINATION\nThe prize competition which is the subject of these rules is called \"Betpassion Fun\" (the \"Competition\").\n4. PERIOD OF PERFORMANCE\nThe Competition will take place from 02 July 2022 to 02 July 2023\nRecord of the awarding of prizes at the premises of a notary public or a responsible official of the Chamber of Commerce, or his delegate: no later than 23 July 2023\n5. TERRITORIAL EXTENSION\nEntire Italian territory and the Republic of San Marino (hereinafter the \"Territory\"). The server dedicated to the running of the Competition is located in Italian territory.\n6. PROMOTED PRODUCTS AND SERVICES\nThe Competition is aimed at promoting the services offered by the Promoter via the Betpassion.it platform, a gaming site with regular authorisation for remote collection XXXXXX\n7. PARTICIPANTS\nAll consumers who are at least 18 years of age and register on the website ww\nThose who do not meet the requirements set out in this Article 7 will be automatically excluded from the Sweepstakes.\nEach user may only register for the Competition once. In the event that the Promoter considers that the same user has created multiple profiles and/or participates with multiple users in the Competition, the same user will be excluded from the Competition and will not be entitled to any prize. Similarly, in the event of a mismatch between the data registered at the time of participation and the data required for confirmation of winning, the user will be excluded from the Competition and will lose the right to obtain any prizes won.\nOnly Participants who meet the requirements set out in this paragraph 7 and perform the activities set out in paragraph 11 will be eligible to win prizes in the Competition.\n8. COMPETITION MECHANICS\nThe Competition provides for the holding on the Site of completely free slot tournaments illustrated in paragraph 9 below through which participants can earn points (PP) or Amazon Gift Cards.\nThe Site also includes information, news, techniques, valid customs in the gaming for real sector, to increase awareness on responsible gaming through a free exercise (Site fun) but experiential and therefore much more effective.\nIn this regard, in addition to the content part of services, the part of games inspired by slots tournaments will contain related references (articles, pills, videos, manuals) useful to acquire know-how and the valid approach to separate the fun component, widely contained in the fun Site, from the gambling component: excluded from the for fun Site but present in everyday life.\n9. MODALITIES OF PARTICIPATION\nAll users who meet the requirements of Section 7 and comply with the terms of the Rules may participate in slot tournaments for FREE.\nParticipants will receive 500 Passionpoints upon registration and another 200 each day upon login.\nPassionpoints (also referred to as PP) are the Site's free, worthless, non-withdrawable and non-transferable currency with which to take part in slots tournaments.\nIn order to receive the 200 Passionpoints and to participate in tournaments, users must have provided their First Name, Last Name, Tax ID, a valid e-mail address and a valid mobile phone number. For the latter two fields, a verification code will be sent to be entered on the site or on the applications.\nAll users are placed on the same playing field.\nUsers will be able to participate in the tournament by purchasing access with the Passionpoints available on the account.\nThe operation of the tournament will be as follows:\n• All tournament entrants will have the same number of spins available.\n• The value of each spin will be the same for all.\n• Winnings achieved on the slots will award points which will populate the tournament leaderboard which will be managed in real time.\n• The user with the highest number of points will win the tournament.\n10. NOTIFICATION OF WINNINGS\nThe winner will be notified by e-mail to the address provided at the time of registration or by SMS to the telephone number provided at the time of registration for the Competition, as well as being able to receive a PUSH notification on the Site.\nThe notification will contain a SECRET CODE and a link. The winner will have to click on the link to access the confirmation/acceptance page of the prize, where he/she will have to enter the secret code, upload via the UPLOAD button a valid identity document that will be stored on the PORTAL systems together with the following data:\nWinner's Name, Surname, email, mobile phone number\nFile with Identity Document\nType of Prize Won\nDate of Prize Won\nDate/Time of entering the secret code\nThe Winner must respond within 7 days from the date of notification by entering the secret code and uploading the identity document. Once the deadline for acceptance has expired unsuccessfully, the prize will be considered \"not accepted\" and it will be assigned to the reserves, in order of ranking, using the same communication methods and with the same deadlines for acceptance as those set out in the previous paragraph for the original winner.\nOnce the receipt of the secret code to access the winners' reserved area has been verified and the identity document uploaded by the winner has been verified, the PRIZE DOWNLOAD button will be activated for the winner to download.");

        return this;
    }
}
