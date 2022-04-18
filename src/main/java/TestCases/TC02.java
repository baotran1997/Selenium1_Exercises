package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.annotations.Test;

public class TC02 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getData", description = "User can't login with blank \"Username\" text box")
    public void TC02(Object[] data) {
        Log.startTestCase("TC02");
        String blankUsername = data[0].toString();
        String validPassword = data[1].toString();
        String expectedErrorMessageOfLoginForm = data[2].toString();
        String expectedErrorMessageOfEmailField = data[3].toString();

        Log.info("Navigate from Home page to Login page");
        homePage.navigateToLoginPage();

        Log.info("Login with blank Email and valid Password");
        loginPage.login(blankUsername, validPassword);

        Log.info("Check error message of login form");
        loginPage.checkErrorMessageOfLoginForm(expectedErrorMessageOfLoginForm);

        Log.info("Check error message of  email field");
        loginPage.checkErrorMessageOfEmailField(expectedErrorMessageOfEmailField);
        Log.endTestCase();
    }
}
