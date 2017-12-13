package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddressPage extends BaseForPages {

    public AddressPage(WebDriver driver) {
        super(driver);
    }



    public ShippingPage switchToShipping () {
        LOG.info("Switch to the 4-step (Shipping) of order");
        wait.until(ExpectedConditions.visibilityOf(proccedToCheckOutBtn));
        proccedToCheckOutBtn.click();
        return  new ShippingPage(driver);
    }







}
