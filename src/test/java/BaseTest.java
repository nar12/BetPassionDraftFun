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
    String username = "nar12";
    String password = "asd456";

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        betPass = new BetPass(webDriver);
    }

    @BeforeMethod
    public void openSite() {
        betPass.openBetPassSite();
    }

    @Test
    public void openRegistrationPage() {
        registrationPage.openRegistrationPage();
    }

    @Test
    public void registration() {
        registrationPage.openRegistrationPage().correctRegistration(username, password);
    }

    @Test
    public void wrongRegister() {
        registrationPage.openRegistrationPage().wrongRegistration(username, password);
    }

    @Test
    public void checkRegCheckBox() {
        registrationPage.openRegistrationPage().checkRegistrationCheckBox();
    }

    @Test
    public void checkSameUserNameRegister() throws InterruptedException {
        registrationPage.openRegistrationPage().checkSameUserNameRegistration(username, password);
    }

    @Test
    public void openLoginPage() {
        loginPage.openLoginPage();
    }

    @Test
    public void logIn() {
        loginPage.openLoginPage().correctLogIn(username, password);
    }

    @Test
    public void wrongPassLogIn() throws InterruptedException {
        loginPage.openLoginPage().wrongPasswordLogIn(username, password);
    }

    @Test
    public void wrongUserLogIn() throws InterruptedException {
        loginPage.openLoginPage().wrongUserNameLogIn(username, password);
    }
}
