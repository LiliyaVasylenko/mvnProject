package lesson_9;


import com.google.common.base.Function;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Base {
    static  WebDriver driver;
    static WebDriverWait wait;
    protected static final String BASE_URL = "http://automationpractice.com";


    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        wait =  new WebDriverWait(driver, 7);
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    static {
        if(System.getProperty("report.path") == null){
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }

    protected <V> V assertThat(Function<? super WebDriver, V> contition) {
        return wait.until(contition);
    }

}
