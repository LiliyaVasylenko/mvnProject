import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    protected  static WebDriver driver;
    protected static  final String BASE_URL = "https://github.com";

    @BeforeClass
    public static void setup() throws  Exception{
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
            }

            @AfterClass
    public static void testClose () throws Exception {
        driver.quit();

            }


            @Test
    public void git() throws  Exception{
                Assert.assertTrue(driver.getTitle().contains("GitHub"));
            }

            @Test
    public void searchRepository() {
                WebElement inputField = driver.findElement(By.name("q"));
                inputField.click();
                inputField.sendKeys("mnvProject");
                inputField.submit();

                WebElement firstReault = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div[1]/div/div[1]/ul/div[1]"));
                //firstReault.get

            }
}
