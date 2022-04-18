package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class TC11 extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData",description = "User can't create account while password and PID fields are empty")
    public void TC11(Object[] data) {
        Log.startTestCase("TC11");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String blankPassword = data[1].toString();
        String blankConfirmPassword = data[2].toString();
        String blankPassportNumber = data[3].toString();
        String errorMessageOfRegisterForm = data[4].toString();
        String invalidPasswordLengthMessage = data[5].toString();
        String invalidPIDLengthMessage = data[6].toString();

        Log.info("Navigate from Home page to Register page");
        homePage.navigateToRegisterPage();

        Log.info("Register account with valid email address and leave other fields empty");
        registerPage.registerAccount(email,blankPassword,blankConfirmPassword,blankPassportNumber);

        Log.info("Check Error Message Of Register Form");
        registerPage.checkErrorMessageOfRegisterForm(errorMessageOfRegisterForm);

        Log.info("Check error message invalid Password Length");
        registerPage.checkInvalidPasswordLengthMessage(invalidPasswordLengthMessage);

        Log.info("Check error message invalid Password Length");
        registerPage.checkInvalidPIDLengthMessage(invalidPIDLengthMessage);
        Log.endTestCase();
    }
}
