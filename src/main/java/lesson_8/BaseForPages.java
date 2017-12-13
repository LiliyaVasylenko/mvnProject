package lesson_8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseForPages extends BaseForTestsAndPages {
    WebDriver driver;
    WebDriverWait wait;

    @Override
    public WebDriver getDriver() {
        return  driver;
    }

    protected   final Logger LOG = LogManager.getLogger(this);

    public BaseForPages(WebDriver driver) {
        this.driver = driver;
        wait =  new WebDriverWait(driver, 8);
        PageFactory.initElements(driver, this);
    }

  // @FindBy(xpath = "//*[@id='layer_cart' or @id='center_column']//span[contains(text(),'Proceed to checkout')]")
    @FindBy (xpath = "//*[@id='center_column']//span[contains(text(),'Proceed to checkout')]")
    WebElement proccedToCheckOutBtn;


    static {
        if(System.getProperty("report.path") == null){
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }


}
