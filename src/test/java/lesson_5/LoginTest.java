package lesson_5;

import lesson_5.AdditionalClass;
import lesson_5.BaseClass;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseClass {
    static AdditionalClass adiitional;


    @Test
    public void test001_Login() throws Exception {
        WebElement signInOption = driver.findElement(By.className("login"));
        signInOption.click();
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys(password);
        WebElement signInField = driver.findElement(By.name("SubmitLogin"));
        signInField.click();
        Assert.assertTrue(driver.findElement(By.xpath(".//span[contains(text(), 'FirstName LastName')]")).isDisplayed());
        Thread.sleep(1000);
    }

    @Test
    public void test002_OpenOrderHistoryAndDetails() throws Exception {
        adiitional.selectSomePage("Order");
        Assert.assertEquals("ORDER HISTORY", driver.findElement(By.xpath("//*[@id='center_column']/h1")).getText());
        adiitional.switchToMyAccount();
    }

    @Test
    public void test003_OpenMyCreditSlips() throws Exception {
        adiitional.selectSomePage("slips");
        Assert.assertEquals("CREDIT SLIPS", driver.findElement(By.xpath("//*[@id='center_column']/h1")).getText());
        adiitional.switchToMyAccount();
    }

    @Test
    public void test004_OpenAddresses() throws Exception {
        adiitional.selectSomePage("addresses");
        Assert.assertEquals("MY ADDRESSES", driver.findElement(By.xpath("//*[@id='center_column']/h1")).getText());
        adiitional.switchToMyAccount();
    }

    @Test
    public void test005_OpenMyPersonalInfo() throws Exception {
        adiitional.selectSomePage("personal");
        Assert.assertEquals("YOUR PERSONAL INFORMATION", driver.findElement(By.xpath("//*[@id='center_column']//h1")).getText());
        adiitional.switchToMyAccount();
    }

    @Test
    public void test006_OpenMyWishLists() throws Exception {
        adiitional.selectSomePage("wishlists");
        Assert.assertEquals("MY WISHLISTS", driver.findElement(By.xpath("//*[@id='mywishlist']/h1")).getText());
        adiitional.switchToMyAccount();
    }
}

