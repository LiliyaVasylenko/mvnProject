package lesson_7;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import javax.annotation.Nullable;
import java.util.List;

public class CustomConditions {

    public static ExpectedCondition<List<WebElement>> listNthElementHasText(By locator , int nthElement, String hasText) {
        return new ExpectedCondition<List<WebElement>>() {
            @Nullable
            @Override
            public List<WebElement> apply(@Nullable WebDriver driver) {
                List<WebElement> list = driver.findElements(locator);
                try {
                    if (list.get(nthElement).getText().contains(hasText)) {
                        return list;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.toString());
                }
                return null;
            }
        };
    }


    public static ExpectedCondition<Boolean> pageIsLoaded(String url, String title) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                return driver.getCurrentUrl().contains(url) & driver.getTitle().contains(title);
            }
        };
    }


    public static ExpectedCondition<Boolean> stalenessOfElement(List<WebElement> someElement) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                try {someElement.isEmpty();
                        return true;
                }
                catch (StaleElementReferenceException var3) {
                    return null;
                }

            }
        };
    }
}

