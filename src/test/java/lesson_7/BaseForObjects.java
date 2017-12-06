package lesson_7;

import com.sun.xml.internal.ws.wsdl.writer.W3CAddressingWSDLGeneratorExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BaseForObjects extends BaseGeneral{
    WebDriver driver;

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    public BaseForObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
