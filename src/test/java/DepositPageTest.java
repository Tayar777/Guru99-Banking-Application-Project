import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DepositPageTest extends BaseTest {

    private DepositPage depositPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckDepositButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnDepositButton();
        String Expected = "Amount Deposit Form";
        WebElement DepositAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = DepositAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //AccountNoTC
    @Test(priority = 1)
    public void AccountNo_MustNotBeBlank ()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAccountNo("");
        depositPage.LeftClickOnThePage();
        String Expected = "Account Number must not be blank";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_SpecialCharactersAreNotAllowed()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAccountNo("@");
        String Expected = "Special characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_CharactersAreNotAllowed()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAccountNo("A");
        String Expected = "Characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_FirstCharacterCannotHaveSpace()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAccountNo(" ");
        String Expected = "First character can not have space";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //AmountTC
    @Test(priority = 2)
    public void Amount_MustNotBeBlank ()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAmount("");
        depositPage.LeftClickOnThePage();
        String Expected = "Amount field must not be blank";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void Amount_SpecialCharactersAreNotAllowed()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAmount("@");
        String Expected = "Special characters are not allowed";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void Amount_CharactersAreNotAllowed()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAmount("A");
        String Expected = "Characters are not allowed";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void Amount_FirstCharacterCannotHaveSpace()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAmount(" ");
        String Expected = "First character can not have space";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //DescriptionTC
    @Test(priority = 3)
    public void Description_MustNotBeBlank ()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterDescription("");
        depositPage.LeftClickOnThePage();
        String Expected = "Description can not be blank";
        WebElement Description_Assertion = driver.findElement(By.xpath("//label[@id='message17']"));
        String Actual = Description_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //ResetButton
    @Test (priority = 4)
    public void CheckResetButton ()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAccountNo("123456");
        depositPage.EnterAmount("500");
        depositPage.EnterDescription("deposit");
        depositPage.ClickOnResetButton();
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//input[@name='accountno']"));
        String Actual = AccountNo_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }

    //HomeButton
    @Test (priority = 5)
    public void CheckHomeButton ()
    {
        depositPage = new DepositPage(driver);
        depositPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
      //homePage.ClickOnDepositButton();
    }


    //ValidDeposit
    @Test (priority = 6,enabled = false)
    public void ValidDeposit ()
    {
        depositPage = new DepositPage(driver);
        depositPage.EnterAccountNo(NewAccountID_Saved);
        depositPage.EnterAmount("500");
        depositPage.EnterDescription("deposit");
        depositPage.ClickOnSubmitButton();
        String Actual = driver.switchTo().alert().getText();
        String Expected = "Deposit is done successfully";
        Assert.assertEquals(Actual,Expected);
        depositPage.ClickOnHomeButton();
    }



}
