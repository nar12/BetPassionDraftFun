package tests.UI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class GuidePageTest extends BaseTest{

    @BeforeMethod
    public void openBetPassSite() {
        homePage.
                openBetPassSite();
    }

    @Test(description = "Check guide page was open")
    public void openGuidePage() {
        guidePage.
                openGuidePage().
                checkGuidePageWasOpen();
    }

    @Test(description = "Check text of guide wrapper")
    public void checkGuideWrapText() {
        guidePage.
                openGuidePage().
                checkGuidePageWasOpen().
                checkGuideWrapIsDisplayed().
                checkTextOfGuideWrap();
    }

    @Test(description = "Check all dropdowns text")
    public void checkDropDownsText() {
        guidePage.
                openGuidePage().
                checkFirstDropDownText().
                checkSecondDropDownText().
                checkThirdDropDownText().
                checkFourthDropDownText().
                checkFifthDropDownText().
                checkSixthDropDownText().
                checkSeventhDropDownText();
    }
}
