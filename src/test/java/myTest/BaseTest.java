package myTest;

import myTest.utils.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    static WebDriver driver;
    @DataProvider (name = "login")
    public static Object[][] credentials (){
        return new Object[][] { { "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" }};
    }

    @Parameters("browser")
    @BeforeClass
    public static WebDriver getDriver(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }


        return driver;
    }

    static EventFiringWebDriver getConfiguredDriver(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        EventFiringWebDriver wrappedDriver = new EventFiringWebDriver(driver);
        wrappedDriver.register(new EventHandler());
        return wrappedDriver;
    }
    @AfterTest
    public  void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }

    }
    private void log (String message){
        Reporter.log(message + "<br>");
    }
}
