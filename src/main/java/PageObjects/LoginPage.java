package PageObjects;

import Common.Constants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    /**
     * Locators
     */
    public By usernameXpath = By.id("username");
    public By passwordXpath = By.id("password");
    public By loginButtonXpath = By.xpath("//input[@value='Login']");
    public By errorMessageOfLoginFormXpath = By.xpath("//p[normalize-space()='There was a problem with your login and/or errors exist in your form.']");
    public By errorMessageOfEmailFieldXpath = By.xpath("//label[normalize-space()='You must specify a username.']");
    public By errorMessageOfInvalidFieldsXpath = By.xpath("//p[normalize-space()='Invalid username or password. Please try again.']");


    /**
     * Elements
     */
    public WebElement getUsernameXpath() {
        return Constants.DRIVER.findElement(usernameXpath);
    }
    public WebElement getPasswordXpath() {
        return Constants.DRIVER.findElement(passwordXpath);
    }
    public WebElement getLoginButtonXpath() {
        return Constants.DRIVER.findElement(loginButtonXpath);
    }
    public WebElement getErrorMessageOfLoginFormXpath() {
        return Constants.DRIVER.findElement(errorMessageOfLoginFormXpath);
    }
    public WebElement getErrorMessageOfEmailFieldXpath() {
        return Constants.DRIVER.findElement(errorMessageOfEmailFieldXpath);
    }
    public WebElement getErrorMessageOfInvalidFieldsXpath() {
        return Constants.DRIVER.findElement(errorMessageOfInvalidFieldsXpath);
    }
    /**
     * Methods
     */
    public void typeUsername(String username) {
        getUsernameXpath().sendKeys(username);
    }
    public void typePassword(String password) {
        getPasswordXpath().sendKeys(password);
    }

    public void fillLoginInformation(String username, String password) {
        typeUsername(username);
        typePassword(password);
    }

    public void clickLoginButton() {
        getLoginButtonXpath().click();
    }

    public void login(String username, String password) {
        fillLoginInformation(username,password);
        clickLoginButton();
    }

    public void repeatLoginWithTimes(int times, String username, String password) {
        for (int i = 0; i < times; i++) {
            BasePage.scrollDown();
            login(username, password);
        }
    }

    public String getErrorMessageOfLoginForm() {
        return getErrorMessageOfLoginFormXpath().getText();
    }

    public void checkErrorMessageOfLoginForm(String errorMessageOfLoginForm) {
        String actualErrorMessageOfLoginForm = getErrorMessageOfLoginForm();
        String expectedErrorMessageOfLoginForm = errorMessageOfLoginForm;

        Assertions.assertEquals(expectedErrorMessageOfLoginForm,actualErrorMessageOfLoginForm);
    }

    public String getErrorMessageOfEmailField() {
        return getErrorMessageOfEmailFieldXpath().getText();
    }

    public void checkErrorMessageOfEmailField(String errorMessageOfEmailField) {
        String actualErrorMessageOfEmailField = getErrorMessageOfEmailField();
        String expectedErrorMessageOfEmailField = errorMessageOfEmailField;

        Assertions.assertEquals(expectedErrorMessageOfEmailField,actualErrorMessageOfEmailField);
    }
    public  String getErrorMessageOfInvalidFields() {
        return getErrorMessageOfInvalidFieldsXpath().getText();
    }

    public void checkErrorMessageOfInvalidFields(String errorMessageOfInvalidFields) {
        String actualErrorMessageOfInvalidFields = getErrorMessageOfInvalidFields();
        String expectedErrorMessageOfInvalidFields = errorMessageOfInvalidFields;

        Assertions.assertEquals(expectedErrorMessageOfInvalidFields,actualErrorMessageOfInvalidFields);
    }

    public void checkErrorSystemMessage(String errorSystemMessage) {
        String actualErrorSystemMessage = getErrorMessageOfInvalidFields();
        String expectedErrorSystemMessage = errorSystemMessage;

        Assertions.assertEquals(expectedErrorSystemMessage,actualErrorSystemMessage);
    }
}
