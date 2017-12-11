package lesson_8;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.*;


public class SummaryPage extends BaseObjects{

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id='cart_title']/span")
    WebElement cartTitle;

    @FindBy (xpath = "//*[@id='center_column']/p[2]/a[1]/span")
    WebElement proccedToCheckoutBtn;


    public SignInPage switchToLogin () {
        wait.until(ExpectedConditions.visibilityOf(proccedToCheckoutBtn));
        proccedToCheckoutBtn.click();
        return  new SignInPage(driver);
    }

}
