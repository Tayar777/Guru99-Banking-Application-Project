import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCustomerPage extends Base {

    // Constructors
    public NewCustomerPage(WebDriver driver)
    {
        super(driver);
    }

    // By
    private By CustomerNameTextBox = By.xpath("//input[@name='name']");
    private By GenderMaleRadioButton = By.xpath("//input[@value='m']");
    private By GenderFemaleRadioButton = By.xpath("//input[@value='f']");
    private By DateOfBirthTextBox = By.xpath("//input[@name='dob']");
    private By AddressTextBox = By.xpath("//textarea[@name='addr']");
    private By CityTextBox = By.xpath("//input[@name='city']");
    private By StateTextBox = By.xpath("//input[@name='state']");
    private By PINTextBox = By.xpath("//input[@name='pinno']");
    private By MobileNumberTextBox = By.xpath("//input[@name='telephoneno']");
    private By EmailTextBox = By.xpath("//input[@name='emailid']");
    private By PasswordTextBox = By.xpath("//input[@name='password']");
    private By ResetButton = By.xpath("//input[@name='res']");
    private By SubmitButton = By.xpath("//input[@name='sub']");
    private By HomeButton = By.xpath("//a[@style='margin-right:80px;']");

    // WebElements
    WebElement CustomerNameTextBoxElement;
    WebElement GenderMaleRadioButtonElement;
    WebElement GenderFemaleRadioButtonElement;
    WebElement DateOfBirthTextBoxElement;
    WebElement AddressTextBoxElement;
    WebElement CityTextBoxElement;
    WebElement StateTextBoxElement;
    WebElement PINTextBoxElement;
    WebElement MobileNumberTextBoxElement;
    WebElement EmailTextBoxElement;
    WebElement PasswordTextBoxElement;
    WebElement ResetButtonElement;
    WebElement SubmitButtonElement;
    WebElement HomeButtonElement;

    // Methods
    public void EnterCustomerName (String Name)
    {
        CustomerNameTextBoxElement = driver.findElement(CustomerNameTextBox);
        ClearText(CustomerNameTextBoxElement);
        SendText(CustomerNameTextBoxElement, Name);
    }

    public void SelectMaleGender()
    {
        GenderMaleRadioButtonElement = driver.findElement(GenderMaleRadioButton);
        Clicking(GenderMaleRadioButtonElement);
    }

    public void SelectFemaleGender()
    {
        GenderFemaleRadioButtonElement = driver.findElement(GenderFemaleRadioButton);
        Clicking(GenderFemaleRadioButtonElement);
    }

    public void EnterDateOfBirth (String date)
    {
        DateOfBirthTextBoxElement = driver.findElement(DateOfBirthTextBox);
        SendText(DateOfBirthTextBoxElement, date);
    }

    public void EnterAddress (String Address)
    {
        AddressTextBoxElement = driver.findElement(AddressTextBox);
        ClearText(AddressTextBoxElement);
        SendText(AddressTextBoxElement, Address);
    }

    public void EnterCity (String City)
    {
        CityTextBoxElement = driver.findElement(CityTextBox);
        ClearText(CityTextBoxElement);
        SendText(CityTextBoxElement, City);
    }

    public void EnterState (String State)
    {
        StateTextBoxElement = driver.findElement(StateTextBox);
        ClearText(StateTextBoxElement);
        SendText(StateTextBoxElement, State);
    }

    public void EnterPIN (String PIN)
    {
        PINTextBoxElement = driver.findElement(PINTextBox);
        ClearText(PINTextBoxElement);
        SendText(PINTextBoxElement, PIN);
    }

    public void EnterMobileNumber (String MobileNumber)
    {
        MobileNumberTextBoxElement = driver.findElement(MobileNumberTextBox);
        ClearText(MobileNumberTextBoxElement);
        SendText(MobileNumberTextBoxElement, MobileNumber);
    }

    public void EnterEmail (String Email)
    {
        EmailTextBoxElement = driver.findElement(EmailTextBox);
        ClearText(EmailTextBoxElement);
        SendText(EmailTextBoxElement, Email);
    }

    public void EnterPassword (String Password)
    {
        PasswordTextBoxElement = driver.findElement(PasswordTextBox);
        ClearText(PasswordTextBoxElement);
        SendText(PasswordTextBoxElement, Password);
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






}
