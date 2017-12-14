package lesson_8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;


public class TestClass extends BaseForTests {
    MainPage mainPage = new MainPage(driver);
    SummaryPage summaryPage;
    SignInPage signInPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderHistoryPage orderHistoryObject;

    @Test
    public void shopping () throws Exception {
        String necessaryProduct = "Blouse";
        String email = "777@gmail.com";
        String password = "7777777";

        // поиск товара
        mainPage.searchProduct(necessaryProduct);
        Assert.assertTrue(mainPage.messageSearschResult.getText().contains("been found"));
        Assert.assertTrue(mainPage.searchedProduct.isEnabled());

        // добавление его в корзину
        mainPage.addProductToCart();
        summaryPage = mainPage.switchToCart();
        Assert.assertTrue(mainPage.title.getText().contains("SHOPPING-CART SUMMARY"));

        // оформление заказа
         signInPage = summaryPage.switchToSignIn();
        Assert.assertTrue(signInPage.title.getText().contains("AUTHENTICATION"));

        signInPage.login(email, password);
        addressPage = signInPage.switchToAddress();
        Assert.assertTrue(signInPage.title.getText().contains("ADDRESSES"));

        shippingPage = addressPage.switchToShipping();
        Assert.assertTrue(signInPage.title.getText().contains("SHIPPING"));

        //покупка
        paymentPage = shippingPage.switchToPayment();
        Assert.assertTrue(signInPage.title.getText().contains("PLEASE CHOOSE YOUR PAYMENT METHOD"));
        paymentPage.payForProduct();

        String  orderReference = $(By.cssSelector("div.box")).getText().substring(216, 225);

       // проверка, что в истории заказов появился ИМЕННО ваш заказ
        orderHistoryObject = paymentPage.switchToOrderHistory();
        orderHistoryObject.selectLastOrder();

       Assert.assertTrue(orderHistoryObject.nameColorSize.getText().contains(necessaryProduct));
       Assert.assertTrue(orderHistoryObject.lastOrderfromHistory.getText().contains(orderReference));
       Assert.assertThat("Check order reference", orderHistoryObject.lastOrderfromHistory.getText(), containsString(orderReference));



    }

}
