package lesson_7;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static lesson_7.CustomConditions.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass extends BaseForTests {
    LoginPage loginPage  = new LoginPage(driver);;
    AccountPage accountPage;

    @Test
    public void test001_UseCustomConditionForPageIsLoaded () throws Exception {
        assertThat(pageIsLoaded(BASE_URL, "My Store"));
    }

    @Test
    public void test002_UseCustomConditionForListNthElementHasText() throws Exception {
        $("//*[@id='block_top_menu']/ul/li[1]/a").click();
        assertThat(listNthElementHasText(loginPage.listDresses, 2, "Dress"));
    }

    @Test
    public void test003_UseCustomConditionForStalenessOfElement () throws Exception {
        By image= By.xpath("//*[@id='center_column']/div[1]/div");
        WebElement cartButton = $("//*[@id='header']//div[3]/div/a");
        cartButton.click();

        assertThat(stalenessOfElement(image));



    }


}

