package lesson_9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;



public class CustomConditions {
    public static ExpectedCondition<Boolean> outOfFrame(WebElement frame) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                if(!frame.getTagName().contains("document"));
                return true;
            }
        };
    }
}
