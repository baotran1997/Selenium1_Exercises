package PageObjects;

import Common.Constants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage{
    /**
     * Locators
     */
    public By emailXpath = By.xpath("//input[@id='email']");
    public By passwordXpath = By.xpath("//input[@id='password']");
    public By confirmPasswordXpath = By.xpath("//input[@id='confirmPassword']");
    public By passportNumberXpath = By.xpath("//input[@id='pid']");
    public By registerButtonXpath = By.xpath("//input[@title='Register']");
    public By registerSuccessfullyMessageXpath = By.xpath("//p[normalize-space()=\"You're here\"]");
    public By errorMessageForExistingEmailXpath = By.xpath("//p[normalize-space()='This email address is already in use.']");
    public By invalidPasswordLengthMessageXpath = By.xpath("//label[normalize-space()='Invalid password length']");
    public By invalidPIDLengthMessageXpath = By.xpath("//label[normalize-space()='Invalid ID length']");
    public By errorMessageOfRegisterFormXpath = By.xpath("//p[@class='message error']");

    /**
     * Elements
     */
    public WebElement getEmailXpath() {
        return Constants.DRIVER.findElement(emailXpath);
    }
    public WebElement getPasswordXpath() {
        return Constants.DRIVER.findElement(passwordXpath);
    }
    public WebElement getConfirmPasswordXpath() {
        return Constants.DRIVER.findElement(confirmPasswordXpath);
    }
    public WebElement getPassportNumberXpath() {
        return Constants.DRIVER.findElement(passportNumberXpath);
    }
    public WebElement getRegisterButtonXpath() {
        return Constants.DRIVER.findElement(registerButtonXpath);
    }
    public WebElement getRegisterSuccessfullyMessageXpath() {
        return Constants.DRIVER.findElement(registerSuccessfullyMessageXpath);
    }
    public WebElement getErrorMessageForExistingEmailXpath() {
        return Constants.DRIVER.findElement(errorMessageForExistingEmailXpath);
    }
    public WebElement getInvalidPasswordLengthMessageXpath() {
        return Constants.DRIVER.findElement(invalidPasswordLengthMessageXpath);
    }
    public WebElement getInvalidPIDLengthMessageXpath() {
        return Constants.DRIVER.findElement(invalidPIDLengthMessageXpath);
    }
    public WebElement getErrorMessageOfRegisterFormXpath() {
        return Constants.DRIVER.findElement(errorMessageOfRegisterFormXpath);
    }

    /**
     * Methods
     */
    public void typeEmailField (String email) {
        getEmailXpath().sendKeys(email);
    }
    public void typePasswordField (String password) {
        getPasswordXpath().sendKeys(password);
    }
    public void typeConfirmPasswordField(String confirmPassword) {
        getConfirmPasswordXpath().sendKeys(confirmPassword);
    }
    public void typePassportNumberField(String passportNumber) {
        getPassportNumberXpath().sendKeys(passportNumber);
    }
    public void clickRegisterButton() {
        getRegisterButtonXpath().click();
    }

    public void registerAccount(String email, String password, String confirmPassword, String passportNumber) {
        typeEmailField(email);
        typePasswordField(password);
        typeConfirmPasswordField(confirmPassword);
        typePassportNumberField(passportNumber);
        clickRegisterButton();
    }

    public void fillRegisterInformation(String email, String password, String confirmPassword, String passportNumber) {
        typeEmailField(email);
        typePasswordField(password);
        typeConfirmPasswordField(confirmPassword);
        typePassportNumberField(passportNumber);
    }

    public String getRegisterSuccessfullyMessage() {
        return getRegisterSuccessfullyMessageXpath().getText();
    }
    public void checkRegisterSuccessfullyMessage(String registerSuccessfullyMessage) {
        String actualRegisterSuccessfullyMessage = getRegisterSuccessfullyMessage();
        String expectedRegisterSuccessfullyMessage = registerSuccessfullyMessage;

        Assertions.assertEquals(expectedRegisterSuccessfullyMessage,actualRegisterSuccessfullyMessage);
    }

    public String getErrorMessageForExistingEmail() {
        return getErrorMessageForExistingEmailXpath().getText();
    }
    public void checkErrorMessageForExistingEmail(String errorMessageForExistingEmail) {
        String actualErrorMessageForExistingEmail = getErrorMessageForExistingEmail();
        String expectedErrorMessageForExistingEmail = errorMessageForExistingEmail;

        Assertions.assertEquals(expectedErrorMessageForExistingEmail,actualErrorMessageForExistingEmail);
    }

    public String getInvalidPasswordLengthMessage() {
        return getInvalidPasswordLengthMessageXpath().getText();
    }
    public void checkInvalidPasswordLengthMessage(String invalidPasswordLengthMessage) {
        String actualInvalidPasswordLengthMessage = getInvalidPasswordLengthMessage();
        String expectedInvalidPasswordLengthMessage = invalidPasswordLengthMessage;

        Assertions.assertEquals(expectedInvalidPasswordLengthMessage,actualInvalidPasswordLengthMessage);
    }

    public String getInvalidPIDLengthMessage() {
        return getInvalidPIDLengthMessageXpath().getText();
    }
    public void checkInvalidPIDLengthMessage(String invalidPIDLengthMessage) {
        String actualInvalidPIDLengthMessage = getInvalidPIDLengthMessage();
        String expectedInvalidPIDLengthMessage = invalidPIDLengthMessage;

        Assertions.assertEquals(expectedInvalidPIDLengthMessage,actualInvalidPIDLengthMessage);
    }

    public String getErrorMessageOfRegisterForm() {
        return getErrorMessageOfRegisterFormXpath().getText();
    }
    public void checkErrorMessageOfRegisterForm(String errorMessageOfRegisterForm) {
        String actualErrorMessageOfRegisterForm = getErrorMessageOfRegisterForm();
        String expectedErrorMessageOfRegisterForm = errorMessageOfRegisterForm;

        Assertions.assertEquals(expectedErrorMessageOfRegisterForm,actualErrorMessageOfRegisterForm);
    }
}

