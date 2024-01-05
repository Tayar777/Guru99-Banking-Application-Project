import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    private HomePage homePage;


    @Test (priority = 1)
    public void CheckNewCustomerButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnNewCustomerButton();
        String Expected = "Add New Customer";
        WebElement NewCustomerAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = NewCustomerAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckEditCustomerButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnEditCustomerButton();
        String Expected = "Edit Customer Form";
        WebElement EditCustomerAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = EditCustomerAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckDeleteCustomerButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnDeleteCustomerButton();
        String Expected = "Delete Customer Form";
        WebElement DeleteCustomerAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = DeleteCustomerAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckNewAccountButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnNewAccountButton();
        String Expected = "Add new account form";
        WebElement NewAccountAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = NewAccountAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckEditAccountButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnEditAccountButton();
        String Expected = "Edit Account Form";
        WebElement EditAccountAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = EditAccountAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckDeleteAccountButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnDeleteAccountButton();
        String Expected = "Delete Account Form";
        WebElement DeleteAccountAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = DeleteAccountAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckDepositButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnDepositButton();
        String Expected = "Amount Deposit Form";
        WebElement DepositAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = DepositAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckWithdrawalButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnWithdrawalButton();
        String Expected = "Amount Withdrawal Form";
        WebElement WithdrawalAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = WithdrawalAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckFundTransferButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnFundTransferButton();
        String Expected = "Fund transfer";
        WebElement FundTransferAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = FundTransferAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckChangePasswordButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnChangePasswordButton();
        String Expected = "Change Password";
        WebElement ChangePasswordAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = ChangePasswordAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckBalanceEnquiryButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnBalanceEnquiryButton();
        String Expected = "Balance Enquiry Form";
        WebElement BalanceEnquiryAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = BalanceEnquiryAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckMiniStatementButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnMiniStatementButton();
        String Expected = "Mini Statement Form";
        WebElement MiniStatementAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = MiniStatementAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void CheckCustomizedStatementButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnCustomizedStatementButton();
        String Expected = "Customized Statement Form";
        WebElement CustomizedStatementAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = CustomizedStatementAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void CheckManagerButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnManagerButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement ManagerAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = ManagerAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 4)
    public void CheckLogoutButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnLogoutButton();
        String Expected = "You Have Succesfully Logged Out!!";
        String Actual = driver.switchTo().alert().getText();
        homePage.ClickOnAlert();
        Assert.assertEquals(Actual,Expected);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='barone']")));
        WebElement LoginPageAssertionElement = driver.findElement(By.xpath("//h2[@class='barone']"));
        String Actual1 = LoginPageAssertionElement.getText();
        String Expected1 = "Guru99 Bank";
        Assert.assertEquals(Actual1,Expected1);
    }




}
