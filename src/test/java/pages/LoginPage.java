package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import library.BaseClass;

public class LoginPage extends BaseClass {

    @FindBy(id = "user-name") private WebElement usernameField;
    @FindBy(id = "password") private WebElement passwordField;
    @FindBy(id = "login-button") private WebElement loginButton;
    @FindBy(xpath = "//*[@id='root']/div/div[1]") private WebElement logo;
    @FindBy(xpath = "//div[contains(text(),'Swag Labs')]") private WebElement successMessage;
    @FindBy(className = "error-message-container") private WebElement errorMessageContainer;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isUsernameFieldDisplayed() {
        return usernameField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessageContainer.getText();
    }
}
