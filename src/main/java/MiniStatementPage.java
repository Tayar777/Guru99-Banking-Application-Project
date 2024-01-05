import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MiniStatementPage extends Base{

    //Constructors
    public MiniStatementPage(WebDriver driver) {
        super(driver);
    }

    //By
    private By AccountNo_TextBox = By.xpath("//input[@name='accountno']");
    private By ResetButton = By.xpath("//input[@name='res']");
    private By SubmitButton = By.xpath("//input[@name='AccSubmit']");
    private By HomeButton = By.linkText("Home");
    private By Heading = By.xpath("//p[@class='heading3']");

    //WebElement
    WebElement AccountNo_TextBoxElement;
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
