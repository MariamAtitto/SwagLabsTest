package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import library.BaseClass;
import pages.LoginPage;

public class LoginPageTest extends BaseClass {

    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyFieldsOnMainScreen() {
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed());
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    public void verifyValidCredentials() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isSuccessMessageDisplayed());
    }

    @Test
    public void verifyInvalidCredentials() {
        loginPage.login("invalid_user", "invalid_pass");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void verifyEmptyCredentials() {
        // Empty Username and Password
        loginPage.login("", "");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username is required"));
    }

    @Test
    public void verifyEmptyUsername() {
        // Empty Username
        loginPage.login("", "secret_sauce");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username is required"));
    }

    @Test
    public void verifyEmptyPassword() {
        // Empty Password
        loginPage.login("standard_user", "");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Password is required"));
    }


}
