package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PaymentPage extends BaseObjects{

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
    WebElement payByBankWire;

    @FindBy (xpath = "//*[@id='cart_navigation']/button/span")
    WebElement paymnentConfirmationBtn;

    public void payForProduct () {
        payByBankWire.click();
        paymnentConfirmationBtn.click();
    }
}

