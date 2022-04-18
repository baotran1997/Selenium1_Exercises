package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.ContactPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class TC06 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ContactPage contactPage = new ContactPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData",description = "User is redirected to Home page after logging out")
    public void TC06(Object[] data) {
        Log.startTestCase("TC06");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();

        Log.info("Register new account");
        homePage.navigateToRegisterPage();
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Login with valid Email and Password");
        homePage.navigateToLoginPage();
        loginPage.login(email, password);

        Log.info("Navigate from Home page to Contact page");
        homePage.navigateToContactPage();

        Log.info("Logout from Contact page");
        contactPage.navigateToLogoutTab();

        Log.info("Check user is redirect to Home page after logging out");
        homePage.checkHomePageURL();

        Log.info("Check 'Logout' tab is disappeared");
        homePage.isLogoutTabDisplayed();
        Log.endTestCase();
    }
}
