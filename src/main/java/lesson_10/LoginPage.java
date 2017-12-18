package lesson_10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected   final Logger LOG = LogManager.getLogger(this);

    @FindBy (id = "email")
    WebElement usernameField;

    @FindBy (className = "login")
    WebElement signInOption;

    @FindBy (id = "passwd")
    WebElement passwordField;

    @FindBy(name = "SubmitLogin")
    WebElement signInBtn;


    public LoginPage enterUsername(String email) {
        LOG.info("Enter Email address");
        wait.until(ExpectedConditions.visibilityOf(signInOption));
        signInOption.click();
        usernameField.sendKeys(email);
        return new LoginPage(driver, wait);
    }

    public LoginPage  enterPassword(String password) {
        LOG.info("Enter Password");
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        return new LoginPage(driver, wait);
    }

    public MainPage  clickSignInBtn() {
        LOG.info("Click Sign in");
        wait.until(ExpectedConditions.visibilityOf(signInBtn));
        signInBtn.click();
       return new MainPage(driver, wait);
    }
}
