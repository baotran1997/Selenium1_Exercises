package PageObjects;

import Common.Constants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    /**
     * Locators
     */
    private By welcomeUserMessageXpath = By.xpath("//div[@class='account']//descendant::strong");
    private By logoutTabXpath = By.xpath("//span[text()='Log out']");
    /**
     * Elements
     */
    public WebElement getWelcomeUserMessageXpath() {
        return Constants.DRIVER.findElement(welcomeUserMessageXpath);
    }
    public WebElement getLogoutTabXpath() {
        return Constants.DRIVER.findElement(logoutTabXpath);
    }

    /**
     * Methods
     */

    public void checkHomePageURL () {
        String actualHomePageUrl = Constants.DRIVER.getCurrentUrl();
        String expectedHomePageUrl= Constants.HOME_PAGE_URL;

        Assertions.assertEquals(expectedHomePageUrl,actualHomePageUrl);
    }

    public String getWelcomeUserMessage() {
        return getWelcomeUserMessageXpath().getText();
    }

    public void checkWelcomeUserMessage(String welcomeUsername) {
        String actualWelcomeUserMessage = getWelcomeUserMessage();
        String expectedWelcomeUserMessage = "Welcome " + welcomeUsername;

        Assertions.assertEquals(expectedWelcomeUserMessage,actualWelcomeUserMessage);
    }

    public void isLogoutTabDisplayed() {
        try {
            boolean logoutTabDisplays = getLogoutTabXpath().isDisplayed();
            if (logoutTabDisplays) {
                System.out.println("Logout Tab is displayed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Logout Tab is not displayed");
        }
    }
}
