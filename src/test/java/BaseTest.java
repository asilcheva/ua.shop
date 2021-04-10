import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class BaseTest {
    static {
        Configuration.remote = "http://localhost:4440/wd/hub";
        Configuration.baseUrl = "https://shop.lifecell.ua/en";
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 60000;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability("enableVNC", true);
        //desiredCapabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = desiredCapabilities;
    }
}
