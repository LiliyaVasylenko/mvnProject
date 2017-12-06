package lesson_7;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.List;


public abstract class BaseGeneral {
    public abstract WebDriver getDriver();


    public WebElement $(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public List<WebElement> $$(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    public List<WebElement> $$(By locator) {
        return getDriver().findElements(locator);
    }

    protected void assertThat(ExpectedCondition<List<WebElement>> condition) {
        try {
            new WebDriverWait(getDriver(),5).until(condition);
        }
        catch ( Exception e)
        {
            System.out.println(e.toString());
        }

    }
}














