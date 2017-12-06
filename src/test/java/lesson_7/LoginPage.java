package lesson_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseForObjects{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "SubmitLogin")
    WebElement signInBtn;


    public LoginPage enterUsername(String email) {
        $("//*[@id=\"header\"]/div[2]//div[1]/a").click();
        $("//*[@id=\"email\"]").sendKeys(email);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword(String password) {
        $("//*[@id=\"passwd\"]").sendKeys(password);
        return new LoginPage(driver);
    }

    public AccountPage clickSignInBtn() {
       $("//*[@id=\"SubmitLogin\"]/span").click();
       return new AccountPage(driver);
    }

    public AccountPage logIn(String email, String password) {
        enterUsername(email);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(driver);
    }
}
