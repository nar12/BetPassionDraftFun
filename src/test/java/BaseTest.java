import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BetPass;

public class BaseTest {
    public static WebDriver webDriver;
    public BetPass betPass;
    String username = "nar12";
    String password = "asd456";

    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        betPass = new BetPass(webDriver);
    }

    @BeforeMethod
    public void openSite() {
        betPass.openBetPassSite();
    }

    @Test
    public void registration() {
        betPass.correctRegistration(username, password);
    }

    @Test
    public void logIn() {
        betPass.correctLogIn(username, password);
    }

    @Test
    public void wrongPassLogIn() throws InterruptedException {
        betPass.wrongPasswordLogIn(username, password);
    }

    @Test
    public void wrongUserLogIn() throws InterruptedException {
        betPass.wrongUserNameLogIn(username, password);
    }

    @Test
    public void wrongRegister() {
        betPass.wrongRegistration(username, password);
    }

    @Test
    public void checkRegCheckBox(){
        betPass.checkRegistrationCheckBox();
    }

    @Test
    public void checkSameUserNameRegister() throws InterruptedException {
        betPass.checkSameUserNameRegistration(username,password);
    }
}
