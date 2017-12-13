package lesson_8;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseForPages {
    public  String productName = "Blouse";
    public void setProductName(String productName) {
        this.productName = productName;
    }


    public MainPage(WebDriver driver) {
        super(driver);
    }
     Actions builder = new Actions (driver);

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


    public void searchProduct(String productName) throws Exception {
        LOG.info("Search necessary product in search field");
        searchfield.sendKeys(productName, Keys.ENTER);
    }


    public void addProductToCart() throws Exception {
        LOG.info("Add necessary product to cart");
        builder.moveToElement(searchedProduct).click(addToCardBtn).perform();
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
    }


    public SummaryPage switchToCart () throws Exception {
        LOG.info("Switch to the 1-step (Summary) of order");
        wait.until(ExpectedConditions.visibilityOf(proccedToCheckOutForPopUpBtn));
        proccedToCheckOutForPopUpBtn.click();
        return new SummaryPage(driver);
    }

}
