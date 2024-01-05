import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage extends Base {

    // Constructor
    public NewAccountPage(WebDriver driver)
    {
        super(driver);
    }

    //By
    private By CustomerID_TextBox = By.xpath("//input[@name='cusid']");
    private By AccountType_DropDown = By.xpath("//select[@name='selaccount']");
    private By InitialDeposit_TextBox = By.xpath("//input[@name='inideposit']");
    private By ResetButton = By.xpath("//input[@name='reset']");
    private By SubmitButton = By.xpath("//input[@name='button2']");
    private By HomeButton = By.xpath("//a[@style='margin-right:80px;']");
    private By Heading = By.xpath("//p[@class='heading3']");

    //WebElements
    WebElement CustomerID_TextBoxElement;
    WebElement AccountType_DropDownElement;
    WebElement InitialDeposit_TextBoxElement;
    WebElement ResetButtonElement;
    WebElement SubmitButtonElement;
    WebElement HomeButtonElement;
    WebElement HeadingElement;

    // Methods
    public void EnterCustomerID (String Name)
    {
        CustomerID_TextBoxElement = driver.findElement(CustomerID_TextBox);
        ClearText(CustomerID_TextBoxElement);
        SendText(CustomerID_TextBoxElement, Name);
    }

    public void EnterInitialDeposit (String Name)
    {
        InitialDeposit_TextBoxElement = driver.findElement(InitialDeposit_TextBox);
        ClearText(InitialDeposit_TextBoxElement);
        SendText(InitialDeposit_TextBoxElement, Name);
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

    public void SelectAccountType (int Index)
    {
        AccountType_DropDownElement = driver.findElement(AccountType_DropDown);
        SelectDropDown(AccountType_DropDownElement,Index);
    }

    public void LeftClickOnThePage ()
    {
        HeadingElement = driver.findElement(Heading);
        Clicking(HeadingElement);
    }







}
