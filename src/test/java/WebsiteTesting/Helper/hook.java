package WebsiteTesting.Helper;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hook {
    public static WebDriver driver;
    public static Wait<WebDriver> wait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        // ========== HEADLESS MODE ==========
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Jalankan tanpa tampilan browser
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options); // Headless driver
        // ===================================

        // ======= MODE BIASA (GUI) =======
        // driver = new ChromeDriver(); // <-- Uncomment jika ingin pakai browser GUI
        // ================================

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver has not been initialized.");
        }
        return driver;
    }
    
}
