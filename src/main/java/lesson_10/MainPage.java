package lesson_10;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions builder;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected   final Logger LOG = LogManager.getLogger(this);



    @FindBy (xpath = "//*[@id='search_query_top']")
    WebElement searchfield;

    @FindBy (className = "heading-counter")
    WebElement messageSearschResult;

    @FindBy (xpath = "//*[@id='center_column']/descendant::li[4]")
    WebElement searchedProduct;

    @FindBy (xpath = "//*[@id='center_column']//span[contains(text(), 'Add to cart')]")
    WebElement addToCardBtn;

    @FindBy (xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement proccedToCheckOutForPopUpBtn;

    @FindBy (xpath = "(//descendant::a/descendant::span)[position()=2]")
    WebElement cartTitle;

    @FindBy (className = "logout")
    WebElement logoutBtn;


    public void searchProduct(String productName) throws Exception {
        LOG.info("Search necessary product in search field");
        wait.until(ExpectedConditions.visibilityOf(searchfield));
        searchfield.sendKeys(productName, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(searchedProduct));
    }


    public void addProductToCart() throws Exception {
        LOG.info("Add necessary product to cart");
        builder =  new Actions (driver);
        builder.moveToElement(searchedProduct).click(addToCardBtn).perform();
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        wait.until(ExpectedConditions.visibilityOf(proccedToCheckOutForPopUpBtn));
        proccedToCheckOutForPopUpBtn.click();
    }

    public LoginPage logout() throws Exception {
        LOG.info("Logout");
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();
        return new LoginPage(driver, wait);
   }
}
