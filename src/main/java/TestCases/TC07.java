package TestCases;

import Common.BaseTest;
import Common.Constants;
import Common.DataFaker;
import Common.Log;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.annotations.Test;

public class TC07 extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "getData",description = "User can create new account")
    public void TC07(Object[] data) {
        Log.startTestCase("TC07");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String confirmPassword = data[2].toString();
        String passportNumber = data[3].toString();
        String registerSuccessfullyMessage = data[4].toString();

        Log.info("Navigate from Home page to Register page");
        homePage.navigateToRegisterPage();

        Log.info("Enter valid register information");
        registerPage.registerAccount(email, password, confirmPassword, passportNumber);

        Log.info("Check Register Successfully Message");
        registerPage.checkRegisterSuccessfullyMessage(registerSuccessfullyMessage);

        Log.endTestCase();
    }
}
