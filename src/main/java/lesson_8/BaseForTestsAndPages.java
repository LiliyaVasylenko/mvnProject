package lesson_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract  class BaseForTestsAndPages {
    public abstract WebDriver getDriver ();

    public WebElement $(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public WebElement $(By locator) {
        return getDriver().findElement(locator);
    }

    public List<WebElement> $$(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    public List<WebElement> $$(By locator) {
        return getDriver().findElements(locator);
    }


}
