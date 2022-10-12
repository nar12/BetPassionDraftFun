package tests.UI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewsPageTest extends BaseTest{

    @BeforeMethod
    public void openBetPassSite() {
        homePage.
                openBetPassSite();
    }

    @Test(description = "Check news page was open")
    public void openNewsPage() {
        newsPage.
                openNewsPage().
                checkNewsPageWasOpen();
    }
}
