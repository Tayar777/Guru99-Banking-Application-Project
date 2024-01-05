import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomizedStatementPage extends Base{

    //Constructors
    public CustomizedStatementPage(WebDriver driver) {
        super(driver);
    }

    //By
    private By AccountNo_TextBox = By.xpath("//input[@name='accountno']");
    private By FromDate_TextBox = By.xpath("//input[@name='fdate']");
    private By ToDate_TextBox = By.xpath("//input[@name='tdate']");
    private By MinimumTransactionValue_TextBox = By.xpath("//input[@name='amountlowerlimit']");
    private By NumberOfTransaction_TextBox = By.xpath("//input[@name='numtransaction']");
    private By ResetButton = By.xpath("//input[@name='res']");
    private By SubmitButton = By.xpath("//input[@name='AccSubmit']");
    private By HomeButton = By.linkText("Home");
    private By Heading = By.xpath("//p[@class='heading3']");

    //WebElements
    WebElement AccountNo_TextBoxElement;
    WebElement FromDate_TextBoxElement;
    WebElement ToDate_TextBoxElement;
    WebElement MinimumTransactionValue_TextBoxElement;
    WebElement NumberOfTransaction_TextBoxElement;
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

    public void EnterFromDate (String FromDate)
    {
        FromDate_TextBoxElement = driver.findElement(FromDate_TextBox);
        ClearText(FromDate_TextBoxElement);
        SendText(FromDate_TextBoxElement,FromDate);
    }

    public void EnterToDate (String ToDate)
    {
        ToDate_TextBoxElement = driver.findElement(ToDate_TextBox);
        ClearText(ToDate_TextBoxElement);
        SendText(ToDate_TextBoxElement,ToDate);
    }

    public void EnterMinimumTransactionValue (String Value)
    {
        MinimumTransactionValue_TextBoxElement = driver.findElement(MinimumTransactionValue_TextBox);
        ClearText(MinimumTransactionValue_TextBoxElement);
        SendText(MinimumTransactionValue_TextBoxElement,Value);
    }

    public void EnterNumberOfTransaction (String Value)
    {
        NumberOfTransaction_TextBoxElement = driver.findElement(NumberOfTransaction_TextBox);
        ClearText(NumberOfTransaction_TextBoxElement);
        SendText(NumberOfTransaction_TextBoxElement,Value);
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
