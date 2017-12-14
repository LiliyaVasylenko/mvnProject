package lesson_9;

import org.junit.Assert;
import org.junit.Test;

import static lesson_7.CustomConditions.stalenessOfElement;
import static lesson_9.CustomConditions.outOfFrame;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;


public class TestClass extends Base {
    MainPage mainPage = new MainPage(driver, wait);


    @Test
    public void test001_FrameAndJavaScript () throws Exception {
        mainPage.scrollToFrame();
        mainPage.openFrame();
        Assert.assertThat("Check link in frame", mainPage.linkInIframe.getText(), containsString("PrestaShop"));
        mainPage.closeFrame();
        assertThat(outOfFrame(mainPage.iframe));
    }
}



