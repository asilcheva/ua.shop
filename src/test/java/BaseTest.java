import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    static {
        Configuration.baseUrl = "https://shop.lifecell.ua/en";
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 60000;
    }
}
