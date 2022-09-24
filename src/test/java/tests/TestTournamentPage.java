package tests;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BetPass;
import pages.LoginPage;
import pages.TournamentPage;
import common.Constants;

public class TestTournamentPage {
    public static WebDriver webDriver;
    public TournamentPage tournamentPage;
    public LoginPage loginPage;

    public BetPass betPass;

    @BeforeClass
    public void startBrowser() {
        webDriver = Config.createWebDriver();
        betPass = new BetPass(webDriver);
        tournamentPage = new TournamentPage(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @BeforeMethod
    public void openBetPassSite() {
        betPass.
                openBetPassSite();
    }

    @Test(description = "Check tournament page was open")
    public void openTournamentPage() {
        tournamentPage.
                openTournamentPage().
                checkTournamentPageWasOpen();
    }

    @Test
    public void openFreerollsTournaments() throws InterruptedException {
        tournamentPage.
                openTournamentPage().
                checkTournamentPageWasOpen().
                openTournamentTypeFilter().
                clickTournamentFreerollCheckBox();
    }

    @Test
    public void openRegularTournaments() throws InterruptedException {
        tournamentPage.
                openTournamentPage().
                checkTournamentPageWasOpen().
                openTournamentTypeFilter().
                clickTournamentRegularCheckBox();
    }

    @Test
    public void registrationInTournament() throws InterruptedException {
        loginPage.
                openLoginForm().
                enterUsername(Constants.USERNAME).
                enterPassword(Constants.PASSWORD).
                clickLoginButton().
                checkLoginSuccess();
        tournamentPage.
                openTournamentPage().
                checkTournamentPageWasOpen().
                registerInTournament(Constants.TOURNAMENT_ID);
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}
