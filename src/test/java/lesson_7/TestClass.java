package lesson_7;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static lesson_7.CustomConditions.*;
import static org.hamcrest.CoreMatchers.containsString;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass extends BaseForTests {
    LoginPage loginPage  = new LoginPage(driver);;
    AccountPage accountPage;


    @Ignore
    @Test
    public void test001_LoginThroughtLogIn() throws Exception {
        accountPage = loginPage.logIn(email, password);
    }


    @Ignore
    @Test
    // Login to application
    public void test002_LoginWithAllMethods() throws Exception {
        accountPage = loginPage.enterUsername(email).enterPassword(password).clickSignInBtn();
        Assert.assertThat("You aren't on the AccountPage", accountPage.logOutField.getText(), containsString("Sign out"));
    }

    @Test
    public void test003_UseCostimCinditionListNthElementHasText() throws Exception {
        accountPage = new AccountPage(driver);
        $("//*[@id=\"block_top_menu\"]/ul/li[1]/a").click();
        assertThat(CustomConditions.listNthElementHasText(accountPage.listDresses, 2, "Dress"));
    }


    

    @Ignore
    @Test
    // Logout from application
    public void test004_LogOut() throws Exception {
        accountPage = new AccountPage(driver);
        accountPage.signOut();

        Assert.assertThat("You aren't on the LoginPage", loginPage.signInBtn.getText(), containsString("Sign in"));
    }
}

