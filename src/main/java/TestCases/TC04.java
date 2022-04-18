package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

public class TC04 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData", description = "User is redirected to Book ticket page after logging in")
    public void TC04(Object @NotNull [] data) {
        Log.startTestCase("TC04");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();

        Log.info("Register a new account");
        homePage.navigateToRegisterPage();
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Navigate from Home page to Book Ticket page");
        homePage.navigateToBookTicketPage();

        Log.info("Check user is redirected to Login page");
        bookTicketPage.checkRedirectedLoginUrl();

        Log.info("Login with valid Email and Password");
        loginPage.login(email, password);

        Log.info("Check user is redirected to Book Ticket page after logging in");
        bookTicketPage.checkBookTicketURL();
        Log.endTestCase();
    }
}
