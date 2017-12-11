package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ShippingPage extends BaseObjects{

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='form']//button/span")
    WebElement proccedToCheckoutBtn;

    @FindBy (id = "cgv")
    WebElement agreement;



    public PaymentPage switchToPayment () {
        wait.until(ExpectedConditions.visibilityOf(proccedToCheckoutBtn));
        agreement.click();
        proccedToCheckoutBtn.click();
        return new PaymentPage(driver);
    }
}
