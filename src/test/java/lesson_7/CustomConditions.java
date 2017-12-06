package lesson_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;
import javax.xml.bind.Element;
import java.util.List;

public class CustomConditions {

    public  static  ExpectedCondition<List<WebElement>> listNthElementHasText(List<WebElement> list, int nthElement, String hasText){
        return new ExpectedCondition<List<WebElement>>() {
            @Nullable
            @Override
            public List<WebElement> apply(@Nullable WebDriver driver) {
               // List<WebElement> list = driver.findElements(locator);
                if (list.get(nthElement).getText().contains(hasText)){
                    return list;
                }
                else {
                    return null;
                }
            }
        };
    }
}