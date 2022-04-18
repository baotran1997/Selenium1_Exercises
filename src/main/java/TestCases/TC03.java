package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.annotations.Test;

public class TC03 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getData", description = "User cannot log into Railway with invalid password ")
    public void TC03(Object[] data) {
        Log.startTestCase("TC03");
        String validUsername = data[0].toString();
        String invalidPassword = data[1].toString();
        String expectedErrorMessageOfInvalidFields = data[2].toString();

        Log.info("Navigate from Home page to Login page");
        homePage.navigateToLoginPage();

        Log.info("Login with valid Email and invalid Password");
        loginPage.login(validUsername, invalidPassword);

        Log.info("Check error message of invalid fields");
        loginPage.checkErrorMessageOfInvalidFields(expectedErrorMessageOfInvalidFields);
        Log.endTestCase();
    }
}
