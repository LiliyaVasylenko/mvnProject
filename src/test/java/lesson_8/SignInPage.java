package lesson_8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SignInPage extends BaseObjects{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "email")
    WebElement emailField;

    @FindBy (id = "passwd")
    WebElement passwordField;

    @FindBy (name = "SubmitLogin")
    WebElement signInField;



    public AddressPage login (String userName, String passw) {

        emailField.sendKeys(userName);
        passwordField.sendKeys(passw);
        signInField.click();
       return new AddressPage(driver);
    }






}
