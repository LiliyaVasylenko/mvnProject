package lesson_10;

import com.google.common.base.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Base {
    static WebDriver driver;
    static WebDriverWait wait;
    protected static final String BASE_URL = "http://automationpractice.com";
    protected final Logger LOG = LogManager.getLogger(this);

    @Rule
    public TestRule rule = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            captureScreenshot(description.getMethodName());
        }
    };

    private void captureScreenshot(String methodName) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh.mm_a");
        File screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("report.path") + "/screenshots/" + dateFormat.format(new Date());
        try {
            org.apache.commons.io.FileUtils.copyFile(screenshot, new File(path));
            LOG.info("Screenshot was written: " + dateFormat.format(new Date()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 7);
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    static {
        if (System.getProperty("report.path") == null) {
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }

}
