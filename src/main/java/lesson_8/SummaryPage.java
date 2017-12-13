package lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SummaryPage extends BaseForPages {

    public SummaryPage(WebDriver driver) {
        super(driver);
    }


    public SignInPage switchToSignIn () {
        LOG.info("Switch to the 2-step (Login) of order");
        wait.until(ExpectedConditions.visibilityOf(proccedToCheckOutBtn));
        proccedToCheckOutBtn.click();
        return  new SignInPage(driver);
    }
}


