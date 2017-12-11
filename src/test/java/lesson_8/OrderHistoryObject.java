package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * Created by Liliia.Vasylenko on 11.12.2017.
 */
public class OrderHistoryObject extends BaseObjects {
    public OrderHistoryObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='order-list']/tbody/tr[1]/td[1]")
    WebElement lastOrderfromHistory;


//    @FindBys({@FindBy(xpath = "//*[@id='order-detail-content']/table//tr/td[2]/label[contains(text(), 'Blouse - Color : Black, Size : S')]"),
//            @FindBy(xpath = "//*[@id='order-detail-content']/table/tfoot/tr[4]/td[2]/span[contains(text(), '$29.00')]")})
   // List<WebElement> orderCorrectness;


    public void selectLastOrder() {
     lastOrderfromHistory.click();
}
}
