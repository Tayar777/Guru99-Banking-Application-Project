import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WithdrawalPage extends Base {

    //Constructor
    public WithdrawalPage(WebDriver driver)
    {
        super(driver);
    }

    //By
    private By AccountNo_TextBox = By.xpath("//input[@name='accountno']");
    private By Amount_TextBox = By.xpath("//input[@name='ammount']");
    private By Description_TextBox = By.xpath("//input[@name='desc']");
    private By ResetButton = By.xpath("//input[@name='res']");
    private By SubmitButton = By.xpath("//input[@name='AccSubmit']");
    private By HomeButton = By.linkText("Home");
    private By Heading = By.xpath("//p[@class='heading3']");

    //WebElement
    WebElement AccountNo_TextBoxElement;
    WebElement Amount_TextBoxElement;
    WebElement Description_TextBoxElement;
    WebElement ResetButtonElement;
    WebElement SubmitButtonElement;
    WebElement HomeButtonElement;
    WebElement HeadingElement;

    //Methods
    public void EnterAccountNo (String AccountNo)
    {
        AccountNo_TextBoxElement = driver.findElement(AccountNo_TextBox);
        ClearText(AccountNo_TextBoxElement);
        SendText(AccountNo_TextBoxElement,AccountNo);
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
