package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.*;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TC15 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimeTablePage timeTablePage = new TimeTablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "\"Ticket price\" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page")
    public void TC15(Object[] data) throws MalformedURLException {
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();
        String hsPrice = data[4].toString();
        String ssPrice = data[5].toString();
        String sscPrice = data[6].toString();
        String hbPrice = data[7].toString();
        String sbPrice = data[8].toString();
        String sbcPrice = data[9].toString();

        Log.info("Register a new account");
        homePage.navigateToRegisterPage();
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Login with valid Email and Password");
        homePage.navigateToLoginPage();
        loginPage.login(email,password);

        Log.info("Navigate from Home page to Time Table page");
        homePage.navigateToTimetablePage();

        Log.info("Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
        timeTablePage.clickCheckPriceButtonDaNangToSaiGon();

        Log.info("Check \"Ticket Price\" page is loaded");
        ticketPricePage.checkTicketPricePagePath();

        Log.info("Check Price for each seat displays correctly");
        ticketPricePage.checkPriceForAllSeats(hsPrice, ssPrice, sscPrice, hbPrice, sbPrice, sbcPrice);
    }
}
