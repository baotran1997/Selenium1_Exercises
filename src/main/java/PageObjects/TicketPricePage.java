package PageObjects;

import Common.Constants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class TicketPricePage {
    /**
     * Locators
     */
    private By xpathTicketPriceForHS = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='HS']/preceding-sibling::td) + 1][text()='90000']");
    private By xpathTicketPriceForSS = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='SS']/preceding-sibling::td) + 1][text()='115000']");
    private By xpathTicketPriceForSSC = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='SSC']/preceding-sibling::td) + 1][text()='140000']");
    private By xpathTicketPriceForHB = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='HB']/preceding-sibling::td) + 1][text()='190000']");
    private By xpathTicketPriceForSB = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='SB']/preceding-sibling::td) + 1][text()='240000']");
    private By xpathTicketPriceForSBC = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='SBC']/preceding-sibling::td) + 1][text()='290000']");

    /**
     * Elements
     */
    public WebElement getXpathTicketPriceForHS() {
        return Constants.DRIVER.findElement(xpathTicketPriceForHS);
    }
    public WebElement getXpathTicketPriceForSS() {
        return Constants.DRIVER.findElement(xpathTicketPriceForSS);
    }
    public WebElement getXpathTicketPriceForSSC() {
        return Constants.DRIVER.findElement(xpathTicketPriceForSSC);
    }
    public WebElement getXpathTicketPriceForHB() {
        return Constants.DRIVER.findElement(xpathTicketPriceForHB);
    }
    public WebElement getXpathTicketPriceForSB() {
        return Constants.DRIVER.findElement(xpathTicketPriceForSB);
    }
    public WebElement getXpathTicketPriceForSBC() {
        return Constants.DRIVER.findElement(xpathTicketPriceForSBC);
    }

    /**
     * Methods
     */
    public String getTicketPricePagePath() throws MalformedURLException {
        String currentURL = Constants.DRIVER.getCurrentUrl();
        URL currentURLDetail = new URL(currentURL);
        return currentURLDetail.getPath();
    }

    public void checkTicketPricePagePath() throws MalformedURLException {
        String actualTicketPricePagePath = getTicketPricePagePath();
        String expectedTicketPricePagePath = "/Page/TicketPricePage.cshtml";

        Assertions.assertEquals(expectedTicketPricePagePath,actualTicketPricePagePath);
    }

    public String ticketPriceForHS() {
        return getXpathTicketPriceForHS().getText();
    }
    public String ticketPriceForSS() {
        return getXpathTicketPriceForSS().getText();
    }
    public String ticketPriceForSSC() {
        return getXpathTicketPriceForSSC().getText();
    }
    public String ticketPriceForHB() {
        return getXpathTicketPriceForHB().getText();
    }
    public String ticketPriceForSB() {
        return getXpathTicketPriceForSB().getText();
    }
    public String ticketPriceForSBC() {
        return getXpathTicketPriceForSBC().getText();
    }

    public void checkPriceForAllSeats(String expectedTicketPriceForHS,
                                      String expectedTicketPriceForSS,
                                      String expectedTicketPriceForSSC,
                                      String expectedTicketPriceForHB,
                                      String expectedTicketPriceForSB,
                                      String expectedTicketPriceForSBC) {

        String actualTicketPriceForHS = ticketPriceForHS();
        String actualTicketPriceForSS = ticketPriceForSS();
        String actualTicketPriceForSSC = ticketPriceForSSC();
        String actualTicketPriceForHB = ticketPriceForHB();
        String actualTicketPriceForSB = ticketPriceForSB();
        String actualTicketPriceForSBC = ticketPriceForSBC();

        Assertions.assertEquals(expectedTicketPriceForHS,actualTicketPriceForHS);
        Assertions.assertEquals(expectedTicketPriceForSS,actualTicketPriceForSS);
        Assertions.assertEquals(expectedTicketPriceForSSC,actualTicketPriceForSSC);
        Assertions.assertEquals(expectedTicketPriceForHB,actualTicketPriceForHB);
        Assertions.assertEquals(expectedTicketPriceForSB,actualTicketPriceForSB);
        Assertions.assertEquals(expectedTicketPriceForSBC,actualTicketPriceForSBC);
    }

}
