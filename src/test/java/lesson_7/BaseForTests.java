package lesson_7;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseForTests extends BaseGeneral {
    static WebDriver driver;
    protected static final String BASE_URL = "http://automationpractice.com";
    public static String email = "777@gmail.com";
    public static String password = "7777777";

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
