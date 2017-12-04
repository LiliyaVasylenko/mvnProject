package lessons_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage {
    WebDriver driver;


    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".logout")
    WebElement logOutField;

    public LoginPage signOut() throws InterruptedException {
        logOutField.click();
          return new LoginPage(driver);
    }
}


