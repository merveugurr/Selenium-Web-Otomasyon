import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.Logs;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(logs.class)
public class BaseTest {

    WebDriver driver;
    String Url = "https://www.lcwaikiki.com/tr-TR/TR";

    @BeforeAll
    public void initializeDriver(){
        System.setProperty("webdriver.chromeDriver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().window().fullscreen();
    }

    @AfterAll
    public void closeDriver(){
        driver.quit();
    }


}
