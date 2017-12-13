package lesson_5;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AdditionalClass {
    WebDriver driver ;

    public AdditionalClass(WebDriver driver) {
        this.driver = driver;
    }

       public void selectSomePage (String locator1) {
            WebElement page = driver.findElement(By.xpath(".//span[contains(text(), '" + locator1 + "')]"));
            page.click();
        }


        public void switchToMyAccount () {
          WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a[2]"));
          myAccount.click();
}
}