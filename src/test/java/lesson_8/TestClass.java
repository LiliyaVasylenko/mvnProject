package lesson_8;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;



public class TestClass extends BaseTests {
    MainPage mainPage = new MainPage(driver);
    SummaryPage summaryPage;
    SignInPage signInPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderHistoryObject orderHistoryObject;

    @Test
    public void shopping () throws Exception {
        String necessaryProduct = "Blouse";
        String email = "777@gmail.com";
        String password = "7777777";

        // поиск товара
        mainPage.searchSomeProduct(necessaryProduct);
        Assert.assertTrue(mainPage.messageSearschResult.getText().contains("been found"));
        Assert.assertTrue(mainPage.product.isEnabled());

        // добавление его в корзину
        mainPage.selectSomeProduct();
        summaryPage = mainPage.navigateToCart();
        Assert.assertTrue(summaryPage.cartTitle.getText().contains("Your shopping cart contains: 1 Product"));

        // оформление заказа
         signInPage = summaryPage.switchToLogin();
         addressPage = signInPage.login(email, password);
         shippingPage = addressPage.switchToShipping();

        //покупка
        paymentPage = shippingPage.switchToPayment();
        paymentPage.payForProduct();


        // проверка, что в истории заказов появился ИМЕННО ваш заказ
        orderHistoryObject = paymentPage.navigateToOrderHistory();
        orderHistoryObject.selectLastOrder();

       Assert.assertTrue(orderHistoryObject.nameColorSize.getText().contains(necessaryProduct));







    }





}
