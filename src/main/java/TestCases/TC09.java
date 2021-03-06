package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class TC09 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData",description = "User can't change password when \"New Password\" and \"Confirm Password\" are different.")
    public void TC09(Object[] data) {
        Log.startTestCase("TC09");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();
        String newPassword = data[4].toString();
        String confirmNewPassword = data[5].toString();
        String errorMessageOfChangePasswordForm = data[6].toString();
        String errorMessageOfConfirmPasswordField = data[7].toString();

        Log.info("Pre-condition: Register a new account");
        homePage.navigateToRegisterPage();
        registerPage.registerAccount(email,password,confirmPassword,passportNumber);

        Log.info("Step 1: Navigate from Home page to Login page");
        homePage.navigateToLoginPage();

        Log.info("Step 2: Login with valid Email and Password above");
        loginPage.login(email, password);

        Log.info("Step 3: Navigate to Change Password page");
        homePage.navigateToChangePasswordPage();

        Log.info("Step 4: Change Password with \"New Password\" and \"Confirm Password\" are different");
        changePasswordPage.changePassword(password, newPassword, confirmNewPassword);

        Log.info("Expected Behavior: Check Error Message Of Change Password Form");
        changePasswordPage.checkErrorMessageOfChangePasswordForm(errorMessageOfChangePasswordForm);

        Log.info("Expected Behavior: Check Error Message Of Confirm Password Field");
        changePasswordPage.checkErrorMessageOfConfirmPasswordField(errorMessageOfConfirmPasswordField);

        Log.endTestCase();
    }
}
