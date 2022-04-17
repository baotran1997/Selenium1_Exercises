package TestCases;

import Common.BaseTest;
import Common.DataFaker;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class TC01 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData",description = "User can log into Railway with valid username and password")
    public void TC01(Object[] data) throws InterruptedException {
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();

        Log.info("Register a new account");
        homePage.navigateToRegisterPage();
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Navigate from Home page to Login page");
        homePage.navigateToLoginPage();

        Log.info("Login with valid username and password");
        loginPage.login(email,password);

        Log.info("Check Home page URL after logging in successfully");
        homePage.checkHomePageURL();
        loginPage.zoomInScreen();

        Log.info("Check Welcome user message on banner after logging in successfully");
        homePage.checkWelcomeUserMessage(email);
    }
}
