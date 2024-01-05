import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FundTransferPage extends Base{

    //Constructor
    public FundTransferPage(WebDriver driver) {
        super(driver);
    }

    //By
    private By PayersAccountNo_TextBox = By.xpath("//input[@name='payersaccount']");
    private By PayeesAccountNo_TextBox = By.xpath("//input[@name='payeeaccount']");
    private By Amount_TextBox = By.xpath("//input[@name='ammount']");
    private By Description_TextBox = By.xpath("//input[@name='desc']");
    private By ResetButton = By.xpath("//input[@name='res']");
    private By SubmitButton = By.xpath("//input[@name='AccSubmit']");
    private By HomeButton = By.linkText("Home");
    private By Heading = By.xpath("//p[@class='heading3']");

    //WebElement
    WebElement PayersAccountNo_TextBoxElement;
    WebElement PayeesAccountNo_TextBoxElement;
    WebElement Amount_TextBoxElement;
    WebElement Description_TextBoxElement;
    WebElement ResetButtonElement;
    WebElement SubmitButtonElement;
    WebElement HomeButtonElement;
    WebElement HeadingElement;

    //Methods
    public void EnterPayersAccountNo (String AccountNo)
    {
        PayersAccountNo_TextBoxElement = driver.findElement(PayersAccountNo_TextBox);
        ClearText(PayersAccountNo_TextBoxElement);
        SendText(PayersAccountNo_TextBoxElement,AccountNo);
    }

    public void EnterPayeesAccountNo (String AccountNo)
    {
        PayeesAccountNo_TextBoxElement = driver.findElement(PayeesAccountNo_TextBox);
        ClearText(PayeesAccountNo_TextBoxElement);
        SendText(PayeesAccountNo_TextBoxElement,AccountNo);
    }

    public void EnterAmount (String Amount)
    {
        Amount_TextBoxElement = driver.findElement(Amount_TextBox);
        ClearText(Amount_TextBoxElement);
        SendText(Amount_TextBoxElement,Amount);
    }

    public void EnterDescription (String Description)
    {
        Description_TextBoxElement = driver.findElement(Description_TextBox);
        ClearText(Description_TextBoxElement);
        SendText(Description_TextBoxElement,Description);
    }

    public void ClickOnResetButton ()
    {
        ResetButtonElement = driver.findElement(ResetButton);
        Clicking(ResetButtonElement);
    }

    public void ClickOnSubmitButton ()
    {
        SubmitButtonElement = driver.findElement(SubmitButton);
        Clicking(SubmitButtonElement);
    }

    public void ClickOnHomeButton ()
    {
        HomeButtonElement = driver.findElement(HomeButton);
        Clicking(HomeButtonElement);
    }

    public void LeftClickOnThePage ()
    {
        HeadingElement = driver.findElement(Heading);
        Clicking(HeadingElement);
    }

}
