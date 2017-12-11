package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import java.util.List;


public class OrderHistoryObject extends BaseObjects {
    public OrderHistoryObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='order-list']/tbody/tr[1]/td[1]")
    WebElement lastOrderfromHistory;

    @FindBy(xpath = ".//tr/td[2]/label")
    WebElement nameColorSize;


    public void selectLastOrder() {
     lastOrderfromHistory.click();
}
}
