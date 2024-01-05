import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BalanceEnquiryPageTest extends BaseTest {

    private BalanceEnquiryPage balanceEnquiryPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckBalanceEnquiryButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnBalanceEnquiryButton();
        String Expected = "Balance Enquiry Form";
        WebElement BalanceEnquiryAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = BalanceEnquiryAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    //CheckAccountNo
    @Test(priority = 1)
    public void AccountNo_MustNotBeBlank ()
    {
        balanceEnquiryPage = new BalanceEnquiryPage(driver);
        balanceEnquiryPage.EnterAccountNo("");
        balanceEnquiryPage.LeftClickOnThePage();
        String Expected = "Account Number must not be blank";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_SpecialCharactersAreNotAllowed()
    {
        balanceEnquiryPage = new BalanceEnquiryPage(driver);
        balanceEnquiryPage.EnterAccountNo("@");
        String Expected = "Special characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_CharactersAreNotAllowed()
    {
        balanceEnquiryPage = new BalanceEnquiryPage(driver);
        balanceEnquiryPage.EnterAccountNo("A");
        String Expected = "Characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_FirstCharacterCannotHaveSpace()
    {
        balanceEnquiryPage = new BalanceEnquiryPage(driver);
        balanceEnquiryPage.EnterAccountNo(" ");
        String Expected = "First character can not have space";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void InvalidAccountNo()
    {
        balanceEnquiryPage = new BalanceEnquiryPage(driver);
        balanceEnquiryPage.EnterAccountNo("123456");
        balanceEnquiryPage.ClickOnSubmitButton();
        String Expected = "Account does not exist";
        String Actual = driver.switchTo().alert().getText();
        balanceEnquiryPage.ClickOnAlert();
        Assert.assertEquals(Actual,Expected);
    }


    //ResetButton
    @Test (priority = 2)
    public void CheckResetButton ()
    {
        balanceEnquiryPage = new BalanceEnquiryPage(driver);
        balanceEnquiryPage.EnterAccountNo("123456");
        balanceEnquiryPage.ClickOnResetButton();
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//input[@name='accountno']"));
        String Actual = AccountNo_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }

    //HomeButton
    @Test (priority = 3)
    public void CheckHomeButton ()
    {
        balanceEnquiryPage = new BalanceEnquiryPage(driver);
        balanceEnquiryPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
      //homePage.ClickOnBalanceEnquiryButton();
    }


    //ValidBalanceEnquiry
    @Test (priority = 4,enabled = false)
    public void ValidAccountNo()
    {
        balanceEnquiryPage = new BalanceEnquiryPage(driver);
        balanceEnquiryPage.EnterAccountNo(NewAccountID_Saved);
        balanceEnquiryPage.ClickOnSubmitButton();
        WebElement BalanceEnquiryAssertion = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/p"));
        String Actual = BalanceEnquiryAssertion.getText();
        String Expected = "Balance Enquiry Details";
        Assert.assertEquals(Actual,Expected);
        balanceEnquiryPage.ClickOnHomeButton();
    }


}
