package lesson_7;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;
import javax.xml.bind.Element;
import java.util.List;

public class CustomConditions {

//    public static ExpectedCondition<List<WebElement>> listNthElementHasText(List<WebElement> list, int nthElement, String hasText) {
//        return new ExpectedCondition<List<WebElement>>() {
//            @Nullable
//            @Override
//            public List<WebElement> apply(@Nullable WebDriver driver) {
//                // List<WebElement> list = driver.findElements(locator);
//                if (list.get(nthElement).getText().contains(hasText)) {
//                    return list;
//                } else {
//                    return null;
//                }
//            }
//        };
//    }


    public static ExpectedCondition<List<WebElement>> listNthElementHasText(List<WebElement> list, int nthElement, String hasText) {
        return new ExpectedCondition<List<WebElement>>() {
            @Nullable
            @Override
            public List<WebElement> apply(@Nullable WebDriver driver) {
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


    public static ExpectedCondition<Boolean> stalenessOfElement(List<Element> someElement) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                if (someElement.isEmpty()) {
                        return true;
                }
                return null;
            }
        };
    }


}

