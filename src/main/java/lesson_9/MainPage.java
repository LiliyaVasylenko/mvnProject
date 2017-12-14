package lesson_9;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static lesson_9.CustomConditions.*;
import static org.hamcrest.CoreMatchers.containsString;


public class MainPage {
    WebDriver driver;
    WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected   final Logger LOG = LogManager.getLogger(this);


    @FindBy (xpath = "//span/child::iframe")
    WebElement iframe;

    @FindBy (xpath = "//child::div[@class='lfloat']//a")
    WebElement linkInIframe;


    public void scrollToFrame() throws Exception {
        LOG.info("Scroll to frame");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollTop = 2200)");
    }

    public void openFrame () {
        LOG.info("Open frame");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }

    public void closeFrame () {
        LOG.info("Close frame");
         driver.switchTo().defaultContent();
    }

}
