package lessons_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    @FindBy (id = "email")
    WebElement usernameField;

    @FindBy (className = "login")
    WebElement signInOption;

    @FindBy (id = "passwd")
    WebElement passwordField;

    @FindBy(name = "SubmitLogin")
    WebElement signInBtn;


    public LoginPage enterUsername(String email) {
        signInOption.click();
        usernameField.sendKeys(email);
        return new LoginPage(driver);
    }

    public LoginPage  enterPassword(String password) {
        passwordField.sendKeys(password);
        return new LoginPage(driver);
    }

    public AccountPage  clickSignInBtn() {
        signInBtn.click();
       return new AccountPage(driver);
    }

    public AccountPage logIn(String email, String password) {
        enterUsername(email);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(driver);
    }
}
