package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

public class TC05 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage  registerPage = new RegisterPage();

    @Test(dataProvider = "getData",description = "System shows message when user enters wrong password several times")
    public void TC05(Object[] data) {
        Log.startTestCase("TC05");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();
        String wrongPassword = data[4].toString();
        Integer times = Integer.parseInt(data[5].toString());
        String expectedErrorSystemMessage = data[6].toString();

        Log.info("Register new account");
        homePage.navigateToRegisterPage();
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Navigate from Home page to Login page");
        homePage.navigateToLoginPage();

        Log.info("Repeat Login 3 times with valid email and wrong password");
        loginPage.repeatLoginWithTimes(times, email, wrongPassword);

        Log.info("Check error system message");
        loginPage.checkErrorSystemMessage(expectedErrorSystemMessage);
        Log.endTestCase();
    }
}
