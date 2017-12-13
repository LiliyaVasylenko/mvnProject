package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PaymentPage extends BaseForPages {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//*[@id='HOOK_PAYMENT']//a)[1]")
    WebElement payByBankWire;

    @FindBy (xpath = "//*[@id='cart_navigation']//span")
    WebElement paymnentConfirmationBtn;

    @FindBy (xpath = "//*[@id='center_column']/p/a")
    WebElement backToHistoryBtn;


    public void payForProduct () {
        LOG.info("Pay for selected product");
        payByBankWire.click();
        paymnentConfirmationBtn.click();
    }

    public OrderHistoryPage switchToOrderHistory () {
        LOG.info("Switch to order history");
        wait.until(ExpectedConditions.visibilityOf(backToHistoryBtn));
        backToHistoryBtn.click();
        return new OrderHistoryPage(driver);

    }
}

