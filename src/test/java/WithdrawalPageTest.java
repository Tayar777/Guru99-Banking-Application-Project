import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WithdrawalPageTest extends BaseTest{

    private WithdrawalPage withdrawalPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckWithdrawalButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnWithdrawalButton();
        String Expected = "Amount Withdrawal Form";
        WebElement WithdrawalAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = WithdrawalAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //AccountNoTC
    @Test(priority = 1)
    public void AccountNo_MustNotBeBlank ()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAccountNo("");
        withdrawalPage.LeftClickOnThePage();
        String Expected = "Account Number must not be blank";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_SpecialCharactersAreNotAllowed()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAccountNo("@");
        String Expected = "Special characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_CharactersAreNotAllowed()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAccountNo("A");
        String Expected = "Characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_FirstCharacterCannotHaveSpace()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAccountNo(" ");
        String Expected = "First character can not have space";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //AmountTC
    @Test(priority = 2)
    public void Amount_MustNotBeBlank ()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAmount("");
        withdrawalPage.LeftClickOnThePage();
        String Expected = "Amount field must not be blank";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void Amount_SpecialCharactersAreNotAllowed()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAmount("@");
        String Expected = "Special characters are not allowed";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void Amount_CharactersAreNotAllowed()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAmount("A");
        String Expected = "Characters are not allowed";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void Amount_FirstCharacterCannotHaveSpace()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAmount(" ");
        String Expected = "First character can not have space";
        WebElement Amount_Assertion = driver.findElement(By.xpath("//label[@id='message1']"));
        String Actual = Amount_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //DescriptionTC
    @Test(priority = 3)
    public void Description_MustNotBeBlank ()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterDescription("");
        withdrawalPage.LeftClickOnThePage();
        String Expected = "Description can not be blank";
        WebElement Description_Assertion = driver.findElement(By.xpath("//label[@id='message17']"));
        String Actual = Description_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //ResetButton
    @Test (priority = 4)
    public void CheckResetButton ()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAccountNo("123456");
        withdrawalPage.EnterAmount("500");
        withdrawalPage.EnterDescription("deposit");
        withdrawalPage.ClickOnResetButton();
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//input[@name='accountno']"));
        String Actual = AccountNo_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }

    //HomeButton
    @Test (priority = 5)
    public void CheckHomeButton ()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
      //homePage.ClickOnWithdrawalButton();
    }


    //ValidWithdrawal
    @Test (priority = 6,enabled = false)
    public void ValidWithdrawal ()
    {
        withdrawalPage = new WithdrawalPage(driver);
        withdrawalPage.EnterAccountNo(NewAccountID_Saved);
        withdrawalPage.EnterAmount("500");
        withdrawalPage.EnterDescription("deposit");
        withdrawalPage.ClickOnSubmitButton();
        String Actual = driver.switchTo().alert().getText();
        String Expected = "Withdrawal is done successfully";
        Assert.assertEquals(Actual,Expected);
        withdrawalPage.ClickOnHomeButton();
    }


}
