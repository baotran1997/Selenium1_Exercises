package Common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtilities {

    public static void initDriver() {
        switch (Constants.BROWSER.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "Executables/Drivers/chromedriver");
                Constants.DRIVER = new ChromeDriver();
                Constants.DRIVER.manage().window().maximize();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "Executables/Drivers/geckodriver");
                Constants.DRIVER = new FirefoxDriver();
                Constants.DRIVER.manage().window().maximize();
                break;
        }
    }

    public static void navigateTo(String URL) {
        Constants.DRIVER.get(URL);
    }

    public static void quitDriver() {
        Constants.DRIVER.quit();
    }
}
