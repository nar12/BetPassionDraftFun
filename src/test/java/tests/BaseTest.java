package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.BetPass;
import pages.LoginPage;
import pages.RegistrationPage;

public class BaseTest {
    public static WebDriver webDriver;
    public BetPass betPass;
    public LoginPage loginPage;
    public RegistrationPage registrationPage;

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        betPass = new BetPass(webDriver);
    }

    @Test
    public void openSite() {
        betPass.openBetPassSite();
    }
}
