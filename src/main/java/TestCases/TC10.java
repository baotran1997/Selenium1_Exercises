package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class TC10 extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData",description = "User can't create account with an already in-use email")
    public void TC10(Object[] data) {
        Log.startTestCase("TC10");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();
        String errorMessageForExistingEmail = data[4].toString();

        Log.info("Navigate from Home page to Register page");
        homePage.navigateToRegisterPage();

        Log.info("Register a new account");
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Register again with an already in-use email above");
        homePage.navigateToRegisterPage();
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Check error message for registering with an already in-use email");
        registerPage.checkErrorMessageForExistingEmail(errorMessageForExistingEmail);

        Log.endTestCase();
    }
}
