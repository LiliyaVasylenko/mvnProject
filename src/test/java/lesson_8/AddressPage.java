package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddressPage extends BaseObjects{

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']//button/span")
    WebElement proccedToCheckoutBtn;

    public ShippingPage switchToShipping () {
        wait.until(ExpectedConditions.visibilityOf(proccedToCheckoutBtn));
        proccedToCheckoutBtn.click();
        return  new ShippingPage(driver);
    }







}
