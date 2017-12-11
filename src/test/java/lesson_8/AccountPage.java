package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountPage  extends BaseObjects {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id='header']/div[2]//div[1]/a/span")
    WebElement account;

    @FindBy (xpath = "//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")
    WebElement orderHistory;

    @FindBy (xpath = "//*[@id='order-list']/tbody/tr[1]/td[1]")
    WebElement lastOrderfromHistory;


    public void history () {
        account.click();
        orderHistory.click();
        lastOrderfromHistory.click();



    }
}
