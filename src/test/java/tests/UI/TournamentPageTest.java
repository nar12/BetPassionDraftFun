package tests.UI;

import org.testng.annotations.*;
public class TournamentPageTest extends BaseTest {

    @BeforeMethod
    public void openBetPassSite() {
        homePage.
                openBetPassSite();
    }

    @Test(description = "Check tournament page was open")
    public void openTournamentPage() {
        tournamentPage.
                openTournamentPage().
                checkTournamentPageWasOpen();
    }

    @Test(description = "Check freeroll filter of tournaments")
    public void openFreerollsTournaments() throws InterruptedException {
        tournamentPage.
                openTournamentPage().
                checkTournamentPageWasOpen().
                openTournamentTypeFilter().
                clickTournamentFreerollCheckBox();
    }

    @Test(description = "Check regular filter of tournaments")
    public void openRegularTournaments() throws InterruptedException {
        tournamentPage.
                openTournamentPage().
                checkTournamentPageWasOpen().
                openTournamentTypeFilter().
                clickTournamentRegularCheckBox();
    }

    /*@Test(description = "Registration to tournament")
    public void registrationInFirstTournament() throws InterruptedException {
        loginPage.
                openLoginPage().
                enterUsername(USERNAME).
                enterPassword(PASSWORD).
                clickLoginButton().
                checkLoginSuccess();
        tournamentPage.
                openTournamentPage().
                checkTournamentPageWasOpen().
                registerInFirstTournament();
    }*/
}
