package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TC14 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData",description = "User can book many tickets at a time")
    public void TC14(Object[] data) throws MalformedURLException, InterruptedException {
        Log.startTestCase("TC14");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();
        String departDate = data[4].toString();
        String departFrom = data[5].toString();
        String arriveAt = data[6].toString();
        String seatType = data[7].toString();
        String ticketAmount = data[8].toString();
        String bookTicketSuccessfullyMessage = data[9].toString();

        Log.info("Pre-condition: Create and activate a new account");
        homePage.navigateToRegisterPage();
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Step 1: Navigate to Login page");
        homePage.navigateToLoginPage();

        Log.info("Step 2: Login with valid Email and Password");
        loginPage.login(email,password);

        Log.info("Step 3: Navigate to Book ticket page");
        homePage.navigateToBookTicketPage();

        Log.info("Step 4: Book tickets");
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType,ticketAmount);

        Log.info("Expected Behavior: Check Book Ticket Successfully Message");
        bookTicketPage.checkBookTicketSuccessfullyMessage(bookTicketSuccessfullyMessage);

        Log.info("Expected Behavior: Check all book ticket information display correctly");
        bookTicketPage.checkAllTicketInformation(departFrom, arriveAt, seatType, departDate, ticketAmount);
        Log.endTestCase();
    }
}
