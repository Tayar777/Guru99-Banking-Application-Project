import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteCustomerPage extends Base {

    //Constructor
    public DeleteCustomerPage(WebDriver driver)
    {
        super(driver);
    }

    //By
    private By CustomerID_TextBox = By.xpath("//input[@name='cusid']");
    private By ResetButton = By.xpath("//input[@name='res']");
    private By SubmitButton = By.xpath("//input[@name='AccSubmit']");
    private By HomeButton = By.xpath("//a[@style='margin-right:80px;']");
    private By Heading = By.xpath("//p[@class='heading3']");

    //WebElement
    WebElement CustomerID_TextBoxElement;
    WebElement ResetButtonElement;
    WebElement SubmitButtonElement;
    WebElement HomeButtonElement;
    WebElement HeadingElement;

    //Methods
    public void EnterCustomerID (String ID)
    {
        CustomerID_TextBoxElement = driver.findElement(CustomerID_TextBox);
        ClearText(CustomerID_TextBoxElement);
        SendText(CustomerID_TextBoxElement,ID);
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
