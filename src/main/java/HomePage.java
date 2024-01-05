import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Base {

    // Constructors
    public HomePage (WebDriver driver)
    {
        super(driver);
    }

    // By
    private By ManagerButton = By.xpath("//li[@class='orange']");
    private By NewCustomerButton = By.xpath("//a[@href='addcustomerpage.php']");
    private By EditCustomerButton = By.xpath("//a[@href='EditCustomer.php']");
    private By DeleteCustomerButton = By.xpath("//a[@href='DeleteCustomerInput.php']");
    private By NewAccountButton = By.xpath("//a[@href='addAccount.php']");
    private By EditAccountButton = By.xpath("//a[@href='editAccount.php']");
    private By DeleteAccountButton = By.xpath("//a[@href='deleteAccountInput.php']");
    private By DepositButton = By.xpath("//a[@href='DepositInput.php']");
    private By WithdrawalButton = By.xpath("//a[@href='WithdrawalInput.php']");
    private By FundTransferButton = By.xpath("//a[@href='FundTransInput.php']");
    private By ChangePasswordButton = By.xpath("//a[@href='PasswordInput.php']");
    private By BalanceEnquiryButton = By.xpath("//a[@href='BalEnqInput.php']");
    private By MiniStatementButton = By.xpath("//a[@href='MiniStatementInput.php']");
    private By CustomizedStatementButton = By.xpath("//a[@href='CustomisedStatementInput.php']");
    private By LogoutButton = By.xpath("//a[@href='Logout.php']");

    // WebElements
    WebElement ManagerButtonElement;
    WebElement NewCustomerButtonElement;
    WebElement EditCustomerButtonElement;
    WebElement DeleteCustomerButtonElement;
    WebElement NewAccountButtonElement;
    WebElement EditAccountButtonElement;
    WebElement DeleteAccountButtonElement;
    WebElement DepositButtonElement;
    WebElement WithdrawalButtonElement;
    WebElement FundTransferButtonElement;
    WebElement ChangePasswordButtonElement;
    WebElement BalanceEnquiryButtonElement;
    WebElement MiniStatementButtonElement;
    WebElement CustomizedStatementButtonElement;
    WebElement LogoutButtonElement;

    // Methods
    public void ClickOnNewCustomerButton ()
    {
        NewCustomerButtonElement = driver.findElement(NewCustomerButton);
        Clicking(NewCustomerButtonElement);
    }
    public void ClickOnEditCustomerButton ()
    {
        EditCustomerButtonElement = driver.findElement(EditCustomerButton);
        Clicking(EditCustomerButtonElement);
    }
    public void ClickOnDeleteCustomerButton ()
    {
        DeleteCustomerButtonElement = driver.findElement(DeleteCustomerButton);
        Clicking(DeleteCustomerButtonElement);
    }
    public void ClickOnNewAccountButton ()
    {
        NewAccountButtonElement = driver.findElement(NewAccountButton);
        Clicking(NewAccountButtonElement);
    }
    public void ClickOnEditAccountButton ()
    {
        EditAccountButtonElement = driver.findElement(EditAccountButton);
        Clicking(EditAccountButtonElement);
    }
    public void ClickOnDeleteAccountButton ()
    {
        DeleteAccountButtonElement = driver.findElement(DeleteAccountButton);
        Clicking(DeleteAccountButtonElement);
    }
    public void ClickOnDepositButton ()
    {
        DepositButtonElement = driver.findElement(DepositButton);
        Clicking(DepositButtonElement);
    }
    public void ClickOnWithdrawalButton ()
    {
        WithdrawalButtonElement = driver.findElement(WithdrawalButton);
        Clicking(WithdrawalButtonElement);
    }
    public void ClickOnFundTransferButton ()
    {
        FundTransferButtonElement = driver.findElement(FundTransferButton);
        Clicking(FundTransferButtonElement);
    }
    public void ClickOnChangePasswordButton ()
    {
        ChangePasswordButtonElement = driver.findElement(ChangePasswordButton);
        Clicking(ChangePasswordButtonElement);
    }
    public void ClickOnBalanceEnquiryButton ()
    {
        BalanceEnquiryButtonElement = driver.findElement(BalanceEnquiryButton);
        Clicking(BalanceEnquiryButtonElement);
    }
    public void ClickOnMiniStatementButton ()
    {
        MiniStatementButtonElement = driver.findElement(MiniStatementButton);
        Clicking(MiniStatementButtonElement);
    }
    public void ClickOnCustomizedStatementButton ()
    {
        CustomizedStatementButtonElement = driver.findElement(CustomizedStatementButton);
        Clicking(CustomizedStatementButtonElement);
    }
    public void ClickOnLogoutButton ()
    {
        LogoutButtonElement = driver.findElement(LogoutButton);
        Clicking(LogoutButtonElement);
    }
    public void ClickOnManagerButton ()
    {
        ManagerButtonElement = driver.findElement(ManagerButton);
        Clicking(ManagerButtonElement);
    }


}
