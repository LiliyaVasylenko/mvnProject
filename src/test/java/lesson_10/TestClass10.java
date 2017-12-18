package lesson_10;

import lesson_10.MainPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.containsString;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass10 extends Base {
    MainPage mainPage = new MainPage(driver, wait);
    LoginPage loginPage = new LoginPage(driver, wait);
    String necessaryProduct = "Blouse";
    String email = "777@gmail.com";
    String password = "7777777";

    @Test
    public void test001_Login () throws Exception {
       loginPage.enterUsername(email).enterPassword(password).clickSignInBtn();
       Assert.assertTrue(mainPage.logoutBtn.isEnabled());

    }

    @Test
    public void test002_SearchProduct () throws Exception {
        mainPage.searchProduct(necessaryProduct);
        Assert.assertTrue(mainPage.messageSearschResult.getText().contains("been found"));
        Assert.assertTrue(mainPage.searchedProduct.isEnabled());
    }

    @Test
    public void test003_AddProductToCart () throws Exception {
        mainPage.addProductToCart();
        Assert.assertThat("Cart must have selected product", mainPage.cartTitle.getText(), containsString("1111"));
    }

    @Test
    public void test004_Logout () throws Exception {
        mainPage.logout();
        Assert.assertTrue(loginPage.signInOption.isEnabled());

    }
}



