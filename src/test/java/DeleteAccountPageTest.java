import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteAccountPageTest extends BaseTest {

    private DeleteAccountPage deleteAccountPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckDeleteAccountButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnDeleteAccountButton();
        String Expected = "Delete Account Form";
        WebElement DeleteAccountAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = DeleteAccountAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test(priority = 1)
    public void AccountNo_MustNotBeBlank ()
    {
        deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.EnterAccountNo("");
        deleteAccountPage.LeftClickOnThePage();
        String Expected = "Account Number must not be blank";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_SpecialCharactersAreNotAllowed()
    {
        deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.EnterAccountNo("@");
        String Expected = "Special characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_CharactersAreNotAllowed()
    {
        deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.EnterAccountNo("A");
        String Expected = "Characters are not allowed";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void AccountNo_FirstCharacterCannotHaveSpace()
    {
        deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.EnterAccountNo(" ");
        String Expected = "First character can not have space";
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//label[@id='message2']"));
        String Actual = AccountNo_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //InvalidAccountNo
    @Test (priority = 2)
    public void InvalidAccountNo ()
    {
        deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.EnterAccountNo("123456");
        deleteAccountPage.ClickOnSubmitButton();
        String Actual1 = driver.switchTo().alert().getText();
        deleteAccountPage.ClickOnAlert();
        String Expected1 = "Do you really want to delete this Account?";
        String Actual2 = driver.switchTo().alert().getText();
        deleteAccountPage.ClickOnAlert();
        String Expected2 = "Account does not exist";
        Assert.assertEquals(Actual1,Expected1);
        Assert.assertEquals(Actual2,Expected2);
    }


    //ResetButton
    @Test (priority = 3)
    public void CheckResetButton ()
    {
        deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.EnterAccountNo("123456");
        deleteAccountPage.ClickOnResetButton();
        WebElement AccountNo_Assertion = driver.findElement(By.xpath("//input[@name='accountno']"));
        String Actual = AccountNo_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }

    //HomeButton
    @Test (priority = 4)
    public void CheckHomeButton ()
    {
        deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
        homePage.ClickOnDeleteAccountButton();
    }


    // DeleteAccount1
    @Test (priority = 5)
    public void DeleteAccount1 ()
    {
        deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.EnterAccountNo(NewAccountID_Saved);
        deleteAccountPage.ClickOnSubmitButton();
        String Actual1 = driver.switchTo().alert().getText();
        deleteAccountPage.ClickOnAlert();
        String Expected1 = "Do you really want to delete this Account?";
        String Actual2 = driver.switchTo().alert().getText();
        deleteAccountPage.ClickOnAlert();
        String Expected2 = "Account does not exist";
        Assert.assertEquals(Actual1,Expected1);
        Assert.assertEquals(Actual2,Expected2);
    }

    // DeleteAccount2
    @Test (priority = 6)
    public void DeleteAccount2 ()
    {
        deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.EnterAccountNo(NewAccountID_Saved2);
        deleteAccountPage.ClickOnSubmitButton();
        String Actual1 = driver.switchTo().alert().getText();
        deleteAccountPage.ClickOnAlert();
        String Expected1 = "Do you really want to delete this Account?";
        String Actual2 = driver.switchTo().alert().getText();
        deleteAccountPage.ClickOnAlert();
        String Expected2 = "Account does not exist";
        Assert.assertEquals(Actual1,Expected1);
        Assert.assertEquals(Actual2,Expected2);
        deleteAccountPage.ClickOnHomeButton();
    }


}
