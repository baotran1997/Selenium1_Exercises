package PageObjects;

import Common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends BasePage{
    /**
     * Locators
     */
    private By daNangToSaiGonCheckPriceButtonXpath = By.xpath("//td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/..//a[contains(@href,'Price')]");

    /**
     * Elements
     */
    public WebElement getDaNangToSaiGonCheckPriceButtonXpath() {
        return Constants.DRIVER.findElement(daNangToSaiGonCheckPriceButtonXpath);
    }

    /**
     * Methods
     */
    public void clickCheckPriceButtonDaNangToSaiGon() {
        getDaNangToSaiGonCheckPriceButtonXpath().click();
    }
}
