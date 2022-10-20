package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static common.Constants.DURATION_TIME;

public class Config {
    public static WebDriver driver = null;

    @Parameters("browser")
    public static WebDriver createWebDriver(String browser) {
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //FirefoxBinary firefoxBinary = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
                firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                System.setProperty("webdriver.gecko.driver", "C:\\FirefoxDriver\\geckodriver.exe");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                Assert.fail("Incorrect platform or browser: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(DURATION_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DURATION_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
