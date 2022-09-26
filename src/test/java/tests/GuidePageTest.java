package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GuidePageTest extends BaseTest{

    @BeforeMethod
    public void openBetPassSite() {
        betPass.
                openBetPassSite();
    }

    @Test(description = "Check guide page was open")
    public void openGuidePage() {
        guidePage.
                openGuidePage().
                checkGuidePageWasOpen();
    }

    @Test
    public void checkGuideWrapText() {
        guidePage.
                openGuidePage().
                checkGuidePageWasOpen().
                checkGuideWrapIsDisplayed().
                checkTextOfGuideWrap();
    }

    @Test
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
