import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FundTransferPageTest extends BaseTest{

    private FundTransferPage fundTransferPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckFundTransferButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnFundTransferButton();
        String Expected = "Fund transfer";
        WebElement FundTransferAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = FundTransferAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //PayersAccountNoTC
    @Test(priority = 1)
    public void PayersAccountNo_MustNotBeBlank ()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo("");
        fundTransferPage.LeftClickOnThePage();
        String Expected = "Payers Account Number must not be blank";
        WebElement PayersAccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message10']"));
        String Actual = PayersAccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void PayersAccountNo_SpecialCharactersAreNotAllowed()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo("@");
        String Expected = "Special characters are not allowed";
        WebElement PayersAccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message10']"));
        String Actual = PayersAccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void PayersAccountNo_CharactersAreNotAllowed()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo("A");
        String Expected = "Characters are not allowed";
        WebElement PayersAccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message10']"));
        String Actual = PayersAccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void PayersAccountNo_FirstCharacterCannotHaveSpace()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo(" ");
        String Expected = "First character can not have space";
        WebElement PayersAccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message10']"));
        String Actual = PayersAccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void PayersAccountNo_DoesNotExist()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo("123456");
        fundTransferPage.EnterPayeesAccountNo(NewAccountID_Saved);
        fundTransferPage.EnterAmount("500");
        fundTransferPage.EnterDescription("Transfer");
        fundTransferPage.ClickOnSubmitButton();
        String Actual = driver.switchTo().alert().getText();
        fundTransferPage.ClickOnAlert();
        String Expected = "Account 123456does not exist!!!";
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void PayersAccountNoEqualsPayersAccountNo()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo(NewAccountID_Saved);
        fundTransferPage.EnterPayeesAccountNo(NewAccountID_Saved);
        fundTransferPage.EnterAmount("500");
        fundTransferPage.EnterDescription("Transfer");
        fundTransferPage.ClickOnSubmitButton();
        String Actual = driver.switchTo().alert().getText();
        fundTransferPage.ClickOnAlert();
        String Expected = "Payers account No and Payees account No Must Not be Same!!!";
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void PayersAccountNo_DoesNotHaveTheNecessaryBalance()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo(NewAccountID_Saved);
        fundTransferPage.EnterPayeesAccountNo(NewAccountID_Saved2);
        fundTransferPage.EnterAmount("1000");
        fundTransferPage.EnterDescription("Transfer");
        fundTransferPage.ClickOnSubmitButton();
        String Actual = driver.switchTo().alert().getText();
        fundTransferPage.ClickOnAlert();
        String Expected = "Transfer Failed. Account Balance low!!";
        Assert.assertEquals(Actual,Expected);
    }


    //PayeesAccountNoTC
    @Test(priority = 2)
    public void PayeesAccountNo_MustNotBeBlank ()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayeesAccountNo("");
        fundTransferPage.LeftClickOnThePage();
        String Expected = "Payees Account Number must not be blank";
        WebElement PayeesAccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message11']"));
        String Actual = PayeesAccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void PayeesAccountNo_SpecialCharactersAreNotAllowed()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayeesAccountNo("@");
        String Expected = "Special characters are not allowed";
        WebElement PayeesAccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message11']"));
        String Actual = PayeesAccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void PayeesAccountNo_CharactersAreNotAllowed()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayeesAccountNo("A");
        String Expected = "Characters are not allowed";
        WebElement PayeesAccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message11']"));
        String Actual = PayeesAccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void PayeesAccountNo_FirstCharacterCannotHaveSpace()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayeesAccountNo(" ");
        String Expected = "First character can not have space";
        WebElement PayeesAccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message11']"));
        String Actual = PayeesAccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void PayeesAccountNo_DoesNotExist()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo(NewAccountID_Saved);
        fundTransferPage.EnterPayeesAccountNo("123456");
        fundTransferPage.EnterAmount("500");
        fundTransferPage.EnterDescription("Transfer");
        fundTransferPage.ClickOnSubmitButton();
        String Actual = driver.switchTo().alert().getText();
        fundTransferPage.ClickOnAlert();
        String Expected = "Account 123456does not exist!!!";
        Assert.assertEquals(Actual,Expected);
    }


    //AmountTC
    @Test(priority = 3)
    public void Amount_MustNotBeBlank ()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterAmount("");
        fundTransferPage.LeftClickOnThePage();
        String Expected = "Amount field must not be blank";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void Amount_SpecialCharactersAreNotAllowed()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterAmount("@");
        String Expected = "Special characters are not allowed";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void Amount_CharactersAreNotAllowed()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterAmount("A");
        String Expected = "Characters are not allowed";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void Amount_FirstCharacterCannotHaveSpace()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterAmount(" ");
        String Expected = "First character can not have space";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //DescriptionTC
    @Test(priority = 4)
    public void Description_MustNotBeBlank ()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterDescription("");
        fundTransferPage.LeftClickOnThePage();
        String Expected = "Description can not be blank";
        WebElement Description_Assertion = driver.findElement(By.xpath("//label[@id='message17']"));
        String Actual = Description_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //ResetButton
    @Test (priority = 5)
    public void CheckResetButton ()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo("123456");
        fundTransferPage.EnterPayeesAccountNo("987654");
        fundTransferPage.EnterAmount("500");
        fundTransferPage.EnterDescription("deposit");
        fundTransferPage.ClickOnResetButton();
        WebElement PayersAccountNo_Assertion = driver.findElement(By.xpath("//input[@name='payersaccount']"));
        String Actual = PayersAccountNo_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }

    //HomeButton
    @Test (priority = 6)
    public void CheckHomeButton ()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
        homePage.ClickOnFundTransferButton();
    }

    //ValidFundTransfer
    @Test (priority = 7)
    public void ValidFundTransfer()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.EnterPayersAccountNo(NewAccountID_Saved);
        fundTransferPage.EnterPayeesAccountNo(NewAccountID_Saved2);
        fundTransferPage.EnterAmount("100");
        fundTransferPage.EnterDescription("Transfer");
        fundTransferPage.ClickOnSubmitButton();
        WebElement FundTransferAssertion = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/p"));
        String Actual = FundTransferAssertion.getText();
        String Expected = "Fund Transfer Details";
        Assert.assertEquals(Actual,Expected);
        fundTransferPage.ClickOnHomeButton();
    }
}
