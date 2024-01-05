import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MiniStatementPageTest extends BaseTest{

    private MiniStatementPage miniStatementPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckMiniStatementButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnMiniStatementButton();
        String Expected = "Mini Statement Form";
        WebElement MiniStatementAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = MiniStatementAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test(priority = 1)
    public void AccountNo_MustNotBeBlank ()
    {
        miniStatementPage = new MiniStatementPage(driver);
        miniStatementPage.EnterAccountNo("");
        miniStatementPage.LeftClickOnThePage();
        String Expected = "Account Number must not be blank";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_SpecialCharactersAreNotAllowed()
    {
        miniStatementPage = new MiniStatementPage(driver);
        miniStatementPage.EnterAccountNo("@");
        String Expected = "Special characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_CharactersAreNotAllowed()
    {
        miniStatementPage = new MiniStatementPage(driver);
        miniStatementPage.EnterAccountNo("A");
        String Expected = "Characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_FirstCharacterCannotHaveSpace()
    {
        miniStatementPage = new MiniStatementPage(driver);
        miniStatementPage.EnterAccountNo(" ");
        String Expected = "First character can not have space";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void InvalidAccountNo()
    {
        miniStatementPage = new MiniStatementPage(driver);
        miniStatementPage.EnterAccountNo("123456");
        miniStatementPage.ClickOnSubmitButton();
        String Expected = "Account does not exist";
        String Actual = driver.switchTo().alert().getText();
        miniStatementPage.ClickOnAlert();
        Assert.assertEquals(Actual,Expected);
    }


    //ResetButton
    @Test (priority = 2)
    public void CheckResetButton ()
    {
        miniStatementPage = new MiniStatementPage(driver);
        miniStatementPage.EnterAccountNo("123456");
        miniStatementPage.ClickOnResetButton();
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//input[@name='accountno']"));
        String Actual = AccountNo_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }

    //HomeButton
    @Test (priority = 3)
    public void CheckHomeButton ()
    {
        miniStatementPage = new MiniStatementPage(driver);
        miniStatementPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
      //homePage.ClickOnMiniStatementButton();
    }


    //ValidMiniStatement
    @Test (priority = 4,enabled = false)
    public void ValidAccountNo()
    {
        miniStatementPage = new MiniStatementPage(driver);
        miniStatementPage.EnterAccountNo(NewAccountID_Saved);
        miniStatementPage.ClickOnSubmitButton();
        WebElement MiniStatementAssertion = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/p"));
        String Actual = MiniStatementAssertion.getText();
        String Expected = "Mini Statement Details";
        Assert.assertEquals(Actual,Expected);
        miniStatementPage.ClickOnHomeButton();
    }




}
