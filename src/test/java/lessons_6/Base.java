package lessons_6;

import lesson_5.AdditionalClass;
import lesson_5.LoginTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Base {
    protected static final String BASE_URL = "http://automationpractice.com";
    public static String email = "777@gmail.com";
    public static String password = "7777777";
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\test\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       //river.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
