package lesson_7;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import static lesson_7.CustomConditions.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass extends BaseForTests {
    LoginPage loginPage  = new LoginPage(driver);
    public By listDresses = By.xpath("//*[@id='center_column']/ul//div[2]/h5/a");


    @Test
    public void test001_UseCustomConditionForPageIsLoaded () throws Exception {
        assertThat(pageIsLoaded(BASE_URL, "My Store"));
    }


    @Test
    public void test002_UseCustomConditionForListNthElementHasText() throws Exception {
        loginPage.woman.click();
        assertThat(listNthElementHasText(listDresses, 2, "Dress"));
    }

    @Test
    public void test003_UseCustomConditionForStalenessOfElement () throws Exception {
       loginPage.cartButton.click();
       assertThat(stalenessOfElement(loginPage.image));



    }
}

