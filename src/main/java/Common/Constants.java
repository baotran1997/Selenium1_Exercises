package Common;

import org.openqa.selenium.WebDriver;

import java.lang.*;

public class Constants {
    public static WebDriver DRIVER;
    public static String BROWSER = "";

    public static String HOME_PAGE_URL = "http://www.raillog.somee.com/Page/HomePage.cshtml";
    public static String BOOK_TICKET_PAGE_URL = "http://www.raillog.somee.com/Page/BookTicketPage.cshtml";
    public static String ERROR_MESSAGE_FOR_NO_TICKET = "Sorry, can't find any results that match your filters.\n" + "Please change the filters and try again.";

}
