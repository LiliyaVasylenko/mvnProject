package lesson_6;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.containsString;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass extends Base {
    LoginPage loginPage  = new LoginPage(driver);;
    AccountPage accountPage;


    @Ignore
    @Test
    public void test001_LoginThroughtLogIn() throws Exception {
        accountPage = loginPage.logIn(email, password);
    }



    @Test
    public void test002_LoginWithAllMethods() throws Exception {
        accountPage = loginPage.enterUsername(email).enterPassword(password).clickSignInBtn();
        Assert.assertThat("You aren't on the AccountPage", accountPage.logOutField.getText(), containsString("Sign out"));
    }


    @Test
    public void test003_LogOut() throws Exception {
        accountPage = new AccountPage(driver);
        accountPage.signOut();
        Assert.assertThat("You aren't on the LoginPage", loginPage.signInBtn.getText(), containsString("Sign in"));
    }
}

