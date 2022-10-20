package tests.UI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RulesPageTest extends BaseTest{

    @BeforeMethod
    public void openBetPassSite() {
        homePage.
                openBetPassSite();
    }

    @Test(description = "Check rules page was open")
    public void openRulesPage() {
        rulesPage.
                openRulesPage().
                checkRulesPageWasOpen();
    }

    @Test(description = "Check text of guide wrapper")
    public void checkGuideWrapText() {
        rulesPage.
                openRulesPage().
                checkRulesPageWasOpen().
                checkRulesWrapIsDisplayed().
                checkTextOfRulesWrap();
    }
}
