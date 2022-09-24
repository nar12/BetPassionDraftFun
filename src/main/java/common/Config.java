package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.Constants.PLATFORM_AND_BROWSER;

public class Config {
    public static WebDriver createWebDriver(){
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER){
            case "win_Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Incorrect platform or browser: " + PLATFORM_AND_BROWSER);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
