package pages;

import org.openqa.selenium.WebDriver;
public class BetPass {
    public WebDriver WD;

    public BetPass(WebDriver webDriver) {
        this.WD = webDriver;
    }

    public BetPass openBetPassSite() {
        WD.get("https://betpassionfun.draft10.com/");

        return this;
    }
}
