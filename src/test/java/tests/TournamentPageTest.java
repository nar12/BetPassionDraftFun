package tests;

import org.testng.annotations.*;
public class TournamentPageTest extends BaseTest {

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
                enterUsername(USERNAME).
                enterPassword(PASSWORD).
                clickLoginButton().
                checkLoginSuccess();
        tournamentPage.
                openTournamentPage().
                checkTournamentPageWasOpen().
                registerInTournament(TOURNAMENT_ID);
    }
}
