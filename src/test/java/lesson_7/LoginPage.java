package lesson_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class LoginPage extends BaseForObjects{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "SubmitLogin")
    WebElement signInBtn;

    @FindBy (xpath = "//*[@id=\"center_column\"]/ul//div[2]/h5/a")
    List<WebElement> listDresses;

    @FindBy (xpath = "//*[@id='center_column']/div[1]/div")
    WebElement image;

    @FindBy (xpath = "//*[@id='header']//div[3]/div/a")
    WebElement cartButton;

    @FindBy (xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
     WebElement woman;


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
