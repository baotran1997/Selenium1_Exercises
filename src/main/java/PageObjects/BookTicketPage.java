package PageObjects;

import Common.Constants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage{
    /**
     * Locators
     */
    private By departDateSelectionXpath = By.xpath("//select[@name='Date']");
    private By departFromSelectionXpath = By.xpath("//select[@name='DepartStation']");
    private By arriveAtSelectionXpath = By.xpath("//select[@name='ArriveStation']");
    private By seatTypeSelectionXpath = By.xpath("//select[@name='SeatType']");
    private By ticketAmountSelectionXpath = By.xpath("//select[@name='TicketAmount']");
    private By bookTicketButtonXpath = By.xpath("//input[@value='Book ticket']");
    private By bookTicketSuccessfullyMessageXpath = By.xpath("//h1[normalize-space()='Ticket Booked Successfully!']");
    private By departStationResultXpath = By.xpath("//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private By arriveStationResultXpath = By.xpath("//td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private By seatTypeResultXpath = By.xpath("//td[count(//th[text()='Seat Type']/preceding-sibling::th)+1]");
    private By departDateResultXpath = By.xpath("//td[count(//th[text()='Depart Date']/preceding-sibling::th)+1]");
    private By ticketAmountResultXpath = By.xpath("//td[count(//th[text()='Amount']/preceding-sibling::th)+1]");

    /**
     * Elements
     */
    public WebElement getDepartDateSelectionXpath() {
        return Constants.DRIVER.findElement(departDateSelectionXpath);
    }
    public WebElement getDepartFromSelectionXpath() {
        return Constants.DRIVER.findElement(departFromSelectionXpath);
    }
    public WebElement getArriveAtSelectionXpath() {
        return Constants.DRIVER.findElement(arriveAtSelectionXpath);
    }
    public WebElement getSeatTypeSelectionXpath() {
        return Constants.DRIVER.findElement(seatTypeSelectionXpath);
    }
    public WebElement getTicketAmountSelectionXpath() {
        return Constants.DRIVER.findElement(ticketAmountSelectionXpath);
    }
    public WebElement getBookTicketButtonXpath() {
        return Constants.DRIVER.findElement(bookTicketButtonXpath);
    }
    public WebElement getBookTicketSuccessfullyMessageXpath() {
        return Constants.DRIVER.findElement(bookTicketSuccessfullyMessageXpath);
    }
    public WebElement getDepartStationResultXpath() {
        return Constants.DRIVER.findElement(departStationResultXpath);
    }
    public WebElement getArriveStationResultXpath() {
        return Constants.DRIVER.findElement(arriveStationResultXpath);
    }
    public WebElement getSeatTypeResultXpath() {
        return Constants.DRIVER.findElement(seatTypeResultXpath);
    }
    public WebElement getDepartDateResultXpath() {
        return Constants.DRIVER.findElement(departDateResultXpath);
    }
    public WebElement getTicketAmountResultXpath() {
        return Constants.DRIVER.findElement(ticketAmountResultXpath);
    }

    /**
     * Methods
     */
    public void checkRedirectedLoginUrl () {
        String actualLoginUrl = Constants.DRIVER.getCurrentUrl();
        String expectedLoginUrl= "http://www.raillog.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";
        Assertions.assertEquals(expectedLoginUrl,actualLoginUrl);
    }

    public void checkBookTicketURL() {
        String actualBookTicketURL = Constants.DRIVER.getCurrentUrl();
        String expectedBookTicketURL = Constants.BOOK_TICKET_PAGE_URL;

        Assertions.assertEquals(expectedBookTicketURL, actualBookTicketURL);
    }

    public void selectDepartDate(String departDate) {
        Select departDateSelection = new Select(getDepartDateSelectionXpath());
        departDateSelection.selectByVisibleText(departDate);
    }
    public void selectDepartFrom(String departFrom) {
        Select departFromSelection = new Select(getDepartFromSelectionXpath());
        departFromSelection.selectByVisibleText(departFrom);
    }
    public void selectArriveAt(String arriveAt) {
        getArriveAtSelectionXpath().click();
        Select arriveAtSelection = new Select(getArriveAtSelectionXpath());
        arriveAtSelection.selectByVisibleText(arriveAt);
    }
    public void selectSeatType(String seatType) {
        Select seatTypeSelection = new Select(getSeatTypeSelectionXpath());
        seatTypeSelection.selectByVisibleText(seatType);
    }
    public void selectTicketAmount(String ticketAmount) {
        Select ticketAmountSelection = new Select(getTicketAmountSelectionXpath());
        ticketAmountSelection.selectByVisibleText(ticketAmount);
    }

    public void selectBookTicketInformation(String departDate,String departFrom,String arriveAt,String seatType,String ticketAmount) throws InterruptedException {
        selectDepartDate(departDate);
        selectDepartFrom(departFrom);
        Thread.sleep(3000);
        selectArriveAt(arriveAt);
        selectSeatType(seatType);
        selectTicketAmount(ticketAmount);
    }

    public void clickBookTicketButton() {
        getBookTicketButtonXpath().click();
    }

    public void bookTicket(String departDate,String departFrom,String arriveAt,String seatType,String ticketAmount) throws InterruptedException {
        selectBookTicketInformation(departDate,departFrom,arriveAt,seatType,ticketAmount);
        BasePage.scrollDown();
        clickBookTicketButton();
    }

    public String getBookTicketSuccessfullyMessage() {
        return getBookTicketSuccessfullyMessageXpath().getText();
    }

    public void checkBookTicketSuccessfullyMessage(String bookTicketSuccessfullyMessage) {
        String actualBookTicketSuccessfullyMessage = getBookTicketSuccessfullyMessage();
        String expectedBookTicketSuccessfullyMessage = bookTicketSuccessfullyMessage;

        Assertions.assertEquals(expectedBookTicketSuccessfullyMessage,actualBookTicketSuccessfullyMessage);
    }

    public String departStationResult() {
        return getDepartStationResultXpath().getText();
    }
    public String arriveStationResult() {
        return getArriveStationResultXpath().getText();
    }
    public String seatTypeResult() {
        return getSeatTypeResultXpath().getText();
    }
    public String departDateResult() {
        return getDepartDateResultXpath().getText();
    }
    public String ticketAmountResult() {
        return getTicketAmountResultXpath().getText();
    }

    public void checkAllTicketInformation(String expectedDepartStationResult,
                                          String expectedArriveStationResult,
                                          String expectedSeatTypeResult,
                                          String expectedDepartDateResult,
                                          String expectedTicketAmountResult)
    {

        String actualDepartStationResult = departStationResult();
        String actualArriveStationResult = arriveStationResult();
        String actualSeatTypeResult = seatTypeResult();
        String actualDepartDateResult = departDateResult();
        String actualTicketAmountResult = ticketAmountResult();

        Assertions.assertEquals(expectedDepartStationResult, actualDepartStationResult);
        Assertions.assertEquals(expectedArriveStationResult, actualArriveStationResult);
        Assertions.assertEquals(expectedSeatTypeResult, actualSeatTypeResult);
        Assertions.assertEquals(expectedDepartDateResult, actualDepartDateResult);
        Assertions.assertEquals(expectedTicketAmountResult, actualTicketAmountResult);
    }
}
