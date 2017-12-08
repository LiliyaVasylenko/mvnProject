package lesson_7;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
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


    protected <V> V assertThat(Function<? super WebDriver, V> contition) {
            return new WebDriverWait(getDriver(), 5).until(contition);
    }
}















