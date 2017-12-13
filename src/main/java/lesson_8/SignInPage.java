package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInPage extends BaseForPages {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "email")
    WebElement emailField;

    @FindBy (id = "passwd")
    WebElement passwordField;

    @FindBy (name = "SubmitLogin")
    WebElement signInBtn;


    public void login (String userName, String passw) {
        LOG.info("Login");
        emailField.sendKeys(userName);
        passwordField.sendKeys(passw);
    }

    public AddressPage switchToAddress () {
        LOG.info("Switch to part Address");
        signInBtn.click();
        return new AddressPage(driver);
    }






}
