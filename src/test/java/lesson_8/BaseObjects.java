package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseObjects extends BaseTestsPages {
    WebDriver driver;
    WebDriverWait wait;

    @Override
    public WebDriver getDriver() {
        return  driver;
    }

    public BaseObjects(WebDriver driver) {
        this.driver = driver;
        wait =  new WebDriverWait(driver, 8);
        PageFactory.initElements(driver, this);
    }




}
