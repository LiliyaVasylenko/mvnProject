package lesson_5;

import com.google.common.base.Verify;
import lesson_5.BaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Liliia.Vasylenko on 29.11.2017.
 */
public class SearchTest extends BaseClass {


    @Test
    public void test001_searchText(){
        String searchText = "Printed Summer Dress";
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
        searchField.sendKeys(searchText);
        searchField.submit();

        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li")).size()==3);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]")).getText().contains(searchText));


    }
}
