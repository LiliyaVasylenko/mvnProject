package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderHistoryPage extends BaseForPages {
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='order-list']//tr[1]/td[1]")
    WebElement lastOrderfromHistory;

    @FindBy(xpath = ".//tr/td[2]/label")
    WebElement nameColorSize;


    public void selectLastOrder() {
        LOG.info("Select last order");
     lastOrderfromHistory.click();
}
}
