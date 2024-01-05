import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends Base {

    //Constructors
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    //By
    private By OldPassword_TextBox = By.xpath("//input[@name='oldpassword']");
    private By NewPassword_TextBox = By.xpath("//input[@name='newpassword']");
    private By ConfirmPassword_TextBox = By.xpath("//input[@name='confirmpassword']");
    private By ResetButton = By.xpath("//input[@name='res']");
    private By SubmitButton = By.xpath("//input[@name='sub']");
    private By HomeButton = By.linkText("Home");
    private By Heading = By.xpath("//p[@class='heading3']");

    //WebElements
    WebElement OldPassword_TextBoxElement;
    WebElement NewPassword_TextBoxElement;
    WebElement ConfirmPassword_TextBoxElement;
    WebElement ResetButtonElement;
    WebElement SubmitButtonElement;
    WebElement HomeButtonElement;
    WebElement HeadingElement;

    //Methods
    public void EnterOldPassword(String Number)
    {
        OldPassword_TextBoxElement = driver.findElement(OldPassword_TextBox);
        ClearText(OldPassword_TextBoxElement);
        SendText(OldPassword_TextBoxElement,Number);
    }

    public void EnterNewPassword(String Number)
    {
        NewPassword_TextBoxElement = driver.findElement(NewPassword_TextBox);
        ClearText(NewPassword_TextBoxElement);
        SendText(NewPassword_TextBoxElement,Number);
    }

    public void EnterConfirmPassword(String Number)
    {
        ConfirmPassword_TextBoxElement = driver.findElement(ConfirmPassword_TextBox);
        ClearText(ConfirmPassword_TextBoxElement);
        SendText(ConfirmPassword_TextBoxElement,Number);
    }

    public void ClickOnResetButton ()
    {
        ResetButtonElement = driver.findElement(ResetButton);
        Clicking(ResetButtonElement);
    }

    public void ClickOnHomeButton ()
    {
        HomeButtonElement = driver.findElement(HomeButton);
        Clicking(HomeButtonElement);
    }

    public void ClickOnSubmitButton ()
    {
        SubmitButtonElement = driver.findElement(SubmitButton);
        Clicking(SubmitButtonElement);
    }

    public void LeftClickOnThePage ()
    {
        HeadingElement = driver.findElement(Heading);
        Clicking(HeadingElement);
    }

}
