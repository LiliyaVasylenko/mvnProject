package lesson_8;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseObjects{

    public MainPage(WebDriver driver) {
        super(driver);
    }
     Actions builder = new Actions (driver);

    @FindBy (xpath = "//*[@id='search_query_top']")
    WebElement searchfield;

    @FindBy (xpath = "//*[@id='center_column']/h1/span[2]")
    WebElement messageSearschResult;

    @FindBy (xpath = "//*[@id='center_column']/ul/li")
    WebElement product;

    @FindBy (xpath = "//*[@id='center_column']//div[2]/a[1]/span")
    WebElement addToCardBtn;

    @FindBy (xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
    WebElement checkOutBtn;


    public void searchSomeProduct(String product) throws Exception {
        searchfield.sendKeys(product, Keys.ENTER);
    }


    public void selectSomeProduct() throws Exception {
        builder.moveToElement(product).click(addToCardBtn).perform();
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
    }



    public SummaryPage navigateToCart () throws Exception {
        wait.until(ExpectedConditions.visibilityOf(checkOutBtn));
        checkOutBtn.click();
         return new SummaryPage(driver);
    }


}
