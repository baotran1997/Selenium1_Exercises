package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.*;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

public class TC16 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User can cancel a ticket")
    public void TC16(Object @NotNull [] data) throws InterruptedException {
        Log.startTestCase("TC16");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();
        String departDate = data[4].toString();
        String departFrom = data[5].toString();
        String arriveAt = data[6].toString();
        String seatType = data[7].toString();
        String ticketAmount = data[8].toString();

        Log.info("Pre-condition: Create and activate a new account");
        homePage.navigateToRegisterPage();
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Step 1: Navigate to Login page");
        homePage.navigateToLoginPage();

        Log.info("Step 2: Login with valid Email and Password");
        loginPage.login(email,password);

        Log.info("Step 3: Book a ticket");
        homePage.navigateToBookTicketPage();
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType,ticketAmount);

        Log.info("Step 4: Navigate to 'My Ticket' page");
        bookTicketPage.navigateToMyTicketPage();

        Log.info("Step 5: Click on 'Cancel' Button on My Ticket page");
        myTicketPage.clickCancelButton();

        Log.info("Step 6: Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.clickAcceptButton();

        Log.info("Expected Behavior: Check No Ticket message in My Ticket page");
        myTicketPage.checkNoTicketInMyTicketPage();
        Log.endTestCase();
    }
}
