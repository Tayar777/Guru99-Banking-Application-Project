import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CustomizedStatementPageTest extends BaseTest{

    private CustomizedStatementPage customizedStatementPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckCustomizedStatementButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnCustomizedStatementButton();
        String Expected = "Customized Statement Form";
        WebElement CustomizedStatementAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = CustomizedStatementAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //AccountNoTC
    @Test(priority = 1)
    public void AccountNo_MustNotBeBlank ()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterAccountNo("");
        customizedStatementPage.LeftClickOnThePage();
        String Expected = "Account Number must not be blank";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_SpecialCharactersAreNotAllowed()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterAccountNo("@");
        String Expected = "Special characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_CharactersAreNotAllowed()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterAccountNo("A");
        String Expected = "Characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_FirstCharacterCannotHaveSpace()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterAccountNo(" ");
        String Expected = "First character can not have space";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //FromDate&ToDateTC
    @Test(priority = 2)
    public void FromDate_MustNotBeBlank ()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterFromDate("");
        customizedStatementPage.LeftClickOnThePage();
        String Expected = "From Date Field must not be blank";
        WebElement FromDate_Assertion = driver.findElement(By.xpath("//label[@id='message26']"));
        String Actual = FromDate_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test(priority = 2)
    public void ToDate_MustNotBeBlank ()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterToDate("");
        customizedStatementPage.LeftClickOnThePage();
        String Expected = "To Date Field must not be blank";
        WebElement ToDate_Assertion = driver.findElement(By.xpath("//label[@id='message27']"));
        String Actual = ToDate_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void FromDateIsGreaterThanToDate ()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterFromDate("10/3/2022");
        customizedStatementPage.EnterToDate("10/3/2020");
        String Expected = "From-date is greater than to-date";
        WebElement FromDate_Assertion = driver.findElement(By.xpath("//label[@id='message26']"));
        String Actual = FromDate_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    //MinimumTransactionValueTC
    @Test(priority = 3)
    public void MinimumTransactionValue_MustNotBeBlank ()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterMinimumTransactionValue("");
        customizedStatementPage.LeftClickOnThePage();
        String Expected = "Minimum Transaction Value must not be blank";
        WebElement MinimumTransactionValue_Assertion = driver.findElement(By.xpath("//label[@id='message12']"));
        String Actual = MinimumTransactionValue_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void MinimumTransactionValue_SpecialCharactersAreNotAllowed()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterMinimumTransactionValue("@");
        String Expected = "Special characters are not allowed";
        WebElement MinimumTransactionValue_Assertion = driver.findElement(By.xpath("//label[@id='message12']"));
        String Actual = MinimumTransactionValue_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void MinimumTransactionValue_CharactersAreNotAllowed()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterMinimumTransactionValue("A");
        String Expected = "Characters are not allowed";
        WebElement MinimumTransactionValue_Assertion = driver.findElement(By.xpath("//label[@id='message12']"));
        String Actual = MinimumTransactionValue_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void MinimumTransactionValue_FirstCharacterCannotHaveSpace()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterMinimumTransactionValue(" ");
        String Expected = "First character can not have space";
        WebElement MinimumTransactionValue_Assertion = driver.findElement(By.xpath("//label[@id='message12']"));
        String Actual = MinimumTransactionValue_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //NumberOfTransactionTC
    @Test(priority = 4)
    public void NumberOfTransaction_MustNotBeBlank ()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterNumberOfTransaction("");
        customizedStatementPage.LeftClickOnThePage();
        String Expected = "Number of Transaction must not be blank";
        WebElement NumberOfTransaction_Assertion = driver.findElement(By.xpath("//label[@id='message13']"));
        String Actual = NumberOfTransaction_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 4)
    public void NumberOfTransaction_SpecialCharactersAreNotAllowed()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterNumberOfTransaction("@");
        String Expected = "Special characters are not allowed";
        WebElement NumberOfTransaction_Assertion = driver.findElement(By.xpath("//label[@id='message13']"));
        String Actual = NumberOfTransaction_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 4)
    public void NumberOfTransaction_CharactersAreNotAllowed()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterNumberOfTransaction("A");
        String Expected = "Characters are not allowed";
        WebElement NumberOfTransaction_Assertion = driver.findElement(By.xpath("//label[@id='message13']"));
        String Actual = NumberOfTransaction_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 4)
    public void NumberOfTransaction_FirstCharacterCannotHaveSpace()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterNumberOfTransaction(" ");
        String Expected = "First character can not have space";
        WebElement NumberOfTransaction_Assertion = driver.findElement(By.xpath("//label[@id='message13']"));
        String Actual = NumberOfTransaction_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //ResetButton
    @Test (priority = 5)
    public void CheckResetButton ()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterAccountNo("123456");
        customizedStatementPage.EnterFromDate("10/3-2022");
        customizedStatementPage.EnterToDate("10/3/2023");
        customizedStatementPage.EnterMinimumTransactionValue("500");
        customizedStatementPage.EnterNumberOfTransaction("10");
        customizedStatementPage.ClickOnResetButton();
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//input[@name='accountno']"));
        String Actual = AccountNo_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }

    //HomeButton
    @Test (priority = 6)
    public void CheckHomeButton ()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
      //homePage.ClickOnCustomizedStatementButton();
    }

    //ValidAccountNo
    @Test (priority = 7,enabled = false)
    public void ValidAccountNo ()
    {
        customizedStatementPage = new CustomizedStatementPage(driver);
        customizedStatementPage.EnterAccountNo(NewAccountID_Saved);
        customizedStatementPage.EnterFromDate("10/3-2022");
        customizedStatementPage.EnterToDate("10/3/2023");
        customizedStatementPage.EnterMinimumTransactionValue("50");
        customizedStatementPage.EnterNumberOfTransaction("10");
        customizedStatementPage.ClickOnSubmitButton();
        WebElement CustomizedStatementAssertion = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/p"));
        String Actual = CustomizedStatementAssertion.getText();
        String Expected = "Customized Statement Details";
        Assert.assertEquals(Actual,Expected);
        customizedStatementPage.ClickOnHomeButton();
    }



}
