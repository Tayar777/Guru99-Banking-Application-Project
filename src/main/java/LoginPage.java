import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage extends Base {

    // Constructors
    public LoginPage (WebDriver driver)
    {
        super(driver);
    }

    // By
    private By UserID_TextBox = By.xpath("//input[@type='text']");
    private By Password_TextBox = By.xpath("//input[@type='password']");
    private By Login_Button = By.xpath("//input[@type='submit']");
    private By Reset_Button = By.xpath("//input[@type='reset']");

    // WebElements
    WebElement UserID_TextBox_Element;
    WebElement Password_TextBox_Element;
    WebElement Login_Button_Element;
    WebElement Reset_Button_Element;

    // Methods
    public void Add_UserID (String UserID)
    {
        UserID_TextBox_Element = driver.findElement(UserID_TextBox);
        SendText(UserID_TextBox_Element, UserID);
    }
    public void Add_Password (String Password)
    {
        Password_TextBox_Element = driver.findElement(Password_TextBox);
        SendText(Password_TextBox_Element, Password);
    }
    public void ClickOnLoginButton ()
    {
        Login_Button_Element = driver.findElement(Login_Button);
        Clicking(Login_Button_Element);
    }

    public void ClickOnUserID_TextBox ()
    {
        UserID_TextBox_Element = driver.findElement(UserID_TextBox);
        Clicking(UserID_TextBox_Element);
    }

    public void ClickOnPassword_TextBox ()
    {
        Password_TextBox_Element = driver.findElement(Password_TextBox);
        Clicking(Password_TextBox_Element);
    }

    public void ClickOnResetButton ()
    {
        Reset_Button_Element = driver.findElement(Reset_Button);
        Clicking(Reset_Button_Element);
    }








}
