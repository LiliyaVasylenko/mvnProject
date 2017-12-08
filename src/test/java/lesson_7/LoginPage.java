package lesson_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.bind.Element;
import java.util.List;


public class LoginPage extends BaseForObjects{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id='center_column']/div[1]")
    List<WebElement> image;

    @FindBy (xpath = "//*[@id='header']//div[3]/div/a")
    WebElement cartButton;

    @FindBy (xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
     WebElement woman;

}
