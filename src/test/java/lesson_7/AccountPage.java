package lesson_7;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.bind.Element;
import java.util.List;


public class AccountPage extends BaseForObjects {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id=\"search_query_top\"]")
    WebElement searchField;

//    @FindBy (xpath = "//*[@id=\"center_column\"]/ul//div[2]/h5/a")
//    List<WebElement> listDresses;


    @FindBy(css = ".logout")
    WebElement logOutField;



    public void searchFor (String searchText) {
    searchField.sendKeys(searchText);
        }


    public LoginPage signOut() throws InterruptedException {
        logOutField.click();
          return new LoginPage(driver);
    }
}


